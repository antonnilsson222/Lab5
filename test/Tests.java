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
        assertArrayEquals(myFrame.getFrameScoreArray(), testThrows);
    }
    
    @Test
    public void frameScore()
    {
        int[] testThrows = {5,1};
        Frame myFrame = new Frame(testThrows[0],testThrows[1]);
        assertEquals(testThrows[0]+testThrows[1], myFrame.getFrameScore());
    }
}
