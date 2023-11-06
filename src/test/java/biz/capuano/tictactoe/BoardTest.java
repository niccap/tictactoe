package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class BoardTest {
    Board board;
    
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
        board = new Board();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidMove method, of class Board.
     */
    @Test
    public void testIsValidMove1() {
        System.out.println("Testing isValidMove: correct row and column");
        assertEquals(true, board.isValidMove(new Move(1,3)));
    }
    @Test
    public void testIsValidMove2() {
        System.out.println("Testing isValidMove: correct row wrong column");
        assertEquals(false, board.isValidMove(new Move(2,0)));
    }
    @Test
    public void testIsValidMove3() {
        System.out.println("Testing isValidMove: wrong row, correct column");
        assertEquals(false, board.isValidMove(new Move(4,2)));
    }
    @Test
    public void testIsValidMove4() {
        System.out.println("Testing isValidMove: wrong row and column");
        assertEquals(false, board.isValidMove(new Move(0,4)));
    }
    
    /**
     * Test of makeMove method, of class Board.
    */
    @Test
    public void testMakeMove1() {
        System.out.println("Testing makeMove: correct row and column");
        assertEquals(true, board.makeMove(new Move(2,2), 'X'));
    }
    @Test
    public void testMakeMove2() {
        System.out.println("Testing makeMove: correct row, wrong column");
        assertEquals(false, board.makeMove(new Move(2,-1), 'O'));
    }
    @Test
    public void testMakeMove3() {
        System.out.println("Testing makeMove: wrong row, correct column");
        assertEquals(false, board.makeMove(new Move(4,1), 'X'));
    }
    @Test
    public void testMakeMove4() {
        System.out.println("Testing makeMove: wrong row and column");
        assertEquals(false, board.makeMove(new Move(-2,-2), 'O'));
    }
    @Test   
    public void testMakeMove5() {
        System.out.println("Testing makeMove: box occupied, same symbol");
        assertEquals(true, board.makeMove(new Move(1,3), 'X'));
        assertEquals(false, board.makeMove(new Move(1,3), 'X'));
    }
    @Test   
    public void testMakeMove6() {
        System.out.println("Testing makeMove: box occupied, different symbol");
        assertEquals(true, board.makeMove(new Move(3,1), 'X'));
        assertEquals(false, board.makeMove(new Move(3,1), 'O'));
    }
    
    /**
     * Test of isFull method, of class Board.
    */
    @Test
    public void testIsFull1() {
        System.out.println("Testing isFull: empty board");
        assertEquals(false, board.isFull());
    }
    @Test
    public void testIsFull2() {
        System.out.println("Testing isFull: not full");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        assertEquals(false, board.isFull());
    }
    @Test
    public void testIsFull3() {
        System.out.println("Testing isFull: almost full");
        board.makeMove(new Move(1,1), 'O');
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(1,3), 'O');
        board.makeMove(new Move(2,1), 'X');
        board.makeMove(new Move(2,2), 'O');
        board.makeMove(new Move(2,3), 'X');
        board.makeMove(new Move(3,1), 'O');
        board.makeMove(new Move(3,2), 'X');
        assertEquals(false, board.isFull());        
    }
    @Test
    public void testIsFull4() {
        System.out.println("Testing isFull: full");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        board.makeMove(new Move(3,1), 'X');
        board.makeMove(new Move(3,2), 'O');
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
