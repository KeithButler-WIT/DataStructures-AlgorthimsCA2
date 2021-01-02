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
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
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
    private int mainMenu() // Added since last interview
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
                    smartAdd();
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
                    updateCandiate();
                    break;
                case 12:
                    updatePolitician();
                    break;
                case 14:
//                    System.out.println(electionList.viewAllStock());
                    break;
                case 15:
                    interactiveViewStock();
                    break;
                case 16:
                    searchPallet();
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

    // Added since last interview
    public void addElection(){
        //Prompts the user to type variables
        int num = Utilities.readNextInt("Input the floors number: ");
        String level = Utilities.validNextLine("Input the floors level: ");
        float temp = Utilities.readNextFloat("Input the floors temperature: ");
        //Makes a Floor obj using those variables
        electionList.insertNext(new Election(num,level,temp));
    }

    // Added since last interview
    public void addCandidate(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too: ");
        //Prompts the user to type variables
        String identifier = Utilities.validNextLine("Input the identifier: ");
        int palletWidth = Utilities.readNextInt("Input the palletWidth: ");
        int palletDepth = Utilities.readNextInt("Input the palletDepth: ");
        // Uses the addPallet method in floorNode
        electionList.getObjectAtIndex(flrIndex).addCandidate(identifier,palletWidth,palletDepth); // Adds aisle with inputted variables
    }

    // Added since last interview
    public void addPolitician(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to add too: ");
        //Prompts the user to type variables
        int num = Utilities.readNextInt("Input the shelf number: ");
        // Uses the addPallet method in aisleNode
        electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).addPolitician(num);
    }

    // Added since last interview
    public void smartAdd(){
        String goodsDescription = Utilities.validNextLine("Input the goodsDescription: ");
        int quantity = Utilities.readNextInt("Input the quantity: ");
        Double minTemp = Utilities.readNextDouble("Input the minimum temperature: ");
        Double maxTemp = Utilities.readNextDouble("Input the maximum temperature: ");
        int width = Utilities.readNextInt("Input the width: ");
        int depth = Utilities.readNextInt("Input the depth: ");
        electionList.smartAdd(goodsDescription, quantity, minTemp, maxTemp, width, depth);
    }


    //--------------------//
    //   Delete Methods   //
    //--------------------//

    // Added since last interview
    public void removeElection(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to remove: ");
        electionList.rmIndex(flrIndex);
        System.out.println("Floor Removed.");
    }

    // Added since last interview
    public void removeCandidate(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to remove: ");
        electionList.getObjectAtIndex(flrIndex).getCandidate().rmIndex(ailIndex);
        System.out.println("Aisle Removed.");
    }

    // Added since last interview
    public void removePolitician(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to remove: ");
        electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).getShelf().rmIndex(slfIndex);
        System.out.println("Shelf Removed.");
    }

    //--------------------//
    //   Update Methods   //
    //--------------------//

    // Added since last interview
    public void updateElection(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to add too: ");
        //Prompts the user to type variables
        Election temp=electionList.getObjectAtIndex(flrIndex).getContents();
        temp.setFloorNum(Utilities.readNextInt("Input the floors number: "));
        temp.setSecurityLevel(Utilities.validNextLine("Input the floors level"));
        temp.setTemperature(Utilities.readNextFloat("Input the floors temperature"));
    }

    // Added since last interview
    public void updateCandiate(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to update");
        //Prompts the user to type variables
        Candidate temp=electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).getContents();
        temp.setIdentifier(Utilities.validNextLine("Input the identifier"));
        temp.setPalletWidth(Utilities.readNextInt("Input the palletWidth"));
        temp.setPalletDepth(Utilities.readNextInt("Input the palletDepth"));
    }

    // Added since last interview
    public void updatePolitician(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to add too");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to update");
        //Prompts the user to type variables
        // Uses the addPallet method in aisleNode
        Politician temp=electionList.getObjectAtIndex(flrIndex).getCandidate().getObjectAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getContents();
        temp.setShelfNum(Utilities.readNextInt("Input the shelf number"));
    }

    //-------------------------//
    //   Search/View Methods   //
    //-------------------------//

    // Added since last interview
    public void searchPallet(){
        String name = Utilities.validNextLine("Input the name of a pallet: ");
        electionList.searchPallet(name);
    }

    // Added since last interview
    public void interactiveViewStock(){
        System.out.println(electionList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to view: ");
        System.out.println(electionList.getObjectAtIndex(flrIndex).getCandidate().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());

    }
