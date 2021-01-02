package controllers;

import Lists.Candidate;
import Lists.Election;
import Lists.ElectionList;
import Lists.Politician;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.Utilities;

import java.util.Scanner;

public class Main extends Application {
    ElectionList<Election> electionList = new ElectionList<>();
    private Scanner input;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Election");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * mainMenu() - This method displays the menu for the application,
     * reads the menu option that the user entered and returns it.
     *
     * @return the users menu choice
     */
    private int mainMenu()
    {
        System.out.println("    1) Add an Election");
        System.out.println("    2) Add a Candidate");
        System.out.println("    3) Add a Politician");
        System.out.println("----------");
        System.out.println("    4) Delete an Election");
        System.out.println("    5) Delete a Candidate");
        System.out.println("    6) Delete a Politician");
        System.out.println("----------");
        System.out.println("    7) Update a Election");
        System.out.println("    8) Update a Candidate");
        System.out.println("    9) Update a Politician");
        System.out.println("    10) Update a Pallet");
        System.out.println("----------");
        System.out.println("    11) View All Stock");
        System.out.println("    15) Interactively View Stock");
        System.out.println("----------");
        System.out.println("    16) Search for pallet");
        System.out.println("----------");
        System.out.println("    17) Save to XML");
        System.out.println("    18) Load from XML");
        System.out.println("----------");
        System.out.println("    0) Exit");
        return Utilities.readNextInt("==>>");
    }


    // Added since last interview
    private void run() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addElection();
                    break;
                case 2:
                    addCandidate();
                    break;
                case 3:
                    addPolitician();
                    break;
                case 5:
//                    smartAdd();
                    break;
                case 6:
                    removeElection();
                    break;
                case 7:
                    removeCandidate();
                    break;
                case 8:
                    removePolitician();
                    break;
                case 10:
                    updateElection();
                    break;
                case 11:
                    updateCandidate();
                    break;
                case 12:
                    updatePolitician();
                    break;
                case 14:
//                    System.out.println(electionList.viewAllStock());
                    break;
                case 15:
//                    interactiveViewStock();
                    break;
                case 16:
//                    searchPallet();
                    break;
                case 17:
                    try {
                        electionList.save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 18:
                    try {
                        electionList.load();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            Utilities.validNextLine("\nPress any key to continue...");

            //display the main menu again
            option = mainMenu();
        }
    }

//    public void setup(){
//        flrList.insertNext(new Floor(1,"High",30));
//        flrList.getFloorAtIndex(0).getAisle().insertNext(new Aisle("5M",1,1));
//        flrList.getFloorAtIndex(0).getAisle().getAisleAtIndex(0).getShelf().insertNext(new Shelf(1));
//        flrList.getFloorAtIndex(0).getAisle().getAisleAtIndex(0).getShelf().getShelfAtIndex(0).getPallet().addElement(new Pallet("Apples",5,10.0,30.1,5,2));
//        flrList.insertNext(new Floor(2,"low",0));
//        flrList.getFloorAtIndex(1).getAisle().insertNext(new Aisle("4G",9,6));
//        flrList.getFloorAtIndex(1).getAisle().getAisleAtIndex(0).getShelf().insertNext(new Shelf(3));
//    }

    //-----------------//
    //   Add Methods   //
    //-----------------//

    public void addElection() {
        //Prompts the user to type variables
        String type = Utilities.validNextLine("Input the elections type: ");
        String location = Utilities.validNextLine("Input the elections location: ");
        String date = Utilities.validNextLine("Input the elections date (DD/MM/YYYY): ");
        String seatsWon = Utilities.validNextLine("Input the elections seats won: ");
        //Makes a Floor obj using those variables
        electionList.insertNext(new Election(type, location, date, seatsWon));
    }

    public void addCandidate() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the election index you want add too: ");
        //Prompts the user to type variables
        int totalVotes = Utilities.readNextInt("Input the total Votes: ");
        String previousParty = Utilities.validNextLine("Input any previous party: ");
        // Uses the addPallet method in floorNode
        electionList.getObjectAtIndex(EleIndex).addCandidate(totalVotes, previousParty); // Adds aisle with inputted variables
    }

    public void addPolitician() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the elections index you want add too: ");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().printList());
        int CandIndex = Utilities.readNextInt("Input the candidates index you want to add too: ");
        //Prompts the user to type variables
        String name = Utilities.validNextLine("Input the politicians name: ");
        String dateOfBirth = Utilities.validNextLine("Input the date of birth (DD/MM/YYYY): ");
        String party = Utilities.validNextLine("Input the party: ");
        String homeCounty = Utilities.validNextLine("Input the home county: ");
        String image = Utilities.validNextLine("Input the image as a url: ");
        // Uses the addPolitician method in aisleNode
        electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).addPolitician(name,dateOfBirth,party,homeCounty,image);
    }

    //TODO: add this if needed
