import java.io.*;

public class Lines
{
    static int lines()
    {
        try
        {
            FileReader file=new FileReader(Path.path()+"\\logs.txt");
            BufferedReader fileinput=new BufferedReader(file);
            int c=0;
            while(fileinput.readLine()!=null)
            {
                ++c;
            }
            fileinput.close();
            return c;
        }
        catch(IOException e)
        {
            //
        }
        catch(Exception e)
        {
            //
        }
        return 0;
    }
}