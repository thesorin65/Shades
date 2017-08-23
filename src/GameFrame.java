import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame() throws Exception
	{
		super("Shades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();

		GraphicsConfiguration gc = getGraphicsConfiguration();
		
		Rectangle screenRect = gc.getBounds();
		
		Insets deskInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
		
		int frameWidth = (int)(screenRect.width) - (deskInsets.left + deskInsets.right);
		int frameHeight = (int)(screenRect.height) - (deskInsets.top + deskInsets.bottom);
			
		setPreferredSize(new Dimension(frameWidth, frameHeight));

		pack();

		Insets frameInsets = getInsets();

		int panelWidth = frameWidth - (frameInsets.left + frameInsets.right);
		int panelHeight = frameHeight - (frameInsets.top + frameInsets.bottom);
		
		GamePanel p = new GamePanel(panelWidth, panelHeight);
		
		
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		
		setLayout(null);
		add(p);
		setVisible(true);
	}
}