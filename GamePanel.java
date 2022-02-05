import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements Runnable{
	Icon backgroundImage;
	Icon paddleIcon;
	Icon button;
	JLabel background;
	JLabel start;
	JLabel saveButton;
	JLabel nextLevel;
	JFrame save;
	JTextArea scoreboard;
	JTextArea username;
	JTextArea textArea;
	JTextField textField;
	Paddle paddle;
	Ball ball;
	
	private int level;
	private  static int score=0;
	private int lives=3;
	int qFinish=0;
	double prevX;
	public GamePanel(MainFrame mainFrame,Menu menu) {
		setBounds(0,0,700,800);
		setLayout(null);
		new Thread(this);
		
		OptionsPanel.fillBrickList();
		Brick.addBricks(this);
		
		level=OptionsPanel.getLevel();
		qFinish=OptionsPanel.getQuickFinish();
		
		paddle=new Paddle(level);
		
		paddle.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				    prevX=e.getPoint().getX();
			}
		});
		
		paddle.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e) {
				int temp=paddle.getPaddleX()+(int)(e.getPoint().getX()-prevX);
				
				if (temp>=0 &&  temp+paddle.getLength()<=690) {
					paddle.setPaddleX(temp);
					paddle.setLocation(paddle.getPaddleX(),660);
					repaint();
				}
			}
		});
		add(paddle);
		
		ball=new Ball();
		add(ball);
		
		scoreboard=new JTextArea("Score:"+score+"\t\tLevel:"+level+"\t\tLives:"+lives);
		scoreboard.setBounds(5,5,800,20);
		scoreboard.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		scoreboard.setOpaque(false);
		scoreboard.setEditable(false);
		add(scoreboard);
		
		button=new ImageIcon(getClass().getResource("button.png"));
		start=new JLabel(button);
		start.setBounds(230,300,250,75);
		start.setText("START");
		start.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.CENTER);
		start.setForeground(Color.WHITE);
		start.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				remove(start);
				repaint();
				ExecutorService executor = Executors.newCachedThreadPool();
				executor.execute(getGamePanel());
				
			}
			public void mouseEntered(MouseEvent e) {
				start.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				start.setForeground(Color.WHITE);	
			}
		});
		add(start);
		
		nextLevel=new JLabel(button);
		nextLevel.setBounds(230,300,250,75);
		nextLevel.setText("NEXT LEVEL");
		nextLevel.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		nextLevel.setHorizontalTextPosition(JLabel.CENTER);
		nextLevel.setVerticalTextPosition(JLabel.CENTER);
		nextLevel.setForeground(Color.WHITE);
		nextLevel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				remove(nextLevel);
				repaint();
				OptionsPanel.fillBrickList();
				ball.resetBall();
				paddle.resetPaddle();
				removeAll();
				add(start);
				Brick.addBricks(getGamePanel());
				addOtherObjects();
				repaint();
				
			}
			public void mouseEntered(MouseEvent e) {
				nextLevel.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				nextLevel.setForeground(Color.WHITE);	
			}
		});
		
		
		saveButton=new  JLabel(button);
		saveButton.setBounds(220,460,250,75);
		saveButton.setText("SAVE");
		saveButton.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		saveButton.setHorizontalTextPosition(JLabel.CENTER);
		saveButton.setVerticalTextPosition(JLabel.CENTER);
		saveButton.setForeground(Color.WHITE);
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Please enter a non-empty username!","Empty String",JOptionPane.WARNING_MESSAGE);
				else {
					String s=DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy").format(LocalDateTime.now());
					new Player(textField.getText(),score,s);
					score=0;
					mainFrame.getContentPane().removeAll();
					mainFrame.getContentPane().add(menu);
					mainFrame.getContentPane().repaint();
					mainFrame.getContentPane().revalidate();
				}
			}
			public void mouseEntered(MouseEvent e) {
				start.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				start.setForeground(Color.WHITE);	
			}
		});
		
		textArea=new JTextArea();
		textArea.setBounds(150,70,450,200);
		textArea.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,70));
		textArea.setOpaque(false);
		textArea.setEditable(false);
		
		username=new JTextArea("username");
		username.setBounds(80,320,250,50);
		username.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,40));
		username.setOpaque(false);
		username.setEditable(false);
		username.setForeground(Color.black);
		
		
		
		textField=new JTextField();
		textField.setBounds(350,310,250,50);
		textField.setFont(new Font("Calibri",Font.BOLD,30));
		
		
		
		
		backgroundImage=new ImageIcon(getClass().getResource("background.jpg"));
		background=new JLabel(backgroundImage);
		background.setSize(700,800);
		add(background);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(this);
		mainFrame.getContentPane().repaint();
		mainFrame.getContentPane().revalidate();
		mainFrame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT && paddle.getPaddleX()>0) {
					paddle.setPaddleX(paddle.getPaddleX()-40);
					paddle.setLocation(paddle.getPaddleX(),660);
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT && paddle.getPaddleX()<685-paddle.getLength()) {
					paddle.setPaddleX(paddle.getPaddleX()+40);
					paddle.setLocation(paddle.getPaddleX(),660);
				}
				
			}
		});
	}
	
	public void run() {
		while(!(gameOver() || ballFell() || levelCompleted())) {
			ball.move();
			hitPaddle();
			hitWalls();
			hitBricks();
			if(level==0 || level==1)
				try {
					Thread.sleep(65);
				} 
				catch (InterruptedException e) {
				}	
			else if(level==2)
				try {
				Thread.sleep(60);
			} 
			catch (InterruptedException e) {
			}	
			else if(level==3)
				try {
				Thread.sleep(55);
			} 
			catch (InterruptedException e) {
			}	
			
		}
		if(levelCompleted()) {
			
			if(qFinish==1) {
				Sound.playSound("pass.wav");
				qFinish=2;
				removeAll();
				add(nextLevel);
				addOtherObjects();
				repaint();
			}
			else if(!(level==3 || qFinish==2)){
				Sound.playSound("pass.wav");
				OptionsPanel.setLevel(level+1);
				level=OptionsPanel.getLevel();
				removeAll();
				add(nextLevel);
				addOtherObjects();
				repaint();
			}
			
			else {
				removeAll();
				textArea.setText("YOU WIN\nScore:"+score);
				textArea.setForeground(Color.green);
				add(textArea);
				add(username);
				add(textField);
				add(saveButton);
				add(background);
				repaint();
				Sound.playSound("win.wav");
			}
		}
		else if(ballFell()) {
			lives--;
				Sound.playSound("fail.wav");
			ball.resetBall();
			paddle.resetPaddle();
			removeAll();
			add(start);
			Brick.addBricks(getGamePanel());
			addOtherObjects();
			repaint();
		}
		if(gameOver()) {
			removeAll();
			textArea.setText("GAME OVER\nScore:"+score);
			textArea.setForeground(Color.red);
			add(textArea);
			add(username);
			add(textField);
			add(saveButton);
			add(background);
			repaint();
			Sound.playSound("gameOver.wav");
		}
	}
	private synchronized void hitPaddle() {
		
		if(ball.getY()+ball.getSizeY() == paddle.getPaddleY()){
			
				if(ball.getX()+ball.getSizeX() >= paddle.getPaddleX() && ball.getX() <= paddle.getPaddleX() +paddle.getLength()/3 ) {
					ball.setVelY((-1)*ball.getVelY());
					ball.setVelX(ball.getVelY());
				}
				else if(ball.getX() > paddle.getPaddleX() +paddle.getLength()/3 && ball.getX() < paddle.getPaddleX() +2*paddle.getLength()/3)
					if(ball.getX() >=paddle.getPaddleX() +(paddle.getLength()/2) -(paddle.getLength()/12) && ball.getX() <=paddle.getPaddleX() +(paddle.getLength()/2) +(paddle.getLength()/12)) {
						ball.setVelY((-1)*ball.getVelY());
						ball.setVelX(0);
					}
					else
						ball.setVelY((-1)*ball.getVelY());
				else if(ball.getX() >= paddle.getPaddleX() +2*paddle.getLength()/3 && ball.getX() <= paddle.getPaddleX() +paddle.getLength()) {
					ball.setVelY((-1)*ball.getVelY());
					ball.setVelX((-1)*ball.getVelY());
				}
			
		}
	}
	
	private  synchronized void hitWalls() {
		if(ball.getY()<=0 && (ball.getX()+ball.getSizeX()>=680 || ball.getX()<=0 )) {
			ball.setVelX((-1)*ball.getVelX());
			ball.setVelY((-1)*ball.getVelY());
		}
		else if(ball.getX()+ball.getSizeX()>=680)
			ball.setVelX((-1)*ball.getVelX());
		else if(ball.getX()<=0)
			ball.setVelX((-1)*ball.getVelX());
		else if(ball.getY()<=0)
			ball.setVelY((-1)*ball.getVelY());
	
	}
	
	private void hitBricks() {
		int size=Brick.brickList.size();
		int flag1=0,flag2=0;
		
		Brick brick;
		for(int i=0;i<size;i++) {
			
			try {
				brick=Brick.brickList.get(i);
			}
			catch(Exception e) {
				continue;
			}
			if(ball.getY()+ball.getSizeY()==brick.getBrickY()) {
				
				if(ball.getX()+ball.getSizeX()==brick.getBrickX()) {
					flag1++;
					ball.setVelY(-20);
					ball.setVelX(ball.getVelY());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}
				else if(ball.getX()==brick.getBrickX()+brick.getBrickLen()) {
					flag1++;
					ball.setVelY(-20);
					ball.setVelX((-1)*ball.getVelY());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}	
				if(flag1==2) {
					ball.setVelY(-20);
					ball.setVelX(0);
					flag1=0;
				}
					
			}
			else if(ball.getY()==brick.getBrickY()+brick.getBrickHeight()) {
				if(ball.getX()+ball.getSizeX()==brick.getBrickX()) {
					flag2++;
					ball.setVelY(20);
					ball.setVelX((-1)*ball.getVelY());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}
				else if(ball.getX()==brick.getBrickX()+brick.getBrickLen()) {
					flag2++;
					ball.setVelY(20);
					ball.setVelX(ball.getVelY());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}	
				if(flag2==2) {
					ball.setVelY(20);
					ball.setVelX(0);
					flag2=0;
				}	
			}
			if(ball.getX()>= brick.getBrickX() && ball.getX()+ball.getSizeX()<= brick.getBrickX()+ brick.getBrickLen()) {
				if(ball.getY()== brick.getBrickY()+brick.getBrickHeight() || ball.getY()+ball.getSizeY()== brick.getBrickY()) {
					ball.setVelY((-1)*ball.getVelY());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}
			}	
			else if(ball.getY()>= brick.getBrickY() && ball.getY()+ball.getSizeY()<= brick.getBrickY()+ brick.getBrickHeight()) {
				if(ball.getX()== brick.getBrickX()+brick.getBrickLen() || ball.getX()+ball.getSizeX()== brick.getBrickX()) {
					ball.setVelX((-1)*ball.getVelX());
					brick.decreaseHit();
					Sound.playSound("Hit.wav");
					removeAll();
					Brick.addBricks(getGamePanel());
					addOtherObjects();
					repaint();
				}
			}
			size=Brick.brickList.size();
			scoreboard.setText("Score:"+score+"\t\tLevel:"+level+"\t\tLives:"+lives);
			repaint();
		}
			
	}
	private boolean gameOver() {
		if(ball.getY()==720 && lives==1)
			return true;
		return false;
	}
	private boolean levelCompleted() {
		if(Brick.brickList.isEmpty())
			return true;
		return false;
	}
	private void addOtherObjects(){
		add(paddle);
		add(ball);
		add(scoreboard);
		add(background);
	}
	public boolean ballFell() {
		
		if(ball.getY()==720 && !gameOver()) {
			return true;
		}
		return false;
	}

	public void setqFinish(int qFinish) {
		this.qFinish = qFinish;
	}
	
	
	
	public GamePanel getGamePanel() {
		return this;
	}



	public static int getScore() {
		return score;
	}



	public static void setScore(int scr) {
		score = scr;
	}
	
}