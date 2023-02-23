package ch01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
적군이 폭발돼서 죽으면 아이템을 랜덤으로 
패스트 아이템은 2분의 1 확률로
목숨 아이템은 5분의 1 확률로 뿌리기
*/

public class Item extends JLabel implements Moveable {

	private AirplaneFrame aContext;
	private BackgroundItemService backgroundItemService;
	EnemyAirplane enemyAirplane = new EnemyAirplane(aContext);
	
	int itemX;
	int itemY;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	// 적군이 살아있는 상태 : 0, 죽었을 때 : 1
	private int status;

	private ImageIcon fastIcon;

	public Item(AirplaneFrame aContext) {
		this.aContext = aContext;

		initData();
		getInitLayout();
		// 만들면 생성하기
//		BackgroundItemService = new BackgroundItemService(this);
		initThread();
	}

	private void initData() {
		fastIcon = new ImageIcon("images/fastIcon");
	}

	private void getInitLayout() {
		itemX = aContext.getEnemy().getX();
		itemY = aContext.getEnemy().getY();

		setIcon(fastIcon);
		setSize(30, 30);
	}

	private void initThread() {

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
		// TODO Auto-generated method stub

	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

	}

	public int getItemX() {
		return itemX;
	}

	public void setItemX(int itemX) {
		this.itemX = itemX;
	}

	public int getItemY() {
		return itemY;
	}

	public void setItemY(int itemY) {
		this.itemY = itemY;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ImageIcon getFastIcon() {
		return fastIcon;
	}

	public void setFastIcon(ImageIcon fastIcon) {
		this.fastIcon = fastIcon;
	}

}