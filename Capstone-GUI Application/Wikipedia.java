import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.HttpStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * This class provides the wikipedia blurb of information for
 * the program
 * 
 * @author Nikhil Sivapatham 
 * @version 24 April 2015
 */
public class Wikipedia
{
    /**
     * This method creates the blurb for the location by frist parsing the name, then utlizing
     * the third party package JSoup to parse through and pick out the first paragraph of the 
     * location's wikipedia page. It then is prepared to be outputed in the text area
     *
     * @param  inittopic   the location, in name,city,state form
     * @return     The fully formated string blurb ready to be displayed
     */
    public static String getBlurb(String inittopic) throws IOException
    {
        String topic = inittopic;
        //Based on the parsing for the GMaps class, this takes the location string and preapres it
        //for the Wikipedia API, excpet the words are separated by underscores instead of +
        List<String> locationsParts = Arrays.asList(topic.split(","));
        List<String> nameParts = Arrays.asList((locationsParts.get(0)).split(" "));
        String name = "";
        String finalMessage = "";
        for (int i = 0; i<nameParts.size();i++)
        {
            if (i == nameParts.size()-1)
            {
                name += nameParts.get(i);
            }
            else
            {
                name += nameParts.get(i)+"_";
            }
        }

        try{
            //This is jjust JSoup working its magic, but very simple
            String baseURL = "http://en.wikipedia.org/wiki/";
            String url = baseURL+name;
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select(".mw-content-ltr p");
            Element firstParagraph = paragraphs.first();

            //Takes the text and puts it into a one line string
            String message = firstParagraph.text();
            //What will be the returned message
            finalMessage += "\nWiki Blurb:\n\n";
            //Counts the character the for loop is on
            int textCount = 0;

            //This for loop iterates through the string and every 70 character adds a substing of the 
            //preceding character to the finalMessage string as well as a \n so that it is properly 
            //formatted
            for (int i = 0; i < message.length(); i++){
                if ((i-textCount)>=60 && message.substring(i,i+1).equals(" ") )
                {
                    finalMessage += message.substring(textCount,i)+"\n";   
                    textCount = i;
                } else if ((message.length()-textCount)<70)
                {
                    break;
                }
            }
            //Should print out the rest of the message, might not be working
            finalMessage += message.substring(textCount,message.length());
        } catch (HttpStatusException e){
            finalMessage += "No information can be acessed on this location";
        }
        return finalMessage;        
    }
}
