import java.lang.reflect.Constructor;
import org.junit.Test;
import static org.junit.Assert.*;
import labb5.game.*;
import org.junit.BeforeClass;

public class Tests {
    
    public Tests() 
    { }
    
    @Test
    public void defineFrameWithThrowsTest()
    {
        int[] testThrows = {5,1};
        Frame myFrame = new Frame(testThrows[0],testThrows[1]);
        assertArrayEquals(myFrame.checkConstructor(), testThrows);
    }
}
