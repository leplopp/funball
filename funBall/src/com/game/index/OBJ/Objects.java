package com.game.index.OBJ;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.util.ID;

public abstract class Objects {
	
	protected int x, y;
	protected float vleX = 0, vleY = 0;
	protected ID id;


	public Objects(int x, int y, ID id)	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVleX() {
		return vleX;
	}

	public void setVleX(float vleX) {
		this.vleX = vleX;
	}

	public float getVleY() {
		return vleY;
	}

	public void setVleY(float vleY) {
		this.vleY = vleY;
	}
}
