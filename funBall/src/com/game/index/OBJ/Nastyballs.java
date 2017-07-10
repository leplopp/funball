package com.game.index.OBJ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Handlers.Handler;
import com.game.index.game;
import com.game.util.ID;

public class Nastyballs  extends Objects{
	

	
	public Nastyballs(int x, int y , ID id) {
		super(x, y, id);
		
		vleX =  1;
		vleY =  1;
	}

	public void tick() {
		
		//collision();
		x += vleX;
		y += vleY;
		
		if (y <=0 || y >= game.HEIGHT - 32) vleY *= -1;
		if (x <=0 || x >= game.WIDTH - 32) vleX *= -1;
		
	}

	
	/*private void collision()	 {
		for (int i = 0; i<handler.object.size(); i++)	{
			
			Objects tempobj = handler.object.get(i);
			
			if(tempobj.getId() == ID.Block)		{
				
				if(getBounds().intersects(tempobj.getBounds()))		{
					x += vleX * -1;
					y += vleY * -1;
				}
				
			}
		}
	}*/

	public void render(Graphics g) {
		
		g.setColor(Color.magenta);
		g.fillOval(x, y, 32, 32);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	

}