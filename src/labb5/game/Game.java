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
        boolean getFullPointAfter = false;
        boolean getFirstPointAfter = false;
        for (int i = 0; i < frames.length; i++)
        {
            if(frames[i] != null)
            {
                if(getFirstPointAfter)
                {
                    totalGameScore += frames[i].getFrameScoreArray()[0];
                    getFirstPointAfter = false;
                }
                
                if(getFullPointAfter)
                {
                    if(frames[i].strike())
                        getFirstPointAfter = true;
                    
                    totalGameScore += frames[i].getFrameScore();
                    getFullPointAfter = false;
                }
                
                totalGameScore += frames[i].getFrameScore();
                                
                if(frames[i].strike())
                    getFullPointAfter = true;
            }
        }
        
        return totalGameScore;
    }
}
