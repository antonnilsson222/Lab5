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
        boolean fullPoint = false;
        boolean firstPoint = false;
        for (Frame frame : frames) {
            if (frame != null) {
                if (firstPoint) {
                    totalGameScore += frame.getFrameScoreArray()[0];
                    firstPoint = false;
                }
                if (fullPoint) {
                    if (frame.strike()) {
                        firstPoint = true;
                    }
                    totalGameScore += frame.getFrameScore();
                    fullPoint = false;
                }
                totalGameScore += frame.getFrameScore();
                if (frame.strike()) {
                    fullPoint = true;
                }
            }
        }
        
        return totalGameScore;
    }
}
