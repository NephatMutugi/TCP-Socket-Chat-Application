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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setTitle("Client");
        mContentPane = new JPanel();
        mContentPane.setBorder(new EmptyBorder(5,5,5,5));
        mContentPane.setLayout(new BorderLayout(0,0));
        setContentPane(mContentPane);

        //GridBagLayout
        GridBagLayout mGridBagLayout = new GridBagLayout();
        mGridBagLayout.columnWidths = new int[]{0};
        mGridBagLayout.rowHeights = new int[]{0};
        mGridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
        mGridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
        mContentPane.setLayout(mGridBagLayout);

        setVisible(true);
    }
}
