package ch01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{

	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initData();
		setInitLayout();
		addEvenetListener();
	}

	private void initData() {
		backgroundMap=new JLabel(new ImageIcon("images/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 640);
		
		player = new Player();
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		add(player);
		
		setVisible(true);
	}

	private void addEvenetListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_RIGHT : 
					
				}
			}
		});
	}
}
