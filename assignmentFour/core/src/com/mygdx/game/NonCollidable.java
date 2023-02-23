package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class NonCollidable extends Entity {
	
	Brain brain = new Brain();
	
    NonCollidable(int x, int y, int speed, int[] controls, Color color) {
    	super(x,y,speed,controls,color);
    }
    
    public void movement() {        	
    	if (Gdx.input.isKeyPressed(getKeybinds()[0]))	{
    	setX(getX()-getSpeed());
    	}
    	if(Gdx.input.isKeyPressed(getKeybinds()[1]))	{
        	setX(getX()+getSpeed());
        }
    	if(Gdx.input.isKeyPressed(getKeybinds()[2]))	{
        	setY(getY()+getSpeed());
        }
    	if(Gdx.input.isKeyPressed(getKeybinds()[3]))	{
    		setY(getY()-getSpeed());
        }
    }
}