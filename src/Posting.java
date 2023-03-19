package src;

public class Posting {
    public Posting next = null;
    public int docId;
    public int dtf = 1; // document term frequency
    public Posting(int docId){
        this.docId = docId;
    }
    public Posting(int docId,int dtf){
        this.docId = docId;
        this.dtf = dtf;
    }
}
