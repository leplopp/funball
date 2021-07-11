package com.game.index;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.Handlers.Handler;
import com.game.controls.MouseInput;
import com.game.controls.keyinput;
import com.game.index.OBJ.Ball;
import com.game.index.OBJ.Block;
import com.game.index.OBJ.Box;
import com.game.index.OBJ.Nastyballs;
import com.game.index.graphics.Render;
import com.game.index.graphics.Screen;
import com.game.registers.BufferdimageLoader;
import com.game.registers.Levels;
import com.game.util.ID;

public class game extends Canvas implements Runnable{
	
	private static final JFrame frame = new JFrame();
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "funBall v.0.0.1.0.2A";
	
	private boolean running = false;
	private Thread therad;
	private Render render;
	private BufferedImage level;
	private Graphics2D g;
	public static int Width, Height ;
	
	public Handler handler;
	protected ID id;
	
	private Camera camera;
	private Random r;
	
	private java.util.Timer timer;
	private boolean isRunning;
	
	
	
	public game()	{
		System.out.println(Height + "," + Width);
		//screen = new Screen(frame.getSize().width, frame.getSize().height);
		//pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		BufferdimageLoader loader = new BufferdimageLoader();
		camera = new Camera(0, 0);
		handler = new Handler();
		this.addMouseListener(new MouseInput(handler, camera));
		this.addKeyListener(new keyinput(handler));
		r = new Random();
		
		level = loader.lodImage("/testlevel.png");
		
		handler.addobj(new Nastyballs(500, 100, ID.Ball));
		handler.addobj(new Ball(100, 100, ID.player, handler));
		LoadLevel(level);
		
		//handler.addobj(new Box(100, 100, ID.Ballon));
		System.out.println("Launch");
		

		
	}
	
	public synchronized void start()	{
		therad = new Thread(this);
		therad.start();
		running = true;
		
		level = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) level.getGraphics();
		System.out.println("progress");
	}
	
	public synchronized void stop()	{
		try {
		therad.join();
		running = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		final double GAME_HERTZ = 60.0;
		final double TBU = 1000000000 / GAME_HERTZ; // time before update
		
		final int MJBR = 5; // must update before render
		
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime;
		
		final double Target_FPS = 60;
		final double TTBR = 1000000000 / Target_FPS; //total time before render
		
		int frameCount = 0;
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);
		int oldFrameCount = 0;
		
		   while (running)	{
			   
			   double now = System.nanoTime();
			   int updateCount = 0;
			   while(((now - lastUpdateTime) >TBU) && (updateCount < MJBR)){
				   tick();
				   input();
				   lastUpdateTime += TBU;
				   updateCount++;
			   }
			   if (now -lastUpdateTime > TBU) {
				   lastUpdateTime = now - TBU;
			   }
			   
			   input();
			   render();
			   draw();
			   lastRenderTime = now;
			   frameCount++;
			   
			   int thisSecond = (int) (lastUpdateTime / 1000000000);
			   if (thisSecond > lastSecondTime) {
				   if(frameCount != oldFrameCount) {
					   System.out.println("new Second " + thisSecond + " " + frameCount);
					   oldFrameCount = frameCount;
				   }
				   
				   frameCount = 0;
				   lastSecondTime = thisSecond;
			   }
			   
			   while(now - lastRenderTime < TTBR && now -lastUpdateTime < TBU) {
				   Thread.yield();
				   
				   try {
					   Thread.sleep(1);
				   } catch (Exception e) {
					   System.out.println("ERROR: yielding thread");
				}
				   now = System.nanoTime();
			   }
	   
		   }
			 
	}
	
	public void input() {
		
	}

	public void tick() {		
		//System.out.println("Tick");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			e.fillInStackTrace();
		}
		
		for (int i = 0; i<handler.object.size(); i++)	{
			if(handler.object.get(i).getId() == ID.player)	{
				camera.tick(handler.object.get(i));
			}
		}
		
		handler.tick();
	}

	
	public void render() {
		//BufferStrategy bs = this.getBufferStrategy();
		//if (bs == null){
		//createBufferStrategy(3);
		if (g != null) {
		
	//Graphics g = bs.getDrawGraphics();
	//Graphics2D g2d = (Graphics2D) g;
	
	g.setColor(Color.cyan);
	g.fillRect(0, 0, Width, Height);

	g.translate(-camera.getX(), -camera.getY());
	
	handler.render(g);
	
	g.translate(camera.getX(), camera.getY());
		}
	//g.dispose();
	//g.show();	
}
	
	public void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		g2.drawImage(level, 0, 0, Width, Height, null);
		g2.dispose();
		
	}

	    public void LoadLevel(BufferedImage image)	{
		int w = image.getWidth();
		int h = image.getHeight();
		
		for (int xx = 0; xx <w; xx++)	{
			for (int yy = 0; yy<h; yy++)	{
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255)		
					handler.addobj(new Block(xx*32, yy*32, ID.Block));

			}
		}
	}
	    

	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	    final int screen_Width = dim.width;
	    final int screen_Height = dim.height;
		
		JFrame frame = new JFrame();
	    
		frame.pack();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setSize(screen_Width , screen_Height);
	    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(true);
		Height = (int) frame.getSize().getHeight();
		Width = (int) frame.getSize().getWidth();
	    
		game game = new game();
		frame.add(game);
		
		frame.setVisible(true);
		
		System.out.println("starting. . . ");
		
		game.start();
		

	}
}
