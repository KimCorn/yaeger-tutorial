package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.scene.paint.Color;

public class AirBubble extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher, Collider {

	public AirBubble(Coordinate2D initialLocation, long speed) {
		super(initialLocation);
		setFill(Color.LIGHTSTEELBLUE);
		setOpacity(0.5);
		setRadius(7);
		setMotion(speed, 180d);
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if(collidingObject instanceof Hanny) {
			var popSound = new SoundClip("audio/pop.mp3");
			popSound.play();

			remove();
		} else {
			remove();
		}
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		if (border == SceneBorder.TOP) {
			remove();
		}
	}

}
