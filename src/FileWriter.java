package src;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileOutputStream f = new FileOutputStream("file10.txt",true);
        DataOutputStream d= new DataOutputStream(f);
        d.writeUTF("jg");
        d.writeUTF("main");
        d.writeUTF("top");
//        d.writeChar('i');
        d.writeUTF("main");
//        d.writeUTF("committed");

//        d.writeUTF("IS");


        d.flush();
        d.close();
    }
}
