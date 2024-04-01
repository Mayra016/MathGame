package com.MathGame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MathGame.Models.GameModel;

@Service
public class GameService {
	
	
	// Reset level
	public GameModel resetLevel(GameModel game) {
		game.clear();
		return game;		
	}
	
	// Generate new level
	public GameModel generateNewLevel(GameModel currentGame) {
		currentGame.generateNumbers();
		currentGame.generateLevelSigns();
		currentGame.setAnswer(currentGame.calculateAnswer());
		return currentGame;
	}
	
	// Compare answer
	public boolean checkAnswer(String playerAnswer, float levelAnswer) {
		String answerString = String.valueOf(levelAnswer);
		if (playerAnswer.endsWith(".0")) {
			String[] answerNums = playerAnswer.split("\\.");
			System.out.println("answerNums[0] :" + answerNums[0]);
			playerAnswer = answerNums[0];
		} 
		
		if (answerString.endsWith(".0")) {
			String[] answerNums = String.valueOf(levelAnswer).split("\\.");
			System.out.println("answerNums[0] :" + answerNums[0]);
			answerString = answerNums[0];
		} 
		
		if (playerAnswer.equals(answerString)) {
			return true;
		} else {
			return false;
		}
	}
	
}
