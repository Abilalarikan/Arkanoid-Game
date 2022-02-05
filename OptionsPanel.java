import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel{
	Icon levelButton;
	Icon backgroundImage;
	Icon button;
	JLabel level1;
	JLabel level2;
	JLabel level3;
	JLabel quickFinishButton;
	JLabel background;
	JLabel select;
	Font f;
	private static int level=1;
	private static int quickFinish;
	
	public OptionsPanel(MainFrame mainFrame,Menu menu) {
		setBounds(0,0,700,800);
		setLayout(null);
		
		levelButton=new ImageIcon(getClass().getResource("levelButton.png"));
		
		level1=new JLabel(levelButton);
		level1.setBounds(100,50,500,150);
		level1.setText("LEVEL 1");
		f=new Font("SHOWCARD GOTHIC",Font.BOLD,30);
		level1.setFont(f);
		level1.setHorizontalTextPosition(JLabel.CENTER);
		level1.setVerticalTextPosition(JLabel.CENTER);
		level1.setForeground(Color.WHITE);
		level1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				level1.setForeground(Color.red);
				level2.setForeground(Color.WHITE);
				level3.setForeground(Color.WHITE);
				quickFinishButton.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				if(level1.getForeground()!=Color.RED)
					level1.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				if(level1.getForeground()!=Color.RED)
					level1.setForeground(Color.WHITE);	
			}
		});
		add(level1);
		
		level2=new JLabel(levelButton);
		level2.setBounds(100,250,500,150);
		level2.setText("LEVEL 2");
		level2.setFont(f);
		level2.setHorizontalTextPosition(JLabel.CENTER);
		level2.setVerticalTextPosition(JLabel.CENTER);
		level2.setForeground(Color.WHITE);
		level2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				level2.setForeground(Color.RED);
				level1.setForeground(Color.WHITE);
				level3.setForeground(Color.WHITE);
				quickFinishButton.setForeground(Color.WHITE);
				
			}
			public void mouseEntered(MouseEvent e) {
				if(level2.getForeground()!=Color.RED)
					level2.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				if(level2.getForeground()!=Color.RED)
					level2.setForeground(Color.WHITE);	
			}
		});
		add(level2);
		
		level3=new JLabel(levelButton);
		level3.setBounds(100,450,500,150);
		level3.setText("LEVEL 3");
		level3.setFont(f);
		level3.setHorizontalTextPosition(JLabel.CENTER);
		level3.setVerticalTextPosition(JLabel.CENTER);
		level3.setForeground(Color.WHITE);
		level3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				level3.setForeground(Color.RED);
				level1.setForeground(Color.WHITE);
				level2.setForeground(Color.WHITE);
				quickFinishButton.setForeground(Color.WHITE);
				
			}
			public void mouseEntered(MouseEvent e) {
				if(level3.getForeground()!=Color.RED)
					level3.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				if(level3.getForeground()!=Color.RED)
					level3.setForeground(Color.WHITE);	
			}
		});
		add(level3);
		
		button=new ImageIcon(getClass().getResource("button.png"));
		
		quickFinishButton=new JLabel(button);
		quickFinishButton.setBounds(0,680,250,75);
		quickFinishButton.setText("QUICK FINISH");
		quickFinishButton.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		quickFinishButton.setHorizontalTextPosition(JLabel.CENTER);
		quickFinishButton.setVerticalTextPosition(JLabel.CENTER);
		quickFinishButton.setForeground(Color.WHITE);
		
		quickFinishButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				quickFinishButton.setForeground(Color.RED);
				level1.setForeground(Color.WHITE);
				level2.setForeground(Color.WHITE);
				level3.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				if(quickFinishButton.getForeground()!=Color.RED)
					quickFinishButton.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				if(quickFinishButton.getForeground()!=Color.RED)
					quickFinishButton.setForeground(Color.WHITE);	
			}
		});
		add(quickFinishButton);
		

		select=new JLabel(button);
		select.setBounds(220,650,250,75);
		select.setText("SELECT");
		select.setFont(f);
		select.setHorizontalTextPosition(JLabel.CENTER);
		select.setVerticalTextPosition(JLabel.CENTER);
		select.setForeground(Color.WHITE);
		
		select.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");

				if(level1.getForeground()==Color.RED) 
					setLevel(1);
				
				else if(level2.getForeground()==Color.RED) 
					setLevel(2);
					
				else if(level3.getForeground()==Color.RED) 
					setLevel(3);
				else if(quickFinishButton.getForeground()==Color.RED) {
					setLevel(0);
					quickFinish=1;
				}
				
				
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(menu);
				mainFrame.getContentPane().repaint();
				mainFrame.getContentPane().revalidate();
				
			}
			public void mouseEntered(MouseEvent e) {
				select.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				select.setForeground(Color.WHITE);	
			}
		});
		add(select);
		
		
		
		
		
		backgroundImage=new ImageIcon(getClass().getResource("background.jpg"));
		background=new JLabel(backgroundImage);
		background.setSize(700,800);
		add(background);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(this);
		mainFrame.getContentPane().repaint();
		mainFrame.getContentPane().revalidate();
	}
	
	public static int getLevel() {
		return level;
	}
	public  static void setLevel(int lvl) {
		level=lvl;
	}
	
	
	public static int getQuickFinish() {
		return quickFinish;
	}

	public static void fillBrickList() {
		Brick brick=new Brick(3);
		
		Brick.brickList.clear();
		int i;
		
		if (level==0) {
			brick=new Brick(3);
			brick.addToBrickList(0);
		}
		else if(level==1) {
			for(i=0;i<40;i++) {
				brick=new Brick(1);
				brick.addToBrickList(i);
			}
		}
		else if(level==2) {
			for(i=0;i<20;i++) {
				brick=new Brick(2);
				brick.addToBrickList(i);
			}
			for(;i<40;i++) {
				brick=new Brick(1);
				brick.addToBrickList(i);
			}
		}
		else if(level==3) {
			for(i=0;i<20;i++) {
				brick=new Brick(3);
				brick.addToBrickList(i);
			}
			for(;i<30;i++) {
				brick=new Brick(2);
				brick.addToBrickList(i);
			}
				
			for(;i<40;i++) {
				brick=new Brick(1);
				brick.addToBrickList(i);
			}
		}
		brick.setBrickBounds();
	}

}
