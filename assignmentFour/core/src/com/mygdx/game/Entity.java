package com.mygdx.game;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;

public abstract class Entity {
	
	protected int x;
	protected int y;
	protected int speed;
	protected int[] controls;
	private Color color;
	
	public Entity(int x, int y, int speed, int[] controls, Color color) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.controls = controls;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int[] getKeybinds(){
		return controls;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	/*public int[] getCenter() {
		// TODO Auto-generated method stub
		return null;
	}*/
	

	// Method to be overriden by subclasses
	// Do not feel like it should be in interfaces
	// Putting this function in abstract class "Entity". NonCollidable will inherit this as well but we will only be using it for Collidable.
	public HashMap<String, Integer[]> getCoordinates() {
		return null;
	}
}