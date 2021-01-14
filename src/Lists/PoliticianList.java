package Lists;

public class PoliticianList {
    public PoliticianNode<Politician> head,tail;

    //FIXME: fix the generics
    public class PoliticianNode<P> {
        // Todo: implement previous variable
        public PoliticianNode<P> next, previous;  //points to next node
        private Politician<P> contents; //stores the actual object in the contents field
//        private CandidateList<C> candidate=new CandidateList<>();

        public Politician<P> getContents() { return contents; }
        public void setContents(Politician<P> c) { contents=c; }
    }

    // Todo: add fancy methods that do fancy things

    //TODO: implement tail variable
    public void addElement(Politician<Politician> e) { //Add element to head of list
        PoliticianNode<Politician> nn = new PoliticianNode<>(); //create a new node
        nn.setContents(e); //add the object to the contents
        nn.next=head; //make the nodes next point to what the head of the list is currently pointing to
        head=nn; //change the head so that it is now pointing to the newly created node
    }

    public void addLast(Politician<Politician> e){
        if(size()==0) {
            head=tail=new PoliticianNode<>();
        }
        else {
            tail.next=new PoliticianNode<>();
            tail=tail.next;
        }
    }

    public String listAll(){
        String str="";
        if(isEmpty())
            return "No Politicians present";
        for(int i=0;i<=size();i++) {
            str+=getObjectAtIndex(i).getContents().getName();
        }
        return str;
    }

    public int size(){ //Counts the total number of nodes
        PoliticianNode<Politician> temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len; //Returns an int
    }

    //Returns location of object in list as int
    public int getIndex(Politician<Politician> obj){
        PoliticianNode<Politician> temp=head;
        int i=0;
        while (temp!=null){
            if(temp.getContents().equals(obj)) //Checks if the node matches the inputted object
                return i;
            temp=temp.next; //Increments temp to next node in list
            i++;
        }
        return i;
    }


    //Returns location Node object at given index
    public PoliticianNode<P> getObjectAtIndex(int index){
        PoliticianNode<P> temp=head;
        if(temp==null) return null;

        int i=0;
        while (temp.next!=null && i!=index){
            temp=temp.next; //Increments temp to next node in list
            i++;
        }
        return temp;
    }

    //TODO: implement tail variable
    public void insertNext(Politician<P> obj) { //Appends new object to end on list of objects
        PoliticianNode<P> nn = new PoliticianNode<P>(); //create a new node
        nn.setContents(obj); //add the object to the contents
        if(head==null)
            head=tail=nn; //change the head so that it is now pointing to the newly created node
        else{
            tail.next=nn;
            tail=tail.next;
            PoliticianNode<P> temp=head;

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
        PoliticianNode<P> temp=head;
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
        PoliticianNode<P> currNode = head;
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
}
