package ch01;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//플레이어 체력과 적군 체력 구현은 어떻게 할 것인가?
//적군은 몇 개 배치할 것인가?
public class EnemyAirplane extends JLabel implements Moveable {

	private AirplaneFrame aContext;

	// 프레임 사이즈
	final int FRAME_SIZE_X = 950;
	final int FRAME_SIZE_Y = 950;

	// 생존 여부 (살아 있음 : 0, 죽음 : 1)
	private int alive;

	// 위치 상태
	private int x;
	private int y;

	// 적군의 방향
	private EnemyWay enemyWay;

	// 움직임 상태 (우선 좌우만 구현 // 움직이지 않음 : false)
	private boolean left;
	private boolean right;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 적군 속도 상태
	private final int SPEED = 3;

	// 이미지
	private ImageIcon enemyImage;

	// 생성자
	public EnemyAirplane(AirplaneFrame aContext) {
		this.aContext = aContext;

		initData();
		setInitLayout();

		// 적군의 방향 결정 + 이동 메서드 호출
		enemyDirection();

	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// 생성자 메서드 1
	private void initData() {
		enemyImage = new ImageIcon("images/enemy.png");
		// 초기 x 위치는 랜덤
		double randomX = Math.random(); // 0~1 범위의 소수 난수 생성
		x = (int) ((FRAME_SIZE_X - 200) * randomX);

		// 초기 y 위치는 일단 고정 (임시)
		y = 80;

		// 초기 값 세팅 (기본값이라서 생략 가능)
		left = false;
		right = false;
		alive = 0; // 살아 있음
	}

	// 생성자 메서드 2
	private void setInitLayout() {
		setSize(150, 150); // 임시 크기
		setLocation(x, y);
		setIcon(enemyImage);

	}

//	 생성자 메서드 3
	private void enemyDirection() {
		Random random = new Random();

		new Thread(() -> {
			// enemy가 살아있는 동안
			while (alive == 0) {

				// 이동 방향을 랜덤으로 선택함
				int randomDirection = random.nextInt(2); // 0 또는 1 생성

				// 이동 메서드 안에 적군이 죽으면 중간에 중단하라는 if 문이 있어서
				// 죽으면 left(), right() 메서드를 빠져나간 뒤 반복이 종료됨

				// 값이 0인 경우 왼쪽으로
				if (randomDirection == 0) {
					// 왼쪽 벽에 부딪친 상태면 left() 실행 X
					if (leftWallCrash == true) {
						continue;
					}
					enemyWay = EnemyWay.LEFT;
					left();

					// 값이 1인 경우 오른쪽으로
				} else {
					// 오른쪽 벽에 부딪친 상태면 right() 실행 X
					if (rightWallCrash == true) {
						continue;
					}
					enemyWay = EnemyWay.RIGHT;
					right();
				}

				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} // end of while

		}).start();

	}

	// 이동 메서드

	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;

		// 적군의 현재 x 좌표 저장
		int currentX = this.getX();

		// 최대 이동 거리 (여유 50)
		int tempX = currentX - 50;

		// 이동할 거리
		int goX = (int) (currentX * Math.random());

		new Thread(() -> {
			left = true;
			for (int i = 0; i < (goX / SPEED); i++) {
				// 적군이 죽었거나, 왼쪽 벽에 부딪치면 중단
				if (alive == 1 || left == false) {
					return;
				}
				x = x - SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		left = false;
	} // end of left

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;

		int currentX = this.getX();

		// 최대 이동 거리 (200 = 아이콘 크기 + 여유 50)
		int tempX = (FRAME_SIZE_X - 200) - currentX;

		// 이동할 거리
		int goX = (int) (tempX * Math.random());

		new Thread(() -> {
			right = true;
			for (int i = 0; i < (goX / SPEED); i++) {
				// 적군이 죽었거나, 오른쪽 벽에 부딪치면 중단
				if (alive == 1 || right == false) {
					return;
				}
				x = x + SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		right = false;
	} // end of right

	// 나중에
	@Override
	public void up() {

	}

	// 나중에
	@Override
	public void down() {

	}

}
