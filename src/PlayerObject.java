import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

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
	int idleState = 0;
	int rightState = 1;
	int leftState = 2;
	int currentState = idleState;
	private BufferedImage image;
	public Rectangle cBox;
	boolean PlayerCollision = false;

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
		cBox = new Rectangle(x, y, width, height);
	}

	public void PlayerCollisionDetection(ArrayList<BlockObject> blocks) {
		for (BlockObject b : blocks) {
			if (b.getBox().intersects(cBox)) {
				PlayerCollision = true;
			} else {
				PlayerCollision = false;
			}
		}
		}
		public boolean isColliding(ArrayList<BlockObject> blocks){
			 		for (BlockObject b : blocks) {
			 		if (b.getBox().intersects(cBox)) {
			 				return true;
			 			}
			 		}
			 		return false;
			 	}
			 	public void refresh(ArrayList<BlockObject> blocks) {
		if (keyA) {
			
			if (PlayerCollision) {
				currentState = idleState;
			} else {
				currentState = leftState;
			}
		}
		if (keyD) {
			
			if (PlayerCollision) {
				currentState = idleState;
			} else {
				currentState = rightState;
			}

		}
		if (!keyA && !keyD) {
			currentState = idleState;
		}
		if (keySpace) {
			if (isJumping == false) {
				y = y - 40;
				isJumping = true;
			}
		}

		if (currentState == leftState) {
			cBox.x = x - speed;
			if (!isColliding(blocks)){
				 			x -= speed;
				 		}
				 			else {
				 				cBox.setBounds(x, y, width, height);
				 			}
		} else if (currentState == rightState) {
			x += speed;
			cBox.x = x + speed;
		} else {
			cBox.x = x;
		}
	}

	//CHECK GITHUB AND HISTORY OF ASDF AND COPY AND PASTE EVERYTHING INTO THIS CODE EXCEPT JUMPING CRAP, FIGURE OUT HOW TO GET JUMPING TO WORK

	public void paint(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
		g.setColor(Color.RED);
		g.drawRect(cBox.x, cBox.y, cBox.width, cBox.height);
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