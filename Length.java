import java.io.*;
import javax.swing.*;
class Length
{
    static int length()
    {
        int length=24;
        try
        {
            FileReader file=new FileReader("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori\\length.txt");
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
            //PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori\\length.txt")));
            int length=16;
            do
            {
                length = Integer.parseInt(JOptionPane.showInputDialog(null ,"Length should be between 16 and 64 :"));
            }while(length<16||length>64);
            if(length<16||length==-1)
                length=16;
            PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori\\length.txt")));
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
