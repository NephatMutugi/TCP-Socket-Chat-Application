package neph;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mContentPane;
    private String name, address;
    private int port;
    private JTextField mMessage;
    private JTextArea mHistory;
    private DefaultCaret mCaret;

    private Socket mSocket;
    private InetAddress mAddress;

    //Create client
    public Client(String name, String address, int port){
        this.name = name;
        this.address = address;
        this.port = port;
        boolean connect = openConnection(address, port);
        createWindow();
        console("Attempting to connect " +name + " to "+address+" at port:"+port);
    }


    private boolean openConnection(String address, int port){
            mSocket = new Socket();
        try {
            mAddress = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }






    private void createWindow(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1){
            e1.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 550);
        setLocationRelativeTo(null);
        setTitle("Client");
        mContentPane = new JPanel();
        mContentPane.setBorder(new EmptyBorder(5,5,5,5));
        mContentPane.setLayout(new BorderLayout(0,0));
        setContentPane(mContentPane);

        //GridBagLayout
        GridBagLayout mGridBagLayout = new GridBagLayout();
        mGridBagLayout.columnWidths = new int[]{28, 815, 30, 7}; //Sum = 880
        mGridBagLayout.rowHeights = new int[]{35, 475, 40}; //Sum = 550
        mGridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        mGridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        mContentPane.setLayout(mGridBagLayout);

        //History Field
        mHistory = new JTextArea();
        mHistory.setEditable(false);
        //Set scroll to display the latest text/ where we're typing
        mCaret = (DefaultCaret) mHistory.getCaret();
        mCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); //Update caret
        //Scroll pane
        JScrollPane mScroll = new JScrollPane(mHistory);
        GridBagConstraints mScrollConstraints = new GridBagConstraints();
        mScrollConstraints.insets = new Insets(0,20,20,20);
        mScrollConstraints.fill = GridBagConstraints.BOTH;
        mScrollConstraints.gridx = 0;
        mScrollConstraints.gridy = 0;
        mScrollConstraints.gridwidth = 3;
        mScrollConstraints.gridheight = 2;
        mContentPane.add(mScroll,mScrollConstraints);

        //Message Text Field
        mMessage = new JTextField();
        mMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    send(mMessage.getText());
                }
            }
        });

        GridBagConstraints mGBCMessage = new GridBagConstraints();
        mGBCMessage.insets = new Insets(0,0,0,5);
        mGBCMessage.fill = GridBagConstraints.HORIZONTAL;
        mGBCMessage.gridx = 0;
        mGBCMessage.gridy = 2;
        mGBCMessage.gridwidth = 2;
        mContentPane.add(mMessage, mGBCMessage);
        mMessage.setColumns(10);

        JButton mBtnSend = new JButton("Send");
        GridBagConstraints mGBCBtnSend = new GridBagConstraints();
        mGBCBtnSend.insets = new Insets(0,0,0,5);
        mGBCBtnSend.gridx = 2;
        mGBCBtnSend.gridy = 2;
        mContentPane.add(mBtnSend, mGBCBtnSend);

        mBtnSend.addActionListener(e -> {
            send(mMessage.getText());
        });


        setVisible(true);
        mMessage.requestFocusInWindow();
    }

    private void send(String message){
        if (message.equals("")) return;
        message = name + ": "+message;
        console(message);
        mMessage.setText("");
    }
    public void console(String message){
        mHistory.append(message +"\n");
        //mHistory.setCaretPosition(mHistory.getDocument().getLength());
    }
}
