import java.util.*;
import java.io.*;
import javax.swing.*;
class Save
{
    static void save()
    {
        try
        {
            FileReader file;BufferedReader fileinput;String txt="";int sameF=0;
            String filename;

            PrintWriter pwr;

            Date d=new Date();
            String dispFileName;

            do{
                filename = JOptionPane.showInputDialog(null , "Enter your file name: ","Type Name Here");
                sameF=0;
                file=new FileReader(Path.path()+"\\logs.txt");
                fileinput=new BufferedReader (file);
                while((txt=fileinput.readLine())!=null&&sameF==0)
                {
                    if(txt.equals(filename))
                    {
                        ++sameF;
                        JOptionPane.showMessageDialog(null, "There is a File with a similar name\nPlease input a new Name", "Tijori", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }while(sameF!=0);

            if(filename==null)
                filename=Tijori.crntPass;

            if(filename!=Tijori.crntPass)
            {
                dispFileName=filename;
                //dispFileName+=" has been saved";

                pwr=new PrintWriter(new BufferedWriter(new FileWriter(Path.path()+"\\logs.txt",true)));
                pwr.println(filename);//logs

                pwr.close();//logs

                filename=Path.path()+"\\"+filename+".txt";
                pwr=new PrintWriter(new BufferedWriter(new FileWriter(filename)));

                pwr.println(Tijori.crntPass);
                pwr.println(dispFileName);
                pwr.print(""+d);
                //pwr.print("The password is generated with the help of Tijori Made By NAKUL SINGH");
                pwr.flush();
                pwr.close();
                JOptionPane.showMessageDialog(null, dispFileName+"\nhas been saved", "SAVED", JOptionPane.INFORMATION_MESSAGE);
                CryptoUtilsEncrypt.main(filename,dispFileName);
                File fileD=new File(filename);
                fileD.delete();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error : Save","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
