import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class WindowFrame extends JFrame
{
    public WindowFrame()
    {
        this.BuildWindow();

    }

    public void BuildWindow()
    {
        WindowPanel panel = new WindowPanel();
        JScrollPane scroll = new JScrollPane(panel);        
        add(scroll);
        setTitle("Fun Times Capstone");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }      
    

}
