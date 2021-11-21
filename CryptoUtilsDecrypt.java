import java.io.*;
import java.util.*;
public class CryptoUtilsDecrypt 
{
    public static void main(String filename)throws IOException
    {
        
        String key = "Mary has one cat";
        //File inputFile = new File(filename);
        File encryptedFile = new File(Path.path()+"\\"+filename+"-Encrypted.txt");
        File decryptedFile = new File(Path.path()+"\\"+filename+"-Decrypted.txt");
        
        try
        {
            //CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        }
        catch (CryptoException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
