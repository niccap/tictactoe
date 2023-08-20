package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {
    
    public ComputerPlayerTest() {
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
     * Test of getMark method, of class ComputerPlayer.
     */
    @Test
    public void testGetMark() {
        System.out.println("Testing getMark");
        ComputerPlayer player = new ComputerPlayer('X');
        assertEquals('X', player.getMark());
        player = new ComputerPlayer('O');
        assertEquals('O', player.getMark());
    }

    /**
     * Test of makeMove method, of class ComputerPlayer.
     */
    @Test
    public void testMakeMove() {
        System.out.println("Testing makeMove");
        ComputerPlayer playerX = new ComputerPlayer('X');
        ComputerPlayer playerO = new ComputerPlayer('O');
        Board board = new Board();
        
        // Check validity
        Move move = playerX.makeMove(board);
        assertTrue(move.getRow() >= 1 && move.getRow() <= 3);
        assertTrue(move.getCol() >= 1 && move.getCol() <= 3);

        // Check for non-repeat
        for (int i = 0; i < 8; ++i) {
            Move newMove = playerO.makeMove(board);
            assertTrue(newMove.getRow() >= 1 && newMove.getRow() <= 3);
            assertTrue(newMove.getCol() >= 1 && newMove.getCol() <= 3);
            assertFalse(newMove.getRow() == move.getRow() && newMove.getCol() == move.getCol());
        }
    }
    
}
