package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EntityRender {
	
	// Instantiate new shape object
	 ShapeRenderer shape = new ShapeRenderer();
	
	 /**
	* renderObject is an overloaded method.
	* It uses getter methods of the object passed into it to render shapes.
	* Getter methods are class specific, and rendering different types of shapes
	* requires different parameters.
	* 
	* @params ball			Ball object instantiated in assignmentOne.java, class created in Ball.java
	* @params rectangle		Rectangle object instantiated in assignmentOne.java, class created in Rectangle.java
	* @params triangle		Triangle object instantiated in assignmentOne.java, class created in Triangle.java
	*/
	public void renderObject(Ball ball) {
		shape.begin(ShapeRenderer.ShapeType.Filled);
    	shape.setColor(ball.getColor());							// Uses object returned by getter method to set color
        shape.circle(ball.getX(), ball.getY(), ball.getRadius());	// Uses integers returned by getter methods to make shape dimensions
		shape.end();
	}
	
	public void renderObject(Rectangle rectangle) {
		shape.begin(ShapeRenderer.ShapeType.Filled);
    	shape.setColor(rectangle.getColor());
        shape.rect(rectangle.getX(), rectangle.getY(), 
        		rectangle.getWidth(), rectangle.getHeight());
        shape.end();
	}
	
	public void renderObject(Triangle triangle) {
		shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(triangle.getColor());
        shape.triangle(triangle.getX1(),triangle.getY1(),
        		triangle.getX2(),triangle.getY2(),
        		triangle.getX3(),triangle.getY3());
        shape.end();
	}
}