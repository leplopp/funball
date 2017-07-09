package com.game.index.OBJ;

import java.awt.Color;
import java.math.*;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Handlers.Handler;
import com.game.util.ID;

public class Bullet extends Objects{
	
	private Handler handler;
	
	public Bullet(int x, int y, ID id, Handler handler, int mX , int mY) {
		super(x, y, id);
		this.handler = handler;
		
		vleX = (mX - x)/ 10; 		
		vleY = (mY - y)/ 10;
		
		if (vleX == 0 && vleY == 0)
			vleX = 2;
		
		
		
		System.out.println("Maus");
		System.out.println(mX);
		System.out.println(mY);
		System.out.println("Camera");
		System.out.println(x);
		System.out.println(y);
		System.out.println("L�nge");
		System.out.println(vleX);
		System.out.println(vleY);
	}

	public void tick() {
		x += vleX;
		y += vleY;
		
		for (int i = 0; i<handler.object.size(); i++)	{
			Objects tempObj = handler.object.get(i); 
			if(tempObj.getId() == ID.Block)		{
				
				if(getBounds().intersects(tempObj.getBounds()))		{
					handler.removeobj(this);
				}
				
			}
		}
		
	}
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillOval(x, y, 8, 8);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
