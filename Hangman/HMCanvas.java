/////setMisses(int n) and a getMisses() methods. In addition, the HMCanvas class should overwrite the JPanal’s paintComponent method.
// (public void paintComponent(Graphics g)). This method should draw the gallows and the parts of the body. 
//Which body parts are drawn should be determined by misses. The gallows should be redrawn every time paintComponent() is called.
// (HINT: Use a switch statement that switches on misses. If misses is equal to 0 then draw the gallows, 
//if misses is equal to 1 draw the head, 2 draw the body, etc. List them in descending order and have no break statements.).
package hangman;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
public class HMCanvas extends JPanel{
	
	int misses;
	private BufferedImage zero;
	private BufferedImage one;
	private BufferedImage two;
	private BufferedImage three;
	private BufferedImage four;
	private BufferedImage five;
	
	public HMCanvas() {
	setPreferredSize(new Dimension(315,450));
	try
	{
		zero = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\0.jpg"));
		one = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\1.jpg"));
		two = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\2.jpg"));
		three = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\3.jpg"));
		four = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\4.jpg"));
		five = ImageIO.read(new File("E:\\CS2\\Hangman\\hangman\\New folder\\5.jpg"));
	}
	catch(IOException e)
	{
		System.out.print("cannot load image!");
		System.exit(0);
	}
	}
	public void setMisses(int m)
	{
		misses=m;
	}
	public int getMisses()
	{
		return misses;
	}

	@Override
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	switch(misses)
		{
			case 0:
			 g.drawImage(zero, 0, 0, null); break;
			case 1: 
			 g.drawImage(one, 0, 0, null); break;
			case 2: 
			 g.drawImage(two, 0, 0, null); break;
			case 3:
			 g.drawImage(three, 0, 0, null); break;
			case 4:
			 g.drawImage(four, 0, 0, null); break;
			case 5:
			g.drawImage(five, 0, 0, null); 
			
		}
	}
}