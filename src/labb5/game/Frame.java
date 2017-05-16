package labb5.game;

public class Frame 
{   
    int[] score = null;
    
    public  Frame()
    { }
    
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
}
