package src;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public  static  String fileName1 = "file1.txt";
    public static  String fileName2="file2.txt";
    public  static String fileName3="file3.txt";
    public static  String fileName4="file4.txt";
    public  static String fileName5="file5.txt";
    public static  String fileName6="file6.txt";
    public static  String fileName7="file7.txt";
    public static  String fileName8="file8.txt";
    public static  String fileName9="file9.txt";
    public static  String fileName10="file10.txt";
    public static HashMap<String,DictEntry> index = new HashMap<String,DictEntry>();
    static int fileNum = 1;
    public static void operate(String fileName, int fileID) throws IOException {
        FileInputStream file = new FileInputStream(fileName);
        DataInputStream data = new DataInputStream(file);
        while(data.available()>0) {
            String word = data.readUTF();
//            System.out.println(word);
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
//            System.out.println("El kelma: "+ word + " da el term freq "+index.get(word).term_freq + " da el doc freq "+index.get(word).doc_freq);
        }
    }

   public static void print(String FileName, int FileID){
       for (String name: index.keySet()) {
           Posting posting = index.get(name).pList;
//           String key = name;
           int value = index.get(name).doc_freq;
           System.out.print(name + " " + value);
           Posting pos = index.get(name).pList;
           String tmpString = " ";
           tmpString += String.valueOf(pos.docId)+" ";
           while(pos.next != null){
               pos = pos.next;
//               System.out.println(pos);
               tmpString+=" " + pos.docId+" ";
           }
           System.out.println(tmpString);

       }
   }

    public static void main(String[] args) throws IOException {

        operate(fileName1,1);
        operate(fileName2,2);
        operate(fileName3,3);
        operate(fileName4,4);
        operate(fileName5,5);
        operate(fileName6,6);
        operate(fileName7,7);
        operate(fileName8,8);
        operate(fileName9,9);
        operate(fileName10,10);
        print(fileName1,1);
//        print(fileName2,2);
//        print(fileName3,3);
//        print(fileName4,4);
//        print(fileName5,5);
//        print(fileName6,6);
//        print(fileName7,7);
//        print(fileName8,8);
//        print(fileName9,9);
//        print(fileName10,10);


    }
}
