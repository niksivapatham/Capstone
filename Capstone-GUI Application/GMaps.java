import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.util.List;
import java.util.Arrays;

/**
 * Gets the Google Maps portion of the Application
 * @author Nikhil Sivapatham
 * @version 24 April 2015
 */
public class GMaps
{
    //The first part of the Google Maps url for the specified image
    private final String PREFIX = "https://maps.googleapis.com/maps/api/staticmap?";
    //Sets the format of what we are getting to be an image
    private final String FORMAT = "&format=jpg";
    //Sets the zoom on the map to 14
    private final String ZOOM = "&zoom=14";
    //Sets pixel size to 400x400 even though it is later both zoomed and scaled
    private final String SIZE = "&size=400x400";
    //Makes the map a "hybrid" meaning both roads and texture
    private final String TYPE = "&maptype=hybrid";
    //The instance variable of the unaltered location when the class is created
    private String location = "";    
    //The instance variable of the altered locaiton that is prepared for the google maps api
    private String parsedLocation = "";  
    

    public GMaps(String initLocation)
    {
        //Creates the location, and then makes the api ready one
        location = initLocation;   
        parseLocation();
    }

    /**
     * This method is what actually reads the website and makes it an image ready to be added to 
     * the JPanel
     *
     * @return     An ImageIcon that can be added to the map JLabel
     */
    public ImageIcon getMap() throws IOException
    {        
        try {
            //Calls the method that takes the parsed location string and makes it a full url
            String imageUrl = this.returnURL();
            //Makes the URL what will eventually be an image called "image.jpg"
            String destinationFile = "image.jpg";
            //Creates the URL object
            URL url = new URL(imageUrl);
            //Opens the URL object to write from
            InputStream is = url.openStream();
            //And opens the image destination to write to
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;
            //Writes to the image
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            //Used to throw the exception, must be done when using websites
            e.printStackTrace();
            System.exit(1);
        }
        return new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH));
    }

    /**
     * This method takes the location in the name,city,state format and puts it into
     * Name+city+state with underscores separating multiple word names or states
     *
     */
    private void parseLocation()
    {
        //This parses the location string and puts it into the correct syntax
        //Input Format should be Name,City,State
        //Separates the String into three arrays, one for city, one for state, and one for name
        List<String> locationsParts = Arrays.asList(location.split(","));
        //Creates a list after splitting the first list again, putting each word in the name into its own
        //section of an array
        List<String> nameParts = Arrays.asList((locationsParts.get(0)).split(" "));
        //Creates a list after splitting the first list again, putting each word in the city into its own
        //section of an array
        List<String> cityParts = Arrays.asList((locationsParts.get(1)).split(" "));

        //This loop takes the name array and puts it into the underscore format ex: Naperville_North
        String name = "";
        for (int i = 0; i<nameParts.size();i++)
        {
            if (i == nameParts.size()-1)
            {
                name += nameParts.get(i);
            }
            else
            {
                name += nameParts.get(i)+"+";
            }
        }

        //This loop takes the city array and puts it into the underscore format ex: New_York
        String city = "";
        for (int j = 0; j<cityParts.size();j++)
        {
            if (j == cityParts.size()-1)
            {
                city += cityParts.get(j);
            }
            else
            {
                city += cityParts.get(j)+"+";
            }
        }
        
        String state = locationsParts.get(2);
        //Returns them with plus signs inbetween
        parsedLocation = name+","+city+","+state;
    }

    /**
     * Returns the url in the correct version as a string, ready to be put into the browser
     * @return    returns the string form of the url
     */
    private String returnURL()
    {
        //The purpose of this class is to construct the appropriate URL to retrieve the image of the
        //location entered
        String markerURL = "&markers=7Ccolor:red%7C"+parsedLocation;        
        String URL = PREFIX+"center="+parsedLocation+ZOOM+SIZE+TYPE+markerURL+FORMAT;
        return URL;
    }

}
