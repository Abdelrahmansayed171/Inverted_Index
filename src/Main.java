package src;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private String fileName1 = "file1.txt",fileName2="file2.txt",fileName3="file3.txt",fileName4="file4.txt",fileName5="file5.txt",fileName6="file6.txt",fileName7="file7.txt",fileName8="file8.txt",fileName9="file9.txt",fileName10="file10.txt";
    public HashMap<String,DictEntry> index = new HashMap<String,DictEntry>();
    int fileNum = 1;
    public void operate(String fileName,int fileID) throws IOException {
        FileInputStream file = new FileInputStream(fileName);
        DataInputStream data = new DataInputStream(file);
        while(data.available()>0) {
            String word = data.readUTF();
            if(!index.containsKey(word)){
                Posting tempPosting = new Posting(fileID);
                DictEntry tempEntry = new DictEntry();
                tempEntry.pList = tempPosting;
                index.put(word,tempEntry);
            }
            else{
                if(fileNum != fileID){
                    fileNum = fileID;
                    index.get(word).doc_freq++;
                    int newDtf = index.get(word).term_freq+1;
                    Posting posting = new Posting(fileID,newDtf);

                    Posting prePosting = index.get(word).pList;
                    while(prePosting.next != null){
                        prePosting = prePosting.next;
                    }
                    prePosting.next = posting;

                }
                index.get(word).term_freq++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        try{
            FileInputStream f = new FileInputStream("file10.txt");
            DataInputStream d = new DataInputStream(f);
            while(d.available()>0) {

                // reads characters encoded with modified UTF-8
                String k = d.readUTF();

                // print
                System.out.print(k+" ");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
