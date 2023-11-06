package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
    
    HumanPlayer player;
    
    public HumanPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        player = new HumanPlayer('O');
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMark method, of class HumanPlayer.
     */
    @Test
    public void testGetMark() {
        System.out.println("Testing getMark");
        assertEquals('O', player.getMark());
    }

    /**
     * Test of makeMove method, of class HumanPlayer.
     */
    @Test
    public void testMakeMove() {
        System.out.println("Tesing MakeMove: Needs Manual Testing");
    }    

}
