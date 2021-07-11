package com.game.index.OBJ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Handlers.Handler;
import com.game.util.ID;

public class Ball extends Objects{
	
	Handler handler;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	


	public void tick() {
		x += vleX;
		y += vleY;
			
		collision();
		
		//movement
		if(handler.isUp()) 
			vleY = -3;
		else 
			if(!handler.isDown()) 
				vleY = 0;			
		if(handler.isDown()) 
			vleY = 3;
		else 
			if(!handler.isUp()) 
			vleY = 0;
		
		if(handler.isRight()) 
			vleX = 3;
		else 
			if(!handler.isLeft()) 
			vleX = 0;
		
		if(handler.isLeft()) 
			vleX = -3;
		else 
			if(!handler.isRight()) 
			vleX = 0;
		
	}
	
	private void collision()	 {
		for (int i = 0; i<handler.object.size(); i++)	{
			
			Objects tempobj = handler.object.get(i);
			
			if(tempobj.getId() == ID.Block)		{
				
				if(getBounds().intersects(tempobj.getBounds()))		{
					x += vleX * -1;
					y += vleY * -1;
				}
				
			}
	if(tempobj.getId() == ID.Ball)		{
				
				if(getBounds().intersects(tempobj.getBounds()))		{
					x += vleX * -1;
					y += vleY * -1;
				}
				
			}
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
