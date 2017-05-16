package labb5.game;

public class Game 
{
    int currentFrame = 0;
    Frame[] frames = null;
    Frame spareThrow = null;
    
    public Game()
    {
        spareThrow = new Frame(0, 0);
        frames = new Frame[10];
    }
    
    public Game(Frame[] frames)
    {
        this.spareThrow = new Frame(0,0);
        this.frames = frames;
    }
    
    public Frame[] getAllFrames()
    {
        return frames;
    }
    
    public boolean makeThrow(int throw1, int throw2)
    {
        boolean keepThrowing = false;
        
        if(currentFrame  < frames.length)
        {
            frames[currentFrame] = new Frame(throw1, throw2);
            currentFrame++;
            keepThrowing = true;
        }
        
        if(currentFrame == frames.length)
        {
            spareThrow = new Frame(throw1,throw2);
        }
        
        return keepThrowing;
    }
    
    public int score()
    {
        int totalGameScore = 0;
        boolean fullPoint = false;
        boolean firstPoint = false;
        for (int i = 0; i < frames.length;i++) {
            if (firstPoint) {
                totalGameScore += frames[i].getThrows()[0];
                firstPoint = false;
            }
            if (fullPoint) {
                if (frames[i].isStrike()) {
                    firstPoint = true;
                }
                totalGameScore += frames[i].score();
                fullPoint = false;
            }
            totalGameScore += frames[i].score();
            if (frames[i].isStrike()) {
                fullPoint = true;
            }
            if (frames[i].isSpare()) {
                firstPoint = true;
            }
        }
        
        if(firstPoint)
            totalGameScore += spareThrow.getThrows()[0];
        
        if(fullPoint)
            totalGameScore += spareThrow.score();
        
        return totalGameScore;
    }
}
