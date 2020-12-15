package Lists;

import utility.Utilities;

public class Politician {
    private String name, dateOfBirth,
            party, // If any; Independent if not
            homeCounty, // E.g. Waterford
            image; // Image is a url

    //---Constructor---//

    public Politician(String name,String dateOfBirth,String party,String homeCounty,String image) {
        this.name=Utilities.max40Chars(name);
        this.dateOfBirth=dateOfBirth;
        this.party = (Utilities.validParty(party)) ? Utilities.toProperCase(party):"Independent";
        this.homeCounty=Utilities.toProperCase(homeCounty);
        this.image=image;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", Party='" + party + '\'' +
                ", homeCounty='" + homeCounty + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    //---Setters & Getters---//


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Utilities.max40Chars(name);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = (Utilities.validParty(party)) ? Utilities.toProperCase(party): this.party;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = Utilities.toProperCase(homeCounty);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
