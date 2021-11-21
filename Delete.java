import java.io.*;
class Delete
{
    public static void delete(String name) //name with full path
    {
        File file=new File(name);
        file.delete();
    }
}
