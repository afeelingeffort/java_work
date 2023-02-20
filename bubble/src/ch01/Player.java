package ch01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{
	
	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	
	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	//기본값 세팅
	private void setInitLayout() {
		x = 55;
		y = 535;
		
		setSize(50, 50);
		setLocation(x, y);
		setIcon(playerR);
	}

	@Override
	public void left() {
		setIcon(playerL);
		x-=10;
		setLocation(x, y);
	}

	@Override
	public void right() {
		
	}

	@Override
	public void up() {
		
	}

	@Override
	public void down() {
		
	}
	
	
}
