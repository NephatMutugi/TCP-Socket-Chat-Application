package neph;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Client extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mContentPane;

    private String name, address;
    private int port;

    //Create client
    public Client(String name, String address, int port){
        this.name = name;
        this.address = address;
        this.port = port;
        createWindow();
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
        mGridBagLayout.columnWidths = new int[]{15, 860, 5}; //Sum = 880
        mGridBagLayout.rowHeights = new int[]{35, 475, 40}; //Sum = 550
        mGridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        mGridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        mContentPane.setLayout(mGridBagLayout);

        JTextArea mHistory = new JTextArea();
        GridBagConstraints mGBCHistory = new GridBagConstraints();
        mGBCHistory.fill = GridBagConstraints.BOTH;
        mGBCHistory.gridx = 1;
        mGBCHistory.gridy = 1;
        mContentPane.add(mHistory,mGBCHistory);

        setVisible(true);
    }
}
