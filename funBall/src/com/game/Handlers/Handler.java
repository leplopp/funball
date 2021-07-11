package com.game.Handlers;

import java.awt.Graphics;
import java.util.LinkedList;
import com.game.index.OBJ.Objects;
import com.game.util.ID;

public class Handler {
	
	private int round = 0;
	
    public static LinkedList<Objects> object = new LinkedList<Objects>();
	
	private boolean up = false, down = false, right = false, left = false;

	public void tick()	{
		for (int i = 0; i <object.size(); i++)	{
			Objects tempobj = object.get(i);
			if(tempobj.getId() == ID.Bullet)
			  if (round < 10)
				  round++;
			  else
			  {
				  round = 10;
				  tempobj.tick();
			  }
			else
			  tempobj.tick();
		}
	}
	
	public void render(Graphics g)	{
		for (int i = 0; i <object.size(); i++)	{
			Objects tempobj = object.get(i);
			
			tempobj.render(g);
		}
	}
	
	public void addobj(Objects tmpobj)	{
		object.add(tmpobj);
	}
	
	public void removeobj(Objects tmpobj)	{
		object.remove(tmpobj);
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
}
