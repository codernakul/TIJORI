import java.io.*;
import java.util.*;
public class CryptoUtilsEncrypt {
    public static void main(String filename,String filenameWOPath)throws IOException {
        
        String key ="Mary has one cat";
        File inputFile = new File(filename);
        File encryptedFile = new File(Path.path()+"\\"+filenameWOPath+"-Encrypted.txt");
        //File decryptedFile = new File(Path.path()+"\\documentd.txt");
        
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            //CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
