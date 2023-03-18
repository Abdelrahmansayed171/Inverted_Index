package src;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileOutputStream f = new FileOutputStream("file1.txt",true);
        DataOutputStream d= new DataOutputStream(f);
        d.writeUTF("name");
        d.writeUTF("seif");
        d.writeUTF("mohamed");
        d.writeChar('S');
        d.writeUTF("SeiffMohemedd");
        d.flush();
        d.close();
    }
}
