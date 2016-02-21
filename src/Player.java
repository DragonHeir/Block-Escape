import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player implements ActionListener
{
	PlayerObject player;
	Player p = new Player();
	Timer playertimer;
	int playercounter = 0;
	int x = 228;
	int y = 464;
	boolean isJumping;
	boolean isAlive = true;
	boolean isMoving = false;
	boolean isTouchingBlock = false;

	public Player()
	{
		player = new PlayerObject(128, 464, 16, 16, "Block.png");
		playertimer = new Timer(1000/24, this);
		playertimer.start();
	}
	public void playerlogic()
	{
		
	}
	public void jump()
	{
		if (isJumping)
		{
			
		}
	}
	public boolean isJumping()
	{
		return isJumping;
	}
	public boolean isMoving()
	{
		return isMoving;
	}
	public boolean isAlive()
	{
		return isAlive();
	}
	public boolean touchingBlock()
	{
		return isTouchingBlock;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
