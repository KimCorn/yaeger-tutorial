package com.github.hanyaeger.tutorial.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider{

	public Swordfish(Coordinate2D location) {
		super("sprites/swordfish.png", location);
		setMotion(2, 270d);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		setAnchorLocationX(getSceneWidth());
		setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
	}

}