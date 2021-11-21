
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
class Open
{
    static void open()
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
                        Object selectedValue = JOptionPane.showInputDialog(null,"Choose one", "OPEN", 
                                JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
                        try
                        {
                            txt=""+selectedValue;
                            CryptoUtilsDecrypt.main(txt);
                            txt=Path.path()+"\\"+selectedValue+"-Decrypted.txt";
                            file=new FileReader(txt);
                            fileinput=new BufferedReader (file);
                            txt=fileinput.readLine();
                            Toolkit toolkit = Toolkit.getDefaultToolkit();
                            Clipboard clipboard = toolkit.getSystemClipboard();
                            StringSelection strSel = new StringSelection(txt);
                            clipboard.setContents(strSel, null);
                            

                            QRCodeGenerator.qrGen(""+selectedValue,txt);
                            
                            txt="PASSWORD:\n"+txt+"\n\nFILE NAME: "+fileinput.readLine()+"\nGENERATED ON: "+fileinput.readLine()+"\n";
                            fileinput.close();

                            //photo.setIcon(imgIcon);

                            
                            ImageIcon imgIcon = new ImageIcon(Path.path()+"\\"+selectedValue+"-qr.png");
                            JOptionPane.showMessageDialog(null,txt+"\nHas been copied to clipboard","Tijori",JOptionPane.PLAIN_MESSAGE,imgIcon);
                            //JOptionPane.showMessageDialog(null,);
                            txt=Path.path()+"\\"+selectedValue+"-Decrypted.txt";
                            Delete.delete(txt);
                            txt=Path.path()+"\\"+selectedValue+"-qr.png";
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
