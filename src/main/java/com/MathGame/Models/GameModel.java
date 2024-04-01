package com.MathGame.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.MathGame.Interfaces.GameI;

public class GameModel implements GameI {
	private List<Integer> levelNumbers = new ArrayList<>();
	private char[] signs = {'+', '_', '/', 'x'};
	private char[] levelSigns;
	private short level;
	private int score;
	private float answer;
	private String levelEquation;
	
	public GameModel() {

		generateNumbers();
		generateLevelSigns();
		level = 1;
		score = 0;
		answer = calculateAnswer();
		
	}

	// GETTERS AND SETTERS


	@Override
	public List<Integer> getLevelNumbers() {
		return this.levelNumbers;
	}


	@Override
	public void setLevelNumbers(List<Integer> newNums) {
		this.levelNumbers = newNums;
		
	}


	@Override
	public char[] getSigns() {
		return this.signs;
	}


	@Override
	public void setSigns(char[] newSigns) {
		this.signs = newSigns;
	}

	@Override
	public char[] getLevelSigns() {
		return this.levelSigns;
	}

	@Override
	public void setLevelSigns(char[] newLevelSigns) {
		this.levelSigns = newLevelSigns;
	}

	@Override
	public short getLevel() {
		return this.level;
	}


	@Override
	public void setLevel() {
		this.level += 1;		
	}
	
	@Override
	public void setNewLevel(short newLevel) {
		this.level = (short) (newLevel + (short) 1);		
	}


	@Override
	public int getScore() {
		return this.score;
	}


	@Override
	public void setScore() {
		this.score += 10;
	}
	
	@Override
	public void setNewScore(int newScore) {
		this.score = newScore;
	}
	

	@Override
	public float getAnswer() {
		return this.answer;
	}

	@Override
	public void setAnswer(float newAnswer) {
		this.answer = newAnswer;	
	}
	
	@Override
	public String getLevelEquation() {
		return this.levelEquation;
	}
	
	@Override
	public void setLevelEquation(String newEquation) {
		this.levelEquation = newEquation;
	}
	
	// LEVEL GENERATION LOGIC

    
    public static int getIndexString(StringBuilder array, char element) {
        for (int i = 0; i < array.length(); i++) {
            if (array.charAt(i) == element) {
                return i;
            }
        }
        return -1;
    }

	
	public void generateLevelSigns() {
		Random generator = new Random();
		byte i;
		if (this.level <= 10) {
			this.levelSigns = new char[2];
			for (i = 0; i < 1; i++) {
				byte index = (byte) generator.nextInt(0, 4);
				this.levelSigns[i] = signs[index];
			}
		}
		
		if (this.level > 10 && this.level <= 20) {
			this.levelSigns = new char[3];
			for (i = 0; i <= 1; i++) {
				byte index = (byte) generator.nextInt(0, 4);
				this.levelSigns[i] = signs[index];
			}
		}
		
		if (this.level > 20 && this.level <= 40) {
			this.levelSigns = new char[4];
			for (i = 0; i <= 2; i++) {
				byte index = (byte) generator.nextInt(0, 4);
				this.levelSigns[i] = signs[index];
			}
		}
		
		if (this.level > 40) {
			this.levelSigns = new char[5];
			for (i = 0; i <= 3; i++) {
				byte index = (byte) generator.nextInt(0, 4);
				this.levelSigns[i] = signs[index];
			}
		}
	}
	
	
	public void generateNumbers() {
		Random generator = new Random();
		byte i = 0;
		if (this.level <= 10) {
			for (i = 0; i <= 1; i++) {
				levelNumbers.add(generator.nextInt(11));		
			}
		}	

		if (this.level > 10 && this.level <= 20) {
			for (i = 0; i <= 2; i++) {
				levelNumbers.add(generator.nextInt(11));
			}
		}
		
		if (this.level > 20 && this.level <= 40) {
			for (i = 0; i <= 3; i++) {
				levelNumbers.add(generator.nextInt(11));
			}
		}
		
		if (this.level > 40) {
			for (i = 0; i <= 4; i++) {
				levelNumbers.add(generator.nextInt(11));
			}
		}
		
		levelSigns = new char[levelNumbers.size() - 1];
		System.out.println(levelSigns.length);
	}
		
	public static String decimal(String answer) {
	    if (answer.contains(".0")) {
	    	String[] answerNums = answer.split("\\.");
	    	answer = answerNums[0];
	    	return answer;
	    }
			
		if (answer.contains(".")) {
			String[] answerNums = answer.split("\\.");
			System.out.println("answerNums[0] :" + answerNums[0]);
		    answer = answerNums[0].concat(".");
		    System.out.println(answerNums[1].length());
		    answer = answerNums[1].length() > 1 ? answer.concat(answerNums[1].substring(0,2)) : answer.concat(answerNums[1]);
		}	
		
		if (answer.endsWith(".0")) {
			String[] answerNums = answer.split("\\.");
			System.out.println("answerNums[0] :" + answerNums[0]);
		    answer = answerNums[0];
		} 		
		
		return answer;

	}
	
