package ch02;

import javax.swing.JButton;
import javax.swing.JFrame;

//좌표 기반으로 컴포넌트들을 배치해보자
public class NoLayoutEx2 extends JFrame {

	// JButton <--
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	public NoLayoutEx2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("모양 만들기");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1 = new JButton("button1");
		button1.setSize(200, 200);
		button2 = new JButton("button2");
		button2.setSize(200, 200);
		button3 = new JButton("button3");
		button3.setSize(200, 200);
		button4 = new JButton("button4");
		button4.setSize(200, 200);
		button5 = new JButton("button5");
		button5.setSize(200, 200);
	}

	private void setInitLayout() {
		setLayout(null);
		button1.setLocation(300, 300);
		add(button1);
		button2.setLocation(200, 200);
		add(button2);
		button3.setLocation(100, 300);
		add(button3);
		button4.setLocation(100, 100);
		add(button4);
		button5.setLocation(300, 100);
		add(button5);

		setVisible(true);
	}

	public static void main(String[] args) {
		new NoLayoutEx2();

	} // end of main

} // end of class
