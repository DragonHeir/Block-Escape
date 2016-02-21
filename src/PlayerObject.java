import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerObject {
	
	int x;
	int y;
	int width;
	int height;
	boolean isFalling = true;
	private BufferedImage image;
	Rectangle cBox;

	PlayerObject(int x, int y, int width, int height, String image)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isFalling = true;
		try
		{
			this.image = ImageIO.read(this.getClass().getResourceAsStream(image));
		} 
		catch (IOException e)
		{
			System.out.println("Error Loading Image");
		}
		cBox = new Rectangle(x, y + 16, width, height);
	}
	public void paint(Graphics g)
	{
		g.drawImage(image, x, y, width, height, null);
	}
}
