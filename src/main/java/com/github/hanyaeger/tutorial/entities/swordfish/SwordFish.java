package com.github.hanyaeger.tutorial.entities.swordfish;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

//import javafx.scene.paint.Color;

public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher{

	public SwordFish(Coordinate2D initialLocation) {
		super(initialLocation);
		setMotion(2, 270d);
	}

	@Override
	public void setupEntities() {
		var swordFishSprite = new SwordFishSprite(new Coordinate2D(0, 0));
		addEntity(swordFishSprite);
		
		var hitBox = new HitBox(new Coordinate2D(0, 39));
		//hitBox.setFill(Color.BLACK);
		addEntity(hitBox);
		
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		setAnchorLocationX(getSceneWidth());
		setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));	
	}


}
