import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
/**
 * Gets the Google Maps portion of the Application
 * 
 * @author Nikhil Sivapatham
 * @version 21 April 2015
 */
public class GMaps
{

    public static ImageIcon getMap() throws IOException
    {        
        try {
            String imageUrl = "http://maps.google.com/staticmap?center=40,26&zoom=1&size=150x112&maptype=satellite&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
            String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        JFrame test = new JFrame("Google Maps");
        return new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(600, 600,
                    java.awt.Image.SCALE_SMOOTH));
    }
}
