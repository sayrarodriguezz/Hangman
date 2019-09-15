package hangman;
import java.util.*;
import java.io.* ;
import javax.swing.JPanel;

public class RandomWords{

	private String[]wordList=new String[10];
	private boolean[]wordUsed=new boolean[10];
	private int totalWordUsed;	

	public RandomWords(){
		try{
			Scanner reader=new Scanner(new File("Hangman.txt"));
			for(int i=0;i<10;i++){
				wordList[i]=reader.nextLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(0);
		}
	}
	public String chooseRandomWord(){
		totalWordUsed++;
		if(totalWordUsed>10){
			totalWordUsed=1;
		}
		for(int i=0;i<10;i++)
			wordUsed[i]=false;
		int a=(int)(Math.random()*9);
		while(wordUsed[a]==true)
			a=(int)(Math.random()*9);
		wordUsed[a]=true;
		return wordList[a];
	}
}


