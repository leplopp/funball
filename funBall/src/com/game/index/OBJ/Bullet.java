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
		
		double a = Math.sqrt(Math.pow(mX-x, 2) + Math.pow(mY - y, 2 ));
		
		double thirdpointx = a + x, thirdpointy = 0 + y;
		
		double b = Math.sqrt(Math.pow(mX-thirdpointx, 2) + Math.pow(mY - thirdpointy, 2 ));
		
		double c = Math.sqrt(Math.pow(thirdpointx - x, 2) + Math.pow(thirdpointy - y, 2 ));
				
		double win =  Math.acos((b * b - c * c - a * a) / (-2 * c * a));
		
		if (mY - y < 0)
			  win = -win;
		
		vleX = (int)(6*Math.cos(win)); 		
		vleY = (int)(6*Math.sin(win));
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
