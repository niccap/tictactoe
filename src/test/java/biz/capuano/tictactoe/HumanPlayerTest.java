package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


public class HumanPlayerTest {
    
    private HumanPlayer player;
    private Board board;

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
        board = new Board();
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
    public void testMakeMove1() {
        System.out.println("Tesing MakeMove: valid move");

        simulateInput("2 3\n");
        Move move = player.makeMove(board);
        assertEquals(2, move.getRow());
        assertEquals(3, move.getCol());
        restoreInput();
    }    
    @Test
    public void testMakeMove2() {
        System.out.println("Tesing MakeMove: invalid move");
        
        simulateInput("1 4 2 3\n");
        Move move = player.makeMove(board);
        assertEquals(2, move.getRow());
        assertEquals(3, move.getCol());
        restoreInput();
    }    
    @Test
    public void testMakeMove3() {
        System.out.println("Tesing MakeMove: occupied cell");
        
        simulateInput("2 3\n");
        player.makeMove(board);
        simulateInput("2 3 3 3\n");
        Move move = player.makeMove(board);
        assertEquals(3, move.getRow());
        assertEquals(3, move.getCol());
        restoreInput();
    }    

    /**
     * Helper fuctions to simulate user input
     */

    private InputStream originalInput; 

    private void simulateInput(String in) {
        originalInput = System.in; // Save the current input stream 
        System.setIn(new ByteArrayInputStream(in.getBytes())); // Temp input stream        
    }
    
    private void restoreInput() {
        System.setIn(originalInput); 
    }
}
