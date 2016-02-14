import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player implements ActionListener
{
	GameObject player;
	Player p = new Player();
	Timer playertimer;
	int playercounter = 0;
	int x = 228;
	int y = 464;
	boolean isJumping;
	boolean isAlive = true;
	boolean isMoving = false;
	
	public void paint(Graphics g)
	{
		{
			player.paint(g);
		}
	}
	public Player()
	{
		player = new GameObject(128, 464, 16, 16, "Block.png");
		playertimer = new Timer(1000/24, this);
		playertimer.start();
	}
	public void playerlogic()
	{
		
	}
	public void jump()
	{
		
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
	public int getX()
	{
		return x;
	}
	public void setX()
	{
		
	}
	public int getY()
	{
		return y;
	}
	public void setY()
	{
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
