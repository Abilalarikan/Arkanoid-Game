import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class ScoresPanel extends JPanel{
	Icon board;
	Icon button;
	Icon backgroundImage;
	JLabel boardLabel;
	JLabel ok;
	JLabel background;
	JTextArea text;
	JTextArea scoresText;
	JTextArea topicText;
	
	
	public ScoresPanel(MainFrame mainFrame,Menu menu) {
		setBounds(0,0,700,800);
		setLayout(null);
		
		
		scoresText=new JTextArea();
		scoresText.setText("SCORES");
		scoresText.setBounds(260,120,150,50);
		scoresText.setEditable(false);
		scoresText.setOpaque(false);
		scoresText.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,40));
		scoresText.setForeground(Color.red);
		add(scoresText);
		
		topicText=new JTextArea();
		topicText.setText("name\t      time\tdate\tscore");
		topicText.setBounds(120,180,550,30);
		topicText.setEditable(false);
		topicText.setOpaque(false);
		topicText.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		topicText.setForeground(Color.red);
		add(topicText);
		
		text=new JTextArea();
		text.setText(Player.getHighScores());
		text.setBounds(70,230,600,400);
		text.setEditable(false);
		text.setOpaque(false);
		text.setFont(new Font("Bauhaus 93",Font.BOLD,25));
		text.setForeground(Color.black);
		add(text);
		
		board=new ImageIcon(getClass().getResource("board.png"));
		boardLabel=new JLabel(board);
		boardLabel.setBounds(50,20,600,700);
		add(boardLabel);
		
		button=new ImageIcon(getClass().getResource("button.png"));
		ok=new JLabel(button);
		ok.setBounds(220,670,250,75);
		ok.setText("OK");
		ok.setFont(new Font("SHOWCARD GOTHIC",Font.BOLD,20));
		ok.setHorizontalTextPosition(JLabel.CENTER);
		ok.setVerticalTextPosition(JLabel.CENTER);
		ok.setForeground(Color.WHITE);
		
		ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("clickSound.wav");
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(menu);
				mainFrame.getContentPane().repaint();
				mainFrame.getContentPane().revalidate();
				
			}
			public void mouseEntered(MouseEvent e) {
				ok.setForeground(Color.blue);
				Sound.playSound("sound.wav");
			}
			public void mouseExited(MouseEvent e) {
				ok.setForeground(Color.WHITE);	
			}
		});
		add(ok);
		
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
