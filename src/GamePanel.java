import character.*;
import character.Unit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import character.Player;

public class GamePanel extends JPanel implements KeyListener, MouseListener, Runnable{

	public GamePanel(int width, int height) throws Exception
	{
		super();

		setSize(width,height);
		
		buffer = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		addKeyListener(this);
		
		keys = new TreeMap<Character, Boolean>();
		keys.put('W', false);
		keys.put('A', false);
		keys.put('S', false);
		keys.put('D', false);
		keys.put(' ', false);
		
		manager.loadImages("ImageRef.txt");
		
		player = new Player(200,200);
		player.addImage("Char_Up", manager.getImage("Char_Up"));
		player.addImage("Char_Left", manager.getImage("Char_Left"));
		player.addImage("Char_Right", manager.getImage("Char_Right"));
		player.addImage("Char_Down", manager.getImage("Char_Down"));
		player.addImage("Attack_Up", manager.getImage("Attack_Up"));
		player.addImage("Attack_Left", manager.getImage("Attack_Left"));
		player.addImage("Attack_Right", manager.getImage("Attack_Right"));
		player.addImage("Attack_Down", manager.getImage("Attack_Down"));
		
		Thread t = new Thread(this);
		t.start();
	}
	
	private ImageManager manager = new ImageManager();
	
	private TreeMap<Character, Boolean> keys;
	
	private BufferedImage buffer;
	
	private Player player;
	
	public void paint(Graphics g)
	{
		Graphics bg = buffer.getGraphics();
		
		bg.setColor(Color.WHITE);
		bg.fillRect(0, 0, getWidth(), getHeight());
		
		if(keys.get(' '))
		{
			if(player.getDirection()==player.UP)
				bg.drawImage(player.getImage("Attack_Up"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.DOWN)
				bg.drawImage(player.getImage("Attack_Down"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.LEFT)
				bg.drawImage(player.getImage("Attack_Left"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.RIGHT)
				bg.drawImage(player.getImage("Attack_Right"), player.getX(), player.getY(), null);
		}
		else
		{
			if(player.getDirection()==player.UP)
				bg.drawImage(player.getImage("Char_Up"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.DOWN)
				bg.drawImage(player.getImage("Char_Down"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.LEFT)
				bg.drawImage(player.getImage("Char_Left"), player.getX(), player.getY(), null);
			if(player.getDirection()==player.RIGHT)
				bg.drawImage(player.getImage("Char_Right"), player.getX(), player.getY(), null);
		}
		
		g.drawImage(buffer,0,0,null);
	}
	
	public void addNotify()
	{
		super.addNotify();
		requestFocus();
	}
	
	@Override
	public void keyPressed(KeyEvent key) 
	{
		
		if(Character.toUpperCase(key.getKeyChar())=='W')
		{
			keys.put('W', true);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='A')
		{
			keys.put('A', true);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='S')
		{
			keys.put('S', true);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='D')
		{
			keys.put('D', true);
		}
		else if(Character.toUpperCase(key.getKeyChar())==' ')
		{
			keys.put(' ', true);
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {

		if(Character.toUpperCase(key.getKeyChar())=='W')
		{
			keys.put('W', false);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='A')
		{
			keys.put('A', false);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='S')
		{
			keys.put('S', false);
		}
		else if(Character.toUpperCase(key.getKeyChar())=='D')
		{
			keys.put('D', false);
		}
		else if(Character.toUpperCase(key.getKeyChar())==' ')
		{
			keys.put(' ', false);
		}
	}

	@Override
	public void keyTyped(KeyEvent key)
	{
		
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(7);
				if(keys.get('W'))
				{
					if(player.getY()>-25)
						player.setY(player.getY()-1);
					player.setDirection(player.UP);
				}
				if(keys.get('S'))
				{
					if(player.getY()+75<getHeight())
						player.setY(player.getY()+1);
					player.setDirection(player.DOWN);
				}
				if(keys.get('A'))
				{
					if(player.getX()>-25)
						player.setX(player.getX()-1);
					player.setDirection(player.LEFT);
				}
				if(keys.get('D'))
				{
					if(player.getX()+75<getWidth())
						player.setX(player.getX()+1);
					player.setDirection(player.RIGHT);
				}
				repaint();
			}
		}
		catch(Exception e)
		{
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
