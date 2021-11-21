import java.io.*;
import javax.swing.*;
class Length
{
    static int length()
    {
        int length=24;
        try
        {
            FileReader file=new FileReader("C:\\Users\\Nakul\\Documents\\Tijori\\length.txt");
            BufferedReader fileinput=new BufferedReader(file);
            length=Integer.parseInt(fileinput.readLine());
            fileinput.close();
        }
        catch(IOException e)
        {
            //
        }
        return length;
    }

    static void changeLength()
    {
        try
        {
            PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Nakul\\Documents\\Tijori\\length.txt")));
            int length=0;
            do
            {
                length = Integer.parseInt(JOptionPane.showInputDialog(null ,"Length should be between 16 and 64 :"));
            }while(length<16||length>64);
            pwr.print(length);
            pwr.flush();
            pwr.close();
        }
        catch(IOException e)
        {
            //
        }
    }
}
