package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    
    public MoveTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRow method, of class Move.
     */
    @Test
    public void testGetRow() {
        System.out.println("Testing getRow");
        Move instance = new Move(1, 2);
        int expResult = 1;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCol method, of class Move.
     */
    @Test
    public void testGetCol() {
        System.out.println("Testing getCol");
        Move instance = new Move(1, 2);
        int expResult = 2;
        int result = instance.getCol();
        assertEquals(expResult, result);
    }
    
}
