import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu  extends JPanel{
	Icon button;
	Icon backgroundImage;
	JLabel newGame;
	JLabel options;
	JLabel scores;
	JLabel help;
	JLabel about;
	JLabel exit;
	JLabel background;
	Font f;
	HelpPanel helpPanel;
	OptionsPanel optionsPanel;
	ScoresPanel scoresPanel;
	GamePanel gamePanel;
	
	public Menu(MainFrame mainFrame) {
		
		setLayout(null);
		setBounds(0,0,700,800);
		
		backgroundImage=new ImageIcon(getClass().getResource("background.jpg"));
		background=new JLabel(backgroundImage);
		background.setSize(700,800);
		
		
		f=new Font("SHOWCARD GOTHIC",Font.BOLD,20);
		button=new ImageIcon(getClass().getResource("button.png"));
		
		newGame=new JLabel(button);
		newGame.setBounds(200,50,250,75);
		newGame.setText("NEW GAME");
		newGame.setFont(f);
		newGame.setHorizontalTextPosition(JLabel.CENTER);
		newGame.setVerticalTextPosition(JLabel.CENTER);
		newGame.setForeground(Color.WHITE);
		newGame.addMouseListener(new MouseAdapter() {
			GamePanel gamePanel;
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				gamePanel=new GamePanel(mainFrame,getMenu());
				newGame.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				newGame.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				newGame.setForeground(Color.WHITE);	
			}
		});
		add(newGame);
		
		options=new JLabel(button);
		options.setBounds(200,150,250,75);
		options.setText("OPTIONS");
		options.setFont(f);
		options.setHorizontalTextPosition(JLabel.CENTER);
		options.setVerticalTextPosition(JLabel.CENTER);
		options.setForeground(Color.WHITE);
		options.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				optionsPanel=new OptionsPanel(mainFrame,getMenu());
				options.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				options.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				options.setForeground(Color.WHITE);	
			}
		});
		add(options);
		
		scores=new JLabel(button);
		scores.setBounds(200,250,250,75);
		scores.setText("SCORES");
		scores.setFont(f);
		scores.setHorizontalTextPosition(JLabel.CENTER);
		scores.setVerticalTextPosition(JLabel.CENTER);
		scores.setForeground(Color.WHITE);
		scores.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				scoresPanel=new ScoresPanel(mainFrame,getMenu());
				scores.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				scores.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				scores.setForeground(Color.WHITE);	
			}
		});
		add(scores);
		
		help=new JLabel(button);
		help.setBounds(200,350,250,75);
		help.setText("HELP");
		help.setFont(f);
		help.setHorizontalTextPosition(JLabel.CENTER);
		help.setVerticalTextPosition(JLabel.CENTER);
		help.setForeground(Color.WHITE);
		help.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				helpPanel=new HelpPanel(mainFrame,getMenu());	
				help.setForeground(Color.WHITE);
				
				}
			public void mouseEntered(MouseEvent e) {
				help.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				help.setForeground(Color.WHITE);	
			}
		});
		add(help);
		
		about=new JLabel(button);
		about.setBounds(200,450,250,75);
		about.setText("ABOUT");
		about.setFont(f);
		about.setHorizontalTextPosition(JLabel.CENTER);
		about.setVerticalTextPosition(JLabel.CENTER);
		about.setForeground(Color.WHITE);
		about.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				JOptionPane.showMessageDialog(null,"Developer:\n       Ahmet Bilal ARIKAN\n"+ 
											"School Number:\n       20190702002\n "+
						 "Contact:\n       ahmetbilal.arikan@std.yeditepe.edu.tr","ABOUT"
						,JOptionPane.INFORMATION_MESSAGE);
			}
			public void mouseEntered(MouseEvent e) {
				about.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				about.setForeground(Color.WHITE);	
			}
		});
		add(about);
		
		exit=new JLabel(button);
		exit.setBounds(200,550,250,75);
		exit.setText("EXIT");
		exit.setFont(f);
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.CENTER);
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.WHITE);	
			}
		});
		add(exit);
		
		add(background);
	}

	public Menu getMenu() {
		return this;
	}
}
