package src;

import java.io.*;
import java.util.*;

public class Main {
    public static String fileName1 = "Doc1.txt";
    public static String fileName2 = "Doc2.txt";
    public static String fileName3 = "Doc3.txt";
    public static String fileName4 = "Doc4.txt";
    public static String fileName5 = "Doc5.txt";
    public static String fileName6 = "Doc6.txt";
    public static String fileName7 = "Doc7.txt";
    public static String fileName8 = "Doc8.txt";
    public static String fileName9 = "Doc9.txt";
    public static String fileName10 = "Doc10.txt";
    public static HashMap<String, DictEntry> index = new HashMap<String, DictEntry>();
    static int fileNum = 1;

    public static void operate(String fileName, int fileID) throws IOException {
//        FileInputStream file = new FileInputStream(fileName);
//        DataInputStream data = new DataInputStream(file);
//        while(data.available()>0) {
//            String word = data.readUTF();
//            word = word.toLowerCase();
//            if(!index.containsKey(word)){
//                Posting tempPosting = new Posting(fileID);
//                DictEntry tempEntry = new DictEntry();
//                tempEntry.pList = tempPosting;
//                index.put(word,tempEntry);
//            }
//            else{
//                if(fileNum != fileID){
//                    fileNum = fileID;
//                    index.get(word).doc_freq++;
//                    int newDtf = index.get(word).term_freq+1;
//                    Posting posting = new Posting(fileID,newDtf);
//
//                    Posting prePosting = index.get(word).pList;
//                    while(prePosting.next != null){
//                        prePosting = prePosting.next;
//                    }
//                    prePosting.next = posting;
//                }
//                index.get(word).term_freq++;
//            }
//        }
        try {
            // create a Scanner object to read the file
            Scanner scanner = new Scanner(new File(fileName));

            // iterate through each word in the file
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.toLowerCase();
                if (!index.containsKey(word)) {
                    Posting tempPosting = new Posting(fileID);
                    DictEntry tempEntry = new DictEntry();
                    tempEntry.pList = tempPosting;
                    index.put(word, tempEntry);
                } else {
                    if (fileNum != fileID) {
                        fileNum = fileID;
                        index.get(word).doc_freq++;
                        int newDtf = index.get(word).term_freq + 1;
                        Posting posting = new Posting(fileID, newDtf);

                        Posting prePosting = index.get(word).pList;
                        while (prePosting.next != null) {
                            prePosting = prePosting.next;
                        }
                        prePosting.next = posting;
                    }
                    index.get(word).term_freq++;
                }
            }

            // close the scanner to free up resources
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void print() {
        List<String> mapKeys = new ArrayList<>(index.keySet());
        Collections.sort(mapKeys);
        for (String name : mapKeys) {
            int value = index.get(name).doc_freq;
            System.out.print(name + " " + value);
            Posting pos = index.get(name).pList;
            String tmpString = " -- > ";
            tmpString += String.valueOf(pos.docId);
            while (pos.next != null) {
                pos = pos.next;
                tmpString += ", " + pos.docId;
            }
            System.out.println(tmpString);

        }
    }

    public static void main(String[] args) throws IOException {

        operate(fileName1, 1);
        operate(fileName2, 2);
        operate(fileName3, 3);
        operate(fileName4, 4);
        operate(fileName5, 5);
        operate(fileName6, 6);
        operate(fileName7, 7);
        operate(fileName8, 8);
        operate(fileName9, 9);
        operate(fileName10, 10);
        print();

    }
}
