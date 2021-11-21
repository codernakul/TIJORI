import java.io.*;
import javax.swing.*;
class Path
{
    public static String path()
    {
        String pathRET="";
        try
        {
            FileReader file=new FileReader("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori\\path.txt");
            BufferedReader fileinput=new BufferedReader(file);
            pathRET=fileinput.readLine();
            fileinput.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error : Path","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pathRET;
    }
}
