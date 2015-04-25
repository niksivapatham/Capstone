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
import java.awt.GridBagLayout;
import javax.swing.JTextArea;

/**
 * Holds everything for the class
 * 
 * @author Nikhil Sivapatham
 * @version 24 April 2015
 */
public class WindowPanel extends JPanel implements ActionListener
{
    //The Text box where the adress is entered
    private JTextField textBox;
    //The Label that the map of the location is added to once the button is clicked
    JLabel map = new JLabel();
    //The Text area where the Wiki blurb appears once the button is clicked
    JTextArea wiki = new JTextArea();
    public WindowPanel()
    {
        createStuff();
    } 

    public void createStuff()
    {
        //This panel uses the gridBagLayout to construct the GUI
        //A little complicated but very useful and not too hard to get the hang of
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //The Text entry
        textBox = new JTextField("Search a location to get started");
        Font font = new Font("Times New Roman", Font.BOLD, 12);
        textBox.setFont(font);
        textBox.setForeground(Color.GRAY);
        c.ipadx = 200;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .5;
        c.weighty = .2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(textBox, c);

        JButton submitButton = new JButton("Submit");
        //Adds the action listener to the button. This is where the magic happens
        submitButton.addActionListener(this);
        c.ipadx = 10;
        c.ipady = 2;
        c.gridx ++ ;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(submitButton, c);

        //Add Map and other stuff to window
        c.gridx = 0;
        c.gridy ++ ;
        c.gridwidth = 2;
        c.weighty = .3;
        this.add(map,c);
        
        c.gridy++;
        this.add(wiki,c);
    }

    public void actionPerformed(ActionEvent e) {
        //This is where every even that processes the previously entered information takes place
        //This gets the test and makes it a string
        String place = textBox.getText();
        //Creates an instance of the Google Maps class I created
        GMaps googleMap = new GMaps(place);
        //Has a try becaue both methods open webpages, need to throw the possible exception
        try{
            //Sets the map label to the image that is found online
            map.setIcon(googleMap.getMap());
            //Sets the text to the information found through the Wikipedia class I made 
            wiki.setText(Wikipedia.getBlurb(place));
        }catch(IOException g){
            g.printStackTrace();
        }
        
    }
}
