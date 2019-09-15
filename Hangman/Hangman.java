package hangman;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.applet.*;
import javax.swing.border.*;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Hangman extends JFrame {
	private JTextField sentence=new JTextField("",24);
	private Font font=new Font(Font.SANS_SERIF,Font.PLAIN,24);
	private String thisWord;//actual word
	private String displayWord;//astrick words
	private int charCount;//length of word
	private int charsReplaced;//number of chars replaced
	private RandomWords wor=new RandomWords();
	private HMCanvas canvas=new HMCanvas();
	private JButton[] buttons=new JButton[26];
	
	public static void main(String[]args){
		Hangman lab = new Hangman();
		lab.initFrame();
		lab.initMenu();
		lab.initGame();
		lab.setVisible(true);
	}	
	public Hangman(){
		
		JPanel top=new JPanel();
		top.setBackground(new Color(63,72,204));
		top.setPreferredSize(new Dimension(600,54));
		sentence.setBorder(new BevelBorder(BevelBorder.LOWERED));
		sentence.setFont(font);
		sentence.setHorizontalAlignment(JTextField.CENTER);
		sentence.setEditable(false);
		sentence.setDisabledTextColor(Color.WHITE);
		top.add(sentence);
		add(top,BorderLayout.NORTH);
	
		JPanel east=new JPanel(new GridLayout(6,5));
		east.setBackground(new Color(63,72,204));
		east.setPreferredSize(new Dimension(300,200));
		add(east,BorderLayout.EAST);
		
		JPanel center=new JPanel();
		center.setBackground(new Color(63,72,204));
		add(center,BorderLayout.CENTER);
		add(canvas,BorderLayout.WEST);
		
		ActionListener listener=new ActionListener(){
			public void actionPerformed(ActionEvent e){
			sentence.setText(displayWord);
			JButton button=(JButton)e.getSource();
				String text=button.getText();
				char ch=text.charAt(0);	
				if(canvas.getMisses()<5 && charsReplaced<charCount)
				{
					button.setEnabled(false);
					thisGuess(ch);
				}
			}
		};
		
		char ch='A';
		 for(int i=0;i<26;i++)
		 {
			buttons[i]=new JButton("" + ch);
			buttons[i].setIcon(new ImageIcon("F:\\CS2\\Hangman\\hangman\\Alphabet\\"+ch+".jpg"));
			buttons[i].addActionListener(listener);
			buttons[i].setBackground(new Color(83,83,83));
			east.add(buttons[i]);
			ch++;
		 }
			pack();
		}
		public void initFrame(){
			setTitle("Hangman");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		public void initMenu(){
		JMenuBar menuBar= new JMenuBar();
		JMenu options=new JMenu("Options");
		JMenuItem ng=new JMenuItem("New Game");
		JMenuItem exit=new JMenuItem("Exit");
		
		ng.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			initGame();
			canvas.repaint();
				for(int i=0;i<26;i++)
				{
					buttons[i].setEnabled(true);
				}
			}	
		});
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			System.exit(0);
			}	
		});
		options.add(ng);
		options.add(exit);
		menuBar.add(options);
		setJMenuBar(menuBar);
		}
		public void initGame(){
			charCount=0;
			charsReplaced=0;
			thisWord=wor.chooseRandomWord();
			char[]w=new char[thisWord.length()];
			for(int i=0;i<thisWord.length();i++)
			{
					w[i] = '*';	
					charCount++;	
				displayWord=new String(w);
	     
	     	}
	     	sentence.setText(displayWord);
	     	canvas.setMisses(0);
		}
		private boolean findCharacters(char thisChar){
			boolean foundChar=false;
			for(int i=0;i<thisWord.length();i++){
				if(thisWord.charAt(i)==thisChar)
				{
					displayWord=displayWord.substring(0,i)+thisChar+displayWord.substring(i+1);
					charsReplaced=charsReplaced+1;
					foundChar=true;
					sentence.setText(displayWord);
				}
			}
			return foundChar;
		}
		public void thisGuess(char ch)
		{
			System.out.println (ch);
				if(findCharacters(ch)==false){
				canvas.setMisses(canvas.getMisses()+1);
				canvas.repaint();
				gameOver();					
				}
		}
		private void gameOver(){
			if(canvas.getMisses()==5)
			{
				System.out.println("Game Over!");
				sentence.setText(thisWord);
			}	
			else if(displayWord==thisWord)
			{
				System.out.println();
				sentence.setText("Not bad, Muggle :D !");
			}
		}		
}