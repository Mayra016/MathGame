package com.MathGame.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MathGame.Services.GameService;
import com.MathGame.Models.GameModel;

@Controller
public class AppController {
	
	@Autowired
	GameService gameService;
	
	GameModel game = new GameModel();

	@GetMapping("/menu")
	public String menu() {
		game = gameService.resetLevel(game);
		return "menu";
	}
	
	@GetMapping("/level")
	public String level(Model model) {
		model.addAttribute("game", game);
		return "level";
	}
}
