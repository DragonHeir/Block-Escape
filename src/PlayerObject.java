import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerObject implements ActionListener {
	int speed;

	public int x;
	public int y;
	public int width;
	public int height;
	boolean isFalling = true;
	boolean keyA;
	boolean keyD;
	boolean keySpace;
	public boolean isJumping = false;
	public boolean isMovingRight = false;
	public boolean isMovingLeft = false;
	private BufferedImage image;
	public Rectangle cBox;

	PlayerObject(int x, int y, int width, int height, String image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 8;
		isFalling = true;
		try {
			this.image = ImageIO.read(this.getClass().getResourceAsStream(image));
		} catch (IOException e) {
			System.out.println("Error Loading Image");
		}
		cBox = new Rectangle(x, y + 16, width, height);
	}

	public void refresh() {
		if (keyA) {
			if (isMovingLeft == false) {
				x = x + speed;
				isMovingRight = true;
			}
		}
		if (keyD) {
			if (isMovingRight == false) {
				x = x + speed;
				isMovingRight = true;
			}
		}
		if (keySpace) {
			if (isJumping == false) {
				y = y - 32;
				isJumping = true;
			}
		}
		cBox.setBounds(x, y, width, height);
	}

	public void paint(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyA = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyD = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keySpace = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyA = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyD = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keySpace = false;
		}

	}
}
