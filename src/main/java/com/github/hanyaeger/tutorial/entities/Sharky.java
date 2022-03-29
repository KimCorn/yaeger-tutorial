package com.github.hanyaeger.tutorial.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Sharky extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher{

	public Sharky(Coordinate2D location) {
		super("sprites/sharky.png", location, new Size(180, 260), 1, 19);
		setMotion(2, 90d);
		setAutoCycle(40);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		setAnchorLocationX(-180);
		setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
	}

}
