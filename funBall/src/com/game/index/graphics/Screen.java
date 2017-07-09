package com.game.index.graphics;

import java.util.Random;

public class Screen extends Render{

	private Render apclix;
	
	public Screen(int width, int heigth) {
		super(width, heigth);
		Random random = new Random();
		apclix = new Render(256, 256);
		for (int i = 0; i<256*256; i++)	{
			apclix.pixels[i] = random.nextInt();
			
		}
	}
	
	public void render()	{
		draw(apclix, 0, 0);
	}

}
