package com.game.controls;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.Handlers.Handler;
import com.game.index.OBJ.Objects;
import com.game.util.ID;

public class keyinput extends KeyAdapter{
	
	Handler handler;
	
	public keyinput(Handler handler)	{
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent EV)	{
		int key = EV.getKeyCode();
		
		for (int i = 0; i <handler.object.size(); i++)	{
			Objects tempopj = handler.object.get(i);
			
			if (tempopj.getId() == ID.player)	{
				if(key == KeyEvent.VK_W) handler.setUp(true);
				if(key == KeyEvent.VK_S) handler.setDown(true);
				if(key == KeyEvent.VK_A) handler.setLeft(true);
				if(key == KeyEvent.VK_D) handler.setRight(true);
				if(key == KeyEvent.VK_SPACE) handler.setUp(true);
				if(key == KeyEvent.VK_UP) handler.setUp(true);
				if(key == KeyEvent.VK_DOWN) handler.setDown(true);
				if(key == KeyEvent.VK_LEFT) handler.setLeft(true);
				if(key == KeyEvent.VK_RIGHT) handler.setRight(true);
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent EV)	{
		int key = EV.getKeyCode();
		
		for (int i = 0; i <handler.object.size(); i++)	{
			Objects tempopj = handler.object.get(i);
			
			if (tempopj.getId() == ID.player)	{
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
				if(key == KeyEvent.VK_SPACE) handler.setUp(false);
				if(key == KeyEvent.VK_UP) handler.setUp(false);
				if(key == KeyEvent.VK_DOWN) handler.setDown(false);
				if(key == KeyEvent.VK_LEFT) handler.setLeft(false);
				if(key == KeyEvent.VK_RIGHT) handler.setRight(false);
				
			}
		}
		
	}

}
