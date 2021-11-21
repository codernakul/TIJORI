import java.io.*;
class LogManager
{
    static void lM(String s)
    {
        try
        {
            FileReader file;
            BufferedReader fileinput;
            String txt="";
            file=new FileReader(Path.path()+"\\logs.txt");
            fileinput=new BufferedReader (file);

            PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter(Path.path()+"\\Templogs.txt"))); //new File
            while((txt=fileinput.readLine())!=null)
            {
                if(!txt.equals(s))
                    pwr.println(txt);
            }
            fileinput.close();
            file.close();
            pwr.close();

            File oldfile=new File(Path.path()+"\\logs.txt");
            boolean b=oldfile.delete();
            
            System.out.println(b);

            File newfile=new File(Path.path()+"\\Templogs.txt");
            File rnmfile=new File(Path.path()+"\\logs.txt");
            newfile.renameTo(rnmfile);

        }
        catch(IOException e)
        {
            //Nothing
        }
    }
}