//    public void smartAdd() {
//        String goodsDescription = Utilities.validNextLine("Input the goodsDescription: ");
//        int quantity = Utilities.readNextInt("Input the quantity: ");
//        Double minTemp = Utilities.readNextDouble("Input the minimum temperature: ");
//        Double maxTemp = Utilities.readNextDouble("Input the maximum temperature: ");
//        int width = Utilities.readNextInt("Input the width: ");
//        int depth = Utilities.readNextInt("Input the depth: ");
//        electionList.smartAdd(goodsDescription, quantity, minTemp, maxTemp, width, depth);
//    }


    //--------------------//
    //   Delete Methods   //
    //--------------------//

    public void removeElection() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the elections index you want to remove: ");
        electionList.rmIndex(EleIndex);
        System.out.println("Election Removed.");
    }

    public void removeCandidate() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the elections index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().printList());
        int CandIndex = Utilities.readNextInt("Input the candidate index you want to remove: ");
        electionList.getObjectAtIndex(EleIndex).getCandidate().rmIndex(CandIndex);
        System.out.println("Candidate Removed.");
    }

    public void removePolitician() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the elections index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().printList());
        int CandIndex = Utilities.readNextInt("Input the candidate index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).getPolitician().printList());
        int PoliIndex = Utilities.readNextInt("Input the politician index you want to remove: ");
        electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).getPolitician().rmIndex(PoliIndex);
        System.out.println("Politician Removed.");
    }

    //--------------------//
    //   Update Methods   //
    //--------------------//

    public void updateElection() {
        System.out.println(electionList.printList());
        int index = Utilities.readNextInt("Input the elections index you want to add too: ");
        //Prompts the user to type variables
        Election temp = electionList.getObjectAtIndex(index).getContents();
        temp.setType(Utilities.validNextLine("Input the election type (e.g. General, Local, European): "));
        temp.setLocation(Utilities.validNextLine("Input the Location"));
        temp.setDate(Utilities.validNextLine("Input the Date taking place (DD/MM/YYYY)"));
        temp.setSeatsWon(Utilities.validNextLine("Input the total of seats won"));
    }

    public void updateCandidate() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the election index you want add too");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().printList());
        int CandIndex = Utilities.readNextInt("Input the candidate index you want to update");
        //Prompts the user to type variables
        Candidate temp = electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).getContents();
        temp.setTotalVotes(Utilities.readNextInt("Input the total votes"));
        temp.setPreviousParty(Utilities.validNextLine("Input the precious parties"));
    }

    public void updatePolitician() {
        System.out.println(electionList.printList());
        int EleIndex = Utilities.readNextInt("Input the election index you want add too");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().printList());
        int CandIndex = Utilities.readNextInt("Input the candidate index you want to add too");
        System.out.println(electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).getPolitician().printList());
        int PoliIndex = Utilities.readNextInt("Input the politician index you want to update");
        //Prompts the user to type variables
        // Uses the addPallet method in candidateNode class
        Politician temp = electionList.getObjectAtIndex(EleIndex).getCandidate().getObjectAtIndex(CandIndex).getPolitician().getObjectAtIndex(PoliIndex).getContents();
        temp.setName(Utilities.validNextLine("Input the politicians name"));
        temp.setDateOfBirth(Utilities.validNextLine("Input the date of birth (DD/MM/YYYY)"));
        temp.setParty(Utilities.validNextLine("Input the party"));
        temp.setHomeCounty(Utilities.validNextLine("Input the home county"));
        temp.setImage(Utilities.validNextLine("Input the politicians image as a url"));
    }

    //-------------------------//
    //   Search/View Methods   //
    //-------------------------//

//    public void searchParty() {
//        String name = Utilities.validNextLine("Input the name of a pallet: ");
//        electionList.searchPallet(name);
//    }

//    public void interactiveViewStock() {
//        System.out.println(electionList.printList());
//        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
//        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
//        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
//        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getAisleAtIndex(ailIndex).getShelf().printList());
//        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to view: ");
//        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());
//    }

    //Todo: change variable names to work with current list
    public static void bubbleSort(int[] a){
        for(int b=1;b<a.length;b++){
            for(int i=0;i<a.length-b;i++){

                if(a[i]>a[i+1]){
                    int swap=a[i];
                    a[i]=a[i+1];
                    a[i+1]=swap;
                }
            }
        }
    }
    public static void bubbleSort(ElectionList a){
        for(int b=1;b<a.size();b++){
            for(int i=0;i<a.size()-b;i++){

                if(a.getObjectAtIndex(i)>a.getObjectAtIndex(i+1){
                    ElectionList swap=a.getObjectAtIndex(i);
                    a[i]=a[i+1];
                    a[i+1]=swap;
                }
            }
        }
    }


}
