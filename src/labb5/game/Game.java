package labb5.game;

public class Game 
{
    Frame[] frames = null;
    
    public Game(Frame[] frames)
    {
        this.frames = frames;
    }
    
    public Frame[] getFrameArray()
    {
        return frames;
    }
    
    public int getGameScore()
    {
        return 0;
    }
}
