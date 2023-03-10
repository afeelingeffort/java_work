package ch01;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AirplaneFrame extends JFrame {

	private AirplaneFrame aContext = this;

	private JLabel backgroundMap;
	private AirplanePlayer player;
	private EnemyAirplane enemy;

	public AirplaneFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("images/background.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1000, 1000);

		player = new AirplanePlayer(aContext);
		enemy = new EnemyAirplane(aContext);
		
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		add(player);
		add(enemy);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
//					if (player.isLeft() == false && player.isLeftWallCrash() == false) {
					if (player.isLeft() == false) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (player.isRight() == false && player.isRightWallCrash() == false) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					player.down();
					break;
				case KeyEvent.VK_SPACE:
					player.attack();
					break;
				} // end of switch
			} // end of keyPressed

			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				}
			} // end of keyReleased
		});
	}

	public JLabel getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(JLabel backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public AirplanePlayer getPlayer() {
		return player;
	}

	public void setPlayer(AirplanePlayer player) {
		this.player = player;
	}

	public EnemyAirplane getEnemy() {
		return enemy;
	}

	public void setEnemy(EnemyAirplane enemy) {
		this.enemy = enemy;
	}

	public static void main(String[] args) {
		new AirplaneFrame();
	}
}