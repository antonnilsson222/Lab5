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
        int totalScore = 0;
        for (Frame x : frames)
        {
            if(x != null)
                totalScore += x.getFrameScore();
        }
        
        return totalScore;
    }
}
