package labb5.game;

public class Game 
{
    Frame[] frames = null;
    
    public Game(Frame[] frames)
    {
        this.frames = frames;
    }
    
    public Frame[] getAllFrames()
    {
        return frames;
    }
    
    public int score()
    {
        int totalGameScore = 0;
        boolean fullPoint = false;
        boolean firstPoint = false;
        for (Frame frame : frames) {
            if (frame != null) {
                if (firstPoint) {
                    totalGameScore += frame.getThrows()[0];
                    firstPoint = false;
                }
                if (fullPoint) {
                    if (frame.strike()) {
                        firstPoint = true;
                    }
                    totalGameScore += frame.score();
                    fullPoint = false;
                }
                totalGameScore += frame.score();
                if (frame.strike()) {
                    fullPoint = true;
                }
                if (frame.spare()) {
                    firstPoint = true;
                }
            }
        }
        
        return totalGameScore;
    }
}
