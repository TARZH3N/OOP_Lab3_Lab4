package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Triangle extends NonCollidable {
	
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    
    Triangle(int x, int y, int speed, int[] controls, Color color) {
    	super(x,y,speed,controls,color);
    	this.x1 = getX();
    	this.x2 = getX() + 100;
    	this.x3 = getX() + 200;
    	this.y1 = getY();
    	this.y2 = getY() + 100;
    	this.y3 = getY();
    }

    // Overwrite to also change x1,x2,x3,y1,y2 and y3 values
    @Override
    public void movement() {        	
        	if (Gdx.input.isKeyPressed(getKeybinds()[0]))	{
        		this.x1 = this.x1 - this.speed;
        		this.x2 = this.x2 - this.speed;
        		this.x3 = this.x3 - this.speed;
        	}
        	if(Gdx.input.isKeyPressed(getKeybinds()[1]))	{
            	this.x1 = this.x1 + this.speed;
            	this.x2 = this.x2 + this.speed;
            	this.x3 = this.x3 + this.speed;
            }
        	if(Gdx.input.isKeyPressed(getKeybinds()[2]))	{
            	this.y1 = this.y1 + this.speed;
            	this.y2 = this.y2 + this.speed;
            	this.y3 = this.y3 + this.speed;
            }
        	if(Gdx.input.isKeyPressed(getKeybinds()[3]))	{
            	this.y1 = this.y1 - this.speed;
            	this.y2 = this.y2 - this.speed;
            	this.y3 = this.y3 - this.speed;
            }
    }

    public int getX1() {
    	return x1;
    }
    
    public int getY1() {
    	return y1;
    }
    public int getX2() {
    	return x2;
    }
    public int getY2() {
    	return y2;
    }
    public int getX3() {
    	return x3;
    }
    public int getY3() {
    	return y3;
    }
    
}