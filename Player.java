import java.util.ArrayList;

import java.util.Collections;

public class Player {
	private String userName;
	private int score;
	private String dateAndTime;
	
	static ArrayList<Player> highScores=new ArrayList<>();
	
	public  Player(String userName,int score,String dateAndTime) {
		this.userName=userName;
		this.score=score;
		this.dateAndTime=dateAndTime;
		
		highScores.add(this);
		Collections.sort(highScores,new PlayerComparator());	
		
	}
	public int getScore() {
		return this.score;
	}
	public static String getHighScores() {
		String s="";
		for(int i=0;i<10;i++) {
			try {
				s+=(i+1)+"."+highScores.get(i).userName;
				for(int j=0;j<20-2*highScores.get(i).userName.length();j++)
						s+=" ";
				s+="     "+highScores.get(i).dateAndTime+"     "+highScores.get(i).score+"\n";
			}
			catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		return s;
	}
}
