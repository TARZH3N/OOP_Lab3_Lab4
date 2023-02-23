package com.mygdx.game;

import java.util.ArrayList;

interface iCollidable {
	// Most impt thing in this interface is the ArrayList, Ball and Shape (Collidable objects) will instantiate themselves into this array list.
	ArrayList<Collidable> EntitiesList = new ArrayList<Collidable>();
	public boolean collidesWith(Entity currentEntity);
	public void handleCollision();
	void reactToCollision();
}