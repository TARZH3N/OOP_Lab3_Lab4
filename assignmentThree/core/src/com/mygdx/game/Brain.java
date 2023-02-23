package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;

public class Brain {
	// Since brain can't access Entity getters and setters we must pass our subclasses in when calling movement.
	
    public void movement(Entity entity) {        	
    	if (Gdx.input.isKeyPressed(entity.getKeybinds()[0]))	{
    	entity.setX(entity.getX()-entity.getSpeed());
    	}
    	if(Gdx.input.isKeyPressed(entity.getKeybinds()[1]))	{
    		entity.setX(entity.getX()+entity.getSpeed());
        }
    	if(Gdx.input.isKeyPressed(entity.getKeybinds()[2]))	{
    		entity.setY(entity.getY()+entity.getSpeed());
        }
    	if(Gdx.input.isKeyPressed(entity.getKeybinds()[3]))	{
    		entity.setY(entity.getY()-entity.getSpeed());
        }
    }
}