	public float calculateAnswer() {
		byte i;
		StringBuilder equation = new StringBuilder();
		List<Double> numbers = new ArrayList<>();
		String answer;
		double result;
		
		// Build equation
		for (i = 0; i < this.levelNumbers.size(); i++) {
			equation.append(this.levelNumbers.get(i));
			numbers.add(Double.valueOf(this.levelNumbers.get(i)));
			System.out.println(this.levelNumbers.get(i));
			
			if (i < (this.levelNumbers.size() - 1)) {
				equation.append(levelSigns[i]);
			}		
		}
		levelEquation = equation.toString();
		if (levelEquation.contains("_")) {
			levelEquation = levelEquation.replaceAll("_", "-");
		}
		answer = equation.toString();
		System.out.println(" Ecuación " + String.valueOf(equation));
		
		while (answer.contains("/")) {
			byte signIndex = (byte) getIndexString(equation, '/');
			byte numIndex = (byte) 0;
			if (equation.length() >= 4) {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 1) : (byte) 0;				
			} else {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 2) : (byte) 0;
			}			System.out.println("numIndex= " + numIndex);
			
			if (numbers.get(numIndex + 1) == 0) {
			    result = 0;
			} else {
			    result = numbers.get(numIndex) / numbers.get(numIndex + 1);
			}
			
			System.out.println("result " + result);
			
			byte digitsNum1 = (byte) String.valueOf(numbers.get(numIndex)).length();
			byte digitsNum2 = (byte) String.valueOf(numbers.get(numIndex+1)).length();
			numbers.set(numIndex, result);
			System.out.println("numbers list " + numbers.get(numIndex));
			int initialIndex = signIndex - digitsNum1 > 0 ? signIndex - digitsNum1 : 0;
			
			equation.replace(initialIndex, signIndex + digitsNum2, String.valueOf(result));
            System.out.println("equation divide: " + equation.toString());
			answer = equation.toString();
		}
		
		while (answer.contains("x")) {
			byte signIndex = (byte) getIndexString(equation, 'x');
			byte numIndex = (byte) 0;
			if (equation.length() >= 4) {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 1) : (byte) 0;				
			} else {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 2) : (byte) 0;
			}
			System.out.println("numIndex= " + numIndex);
			
			if (numIndex != 1) {
				result = numbers.get(numIndex) * numbers.get(numIndex + 1);	
			} else {
				result = numbers.get(0) * numbers.get(1);				
			}
			
			System.out.println("result " + result);
			
			byte digitsNum1 = (byte) String.valueOf(numbers.get(numIndex)).length();
			byte digitsNum2 = (byte) String.valueOf(numbers.get(numIndex+1)).length();
			numbers.set(numIndex, result);
			System.out.println("numbers list " + numbers.get(numIndex));
			int initialIndex = signIndex - digitsNum1 > 0 ? signIndex - digitsNum1 : 0;
			
			equation.replace(initialIndex, signIndex + digitsNum2, String.valueOf(result));
            System.out.println("equation multiply: " + equation.toString());
			answer = equation.toString();
		}
		
		while (answer.contains("+")) {
			byte signIndex = (byte) getIndexString(equation, '+');
			byte numIndex = (byte) 0;
			if (equation.length() >= 4) {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 1) : (byte) 0;				
			} else {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 2) : (byte) 0;
			}			System.out.println("numIndex= " + numIndex);
			
			result = numbers.get(numIndex) + numbers.get(numIndex + 1);
			
			System.out.println("result " + result);
			
			byte digitsNum1 = (byte) String.valueOf(numbers.get(numIndex)).length();
			byte digitsNum2 = (byte) String.valueOf(numbers.get(numIndex+1)).length();
			numbers.set(numIndex, result);
			System.out.println("numbers list " + numbers.get(numIndex));
			int initialIndex = signIndex - digitsNum1 > 0 ? signIndex - digitsNum1 : 0;
			
			equation.replace(initialIndex, signIndex + digitsNum2, String.valueOf(result));
            System.out.println("equation plus: " + equation.toString());
			answer = equation.toString();
		}
		
		while (answer.contains("_")) {
			byte signIndex = (byte) getIndexString(equation, '_');
			byte numIndex = (byte) 0;
			if (equation.length() >= 4) {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 1) : (byte) 0;				
			} else {
				numIndex = (signIndex >= 2) ? (byte) (signIndex - 2) : (byte) 0;
			}			System.out.println("numIndex= " + numIndex);
			
			if (numIndex != 1) {
				result = numbers.get(numIndex) - numbers.get(numIndex + 1);				
			} else {
				result = numbers.get(0) - numbers.get(1);
			}
			
			
			
			System.out.println("result " + result);
			
			byte digitsNum1 = (byte) String.valueOf(numbers.get(numIndex)).length();
			byte digitsNum2 = (byte) String.valueOf(numbers.get(numIndex+1)).length();
			numbers.set(numIndex, result);
			System.out.println("numbers list " + numbers.get(numIndex));
			int initialIndex = signIndex - digitsNum1 > 0 ? signIndex - digitsNum1 : 0;
			
			equation.replace(initialIndex, signIndex + digitsNum2, String.valueOf(result));
			
            System.out.println("equation minus: " + equation.toString());
			answer = equation.toString();
		}
		
		answer = decimal(answer);
		if (answer.chars().filter(ch -> ch == '.').count() > 1) {
			answer = decimal(answer);
		}
		
		System.out.println("answer" + answer);
		return Float.valueOf(answer);
    }
	
	public void clear() {
		this.level = 1;
		this.levelNumbers.clear();
		this.levelSigns = null;
		this.score = 0;
		this.levelEquation = "";
		this.answer= 0;
	}


}
