package labb5.game;

public class Frame 
{   
    int[] score = null;
    
    public Frame(int firstThrow, int secondThrow)
    {
        score = new int[2];
        score[0] = firstThrow;
        score[1] = secondThrow;
    }
    
    public int[] getFrameScoreArray()
    {   
        return score;
    }
    
    public int getFrameScore()
    {
        return (score[0]+score[1]);
    }
    
    public boolean strike()
    {
        boolean isStrike = false;
        if(score[0] == 10)
            isStrike = true;
        
        return isStrike;
    }
}
