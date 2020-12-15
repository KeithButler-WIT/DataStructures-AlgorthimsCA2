package Lists;

import javafx.beans.property.StringProperty;

public class Candidate {
    private int totalVotes; // Total votes they got
    private String previousParty; // Any past party associations

    public Candidate(int totalVotes, String previousParty){
        this.totalVotes=totalVotes;
        this.previousParty=previousParty;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "totalVotes=" + totalVotes +
                ", previousParty='" + previousParty + '\'' +
                '}';
    }
}
