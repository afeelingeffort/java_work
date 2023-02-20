package ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

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

	private void setInitLayout() {
		x = 55;
		y = 535;
		// 좌표 기반, 라벨의 크기를 지정해야 한다.
		setSize(50, 50);
		setLocation(x, y);
		// JLabel에 아이콘을 셋팅하는 메서드
		setIcon(playerR);
	}

	@Override
	public void left() {
		setIcon(playerL);
		x -= 10;
		setLocation(x, y);
	}

	@Override
	public void right() {
		setIcon(playerR);
		x += 10;
		setLocation(x, y);
	}

	@Override
	public void up() {
		System.out.println("점프");
		
	}

	@Override
	public void down() {
		System.out.println("p down");
	}

}
