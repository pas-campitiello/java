import java.nio.channels.FileChannel;
import java.net.URL;
import java.nio.channels.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.FileNotFoundException;


public class DownloadBible {

    public static final String BASE_URL = "http://www.reginamundi.info/Bibbia-mp3/";
    public static final String BOOK = "Apocalisse";
    public static final int CHAPTERS = 22;

    public static void main(String[] args) 
    {
        System.out.println("Downloading - book: " + BOOK + " | chapters: " + CHAPTERS);

	try
	{
		String fileName = "";
		String URL = "";

		for(int i=1; i<=CHAPTERS; i++)
		{
			fileName = BOOK + i + ".mp3";
			URL = BASE_URL + BOOK + "/" + fileName;

			File dir = new File(BOOK);
			dir.mkdir();
			
			System.out.print(i + "..");
			URL website = new URL(URL);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(BOOK + "/" + fileName);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		System.out.println("FINISHED");
	}
	catch (MalformedURLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) 
	{
      	  	// TODO Auto-generated catch block
       		 e.printStackTrace();
    	}
    }

}
