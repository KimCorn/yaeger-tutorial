package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene{
	
	private Waterworld waterworld;
	
	public GameOverScene(Waterworld waterworld) {
		this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/ocean.mp3");
		setBackgroundImage("backgrounds/background1.jpg");
	}

	@Override
	public void setupEntities() {
		var gameOverText = new TextEntity(
				new Coordinate2D(getWidth() / 2, getHeight() / 2),
				"Game Over"
		);
		gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		gameOverText.setFill(Color.DARKBLUE);
		gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
		addEntity(gameOverText);
		
		var playAgainButton = new PlayAgainButton(
				new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 40),
				waterworld
		);
		playAgainButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
		addEntity(playAgainButton);
		
		var quitButton = new QuitButton(
				new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 240),
				waterworld
		);
		quitButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
		addEntity(quitButton);
	}

}