package com.MathGame;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.MathGame.Models.GameModel;

public class GameEntityTest {

	@InjectMocks
	GameModel gameEntity = new GameModel();

	List<Double> levelNumbers = new ArrayList<>();
	
	char[] sign = new char[1];
	
	float answer;
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void generateNumersTest() {
		levelNumbers = gameEntity.getLevelNumbers();
		for (Double number : levelNumbers) {
			System.out.println(number);
			assertNotNull(number);
		}		
	}
	
	@Test
	public void calculateAnswerTest() {
		assertNotNull(gameEntity.getAnswer());
	}
	
	@Test
	public void sume() {
		char[] sign = {'+'};
		levelNumbers.clear();
		levelNumbers.add((double) 3);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(sign);
		answer = gameEntity.calculateAnswer();
		assertEquals("3.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("5.0", String.valueOf(answer));
		System.out.println("answer test sume: " + answer);
	}
	
	@Test
	public void minus() {
		char[] minus = {'_'};
		levelNumbers.clear();
		levelNumbers.add((double) 3);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(minus);
		answer = gameEntity.calculateAnswer();
		assertEquals("3.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("1.0", String.valueOf(answer));
		System.out.println("answer test minus: " + answer);
	}
	
	@Test
	public void divideRounded() {
		char[] divide = {'/'};
		levelNumbers.clear();
		levelNumbers.add((double) 6);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(divide);
		answer = gameEntity.calculateAnswer();
		assertEquals("6.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("3.0", String.valueOf(answer));
		System.out.println("answer test divide: " + answer);
	}
	
	@Test
	public void divideWithDecimals() {
		char[] divide = {'/'};
		levelNumbers.clear();
		levelNumbers.add((double) 7);
		levelNumbers.add((double) 3);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(divide);
		answer = gameEntity.calculateAnswer();
		assertEquals("7.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("3.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("2.33", String.valueOf(answer));
		System.out.println("answer test divide with decimals: " + answer);
	}
	
	@Test
	public void multiply() {
		char[] multiply = {'x'};
		levelNumbers.clear();
		levelNumbers.add((double) 3);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(multiply);
		answer = gameEntity.calculateAnswer();
		assertEquals("3.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("6.0", String.valueOf(answer));
		System.out.println("answer test multiply: " + answer);
	}
	
	@Test
	public void complexesEquations() {
		char[] signs = {'x', '+'};
		levelNumbers.clear();
		levelNumbers.add((double) 3);
		levelNumbers.add((double) 2);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(signs);
		answer = gameEntity.calculateAnswer();
		assertEquals("3.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(2)));
		assertEquals("8.0", String.valueOf(answer));
		System.out.println("answer 3 x 2 + 2 : " + answer);
	}
	
	@Test
	public void complexesEquationsDivision() {
		char[] signs = {'/', '+'};
		levelNumbers.clear();
		levelNumbers.add((double) 6);
		levelNumbers.add((double) 2);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(signs);
		answer = gameEntity.calculateAnswer();
		assertEquals("6.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(2)));
		assertEquals("5.0", String.valueOf(answer));
		System.out.println("answer 6 / 2 + 2 : " + answer);
	}
	
	@Test
	public void complexesEquationsDivisionAndMultiply() {
		char[] signs = {'/', 'x'};
		levelNumbers.clear();
		levelNumbers.add((double) 6);
		levelNumbers.add((double) 2);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(signs);
		answer = gameEntity.calculateAnswer();
		assertEquals("6.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(2)));
		assertEquals("6.0", String.valueOf(answer));
		System.out.println("answer 6 / 2 + 2 : " + answer);
	}
	
	@Test
	public void complexesEquationsFourNumbers() {
		char[] signs = {'/', 'x', '+'};
		levelNumbers.clear();
		levelNumbers.add((double) 6);
		levelNumbers.add((double) 2);
		levelNumbers.add((double) 2);
		levelNumbers.add((double) 2);
		gameEntity.setLevelNumbers(levelNumbers);
		gameEntity.setLevelSigns(signs);
		answer = gameEntity.calculateAnswer();
		assertEquals("6.0", String.valueOf(levelNumbers.get(0)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(1)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(2)));
		assertEquals("2.0", String.valueOf(levelNumbers.get(3)));
		assertEquals("8.0", String.valueOf(answer));
		System.out.println("answer 6 / 2 + 2 : " + answer);
	}
	
	@Test
	public void generateLevelSignsTest() {
		gameEntity.generateLevelSigns();
		int signsNumber = gameEntity.getLevelSigns().length;
		assertEquals(2, signsNumber);
		
		for (int i = 0; i < 15; i++) {
			gameEntity.setLevel();
		}
		gameEntity.generateLevelSigns();
		signsNumber = gameEntity.getLevelSigns().length;
		assertEquals(3, signsNumber);
		
		for (int i = 0; i < 11; i++) {
			gameEntity.setLevel();
		}
		gameEntity.generateLevelSigns();
		signsNumber = gameEntity.getLevelSigns().length;
		assertEquals(4, signsNumber);
		
		for (int i = 0; i < 15; i++) {
			gameEntity.setLevel();
		}
		gameEntity.generateLevelSigns();
		signsNumber = gameEntity.getLevelSigns().length;
		assertEquals(5, signsNumber);
	}
	
}
