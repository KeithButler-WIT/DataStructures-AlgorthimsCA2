package Lists;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ElectionList<E> {
    public ElectionNode<E> head,tail;

    public class ElectionNode<E> {
        // Todo: implement previous variable
        public ElectionNode<E> next, previous;  //points to next node
        private Election<E> contents; //stores the actual object in the contents field
        private CandidateList<Candidate> candidate=new CandidateList<>();

        public Election<E> getContents() { return contents; }
        public void setContents(Election<E> c) { contents=c; }

        public CandidateList<Candidate> getCandidate() {
            return candidate;
        }

        //---candidate Methods---//

        //Adds an candidate to the CandidateList
        public void addCandidate(int totalVotes, String previousParty){
            candidate.addElement(new Candidate(totalVotes,previousParty));
        }
    }

    //TODO: implement tail variable
    public void addElement(Election<E> e) { //Add element to head of list
        ElectionNode<E> nn = new ElectionNode<>(); //create a new node
        nn.setContents(e); //add the object to the contents
        nn.next=head; //make the nodes next point to what the head of the list is currently pointing to
        head=nn; //change the head so that it is now pointing to the newly created node
    }

    public void addLast(Election<E> e){
        if(size()==0) {
            head=tail=new ElectionNode<>();
        }
        else {
            tail.next=new ElectionNode<>();
            tail=tail.next;
        }
    }

    public String listAll(){
        String str="";
        if(isEmpty())
            return "No Elections present";
        for(int i=0;i<=size();i++) {
            str+=getObjectAtIndex(i).getContents().getType();
        }
        return str;
    }

    public int size(){ //Counts the total number of nodes
        ElectionNode<E> temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len; //Returns an int
    }

    //Returns location of object in list as int
    public int getIndex(Election<E> obj){
        ElectionNode<E> temp=head;
        int i=0;
        while (temp!=null){
            if(temp.getContents()==obj) //Checks if the node matches the inputted object
                return i;
            temp=temp.next; //Increments temp to next node in list
            i++;
        }
        return i;
    }


    //Returns location Node object at given index
    public ElectionNode<E> getObjectAtIndex(int index){
        ElectionNode<E> temp=head;
        if(temp==null) return null;

        int i=0;
        while (temp.next!=null && i!=index){
            temp=temp.next; //Increments temp to next node in list
            i++;
        }
        return temp;
    }

    //TODO: implement tail variable
    public void insertNext(Election<E> obj) { //Appends new object to end on list of objects
        ElectionNode<E> nn = new ElectionNode<>(); //create a new node
        nn.setContents(obj); //add the object to the contents
        if(head==null)
            head=tail=nn; //change the head so that it is now pointing to the newly created node
        else{
            tail.next=nn;
            tail=tail.next;
            ElectionNode<E> temp=head;

            while(temp.next!=null)
                temp = temp.next;
            temp.next=nn;
            tail=nn;
        }
    }

    public void rmFirst(){
        head=head.next;//Deletes the first element in list
    }

    public void rmIndex(int index){
        ElectionNode<E> temp=head;
        int i=0;
        while (++i<index-1 && temp!=null)
            temp=temp.next;
        if(temp!=null && temp.next!=null)
            temp.next=temp.next.next;
    }

    public void clear(){
        head=tail=null;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public  String printList()
    {
        ElectionNode<E> currNode = head;
        String fullList = "LinkedList: \n";

        if(currNode==null)
            fullList="Empty List.";
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            fullList += currNode.getContents();

            // Go to next node
            currNode = currNode.next;
        }
        return fullList;
    }

    //Todo: search
//    public String searchParty(String name){    //Returns only the first pallet found matching the input
//        for(int i=0;i<=size();i++) {
//            AisleList<Aisle> aisle=getFloorAtIndex(i).getAisle();
//            for(int j=0;j<=aisle.size();j++) {
//                ShelfList<Shelf> shelf=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf();
//                for(int k=0;k<=shelf.size();k++){
//                    PalletList<Pallet> pallet=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf().getShelfAtIndex(k).getPallet();
//                    for(int l=0;l<=pallet.size();l++){
//                        if(pallet.getPalletAtIndex(l).getContents().getGoodsDescription().contains(name))   //changed .equals to .contains
//                            return "Location in warehouse: "
//                                    +"\nFloor Index: "+getIndex(getFloorAtIndex(i).getContents())   //Returns index
//                                    +"\nAisle Identifier: "+aisle.getAisleAtIndex(j).getContents().getIdentifier()    //returns identifier not index
//                                    +"\nShelf Number: "+shelf.getShelfAtIndex(k).getContents().getShelfNum()    //returns shelf number not index
//                                    +"\nPallet Index: "+pallet.getIndex(pallet.getPalletAtIndex(l).getContents())   //Returns index
//                                    +"\n\n"+pallet.getPalletAtIndex(l).getContents().toString();
//                    }
//                }
//            }
//        }
//
//        return "No pallet with that description found.";
//    }

    //Todo: smart add
//    public void smartAdd(String goodsDescription, int quantity, Double minTemp, Double maxTemp, int width, int depth) {
//        //4 for loops is the only way I could think of doing it.
//        for(int i=0;i<=size();i++) {
//            AisleList<Aisle> aisle=getFloorAtIndex(i).getAisle();
//            if ((getFloorAtIndex(i).getContents().getTemperature() <= minTemp && getFloorAtIndex(i).getContents().getTemperature() >= maxTemp))
//                i++;
//            for(int j=0;j<=aisle.size();j++) {
//                ShelfList<Shelf> shelf=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf();
//                for(int k=0;k<=shelf.size();k++){
//                    PalletList<Pallet> pallet=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf().getShelfAtIndex(k).getPallet();
////                    for(int l=0;l<=pallet.size();l++){
//                    pallet.insertNext(new Pallet(goodsDescription, quantity, minTemp, maxTemp, width, depth));
//                    break;
////                    }
//                }
//            }
//        }
//    }

    //Todo: view
//    public String viewAllStock(){    //Returns every object in list as a String
//        String str="Warehouse contains: \n";
//        if(head==null) return "Warehouse is empty.";    //FloorList is empty
//        for(int i=0;i<=size()-1;i++) {
//            //Assigns AisleList to a variable
//            AisleList<Aisle> aisle=getFloorAtIndex(i).getAisle();   //Slightly improves readability later on
//            if(getFloorAtIndex(i)==null) str+="";
//            else str+="\nFloor Index: "+getIndex(getFloorAtIndex(i).getContents());  //Returns index;
//            for(int j=0;j<=aisle.size()-1;j++) {
//                //Assigns current ShelfList to a variable
//                ShelfList<Shelf> shelf=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf();
//                if(aisle.getAisleAtIndex(j)==null) str+="";
//                else str+="\n   Aisle Identifier: "+aisle.getAisleAtIndex(j).getContents().getIdentifier();    //returns identifier not index
//                for(int k=0;k<=shelf.size()-1;k++){
//                    //Assigns current PalletList to a variable
//                    PalletList<Pallet> pallet=getFloorAtIndex(i).getAisle().getAisleAtIndex(j).getShelf().getShelfAtIndex(k).getPallet();
//                    if(shelf.getShelfAtIndex(k)==null) str+="";
//                    else str+="\n       Shelf Number: "+shelf.getShelfAtIndex(k).getContents().getShelfNum();    //returns shelf number not index;
//                    for(int l=0;l<=pallet.size()-1;l++){
//                        if(pallet.getPalletAtIndex(l)==null) str+="";
//                        else str+="\n           Pallet Index: "+pallet.getIndex(pallet.getPalletAtIndex(l).getContents()); ;
//                    }
//                }
//            }
//        }
//
//        return str; //Final completed list of objects
//    }

    /**
     * loads the election from a .xml file
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Election.xml"));
        head = (ElectionNode<E>) is.readObject();
        is.close();
    }

    /**
     * saves the election to a .xml file
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Election.xml"));
        out.writeObject(head);
        out.close();
    }
}
