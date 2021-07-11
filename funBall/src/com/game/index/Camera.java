package com.game.index;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.game.index.OBJ.Objects;

public class Camera {
	

	private float x, y;
	
	public Camera(float x, float y)	 {
		this.x = x;
		this.y = y;		
	}
	
	public void tick(Objects object)	{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize().getSize();

	    final int screen_Width = dim.width;
	    final int screen_Height = dim.height;

		x += ((object.getX() - x) -screen_Width/2);
		y += ((object.getY() - y) -screen_Height/2);
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
