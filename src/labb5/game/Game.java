package labb5.game;

public class Game 
{
    Frame[] frames = null;
    
    public Game(Frame[] frames)
    {
        this.frames = frames;
    }
    
    public Frame[] getAllFramesArray()
    {
        return frames;
    }
    
    public int getGameScore()
    {
        int totalGameScore = 0;
        for (Frame x : frames)
        {
            if(x != null)
                totalGameScore += x.getFrameScore();
        }
        
        return totalGameScore;
    }
}
