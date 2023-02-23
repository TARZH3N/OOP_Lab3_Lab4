package com.mygdx.game;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Rectangle extends Collidable {
	
    private int width;
    private int height;
    
    Rectangle(int x, int y, int speed, int[] controls, Color color, int width, int height) {
    	super(x,y,speed,controls,color);
    	this.width = width;
    	this.height = height;
    	EntitiesList.add(this);
    }
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
    /*
    public int[] getCenter() {
		int[] arr={x+(width/2), y+(height/2)};
		return arr;
    }*/
    
    @Override
    public HashMap<String, Integer[]> getCoordinates() {
    	HashMap<String, Integer[]> coordinates = new HashMap<String, Integer[]>();
    	coordinates.put("tl", new Integer[] {x,y+height});
    	coordinates.put("tr", new Integer[] {x+width,y+height});
    	coordinates.put("bl", new Integer[] {x,y});
    	coordinates.put("br", new Integer[] {x+width,y});
        return coordinates;
    }
}