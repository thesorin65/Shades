import java.awt.Graphics;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import java.util.Set;

public class ImageManager
{
	TreeMap<String, BufferedImage> images = null;

	public ImageManager()
	{
		images = new TreeMap<String, BufferedImage>();
	}

	/*
	 * Pre: Receives a name of file Post: Loads all this images in the file to
	 * map of images using the provided load type
	 */
	public boolean loadImages(String fileName)
	{
		try
		{
			BufferedImage img;
			Scanner file = new Scanner(new File(fileName));

			while (file.hasNextLine())
			{
				String load = file.nextLine();
				String[] s = load.split(",");

				switch (s[0])
				{
					case "single":
						loadImage(s[1], s[2],0,0, "single", 1, 1);
						break;
					case "SNbL":
						for (int x = 0; x < Integer.parseInt(s[1]); x++)
						{
							loadImage(s[2] + x, s[3],0,x,"SNbL", 1, Integer.parseInt(s[1]));
						}
						break;
					case "GNbL":
						for (int x = 0; x < Integer.parseInt(s[1]); x++)
						{
							for (int y = 0; y < Integer.parseInt(s[2]); y++)
							{
								loadImage(s[3] + 'r'+y+'c'+x, s[4],y,x,"GNbL", Integer.parseInt(s[2]), Integer.parseInt(s[1]));
							}
						}
						break;
					case "SSN":
						for (int x = 0; x < Integer.parseInt(s[1]); x++)
						{
							loadImage(s[x+2], s[Integer.parseInt(s[1])+2],0,x,"SSN", 1, Integer.parseInt(s[1]));
						}
						break;
					case "GSN":
						int n = 0;
						for (int y = 0; y < Integer.parseInt(s[2]); y++)
						{
							for (int x = 0; x < Integer.parseInt(s[1]); x++)
							{
								loadImage(s[n+3], s[Integer.parseInt(s[1])*Integer.parseInt(s[2])+3],y,x,"GSN", Integer.parseInt(s[2]), Integer.parseInt(s[1]));
								n++;
							}
						}
						break;
					default:
						break;
				}
			}
			
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Pre: Receives a key Post: returns the image that corresponds to the given
	 * key, null if the key is not found
	 */
	public BufferedImage getImage(String key)
	{
		return images.get(key);
	}

	/*
	 * Pre: Receives a key and a file name Post: loads the image in the given
	 * file to the map with the provided key Note: null is returned if the file
	 * can not be opened
	 */
	public BufferedImage loadImage(String key, String file, int row, int col, String type, int numRows, int numCols)
	{
		BufferedImage img;
		try
		{
			img = ImageIO.read(new File(file));
			
			switch(type)
			{
				case "single":
					images.put(key, img);
					return img;
				case "SNbL":
					img = img.getSubimage(col*(img.getWidth()/numCols), 0, img.getWidth()/numCols, img.getHeight());
					images.put(key, img);
					return img;
				case "GNbL":
					System.out.println(col*(img.getWidth()/numCols)+"    "+img.getWidth()/numCols+"    "+img.getWidth());
					img = img.getSubimage(col*(img.getWidth()/numCols), (row*img.getHeight()/numRows), img.getWidth()/numCols, img.getHeight()/numRows);
					images.put(key, img);
					return img;
				case "SSN":
					img = img.getSubimage(col*(img.getWidth()/numCols), 0, img.getWidth()/numCols, img.getHeight());
					images.put(key, img);
					return img;
				case "GSN":
					img = img.getSubimage(col*(img.getWidth()/numCols), row*(img.getHeight()/numRows), img.getWidth()/numCols, img.getHeight()/numRows);
					images.put(key, img);
					return img;
				default:
					return img;
					
			}
		}
		catch (IOException e)
		{
			return null;
		}
	}

	/*
	 * Pre: Receives a key a Post: removes the key and its image from the map,
	 * the removed image is returned. null is returned if the map does not
	 * contain the given key
	 */
	public BufferedImage removeImage(String key)
	{
		return images.remove(key);
	}

	/*
	 * Pre: Post: empties the map
	 */
	public void clear()
	{
		images = new TreeMap<String, BufferedImage>();
	}

	/*
	 * Pre: Post: returns a set of all the keys in the map
	 */
	public Set<String> getKeys()
	{
		return images.keySet();
	}
}