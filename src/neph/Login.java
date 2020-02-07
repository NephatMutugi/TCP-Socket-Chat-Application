package neph;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField mName;
    private JTextField mIP;
    private JTextField mPort;

    // Create the frame
    public Login(){
        //JPanel
        JPanel contentPane;
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,350);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
       // contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Login Field
        mName = new JTextField();
        mName.setBounds(100,50, 150,25);
        contentPane.add(mName);
        mName.setColumns(10);

        //Login Text
        JLabel mLabelName = new JLabel("Name:");
        mLabelName.setBounds(150,30,40,15);
        contentPane.add(mLabelName);

        //IP Address Field
        mIP = new JTextField();
        mIP.setBounds(100,100, 150,25);
        contentPane.add(mIP);
        mIP.setColumns(10);

        //IP Address Text
        JLabel mIPLabel = new JLabel("IP Address:");
        mIPLabel.setBounds(150,80,100,15);
        contentPane.add(mIPLabel);


        //Port Field
        mPort = new JTextField();
        mPort.setBounds(100,150,150,25);
        contentPane.add(mPort);
        mPort.setColumns(10);

        //Port text
        JLabel mPortLabel = new JLabel("Port Number:");
        mPortLabel.setBounds(150,130,100,15);
        contentPane.add(mPortLabel);

        //Login Button
        JButton mLoginBtn;
        mLoginBtn= new JButton("Login");
        mLoginBtn.setBounds(100,200,150,30);
        contentPane.add(mLoginBtn);

        mLoginBtn.addActionListener(e -> {
            String name = mName.getText();
            String address = mIP.getText();
            int port = Integer.parseInt(mPort.getText());
            login(name,address,port);
        });
    }
    /** Login**/
    private void login(String name, String address, int port){
        dispose();
        System.out.println(name + " " + address + " " + port);
    }

    //Launch App
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
