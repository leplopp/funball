package com.game.index.OBJ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.util.ID;

public class Block extends Objects{

	public Block(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 64, 64);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}

}
