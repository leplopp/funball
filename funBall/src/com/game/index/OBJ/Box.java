package com.game.index.OBJ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.util.ID;

public class Box extends Objects{

	public Box(int x, int y , ID id) {
		super(x, y, id);
	}

	public void tick() {
		
		x += vleX;
		y += vleY;
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(x, y, 8, 8);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}
	
	

}
