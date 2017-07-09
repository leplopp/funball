package com.game.index.graphics;

public class Render {
	
	public final int width;
	public final int heigth;
	public final int[] pixels;
	
	public Render(int width, int heigth)	{
		this.width = width;
		this.heigth = heigth;
		
		pixels = new int[width * heigth];
		
	}
	
	public void draw(Render render, int xOffset, int yOffset)	{
		for (int y = 0; y<render.heigth; y++){
			int ypix = y + yOffset;
			for (int x = 0; x<render.width; x++){
				int xpix = x + xOffset;
				
				pixels[xpix+ypix*width] = render.pixels[x+y*render.width];
			}
		}
	}

}
