package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;

import java.util.ArrayList;

public class Collidable extends Entity implements iCollidable {
	
	// Aggregation
	Brain brain = new Brain();
	
    Collidable(int x, int y, int speed, int[] controls, Color color) {
    	super(x,y,speed,controls,color);
    }

    private int prevX;
    private int prevY;

    public void movement(){
    	
    	if (collidesWith(this)==false) {
        	prevX = getX();
        	prevY = getY();
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
    	else {
    		setX(prevX);
    		setY(prevY);
    		
    	}
    }
	
    // Refrence for logic:
    // https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point
    // https://leetcode.com/problems/rectangle-overlap/solutions/468548/Java-check-if-two-rectangles-overlap-at-any-point/
    
	public boolean collidesWith(Entity currentEntity) {
		
		// Test hashmap for movingEntity
		
		// System.out.println(currentEntity.getX());
		// System.out.println(EntitiesList.size()); // 2 since 2 entities
		// System.out.println(movingEntity.getCoordinates().get("tr")[0]);
		// System.out.println(movingEntity.getCoordinates().get("tr")[1]);
		
		for (int i = 0; i < EntitiesList.size(); i++) {
			if (EntitiesList.get(i)!=currentEntity) {
				Entity movingEntity = currentEntity;
				Entity stationaryEntity = EntitiesList.get(i);
				
				//Test hashmap for stationaryEntity
				//System.out.println(stationaryEntity.getCoordinates().get("tr")[0]);
				//System.out.println(movingEntity.getCoordinates().get("tr")[0]);

				//(x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2)
				if (
					((int)(movingEntity.getCoordinates().get("bl")[0])<(int)(stationaryEntity.getCoordinates().get("tr")[0]))
					&&
					((int)(stationaryEntity.getCoordinates().get("bl")[0])<(int)(movingEntity.getCoordinates().get("tr")[0]))
					&&
					((int)(movingEntity.getCoordinates().get("bl")[1])<(int)(stationaryEntity.getCoordinates().get("tr")[1]))
					&&
					((int)(stationaryEntity.getCoordinates().get("bl")[1])<(int)(movingEntity.getCoordinates().get("tr")[1]))
						) {
					System.out.println(currentEntity);
					System.out.println("Collision");

					return true;
				}
			}
		}
		return false;
	}
	
    
    // I could not find a use for these 2 methods. I realise they have no return type.
	// collideWith() also could not be split up.
	public void handleCollision() {
	}

	public void reactToCollision() {	
	}
	
    /* My original attempt at creating the logic myself.
     * It has an edge case scenario, where a larger object can swallow a smaller object at a specific angle.
     * But a smaller object cannot enter a larger object.
     * 
	public boolean collidesWith(Entity currentEntity) {
		//System.out.println(currentEntity.getX());
		//System.out.println(EntitiesList.size()); // 2 since 2 entities

		//Test hashmap for movingEntity
		//System.out.println(movingEntity.getCoordinates().get("tr")[0]);
		//System.out.println(movingEntity.getCoordinates().get("tr")[1]);
		
		for (int i = 0; i < EntitiesList.size(); i++) {
			if (EntitiesList.get(i)!=currentEntity) {
				Entity movingEntity = currentEntity;
				Entity stationaryEntity = EntitiesList.get(i);
				//Test hashmap for stationaryEntity
				System.out.println(stationaryEntity.getCoordinates().get("tr")[0]);
				System.out.println(movingEntity.getCoordinates().get("tr")[0]);
				// Can't use switch cases since no expressions. Using if else statement instead
				if (
						((int)(movingEntity.getCoordinates().get("tr")[0])==(int)(stationaryEntity.getCoordinates().get("tl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[1])<(int)(stationaryEntity.getCoordinates().get("tl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[1])>(int)(stationaryEntity.getCoordinates().get("bl")[1]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("br")[0])==(int)(stationaryEntity.getCoordinates().get("bl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("br")[1])<(int)(stationaryEntity.getCoordinates().get("tl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("br")[1])>(int)(stationaryEntity.getCoordinates().get("bl")[1]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("tl")[0])==(int)(stationaryEntity.getCoordinates().get("tr")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[1])<(int)(stationaryEntity.getCoordinates().get("tl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[1])>(int)(stationaryEntity.getCoordinates().get("bl")[1]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("bl")[0])==(int)(stationaryEntity.getCoordinates().get("br")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("br")[1])<(int)(stationaryEntity.getCoordinates().get("tl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("br")[1])>(int)(stationaryEntity.getCoordinates().get("bl")[1]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				
				else if (
						((int)(movingEntity.getCoordinates().get("tr")[1])==(int)(stationaryEntity.getCoordinates().get("bl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[0])>(int)(stationaryEntity.getCoordinates().get("bl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[0])<(int)(stationaryEntity.getCoordinates().get("br")[0]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("tl")[1])==(int)(stationaryEntity.getCoordinates().get("br")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tl")[0])>(int)(stationaryEntity.getCoordinates().get("bl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tl")[0])<(int)(stationaryEntity.getCoordinates().get("br")[0]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("br")[1])==(int)(stationaryEntity.getCoordinates().get("tl")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[0])>(int)(stationaryEntity.getCoordinates().get("bl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tr")[0])<(int)(stationaryEntity.getCoordinates().get("br")[0]))
						) {
					System.out.println("Collision");
					return true;
				}
				
				else if (
						((int)(movingEntity.getCoordinates().get("bl")[1])==(int)(stationaryEntity.getCoordinates().get("tr")[1]))
						&&
						((int)(movingEntity.getCoordinates().get("tl")[0])>(int)(stationaryEntity.getCoordinates().get("bl")[0]))
						&&
						((int)(movingEntity.getCoordinates().get("tl")[0])<(int)(stationaryEntity.getCoordinates().get("br")[0]))
						) {
					System.out.println("Collision");
					return true;
				}
			}
		}
		return false;
	}*/
}