package com.game.controls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.game.Handlers.Handler;
import com.game.index.Camera;
import com.game.index.OBJ.Bullet;
import com.game.index.OBJ.Objects;
import com.game.util.ID;

public class MouseInput extends MouseAdapter{
	
	private Handler handler;
	
	private Camera camera;
	
	public MouseInput(Handler handler, Camera camera)	{
		this.handler = handler;
		this.camera = camera;
	}
	
public void mousePressed(MouseEvent e) {
	int mX  = (int) (e.getX());
	int mY = (int) (e.getY());
	
	for (int i = 0; i<handler.object.size(); i++)	{
		
		Objects tempObj = handler.object.get(i); 
		
		if (tempObj.getId() == ID.player)	{
			
			handler.addobj(new Bullet(tempObj.getX() , tempObj.getX(), ID.Bullet, handler, mX , mY));
		}
		
	}
}

}