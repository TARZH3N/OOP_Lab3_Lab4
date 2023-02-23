package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;	
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
// https://javadoc.io/static/com.badlogicgames.gdx/gdx/1.11.0/com/badlogic/gdx/graphics/glutils/ShapeRenderer.html#triangle-float-float-float-float-float-float-
import com.badlogic.gdx.graphics.Color; // Imported in classes
import com.badlogic.gdx.graphics.GL20;

public class assignmentThree extends ApplicationAdapter {
    
    
	/**
	 * To proof that the movement() function is overwritten, 
	 * when you remove it from the ball and rectangle subclasses, the control scheme will be inverted.
	 * The subclasses movement() method overwrite the superclass movement() method to implement a standard control scheme.
	 * 
	 * Changes made from Lab1:
	 * 1. Removed setters and getters not called
	 * 2. Brain contains movement related function and attributes such as x, y and speed
	 * 3. Entity contains non shape specific attributes such as color and 
	 * 	  control scheme (all shapes uses 4 directional inputs
	 * 4. Shape specific values such as "radius", "x1" are declared in their subclasses
	 */
	
	// Declare entityRender object
    EntityRender entityRender;
    
    // Declare the 4 "Geometric Objects"
    Ball ball;
    Rectangle rect;
    Rectangle rect2;
    Triangle tri;
    
    @Override
    public void create() {
    	
    	entityRender = new EntityRender();
    	
    	// ball, rect, rect2 collidable
        ball = new Ball(100,100,5,new int[]{Input.Keys.A, Input.Keys.D, Input.Keys.W, Input.Keys.S},Color.BLUE,50);
        rect = new Rectangle(200,60,5,new int[]{Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.UP, Input.Keys.DOWN},Color.GREEN,150,100);
        rect2 = new Rectangle(400,60,5,new int[]{Input.Keys.F, Input.Keys.H, Input.Keys.T, Input.Keys.G},Color.PURPLE,70,70);
        tri = new Triangle(400,60,5,new int[]{Input.Keys.J, Input.Keys.L, Input.Keys.I, Input.Keys.K},Color.RED);
    }

    @Override
    public void render() {

    	// Remove trail lines
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	
    	// entityRender has access to the renderObject method,
    	// overloaded method selected based on data types(class) of the object passed
        entityRender.renderObject(ball);
        entityRender.renderObject(rect);
        entityRender.renderObject(rect2);
        entityRender.renderObject(tri);
        
        //ball.brain.movement(ball); // Using the aggregated Brain's movement function instead
        ball.movement();
        rect.movement();
        rect2.movement();
        tri.movement();
    }
    public void dispose() {
    	entityRender.shape.dispose();
     }
}