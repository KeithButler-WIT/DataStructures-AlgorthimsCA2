package utility;

import junit.framework.TestCase;

public class UtilitiesTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testOnlyContainsNumbers() {
    }

    public void testMax40Chars() {
        // Tests below the cut off point
        assertEquals("This is a 30 character string.", Utilities.max40Chars("This is a 30 character string."));
        // Tests at the cut off point
        assertEquals("This is a 40 character string. Extra bit", Utilities.max40Chars("This is a 40 character string. Extra bit"));
        // Tests after the cut off point
        assertEquals("This is a 46 character string. Extra EXTRA bit", Utilities.max40Chars("This is a 46 character string. Extra EXTRA bit"));
    }

    public void testValidIntRange() {
    }

    public void testValidParty() {
        assertTrue(Utilities.validParty("FinNA FalL"));     // Test on valid input
        assertTrue(Utilities.validParty("lABour paRTY"));     // Test on valid input
        assertFalse(Utilities.validParty("United Kingdom"));    // Test on invalid input
    }

    public void testToProperCase() {
        assertEquals("Finna Fall",Utilities.toProperCase("FinNA FalL"));    // toProperCase Only ever gets used if string is correct
    }
}