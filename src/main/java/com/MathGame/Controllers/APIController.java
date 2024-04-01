package com.MathGame.Controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MathGame.Services.GameService;
import com.MathGame.Models.GameModel;

@RestController
public class APIController {

	@Autowired
	GameService gameService;
	
	GameModel game = new GameModel();
	float gameAnswer = -999999999;
	
	@GetMapping("/getLevel")
	public ResponseEntity<String> getLevel(@RequestParam short level, @RequestParam int score) {
		game.clear();
		game.setNewLevel(level);
		game.setNewScore(score);
		game.setScore();
		System.out.println("Level APICONTROLLER: " + level);
		
		game = gameService.generateNewLevel(game);
		gameAnswer = game.getAnswer();
		
		JSONObject levelStats = new JSONObject();
		levelStats.put("level", game.getLevel());
		levelStats.put("score", game.getScore());
		levelStats.put("equation", game.getLevelEquation());
				
		return ResponseEntity.status(HttpStatus.OK).body(game.getLevelEquation());
	}
	
	@GetMapping("/checkAnswer")
	public ResponseEntity<String> checkAnswer(@RequestParam String playerAnswer, @RequestParam float answer) {
		boolean result = false;
		if (gameAnswer != -999999999) {
			result = gameService.checkAnswer(playerAnswer, gameAnswer);
		} else {
			result = gameService.checkAnswer(playerAnswer, answer);
		}
		
		System.out.println("Player answer api controller: " + playerAnswer);
		System.out.println("Answer api controller: " + answer);
		
		if (result) {
			System.out.println("OK");
			return ResponseEntity.status(HttpStatus.OK).body("TRUE");
		} else {
			System.out.println("NO");
			return ResponseEntity.status(HttpStatus.OK).body("FALSE");
		}
	}
}
