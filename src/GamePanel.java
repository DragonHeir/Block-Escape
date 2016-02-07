import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener
{
	boolean isFalling;
	int x = 5;
	int blockcounter = 0;
	Timer blocktimer;
	GameObject bg;
	ArrayList<GameObject> blocks;
	public void paint(Graphics g)
	{
		bg.paint(g);
		for (GameObject block:blocks)
		{
			block.paint(g);
		}
	}
	public GamePanel()
	{
		bg = new GameObject(0, 0, 256, 480, "Background.png");
		blocks = new ArrayList<GameObject>();
		blocktimer = new Timer(1000/20, this);
		blocktimer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (GameObject block:blocks)
		{
			if (block.isFalling)
			{			
				block.checkCollision(blocks);
				block.refresh();
			}

		}
		repaint();
		blockLogic();
	}
	int block()
	{
		Random r = new Random();
		int x = r.nextInt(16);
		x = x * 16;
		return x;
	}
	public void addBlock()
	{
		blocks.add(new GameObject(block(), 0, 16, 16, "block.png"));
	}
	public void blockLogic()
	{
		if (blockcounter == 7)
		{
			addBlock();
			blockcounter = 0;
		}
		blockcounter++;
	}
	boolean isFalling()
	{
		return isFalling;
	}
	public void checkCollision()
	{
		for (int i = 0; i < blocks.size(); i++)
		{
			for (int j = 0; j < blocks.size(); j++)
			{
				if (i == j)
				{
					continue;
				}
				Rectangle r1 = blocks.get(i).getBox();
				Rectangle r2 = blocks.get(j).getBox();
				if (r1.intersects(r2)&& blocks.get(i).getisFalling())
				{
					GameObject go = blocks.get(j);
					go.setY(go.getY()-32);
					go.setIsFalling(false);
				}
			}
		}
	}
}
