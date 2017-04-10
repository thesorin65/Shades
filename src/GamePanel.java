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

import character.AngelStatue;
import character.Blacksmith;
import character.Healer;
import character.Player;
import character.Shopkeeper;

public class GamePanel extends JPanel implements KeyListener{

	public GamePanel()
	{
		super();

		setSize(1100,700);
		
		buffer = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		addKeyListener(this);
		
		try {
			swordIcon = ImageIO.read(new File("Images//SwordIcon.png"));
			heartIcon = ImageIO.read(new File("Images//HeartIcon.png"));
			shieldIcon = ImageIO.read(new File("Images//ShieldIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player = new Player(3,3);
		mapX = 2;
		mapY = 2;
	}
	
	private BufferedImage buffer;

	private BufferedImage swordIcon;
	private BufferedImage heartIcon;
	private BufferedImage shieldIcon;
	
	private Map m = new Map();
	private Room[][] map = m.getMap();
	private int mapX;
	private int mapY;
//	private Base b = new Base();
//	private Character[][] base = b.getBase();
//	private HomeRoom h = new HomeRoom();
//	private Character[][] home = h.getRoom();
	private Player player;
//	private AngelStatue angelStatue;
//	private Blacksmith blacksmith;
//	private Healer healer;
//	private Shopkeeper shopkeeper;
	
	public void paint(Graphics g)
	{
		Graphics bg = buffer.getGraphics();
		
//		if(player.getInHome())
//		{
//			for(int x = 0;x<home.length;x++)
//			{
//				for(int y = 0;y<home[0].length;y++)
//				{
//					if(home[x][y] instanceof Healer)
//					{
//						bg.drawImage(healer.getImage(), x*100, y*100, null);
//					}
//					else if(home[x][y] instanceof AngelStatue)
//					{
//						//bg.drawImage(AngelStatue.getImage(), x*100, y*100, null);
//					}
//					else
//					{
//						bg.setColor(new Color(0,0,0));
//						if(home[x][y].getWalkable())
//						{
//							bg.setColor(new Color(255,255,255));
//						}
//						if(home[x][y] instanceof Player)
//						{
//							bg.setColor(new Color(0,255,0));
//							//bg.drawImage(player.getImage(), a*100, b*100, null);
//							bg.fillRect(x*100, y*100, 100, 100);
//						}
//						bg.fillRect(x*100, y*100, 100, 100);
//					}
//				}
//			}
//		}
//		else if(player.getInBase())
//		{
//			dungeonMusic1.stopMusic();
//			for(int x = 0;x<base.length;x++)
//			{
//				for(int y = 0;y<base[0].length;y++)
//				{
//					if(base[x][y] instanceof Shopkeeper)
//					{
//						//bg.drawImage(shopkeeper.getImage(), x*100, y*100, null);
//					}
//					else if(base[x][y] instanceof Blacksmith)
//					{
//						//bg.drawImage(blacksmith.getImage(), x*100, y*100, null);
//					}
//					else
//					{
//						bg.setColor(new Color(0,0,0));
//						if(base[x][y].getWalkable())
//						{
//							bg.setColor(new Color(255,255,255));
//						}
//						if(player.getInBase()&&player.getX()==x&&player.getY()==y)
//						{
//							bg.setColor(new Color(0,255,0));
//							//bg.drawImage(player.getImage(), a*100, b*100, null);
//							bg.fillRect(x*100, y*100, 100, 100);
//						}
//						bg.fillRect(x*100, y*100, 100, 100);
//					}
//				}
//			}
//		}
//		else
//		{
//			for(int x = 0;x<map.length;x++)
//			{
//				for(int y = 0;y<map[0].length;y++)
//				{
//					if(map[x][y].hasPlayer())
//					{
//						Character[][] room = map[x][y].getRoom();
//						for(int a = 0;a<room.length;a++)
//						{
//							for(int b = 0;b<room[0].length;b++)
//							{
//								bg.setColor(new Color(0,0,0));
//								if(room[a][b].getWalkable())
//								{
//									bg.setColor(new Color(255,255,255));
//								}
//								bg.fillRect(a*100, b*100, 100, 100);
//								
//								if(room[a][b] instanceof Player)
//								{
//									bg.setColor(new Color(0,255,0));
//									//bg.drawImage(player.getImage(), a*100, b*100, null);
//									bg.fillRect(a*100, b*100, 100, 100);
//								}
//							}
//						}
//					}
//					else
//					{
//						bg.setColor(new Color(200,200,0));
//						bg.fillRect(200, 200, 200, 200);
//					}
//				}
//			}
//		}

		//Panel on right
		
		bg.setColor(new Color(50,50,50));
		bg.fillRect(700, 0, 400, 700);
		
		bg.setColor(new Color(150,150,150));
		bg.drawLine(700, 470, 1100, 470);
		bg.setFont(new Font("Times New Roman",Font.PLAIN,25));
		bg.drawString("Bag Items", 860, 195);
		bg.drawLine(700,210,1100,210);
		
		for(int x = 0;x<=210;x+=42)
		{
			bg.drawLine(700,210+x,1100,210+x);
		}
		bg.drawLine(900, 210, 900, 420);
		
		bg.drawString("Messages", 854, 460);
		
		bg.drawString("Player  Lvl: "+player.getLvl(), 838, 25);
		bg.drawLine(700, 40, 1100, 40);
		bg.drawLine(700, 140, 1100, 140);

		bg.setColor(new Color(255,0,0));
		bg.fillRect(751, 66, 299, 19);
		bg.setColor(new Color(255,255,255));
		bg.drawRect(750, 65, 300, 20);
		
		bg.drawImage(heartIcon, 715, 62, null);
		
		bg.setFont(new Font("Times New Roman",Font.PLAIN,16));
		bg.drawString(""+player.getHealth()+"/"+player.getMaxHealth(), 879, 63);
		bg.drawImage(swordIcon, 760, 97, null);
		bg.drawString(""+player.getAtt(), 799, 118);
		
		bg.drawImage(shieldIcon, 960, 97, null);
		bg.drawString(""+player.getDef(), 999, 118);
		
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
		
//		if(key.getKeyChar()=='b')
//		{
//			player.setInHome(false);
//			player.setInBase(true);
//			base[3][0] = new Empty(3,0);
//			base[3][3] = new Player(3,3);
//		}
		
		if(key.getKeyChar()=='l')
		{
			player.lvlUp();
		}
//		if(player.getInHome())
//		{
//
//			int playerCol = player.getY();
//			int playerRow = player.getX();
//			
//			for(int x = 0;x<home.length;x++)
//			{
//				for(int y = 0;y<home[0].length;y++)
//				{
//					if(key.getKeyChar()=='d'&&playerRow==6&&playerCol==3)
//					{
//						player.setInHome(false);
//						player.setInBase(true);
//						home[6][3] = new Empty(6,3);
//						base[0][3] = new Player(0,3);
//					}
//					if(key.getKeyChar()=='w'&&playerCol!=0)//change to arrow key
//					{
//						if(home[playerRow][playerCol-1].getWalkable())
//						{
//							home[playerRow][playerCol] = new Empty(playerRow,playerCol);
//							home[playerRow][playerCol-1] = new Player(playerRow,playerCol-1);
//						}
//					}
//					if(key.getKeyChar()=='a'&&playerRow!=0)//change to arrow key
//					{
//						if(home[playerRow-1][playerCol].getWalkable())
//						{
//							home[playerRow][playerCol] = new Empty(playerRow,playerCol);
//							home[playerRow-1][playerCol] = new Player(playerRow-1,playerCol);
//						}
//					}
//					if(key.getKeyChar()=='s'&&playerCol!=6)//change to arrow key
//					{
//						if(home[playerRow][playerCol+1].getWalkable())
//						{
//							home[playerRow][playerCol] = new Empty(playerRow,playerCol);
//							home[playerRow][playerCol+1] = new Player(playerRow,playerCol+1);
//						}
//					}
//					if(key.getKeyChar()=='d'&&playerRow!=6)//change to arrow key
//					{
//						if(home[playerRow+1][playerCol].getWalkable())
//						{
//							home[playerRow][playerCol] = new Empty(playerRow,playerCol);
//							home[playerRow+1][playerCol] = new Player(playerRow+1,playerCol);
//						}
//					}
//				}
//			}
//		}
//		else if(player.getInBase())
//		{
//			int playerCol = 0;
//			int playerRow = 0;
//
//			for(int x = 0;x<base.length;x++)
//			{
//				for(int y = 0;y<base[0].length;y++)
//				{
//					if(base[x][y] instanceof Player)
//					{
//						playerCol = y;
//						playerRow = x;
//					}
//				}
//			}
//			
//			
//			for(int x = 0;x<base.length;x++)
//			{
//				for(int y = 0;y<base[0].length;y++)
//				{
//					if(key.getKeyChar()=='w'&&playerCol==0&&playerRow==3)//change to arrow key
//					{
//						player.setInHome(false);
//						player.setInBase(false);
//						base[3][0] = new Empty(3,0);
//						player.setX(3);
//						player.setY(3);
//						dungeonMusic1.playMusic();
//					}
//					if(key.getKeyChar()=='a'&&playerRow==0&&playerCol==3)
//					{
//						player.setInHome(true);
//						player.setInBase(false);
//						player.setX(6);
//						player.setY(3);
//					}
//					if(key.getKeyChar()=='w'&&playerCol!=0)//change to arrow key
//					{
//						if(base[playerRow][playerCol-1].getWalkable())
//						{
//							player.setX(playerRow);
//							player.setY(playerCol-1);
//						}
//					}
//					if(key.getKeyChar()=='a'&&playerRow!=0)//change to arrow key
//					{
//						if(base[playerRow-1][playerCol].getWalkable())
//						{
//							player.setX(playerRow-1);
//							player.setY(playerCol);
//						}
//					}
//					if(key.getKeyChar()=='s'&&playerCol!=6)//change to arrow key
//					{
//						if(base[playerRow][playerCol+1].getWalkable())
//						{
//							player.setX(playerRow);
//							player.setY(playerCol+1);
//						}
//					}
//					if(key.getKeyChar()=='d'&&playerRow!=6)//change to arrow key
//					{
//						if(base[playerRow+1][playerCol].getWalkable())
//						{
//							player.setX(playerRow+1);
//							player.setY(playerCol);
//						}
//					}
//				}
//			}
//		}
//		else
//		{
			int playerCol = 0;
			int playerRow = 0;
			int playerRoomRow = 0;
			int playerRoomCol = 0;
			for(int x = 0;x<map.length;x++)
			{
				for(int y = 0;y<map[0].length;y++)
				{
					if(map[x][y].hasPlayer())
					{
						playerRoomRow = player.getX();
						playerRoomCol = player.getY();
						Character[][] room= map[x][y].getRoom();
					}
				}
			}
	
			if(key.getKeyChar()=='w'&&playerCol!=0)//change to arrow key
			{
				if(map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol-1].getWalkable())
				{
					player.setX(playerRow);
					player.setY(playerCol-1);
				}
			}
			if(key.getKeyChar()=='a'&&playerRow!=0)//change to arrow key
			{
				if(map[playerRoomRow][playerRoomCol].getRoom()[playerRow-1][playerCol].getWalkable())
				{
					player.setX(playerRow-1);
					player.setY(playerCol);				}
			}
			if(key.getKeyChar()=='s'&&playerCol!=6)//change to arrow key
			{
				if(map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol+1].getWalkable())
				{
					player.setX(playerRow);
					player.setY(playerCol+1);
				}
			}
			if(key.getKeyChar()=='d'&&playerRow!=6)//change to arrow key
			{
				if(map[playerRoomRow][playerRoomCol].getRoom()[playerRow+1][playerCol].getWalkable())
				{
					player.setX(playerRow+1);
					player.setY(playerCol);
				}
			}
//	
//			if(key.getKeyChar()=='w'&&playerCol==0&&playerRoomCol!=0)
//			{
//				map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol].setPlayer(false);
//				map[playerRoomRow][playerRoomCol-1].getRoom()[playerRow][6].setPlayer(true);
//			}
//	
//			if(key.getKeyChar()=='a'&&playerRow==0&&playerRoomRow!=0)
//			{
//				map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol].setPlayer(false);
//				map[playerRoomRow-1][playerRoomCol].getRoom()[6][playerCol].setPlayer(true);
//			}
//	
//			if(key.getKeyChar()=='s'&&playerCol==6&&playerRoomCol!=4)
//			{
//				map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol].setPlayer(false);
//				map[playerRoomRow][playerRoomCol+1].getRoom()[playerRow][0].setPlayer(true);
//			}
//	
//			if(key.getKeyChar()=='d'&&playerRow==6&&playerRoomRow!=4)
//			{
//				map[playerRoomRow][playerRoomCol].getRoom()[playerRow][playerCol].setPlayer(false);
//				map[playerRoomRow+1][playerRoomCol].getRoom()[0][playerCol].setPlayer(true);
//			}
//		}
		repaint();
	}
}
