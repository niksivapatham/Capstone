import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * The Frame that holds it all together
 * This Frame is custom made to have some toolbars to experiment with GUI building
 * This is also where all of the other options are set like size and title
 * 
 * @author Nikhil Sivapatham 
 * @version 24 April 2015
 */
public class WindowFrame extends JFrame
{
    public WindowFrame()
    {
        //Kept all of the other stuff in another method to keep it simple
        this.BuildWindow();
    }

    public void BuildWindow()
    {
        //This Method is called to create the menubar with dropdown menus at the top
        createMenuBar();
        WindowPanel panel = new WindowPanel();
        //A scrollable panel because once the information is entered, it will take up more than the 
        //default screen
        JScrollPane scroll = new JScrollPane(panel);        
        add(scroll);
        setTitle("Location Informer");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }  

    private void createMenuBar()
    {
        //This Class creates all of the menu buttons
        
        JMenuBar menubar = new JMenuBar();
        //This creates the "File" menu bar with the dropdown with an exit button
        JMenu file = new JMenu("File");
        ImageIcon icon = new ImageIcon("exit.png");
        JMenuItem eMenuItem = new JMenuItem("Exit",icon);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            });
        file.add(eMenuItem);
        
        //This creates the "Help" menus bar with a button containing useful information
        JMenu help = new JMenu("Help");
        //Button that creates a popup message with information
        JMenuItem hMenuItem = new JMenuItem("Information");
        hMenuItem.setToolTipText("Additional Helpful Information");
        String message = "When typing in an adress, you will want to use this format:\nName,City,State\nExample: Naperville North,Naperville,IL";
        hMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, message);;
                }
            });
        help.add(hMenuItem);
        
        menubar.add(file);
        menubar.add(help);
        
        setJMenuBar(menubar);
    }

}
