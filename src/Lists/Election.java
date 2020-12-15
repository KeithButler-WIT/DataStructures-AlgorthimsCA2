package Lists;

import utility.Utilities;

public class Election {
    private String type, // E.g. General, Local, European
            location, // E.g. County for local
            date, // Date/year taking place
            seatsWon; // 1 or more

    //---Constructor---//

    public Election(String type,String location,String date,String seatsWon){
        this.type=Utilities.toProperCase(type);
        this.location=location;
        this.date=date;
        this.seatsWon= Utilities.onlyContainsNumbers(seatsWon);
    }

    @Override
    public String toString() {
        return "Election{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", seatsWon='" + seatsWon + '\'' +
                '}';
    }
}
