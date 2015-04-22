import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Holds everything for the class
 * 
 * @author Nikhil Sivapatham
 * @version 16 April 2015
 */
public class WindowPanel extends JPanel implements ActionListener
{
    private JTextField textBox;
    JLabel map = new JLabel();
    public WindowPanel()
    {
        createStuff();
    } 

    public void createStuff()
    {
        textBox = new JTextField("Search a location to get started");
        Font font = new Font("Times New Roman", Font.BOLD, 12);
        textBox.setFont(font);
        textBox.setForeground(Color.GRAY);
        textBox.setBounds(50,50,300,30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(370,50,100,30);  
        submitButton.addActionListener(this);
        map.setBounds(0,100,550,1000);
        
        
        this.add(map);
        this.add(submitButton);
        this.add(textBox);
        this.setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        String place = textBox.getText();
        try{
            map.setIcon(GMaps.getMap());
            this.add(map);
        }catch(IOException g){
            g.printStackTrace();
        }
    }
}
