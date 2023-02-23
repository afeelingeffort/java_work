package ch01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//왜 중간에서 안 쏴지고 오른쪽으로 기울어있지 (사이즈 지정 의심)
public class PlayerBullet extends JLabel implements Moveable {

	private AirplaneFrame aContext;
	private BackgroundBulletService backgroundbulletService;

	int bulletX;
	int bulletY;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	// 적군을 맞췄을 때 : 0, 적을 가두고 터질 때
	private int alive;

	private ImageIcon bullet;
	private ImageIcon bulletBomb;

	public PlayerBullet(AirplaneFrame aContext) {
		this.aContext = aContext;

		initData();
		setInitLayout();
		backgroundbulletService = new BackgroundBulletService(this);
		initThread();
	}

	private void initData() {
		bullet = new ImageIcon("images/bullet.png");
		bulletBomb = new ImageIcon("images/bulletBomb.png");

		left = false;
		right = false;
		up = false;
		down = false;
		alive = 0;

	}

	private void setInitLayout() {
		bulletX = aContext.getPlayer().getX();
		bulletY = aContext.getPlayer().getY();

		setIcon(bullet);
		setSize(140, 100);
		setLocation(bulletX, bulletY);
	}

	private void initThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				up();
			}
		}).start();
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub

	}

	@Override
	public void right() {
		// TODO Auto-generated method stub

	}

	@Override
	public void up() {
		up = true;

		while (true) {
			bulletY--;
			setLocation(bulletX, bulletY);

			if(backgroundbulletService.leftWall()) {
				
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void crash() {
		aContext.getEnemy().setAlive(1);
		alive = 1;
		setIcon(bulletBomb);

		// heap 메모리에서는 아직 남아있다. (가비지 컬렉터가 알아서 제거해줌)
		aContext.remove(aContext.getEnemy());

		aContext.repaint();
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

	}

	public int getBulletX() {
		return bulletX;
	}

	public void setBulletX(int bulletX) {
		this.bulletX = bulletX;
	}

	public int getBulletY() {
		return bulletY;
	}

	public void setBulletY(int bulletY) {
		this.bulletY = bulletY;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isUpWallCrash() {
		return upWallCrash;
	}

	public void setUpWallCrash(boolean upWallCrash) {
		this.upWallCrash = upWallCrash;
	}

	public boolean isDownWallCrash() {
		return downWallCrash;
	}

	public void setDownWallCrash(boolean downWallCrash) {
		this.downWallCrash = downWallCrash;
	}

	public int getAlive() {
		return alive;
	}

	public void setAlive(int alive) {
		this.alive = alive;
	}

	public ImageIcon getBullet() {
		return bullet;
	}

	public void setBullet(ImageIcon bullet) {
		this.bullet = bullet;
	}

	public ImageIcon getBulletBomb() {
		return bulletBomb;
	}

	public void setBulletBomb(ImageIcon bulletBomb) {
		this.bulletBomb = bulletBomb;
	}

}