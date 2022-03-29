package com.github.hanyaeger.tutorial;

import java.util.Random;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
	
	Waterworld waterworld;
	
	public GameLevel(Waterworld waterworld) {
		this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/waterworld.mp3");
		setBackgroundImage("backgrounds/background2.jpg");
	}

	@Override
	public void setupEntities() {
		var swordfish = new SwordFish(new Coordinate2D(getWidth(), new Random().nextInt((int) getHeight()- 81)));
		addEntity(swordfish);
		
		var healthText = new HealthText(new Coordinate2D((getWidth() / 3), 0));
		healthText.setAnchorPoint(AnchorPoint.TOP_CENTER);
		addEntity(healthText);
		
		var bubblesPoppedText = new BubblesPoppedText(new Coordinate2D((getWidth() / 3) * 2, 0));
		bubblesPoppedText.setAnchorPoint(AnchorPoint.TOP_CENTER);
		addEntity(bubblesPoppedText);
		
		var Hanny = new Hanny(new Coordinate2D(0, 0), healthText, waterworld, bubblesPoppedText);
		addEntity(Hanny);
		
		var sharky = new Sharky(new Coordinate2D(-180, new Random().nextInt((int) getHeight()- 81)));
		addEntity(sharky);
	}

	@Override
	public void setupEntitySpawners() {
		addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
	}
}
