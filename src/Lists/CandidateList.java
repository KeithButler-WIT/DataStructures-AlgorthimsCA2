package Lists;

public class CandidateList<C> {
    public CandidateNode<C> head,tail;

    public class CandidateNode<C> {
        public CandidateNode<C> next, previous;  //points to next node
        private Candidate<C> contents; //stores the actual object in the contents field
        private PoliticianList<P> politician=new PoliticianList<>();

        public Candidate<C> getContents() { return contents; }
        public void setContents(Candidate<C> c) { contents=c; }

        //Fixme: this needs to be changed
        public PoliticianList<P> getPolitician() {
            return politician;
        }

        //---politician Methods---//

        //Adds an politician to the PoliticianList
        public void addPolitician(String name,String dateOfBirth,String party,String homeCounty,String image){
            politician.addElement(new Politician(name,dateOfBirth,party,homeCounty,image));
        }
    }

    //TODO: implement tail variable
    public void addElement(C e) { //Add element to head of list
        CandidateNode<C> nn = new CandidateNode<C>(); //create a new node
        nn.setContents(e); //add the object to the contents
        nn.next=head; //make the nodes next point to what the head of the list is currently pointing to
        head=nn; //change the head so that it is now pointing to the newly created node
    }

    public void addLast(C e){
        if(size()==0) {
            head=tail=new CandidateNode<C>();
        }
        else {
            tail.next=new CandidateNode<C>();
            tail=tail.next;
        }
    }

    public String listAll(){
        String str="";
        if(isEmpty())
            return "No Candidates present";
        for(int i=0;i<=size();i++) {
            str+=getObjectAtIndex(i).getContents().getType();
        }
        return str;
    }

    public int size(){ //Counts the total number of nodes
        CandidateNode<C> temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len; //Returns an int
    }

    //Returns location of object in list as int
    public int getIndex(C obj){
        CandidateNode<C> temp=head;
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
    public CandidateNode<C> getObjectAtIndex(int index){
        CandidateNode<C> temp=head;
        if(temp==null) return null;

        int i=0;
        while (temp.next!=null && i!=index){
            temp=temp.next; //Increments temp to next node in list
            i++;
        }
        return temp;
    }

    //TODO: implement tail variable
    public void insertNext(C obj) { //Appends new object to end on list of objects
        CandidateNode<C> nn = new CandidateNode<C>(); //create a new node
        nn.setContents(obj); //add the object to the contents
        if(head==null)
            head=tail=nn; //change the head so that it is now pointing to the newly created node
        else{
            tail.next=nn;
            tail=tail.next;
            CandidateNode<C> temp=head;

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
        CandidateNode<C> temp=head;
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
        CandidateNode<C> currNode = head;
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