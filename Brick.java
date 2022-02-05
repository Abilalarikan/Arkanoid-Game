import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Icon;

public class Brick extends JLabel{
	private int level;
	Icon brickImage1;
	Icon brickImage2;
	Icon brickImage3;
	static ArrayList<Brick> brickList=new ArrayList<>();
	private int hit;
	private int brickX,brickY;
	private int brickLen=40,brickHeight=40;
	
	public Brick(int level) {
		this.level=level;
		if(level==1) {
			brickImage1=new ImageIcon(getClass().getResource("yellowBrick.png"));
			hit=1;
			setIcon(brickImage1);
		}
		else if(level==2) {
			brickImage2=new ImageIcon(getClass().getResource("redBrick.png"));
			hit=2;
			setIcon(brickImage2);
			
		}
		else if(level==3) {
			brickImage3=new ImageIcon(getClass().getResource("blueBrick.png"));
			hit=3;
			setIcon(brickImage3);
		}
	}
	
	
	public  void setBrickBounds() {
		int x=60,y=80;
		if(OptionsPanel.getLevel()==0) {
			brickList.get(0).setBounds(600,260,brickLen,brickHeight);
			brickList.get(0).brickX=600;
			brickList.get(0).brickY=260;
		}
		else {
			for(int i=0;i<4;i++) {
				x=60;
				
				for(int j=0;j<10;j++) {
					brickList.get(10*i+j).setBounds(x,y,brickLen,brickHeight);
					brickList.get(10*i+j).brickX=x;
					brickList.get(10*i+j).brickY=y;
					x+=60;
				}
				y+=60;
			}
		}
		
	}
	public void addToBrickList(int index) {
		brickList.add(index,this);
	}
	
	public void decreaseHit(){
		
		
		try {
			int index=brickList.indexOf(this);
			int x=getBoundX();
			int y=getBoundY();
			int lvl=getLevel();
			
			int temp=this.hit-1;
			brickList.remove(this);
			Brick brick;
			if(temp==2) {
				brick=new Brick(2);
				brick.setLevel(lvl);
				brick.setBounds(x,y,brickLen,brickHeight);
				brick.brickX=x;
				brick.brickY=y;
				brickList.add(index,brick);
			}
			else if(temp==1) {
				brick=new Brick(1);
				brick.setLevel(lvl);
				brick.setBounds(x,y,brickLen,brickHeight);
				brick.brickX=x;
				brick.brickY=y;
				brickList.add(index,brick);
			}
			else if(temp==0) {
				if(this.level==3)
					GamePanel.setScore(GamePanel.getScore()+50);
				else if(this.level==2)
					GamePanel.setScore(GamePanel.getScore()+25);
				else if(this.level==1)
					GamePanel.setScore(GamePanel.getScore()+10);
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
		}
		catch(IndexOutOfBoundsException e) {
		}
		
	}
	public static void addBricks(GamePanel gamePanel) {
		if(OptionsPanel.getLevel()==0) {
			try {
				gamePanel.add(brickList.get(0));
			}
			catch(Exception e) {}
			
		}
		else {
			for(int i=0;i<40;i++) {
				try {
					brickList.get(i);
				}
				catch(ArrayIndexOutOfBoundsException e){
					continue;
				}
				catch(IndexOutOfBoundsException e) {
					continue;
				}
					gamePanel.add(brickList.get(i));
			}
		}
		
	}
	public int getBrickX() {
		return brickX;
	}
	public int getBrickY() {
		return brickY;
	}
	public int getBrickLen() {
		return brickLen;
	}
	public int getBrickHeight() {
		return brickHeight;
	}
	private int getBoundX() {
		return brickX;
	}
	private int getBoundY() {
		return brickY;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}	
