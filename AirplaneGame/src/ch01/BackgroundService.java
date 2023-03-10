package ch01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundService implements Runnable {

	private BufferedImage image;
	private AirplanePlayer player;

	public BackgroundService(AirplanePlayer player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("images/backgroundService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX() +50, player.getY()));
			Color rightColor = new Color(image.getRGB(player.getX() + 40, player.getY()));
			Color bottomColor = new Color(image.getRGB(player.getX() - 20, player.getY() + 60));
			Color highColor = new Color(image.getRGB(player.getX() + 40, player.getY() + 10));

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽");
				player.setLeft(false);
				player.setLeftWallCrash(true);

			} else if ((rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0)) {
				System.out.println("오른쪽 벽");
				player.setRight(false);
				player.setRightWallCrash(true);

			} else if (highColor.getRed() == 255 && highColor.getGreen() == 0 && highColor.getBlue() == 0) {
				System.out.println("위쪽 벽");
				player.setUp(false);
				player.setUpWallCrash(true);

			} else if (bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 && bottomColor.getBlue() == 0) {
				System.out.println("아래쪽 벽");
				player.setDown(false);
				player.setDownWallCrash(true);

			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
				player.setUpWallCrash(false);
				player.setDownWallCrash(false);

			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}