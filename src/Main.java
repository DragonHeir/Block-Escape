import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
	JFrame Frame;
	BlockObject entity;
	public static void main(String[] args)
	{
		Main m = new Main();
	}
	Main()
	{
		Frame = new JFrame("Block Escape");
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.add(Frame, new BlockObject(0, 0, 0, 0, "Block.png"), 0);
		Frame.setSize(256,502);
	}
}