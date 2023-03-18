package src;

public class DictEntry {
    private int doc_freq = 0; // number of documents that contain the term
    private int term_freq = 0; //number of times the term is mentioned in the collection
    private Posting pList = null;

}
