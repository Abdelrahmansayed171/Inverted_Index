package src;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader  {
    public static void main(String[] args) throws IOException {
        try{
            FileInputStream f = new FileInputStream("file1.txt");
            DataInputStream d = new DataInputStream(f);


        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
