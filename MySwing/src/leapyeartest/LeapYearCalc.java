package leapyeartest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LeapYearCalc extends JFrame implements ActionListener{

	JButton button;

	public LeapYearCalc() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("윤년 계산기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton();
	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
