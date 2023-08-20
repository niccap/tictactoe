package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class BoardTest {
    
    public BoardTest() {
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
     * Test of isValidMove method, of class Board.
     */
    @Test
    public void testIsValidMove() {
        System.out.println("Testing isValidMove");
        Board board = new Board();
        assertEquals(false, board.isValidMove(new Move(0,0)));
        assertEquals(false, board.isValidMove(new Move(1,4)));
        assertEquals(false, board.isValidMove(new Move(0,1)));
        assertEquals(true, board.isValidMove(new Move(1,3)));
        assertEquals(true, board.isValidMove(new Move(2,2)));
    }

    /**
     * Test of makeMove method, of class Board.
    */
    @Test
    public void testMakeMove() {
        System.out.println("Testing makeMove");
        Board board = new Board();
        assertEquals(false, board.makeMove(new Move(0,0), 'X'));
        assertEquals(false, board.makeMove(new Move(1,4), 'X'));
        assertEquals(false, board.makeMove(new Move(0,1), 'X'));
        assertEquals(true, board.makeMove(new Move(1,3), 'X'));
        assertEquals(true, board.makeMove(new Move(2,2), 'X'));
        assertEquals(false, board.makeMove(new Move(1,3), 'X'));
        assertEquals(false, board.makeMove(new Move(2,2), 'X'));
    }
    
    /**
     * Test of isFull method, of class Board.
    */
    @Test
    public void testIsFull() {
        System.out.println("Testing isFull");
        Board board = new Board();
        assertEquals(false, board.isFull());
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(1,3), 'X');
        assertEquals(false, board.isFull());
        board.makeMove(new Move(2,1), 'X');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'X');
        assertEquals(false, board.isFull());
        board.makeMove(new Move(3,1), 'X');
        board.makeMove(new Move(3,2), 'X');
        board.makeMove(new Move(3,3), 'X');
        assertEquals(true, board.isFull());        
    }

    /**
     * Test of checkForWin method, of class Board.
    */
    @Test
    public void testCheckForWin() {
        System.out.println("Testing checkForWin");
        Board board = new Board();
        
        // Check empty board
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));

        // Check horizontal win X
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(1,3), 'X');
        assertEquals(true, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
        
        // Check horizontal win O
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'O');
        board.makeMove(new Move(2,3), 'O');
        assertEquals(true, board.checkForWin('X'));
        assertEquals(true, board.checkForWin('O'));

        // Check vertical win
        board = new Board();
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(3,2), 'X');        
        assertEquals(true, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
        
        // Check diagonal win
        board = new Board();
        board.makeMove(new Move(1,1), 'O');
        board.makeMove(new Move(2,2), 'O');
        board.makeMove(new Move(3,3), 'O');
        assertEquals(false, board.checkForWin('X'));
        assertEquals(true, board.checkForWin('O'));

        // Check no win
        board = new Board();
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));

        // Check no win with full board
        board.makeMove(new Move(3,1), 'O');
        board.makeMove(new Move(3,2), 'X');
        board.makeMove(new Move(3,3), 'O');
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
    }
    
    /**
     * Test of print method, of class Board.
    */
    @Test
    public void testPrint() {
        System.out.println("Testing print");

        // Save the current output stream 
        PrintStream originalOut = System.out;

        // Create a temporary output stream 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the test cases
        Board board = new Board();
        board.print();
        String expectedOutput = "┌───┬───┬───┐\n│   │   │   │ \n├───┼───┼───┤\n│   │   │   │ \n├───┼───┼───┤\n│   │   │   │ \n└───┴───┴───┘";
        assertEquals(expectedOutput, outputStream.toString().trim());

        outputStream.reset();
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(2,2), 'O');
        board.print();
        expectedOutput = "┌───┬───┬───┐\n│ X │   │   │ \n├───┼───┼───┤\n│   │ O │   │ \n├───┼───┼───┤\n│   │   │   │ \n└───┴───┴───┘";
        assertEquals(expectedOutput, outputStream.toString().trim());

        // Restore the original output stream
        System.setOut(originalOut);
    }

}
