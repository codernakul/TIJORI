
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.commons.codec.binary.Base64;

class QRCodeGenerator
{
    //     static final String QR_CODE_IMAGE_PATH = Path.path()+"qr.png";
    static void generateQRCodeImage(String text, int width, int height, String filePath)
    throws WriterException, IOException 
    {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    static void qrGen(String name,String pass)throws IOException, Exception
    {
        try
        {
            //FileReader file=new FileReader("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori\\path.txt");
            //BufferedReader fileinput=new BufferedReader(file);
            //String pathRET=fileinput.readLine();
            String pathRET="C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Tijori";
            //fileinput.close();
            
            generateQRCodeImage(pass, 100, 100, pathRET+"\\"+name+"-qr.png");
            
        }
        catch (WriterException e)
        {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }
}