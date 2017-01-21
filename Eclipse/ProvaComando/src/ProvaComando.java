import java.io.*;

public class ProvaComando 
{
    public static void main(String[] args) 
    {
        try 
        {
            Process p = Runtime.getRuntime().exec("ASQS\\LauncherAxisServer.exe");
            
            try
            {
                //p.waitFor();
                //p2.waitFor();
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
            BufferedReader in = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
}
