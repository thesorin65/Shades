import map.*;
import character.*;
import character.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import character.Player;

public class GamePanel extends JPanel implements KeyListener{

	public GamePanel(int width, int height)
	{
		super();

		setSize(width,height);
		
		buffer = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		addKeyListener(this);
		
		player = new Player(200,200);
	}
	
	private BufferedImage buffer;
	
	private Player player;
	
	public void paint(Graphics g)
	{
		Graphics bg = buffer.getGraphics();
		
		g.drawImage(buffer,0,0,null);
	}
	
	public void addNotify()
	{
		super.addNotify();
		requestFocus();
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent key) {
		
		repaint();
	}
}
