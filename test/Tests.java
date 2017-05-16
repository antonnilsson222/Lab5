import org.junit.Test;
import static org.junit.Assert.*;
import labb5.game.*;

public class Tests {
    
    public Tests() 
    { }
    
    @Test
    public void defineFrameWithThrowsTest()
    {
        int[] testThrows = {5,1};
        Frame myFrame = new Frame(testThrows[0],testThrows[1]);
        assertArrayEquals(myFrame.getThrows(), testThrows);
    }
    
    @Test
    public void frameScore()
    {
        int[] testThrows = {5,1};
        Frame myFrame = new Frame(testThrows[0],testThrows[1]);
        assertEquals(testThrows[0]+testThrows[1], myFrame.score());
    }
    
    @Test
    public void defineGameWithFrames()
    {
        Frame[] testFrames = new Frame[10];
        testFrames[0] = new Frame(12,5);
        Game testGame = new Game(testFrames);
        assertArrayEquals(testGame.getAllFrames(), testFrames);
    }
    
    @Test
    public void gameScore()
    {
        Frame[] testFrames = new Frame[10];
        testFrames[0] = new Frame(12,5);
        testFrames[5] = new Frame(2,18);
        testFrames[9] = new Frame(6,3);
        
        Game testGame = new Game(testFrames);
        assertEquals(46, testGame.score());
    }
    
    @Test
    public void strikeTest()
    {
        Frame strikeFrame = new Frame(10,0);
        Frame noneStrikeFrame = new Frame(5,2);
        assertEquals(true, strikeFrame.strike());
        assertEquals(false, noneStrikeFrame.strike());

        assertEquals(10, strikeFrame.score());
        
        Frame[] testFrames = new Frame[10];
        testFrames[0] = strikeFrame;
        testFrames[1] = noneStrikeFrame;
        testFrames[2] = strikeFrame;
        testFrames[3] = strikeFrame;
        testFrames[4] = noneStrikeFrame;
        testFrames[5] = strikeFrame;
        testFrames[6] = strikeFrame;
        testFrames[7] = strikeFrame;
        testFrames[8] = noneStrikeFrame;
        testFrames[9] = strikeFrame;
        Game testGame = new Game(testFrames);
        
        assertEquals(((10+5+2)+5+2+(10+10+5)+(10+5+2)+5+2+(10+10+10)+(10+10+5)+(10+5+2)+5+2+(10)), testGame.score());

    }
    
    @Test
    public void spareTest()
    {
        Frame strikeFrame = new Frame(10,0);
        Frame noneStrikeFrame = new Frame(5,2);
        Frame spareFrame = new Frame(6,4);
        assertEquals(true, spareFrame.spare());
        assertEquals(false, noneStrikeFrame.spare());
        assertEquals(false, strikeFrame.spare());
        
        assertEquals(10, spareFrame.score());

        Frame[] testFrames = new Frame[10];
        testFrames[0] = spareFrame;
        testFrames[1] = noneStrikeFrame;
        testFrames[2] = spareFrame;
        testFrames[3] = spareFrame;
        testFrames[4] = noneStrikeFrame;
        testFrames[5] = spareFrame;
        testFrames[6] = spareFrame;
        testFrames[7] = spareFrame;
        testFrames[8] = noneStrikeFrame;
        testFrames[9] = spareFrame;
        Game testGame = new Game(testFrames);
        
        assertEquals((10+5)+5+2+(10+6)+(10+5)+5+2+(10+6)+(10+6)+(10+5)+5+2+(10), testGame.score());

    }
}
