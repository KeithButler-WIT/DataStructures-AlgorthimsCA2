package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.Utilities;

public class Main extends Application {

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
        System.out.println("    9) Update a Polnitician");
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
                    addAisle();
                    break;
                case 3:
                    addShelf();
                    break;
                case 4:
                    addPallet();
                    break;
                case 5:
                    smartAdd();
                    break;
                case 6:
                    removeFloor();
                    break;
                case 7:
                    removeAisle();
                    break;
                case 8:
                    removeShelf();
                    break;
                case 9:
                    removePallet();
                    break;
                case 10:
                    updateFloor();
                    break;
                case 11:
                    updateAisle();
                    break;
                case 12:
                    updateShelf();
                    break;
                case 13:
                    updatePallet();
                    break;
                case 14:
                    System.out.println(flrList.viewAllStock());
                    break;
                case 15:
                    interactiveViewStock();
                    break;
                case 16:
                    searchPallet();
                    break;
                case 17:
                    try {
                        flrList.save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 18:
                    try {
                        flrList.load();
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
        flrList.insertNext(new Floor(num,level,temp));
    }

    // Added since last interview
    public void addAisle(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too: ");
        //Prompts the user to type variables
        String identifier = Utilities.validNextLine("Input the identifier: ");
        int palletWidth = Utilities.readNextInt("Input the palletWidth: ");
        int palletDepth = Utilities.readNextInt("Input the palletDepth: ");
        // Uses the addPallet method in floorNode
        flrList.getFloorAtIndex(flrIndex).addAisle(identifier,palletWidth,palletDepth); // Adds aisle with inputted variables
    }

    // Added since last interview
    public void addShelf(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to add too: ");
        //Prompts the user to type variables
        int num = Utilities.readNextInt("Input the shelf number: ");
        // Uses the addPallet method in aisleNode
        flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).addShelf(num);
    }

    // Added since last interview
    public void addPallet(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want add too: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want add too: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());
        //Prompts the user to type variables
        String goodsDescription = Utilities.validNextLine("Input the goodsDescription: ");
        int quantity = Utilities.readNextInt("Input the quantity: ");
        Double minTemp = Utilities.readNextDouble("Input the minimum temperature: ");
        Double maxTemp = Utilities.readNextDouble("Input the maximum temperature: ");
        int width = Utilities.readNextInt("Input the width: ");
        int depth = Utilities.readNextInt("Input the depth: ");
        // Uses the addPallet method in shelfNode
        flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).addPallet(goodsDescription,quantity,minTemp,maxTemp,width,depth);
    }

    // Added since last interview
    public void smartAdd(){
        String goodsDescription = Utilities.validNextLine("Input the goodsDescription: ");
        int quantity = Utilities.readNextInt("Input the quantity: ");
        Double minTemp = Utilities.readNextDouble("Input the minimum temperature: ");
        Double maxTemp = Utilities.readNextDouble("Input the maximum temperature: ");
        int width = Utilities.readNextInt("Input the width: ");
        int depth = Utilities.readNextInt("Input the depth: ");
        flrList.smartAdd(goodsDescription, quantity, minTemp, maxTemp, width, depth);
    }


    //--------------------//
    //   Delete Methods   //
    //--------------------//

    // Added since last interview
    public void removeFloor(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to remove: ");
        flrList.rmIndex(flrIndex);
        System.out.println("Floor Removed.");
    }

    // Added since last interview
    public void removeAisle(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to remove: ");
        flrList.getFloorAtIndex(flrIndex).getAisle().rmIndex(ailIndex);
        System.out.println("Aisle Removed.");
    }

    // Added since last interview
    public void removeShelf(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to remove: ");
        flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().rmIndex(slfIndex);
        System.out.println("Shelf Removed.");
    }

    // Added since last interview
    public void removePallet(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());
        int pltIndex = Utilities.readNextInt("Input the pallet index you want to remove: ");
        flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().rmIndex(pltIndex);
        System.out.println("Pallet Removed.");
    }

    //--------------------//
    //   Update Methods   //
    //--------------------//

    // Added since last interview
    public void updateFloor(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to add too: ");
        //Prompts the user to type variables
        Floor temp=flrList.getFloorAtIndex(flrIndex).getContents();
        temp.setFloorNum(Utilities.readNextInt("Input the floors number: "));
        temp.setSecurityLevel(Utilities.validNextLine("Input the floors level"));
        temp.setTemperature(Utilities.readNextFloat("Input the floors temperature"));
    }

    // Added since last interview
    public void updateAisle(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to update");
        //Prompts the user to type variables
        Aisle temp=flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getContents();
        temp.setIdentifier(Utilities.validNextLine("Input the identifier"));
        temp.setPalletWidth(Utilities.readNextInt("Input the palletWidth"));
        temp.setPalletDepth(Utilities.readNextInt("Input the palletDepth"));
    }

    // Added since last interview
    public void updateShelf(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to update");
        //Prompts the user to type variables
        // Uses the addPallet method in aisleNode
        Shelf temp=flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getContents();
        temp.setShelfNum(Utilities.readNextInt("Input the shelf number"));
    }

    // Added since last interview
    public void updatePallet(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want add too");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());
        int pltIndex = Utilities.readNextInt("Input the pallet index you want to update");
        //Prompts the user to type variables
        Pallet temp=flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().getPalletAtIndex(pltIndex).getContents();
        temp.setGoodsDescription(Utilities.validNextLine("Input the shelf number"));
        temp.setQuantity(Utilities.readNextInt("Input the shelf number"));
        temp.setMinTemp(Utilities.readNextDouble("Input the shelf number"));
        temp.setMaxTemp(Utilities.readNextDouble("Input the shelf number"));
        temp.setWidth(Utilities.readNextInt("Input the shelf number"));
        temp.setDepth(Utilities.readNextInt("Input the shelf number"));
    }

    //-------------------------//
    //   Search/View Methods   //
    //-------------------------//

    // Added since last interview
    public void searchPallet(){
        String name = Utilities.validNextLine("Input the name of a pallet: ");
        flrList.searchPallet(name);
    }

    // Added since last interview
    public void interactiveViewStock(){
        System.out.println(flrList.printList());
        int flrIndex = Utilities.readNextInt("Input the floors index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().printList());
        int ailIndex = Utilities.readNextInt("Input the aisles index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().printList());
        int slfIndex = Utilities.readNextInt("Input the Shelf index you want to view: ");
        System.out.println(flrList.getFloorAtIndex(flrIndex).getAisle().getAisleAtIndex(ailIndex).getShelf().getShelfAtIndex(slfIndex).getPallet().printList());

    }
