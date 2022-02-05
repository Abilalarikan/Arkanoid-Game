import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel{
	Icon ballImage;
	private int x=340,y=620;
	private int velocityX=0,velocityY=0;
	private int sizeX=20,sizeY=20;
	
	
	public Ball() {
		velocityX=20;
		velocityY=-20;
		setBounds(x,y,sizeX,sizeY);
		ballImage=new ImageIcon(getClass().getResource("ball.png"));
		setIcon(ballImage);
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	

	public int getVelX() {
		return velocityX;
	}

	public void setVelX(int velX) {
		this.velocityX = velX;
	}

	public int getVelY() {
		return velocityY;
	}

	public void setVelY(int velY) {
		this.velocityY = velY;
	}
	
	public void move() {
		x+=velocityX;
		y+=velocityY;
		setLocation(x,y);
	}
	public void resetBall() {
		setLocation(340,620);
		x=340;
		y=620;
		velocityX=20;
		velocityY=-20;
		
	}
	
}
