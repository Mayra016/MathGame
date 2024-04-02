package com.MathGame.Interfaces;

import java.util.List;

public interface GameI {
	// GETTER AND SETTERS 
	public List<Double> getLevelNumbers();
	public void setLevelNumbers(List<Double> newNums);
	
	public char[] getSigns();
	public void setSigns(char[] newSigns);
	
	public char[] getLevelSigns();
	public void setLevelSigns(char[] newLevelSigns);
	
	public short getLevel();
	public void setLevel();
	public void setNewLevel(short newLevel);
	
	public int getScore();
	public void setScore();
	public void setNewScore(int newScore);
	
	public float getAnswer();
	public void setAnswer(float newAnswer);
	
	public String getLevelEquation();
	public void setLevelEquation(String equation);
	
	// LEVEL GENERATION LOGIC
	
	public void generateLevelSigns();
	public void generateNumbers();
}
