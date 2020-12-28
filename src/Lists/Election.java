package Lists;

import utility.Utilities;

public class Election<E> {
    // test to see if commits
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

    //---Methods---//

    @Override
    public String toString() {
        return "Election{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", seatsWon='" + seatsWon + '\'' +
                '}';
    }

    //---Setters & Getters---//

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeatsWon() {
        return seatsWon;
    }

    public void setSeatsWon(String seatsWon) {
        this.seatsWon = seatsWon;
    }
}
