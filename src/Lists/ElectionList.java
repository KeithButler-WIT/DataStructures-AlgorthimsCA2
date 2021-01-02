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
//        private CandidateList<C> candidate=new CandidateList<>();

        public Election<E> getContents() { return contents; }
        public void setContents(Election<E> c) { contents=c; }

//        public CandidateList<C> getCandidate() {
//            return candidate;
//        }
//
//        //---candidate Methods---//
//
//        //Adds an candidate to the CandidateList
//        public void addCandidate(String id,int width,int depth){
//            candidate.addElement(new Candidate(id,width,depth));
//        }
    }

    //TODO: implement tail variable
    public void addElement(Election<E> e) { //Add element to head of list
        ElectionNode<E> nn = new ElectionNode<>(); //create a new node
        nn.setContents(e); //add the object to the contents
        nn.next=head; //make the nodes next point to what the head of the list is currently pointing to
        head=nn; //change the head so that it is now pointing to the newly created node
    }

    public void addLast(Election e){
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
            return "No Floors present";
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

    // TODO: implement save/load
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
