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
        for(int i = 0; i < testFrames.length; i++)
            testFrames[i] = new Frame(0,0);
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
        assertEquals(true, strikeFrame.isStrike());
        assertEquals(false, noneStrikeFrame.isStrike());

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
        assertEquals(true, spareFrame.isSpare());
        assertEquals(false, noneStrikeFrame.isSpare());
        assertEquals(false, strikeFrame.isSpare());
        
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
    
    @Test
    public void strikeAndSpareTest()
    {
        Frame[] testFrames = new Frame[10];
        testFrames[0] = new Frame(10,0);
        testFrames[1] = new Frame(4,6);
        testFrames[2] = new Frame(7,2);
        testFrames[3] = new Frame(3,6);
        testFrames[4] = new Frame(4,4);
        testFrames[5] = new Frame(5,3);
        testFrames[6] = new Frame(3,3);
        testFrames[7] = new Frame(4,5);
        testFrames[8] = new Frame(8,1);
        testFrames[9] = new Frame(2,6);
        Game testGame = new Game(testFrames);
        
        assertEquals((10+4+6)+(4+6+7)+7+2+3+6+4+4+5+3+3+3+4+5+8+1+2+6, testGame.score());
    }
    
    @Test
    public void multipleStrikesTest()
    {
        Frame[] testFrames = new Frame[10];
        testFrames[0] = new Frame(10,0);
        testFrames[1] = new Frame(10,0);
        testFrames[2] = new Frame(7,2);
        testFrames[3] = new Frame(3,6);
        testFrames[4] = new Frame(4,4);
        testFrames[5] = new Frame(5,3);
        testFrames[6] = new Frame(3,3);
        testFrames[7] = new Frame(4,5);
        testFrames[8] = new Frame(8,1);
        testFrames[9] = new Frame(2,6);
        Game testGame = new Game(testFrames);
        
        assertEquals((10+10+7)+(10+7+2)+7+2+3+6+4+4+5+3+3+3+4+5+8+1+2+6, testGame.score());
    }
    
    @Test
    public void multipleSparesTest()
    {
        Frame[] testFrames = new Frame[10];
        testFrames[0] = new Frame(8,2);
        testFrames[1] = new Frame(5,5);
        testFrames[2] = new Frame(7,2);
        testFrames[3] = new Frame(3,6);
        testFrames[4] = new Frame(4,4);
        testFrames[5] = new Frame(5,3);
        testFrames[6] = new Frame(3,3);
        testFrames[7] = new Frame(4,5);
        testFrames[8] = new Frame(8,1);
        testFrames[9] = new Frame(2,6);
        Game testGame = new Game(testFrames);
        
        assertEquals((10+5)+(10+7)+7+2+3+6+4+4+5+3+3+3+4+5+8+1+2+6, testGame.score());
    }
    
    @Test
    public void spareLastFrameTest()
    {
        Frame[] testFrames = new Frame[11];
        testFrames[0] = new Frame(1,5);
        testFrames[1] = new Frame(3,6);
        testFrames[2] = new Frame(7,2);
        testFrames[3] = new Frame(3,6);
        testFrames[4] = new Frame(4,4);
        testFrames[5] = new Frame(5,3);
        testFrames[6] = new Frame(3,3);
        testFrames[7] = new Frame(4,5);
        testFrames[8] = new Frame(8,1);
        testFrames[9] = new Frame(2,8);
        //Spare throw
        testFrames[10] = new Frame(7,0);
        Game testGame = new Game();
        
        boolean keepThrow = true;
        for(Frame x : testFrames)
        {
            if(keepThrow)
                keepThrow = testGame.makeThrow(x.getThrows()[0], x.getThrows()[1]);
        }
        
        assertEquals(1+5+3+6+7+2+3+6+4+4+5+3+3+3+4+5+8+1+2+8+7, testGame.score());
    }
    
    @Test
    public void strikeLastFrameTest()
    {
        Frame[] testFrames = new Frame[11];
        testFrames[0] = new Frame(1,5);
        testFrames[1] = new Frame(3,6);
        testFrames[2] = new Frame(7,2);
        testFrames[3] = new Frame(3,6);
        testFrames[4] = new Frame(4,4);
        testFrames[5] = new Frame(5,3);
        testFrames[6] = new Frame(3,3);
        testFrames[7] = new Frame(4,5);
        testFrames[8] = new Frame(8,1);
        testFrames[9] = new Frame(10,0);
        //Spare throw
        testFrames[10] = new Frame(7,2);
        Game testGame = new Game();
        
        boolean keepThrow = true;
        for(Frame x : testFrames)
        {
            if(keepThrow)
                keepThrow = testGame.makeThrow(x.getThrows()[0], x.getThrows()[1]);
        }
        
        assertEquals(1+5+3+6+7+2+3+6+4+4+5+3+3+3+4+5+8+1+10+7+2, testGame.score());
    }
}
