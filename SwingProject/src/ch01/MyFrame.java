package ch01;

import javax.swing.JFrame;

//상속 JFrame <-- 자바 개발자들이 만들어 준 클래스
public class MyFrame extends JFrame {

	JFrame jf = new JFrame("Title");

	public MyFrame() {
		super.setTitle("Title");
	}
}
