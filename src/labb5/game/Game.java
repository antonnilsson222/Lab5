package labb5.game;

public class Game 
{
    Frame[] frames = null;
    Frame spareThrow = null;
    
    public Game(Frame[] frames)
    {
        this.spareThrow = new Frame(0,0);
        this.frames = frames;
    }
    
    public Game(Frame[] frames, Frame spareThrow)
    {
        this.spareThrow = spareThrow;
        this.frames = frames;
    }
    
    public Frame[] getAllFrames()
    {
        return frames;
    }
    
    public int score()
    {
        int totalGameScore = 0;
        int lastFrame = 0;
        boolean fullPoint = false;
        boolean firstPoint = false;
        for (int i = 0; i < frames.length;i++) {
            if (frames[i] != null) {
                if (firstPoint) {
                    totalGameScore += frames[i].getThrows()[0];
                    firstPoint = false;
                }
                if (fullPoint) {
                    if (frames[i].strike()) {
                        firstPoint = true;
                    }
                    totalGameScore += frames[i].score();
                    fullPoint = false;
                }
                totalGameScore += frames[i].score();
                if (frames[i].strike()) {
                    fullPoint = true;
                }
                if (frames[i].spare()) {
                    firstPoint = true;
                }
                lastFrame = i;
            }
        }
        
        if(frames[lastFrame].spare())
            totalGameScore += spareThrow.getThrows()[0];
        
        return totalGameScore;
    }
}
