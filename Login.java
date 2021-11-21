import java.util.*;
import java.io.*;
import javax.swing.*;
class Login
{
    static boolean login()
    {
        try
        {
            FileReader file=new FileReader("C:\\Users\\Nakul\\Documents\\Tijori\\key.txt");
            BufferedReader fileinput=new BufferedReader(file);
            String filenameCH=fileinput.readLine();
            fileinput.close();
            String filename = JOptionPane.showInputDialog(null , "Enter your key:","Login",JOptionPane.PLAIN_MESSAGE);
            if(filename.equals(filenameCH))
                return true;
            else
            {
                JOptionPane.showMessageDialog(null,"Provided key does not match, Try again","ERROR",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,"Operation Cancelled","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
