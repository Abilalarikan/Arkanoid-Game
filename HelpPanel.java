import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {
	Icon board;
	Icon button;
	Icon backgroundImage;
	JLabel boardLabel;
	JLabel gotIt;
	JLabel background;
	JTextArea welcome;
	JTextArea  text;
	Font f;
	public HelpPanel(MainFrame mainFrame,Menu menu) {
		setBounds(0,0,700,800);
		setLayout(null);
		
		
		welcome=new JTextArea();
		welcome.setText("        WELCOME TO THE ARKANOID GAME");
		welcome.setBounds(100,110,550,30);
		welcome.setEditable(false);
		welcome.setOpaque(false);
		f=new Font("SHOWCARD GOTHIC",Font.BOLD,20);
		welcome.setFont(f);
		welcome.setForeground(Color.red);
		add(welcome);
		
	
		text=new JTextArea();
		text.setText("The main purpose of the game is to break all the \n"
				+"bricks without letting the ball fall.\n\n"
				+"You have 3 lives at the beginning of the game.If\n "
				+"the ball drops when you don't have any extra life\n"
				+"the game will be over.\n\n"
				+"There are 3 different levels. You can choose difficulty\n "
				+"before starting the game. The game will continue \n"
				+"with the next level when you finish the current one.\n"
				+"If you finish the third level succesfully you will win\n"
				+"the game.\n\n"
				+"You can slide the paddle left and right either by \n"
				+"using left and right keys on the keyboard or moving\n"
				+"the mouse.\n"
				+ "\tGOOD LUCK HAVE FUN !!!");
		text.setBounds(100,140,550,500);
		text.setEditable(false);
		text.setOpaque(false);
		text.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		text.setForeground(Color.black);
		add(text);
		
		
		board=new ImageIcon(getClass().getResource("board.png"));
		boardLabel=new JLabel(board);
		boardLabel.setBounds(50,20,600,700);
		add(boardLabel);
		
		button=new ImageIcon(getClass().getResource("button.png"));
		gotIt=new JLabel(button);
		gotIt.setBounds(220,670,250,75);
		gotIt.setText("GOT IT!");
		gotIt.setFont(f);
		gotIt.setHorizontalTextPosition(JLabel.CENTER);
		gotIt.setVerticalTextPosition(JLabel.CENTER);
		gotIt.setForeground(Color.WHITE);
		
		gotIt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(menu);
				mainFrame.getContentPane().repaint();
				mainFrame.getContentPane().revalidate();
				
			}
			public void mouseEntered(MouseEvent e) {
				gotIt.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				gotIt.setForeground(Color.WHITE);	
			}
		});
		add(gotIt);
		
		backgroundImage=new ImageIcon(getClass().getResource("background.jpg"));
		background=new JLabel(backgroundImage);
		background.setSize(700,800);
		add(background);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(this);
		mainFrame.getContentPane().repaint();
		mainFrame.getContentPane().revalidate();
		
	}
}
