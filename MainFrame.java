import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame { 
	Menu menu;
	ArrayList<String> keyList=new ArrayList<>();
	
	public MainFrame()  {
		super("Arkanoid");
		
		setSize(700,800);
		setLayout(null);
		
		menu=new Menu(this);
		add(menu);
		
		this.addKeyListener(new KeyListener() {
			public synchronized void keyTyped(KeyEvent e) {
			}
		
			public  synchronized  void keyPressed(KeyEvent e) {
				String key=KeyEvent.getKeyText(e.getKeyCode());
				keyList.add(key);
				int i=keyList.indexOf(key);
				if(keyList.size()>=2 && key.equals("Q")) 
					for(int j=0;j<i;j++)
					if(keyList.get(j).equals("Ctrl"))
						System.exit(0);
				
			}
		
			public synchronized  void  keyReleased(KeyEvent e) {
				String key=KeyEvent.getKeyText(e.getKeyCode());
				keyList.remove(key);
			}
		});
	}
	
	public Menu getMenu() {
		return menu;
	}

	
}

