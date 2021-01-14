package Lists;

import junit.framework.TestCase;

public class ElectionListTest extends TestCase {
    private ElectionList<Election> populatedElection,emptyElection = new ElectionList<>();
    private Election election1,election2,election3,election4;

    public void setUp() throws Exception {
        super.setUp();
        election1=new Election("Local","Waterford","20-05-2023","1");
        election2=new Election("General","Dublin","15-1-2200","0");
        election3=new Election("European","Europe","11-11-2055","abc");
        election3=new Election("Local","Cork","19-05-2077","-1");
    }

    public void tearDown() throws Exception {
        election1=election2=election3=null;
    }

    public void testAddElement() {
        populatedElection.addElement(election4);
        assertEquals(4,populatedElection.size());
    }

    public void testAddLast() {
        populatedElection.addLast(election4);
        assertEquals(election4,populatedElection.getObjectAtIndex(3));
    }

    public void testListAll() {
        assertEquals("",populatedElection.listAll());
        assertEquals("No Elections present",emptyElection.listAll());
    }

    public void testSize() {
        assertEquals(3,populatedElection.size());
        assertEquals(0,emptyElection.size());
    }

    public void testGetIndex() {
        assertEquals(0,populatedElection.getIndex(election1));
        assertEquals(2,populatedElection.getIndex(election3));
    }

    public void testGetObjectAtIndex() {
        assertEquals(election1,populatedElection.getObjectAtIndex(0));
        assertEquals(election3,populatedElection.getObjectAtIndex(2));
    }

    public void testInsertNext() {
        emptyElection.insertNext(election4);
        assertEquals(1,emptyElection.size());
        populatedElection.insertNext(election4);
        assertEquals(4,populatedElection.size());
    }

    public void testRmFirst() {
        assertEquals(election1,populatedElection.getObjectAtIndex(0));
        assertEquals(3,populatedElection.size());
        populatedElection.rmFirst();
        assertEquals(election2,populatedElection.getObjectAtIndex(0));
        assertEquals(2,populatedElection.size());
    }

    public void testRmIndex() {
        populatedElection.rmIndex(1);
        assertEquals(election3,populatedElection.getObjectAtIndex(1));
        assertEquals(2,2, populatedElection.size());
    }

    public void testClear() {
        populatedElection.clear();
        assertEquals(0,populatedElection.size());
    }

    public void testIsEmpty() {
    }

    public void testPrintList() {
        assertEquals("Empty List.",emptyElection.printList());
        assertEquals("",populatedElection.printList());
    }

    /**
     * Method for save and load
     * @throws java.lang.Exception Throws an exceptions
     */
    public void testSaveAndLoad() throws Exception{
        //TESTING AN EMPTY FLOOR LIST
        //--------------------------
        //Saving a new library object with an empty ArrayList of DVD
        assertEquals(0, emptyElection.size());
        assertNull(emptyElection.head);
        emptyElection.save();
        //Load the file into another library object and compare it to emptyFloor
        ElectionList<Election> newList1 = new ElectionList<>();
        newList1.load();
        assertEquals(newList1.size(), emptyElection.size());

        //TESTING A POPULATED FLOOR LIST
        //-----------------------------
        //Saving a library object with a populated List of Floors
        assertEquals(2, populatedElection.size());
        assertNotNull(populatedElection.head);
        populatedElection.save();
        //Load the file into another library object and compare it to populatedFloor
        ElectionList<Election> newList2 = new ElectionList<>();
        newList2.load();
        assertEquals(newList2.size(), populatedElection.size());
        assertEquals(newList2.getObjectAtIndex(0).getContents().toString(), populatedElection.getObjectAtIndex(0).getContents().toString());
        assertEquals(newList2.getObjectAtIndex(1).getContents().toString(), populatedElection.getObjectAtIndex(1).getContents().toString());
        //Checks if all child lists are saved/loaded correctly
        assertEquals(newList2.getObjectAtIndex(0).getCandidate().getObjectAtIndex(0).getContents().toString(), populatedElection.getObjectAtIndex(0).getCandidate().getObjectAtIndex(0).getContents().toString());
    }
}