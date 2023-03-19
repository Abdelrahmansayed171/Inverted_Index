package src;

public class DictEntry {
    public int doc_freq = 0; // number of documents that contain the term
    public int term_freq = 0; //number of times the term is mentioned in the collection
    public Posting pList = null;

    public DictEntry() {
        doc_freq = 1;
        term_freq = 1;
    }
}
