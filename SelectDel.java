
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
class SelectDel
{
    static void selectDel()
    {
        if(Login.login())
        {
            try
            {
                FileReader file;BufferedReader fileinput;String txt="",stxt="";
                file=new FileReader(Path.path()+"\\logs.txt");
                fileinput=new BufferedReader (file);
                int i=0;
                while((txt=fileinput.readLine())!=null)
                {
                    ++i;
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null, "No saved Passwords Found", "Error 404", JOptionPane.ERROR_MESSAGE);
                else
                {
                    fileinput.close();
                    file=new FileReader(Path.path()+"\\logs.txt");
                    fileinput=new BufferedReader (file);
                    Object possibleValues[] = new Object[i];
                    for(int j=0;j<i;j++)
                    {
                        possibleValues[j]=txt=fileinput.readLine();
                    }
                    try
                    {
                        Object selectedValue = JOptionPane.showInputDialog(null,"Choose one to delete", "DELETE", 
                                JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
                        try
                        {
                            txt=""+selectedValue;
                            LogManager.lM(txt);
                            txt=Path.path()+"\\"+selectedValue+"-Encrypted.txt";
                            
                            Delete.delete(txt);
                            
                        }
                        catch(Exception e)
                        {
                            //Nothing
                        }
                    }
                    catch(Exception e)
                    {
                        //Nothing
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "No saved Passwords Found", "Error 404", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}