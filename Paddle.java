import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Paddle extends JLabel {
	Icon paddleImage;
	private int level;
	private int paddleX,paddleY;
	private int length,thickness;
	
	public Paddle(int level) {
		this.level=level;
		if(level==0 || level==1) {
			paddleX=250;
			paddleY=660;
			length=180;
			thickness=35;
			paddleImage=new ImageIcon(getClass().getResource("paddle1.png"));	
		}
		else if(level==2){
			paddleX=275;
			paddleY=660;
			length=150;
			thickness=35;
			paddleImage=new ImageIcon(getClass().getResource("paddle2.png"));
		}
		else if(level==3) {
			paddleX=310;
			paddleY=660;
			length=120;
			thickness=35;
			paddleImage=new ImageIcon(getClass().getResource("paddle3.png"));	
		}
		setBounds(paddleX,paddleY,length,thickness);
		setIcon(paddleImage);
		
	}
	public void resetPaddle() {
		if(level==1) 
			paddleX=250;
		else if(level==2)
			paddleX=275;
		else if(level==3) 
			paddleX=310;	
		setLocation(paddleX,660);
	}
	public int getPaddleX() {
		return paddleX;
	}
	
	public int getPaddleY() {
		return paddleY;
	}
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}
	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}
	public int getLength() {
		return length;
	}

	public int getThickness() {
		return thickness;
	}
}