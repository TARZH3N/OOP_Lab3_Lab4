package com.mygdx.game;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends Collidable {
	
    private int radius;
    
    Ball(int x, int y, int speed, int[] controls, Color color, int radius) {
    	super(x,y,speed,controls,color);
    	this.radius = radius;
    	EntitiesList.add(this);
    }

    // Overwrite to change from inverted keybinds to non-inverted keybinds

    public int getRadius() {
    	return radius;
    }
    
    /* I realise instead of gettingCenter and using offsets, a more efficient way would be to use hashmap for 4 coordinates
    public int[] getCenter() {
		int[] arr={x, y};  //initializing array
		return arr;
    }*/
    
    // Override as in "collidable", getCoordinates is used for both Square and Circle.
    // getCoordinate is declared as a abstract method in Entity Class
    @Override
    public HashMap<String, Integer[]> getCoordinates() {
    	HashMap<String, Integer[]> coordinates = new HashMap<String, Integer[]>();
    	coordinates.put("tl", new Integer[] {x-radius,y+radius});
    	coordinates.put("tr", new Integer[] {x+radius,y+radius});
    	coordinates.put("bl", new Integer[] {x-radius,y-radius});
    	coordinates.put("br", new Integer[] {x+radius,y-radius});
        return coordinates;
    }
}