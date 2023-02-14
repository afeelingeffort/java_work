package ch02;

import javax.swing.JButton;
import javax.swing.JFrame;

//좌표 기반으로 컴포넌트들을 배치해보자
public class NoLayoutEx1 extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;

	public NoLayoutEx1() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("좌표기반 연습");
		setSize(1_000, 1_000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1 = new JButton("button1");
		button1.setSize(100, 100);
		button2 = new JButton("button2");
		button2.setSize(150, 50);
		button3 = new JButton("button3");
		button3.setSize(200, 30);
	}

	private void setInitLayout() {
		setLayout(null); // 좌표 기반으로 컴포넌트들을 배치해야 한다.
		// 좌표 기반을 세팅을 하면 각 컴포넌트에 크기를 지정해 주어야 한다. 기본값 0
		button1.setLocation(100, 100);
		add(button1);
		button2.setLocation(200, 150);
		add(button2);
		button3.setLocation(450, 200);
		add(button3);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NoLayoutEx1();

	} // end of main

} // end of class
