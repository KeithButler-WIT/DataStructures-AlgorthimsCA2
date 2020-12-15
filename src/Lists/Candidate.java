package Lists;

import javafx.beans.property.StringProperty;

public class Candidate {
    private int totalVotes; // Total votes they got
    private String previousParty; // Any past party associations

    //---Constructor---//

    public Candidate(int totalVotes, String previousParty){
        this.totalVotes=totalVotes;
        this.previousParty=previousParty;
    }

    //---Methods---//

    @Override
    public String toString() {
        return "Candidate{" +
                "totalVotes=" + totalVotes +
                ", previousParty='" + previousParty + '\'' +
                '}';
    }

    //---Setters & Getters---//

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public String getPreviousParty() {
        return previousParty;
    }

    public void setPreviousParty(String previousParty) {
        this.previousParty = previousParty;
    }
}
