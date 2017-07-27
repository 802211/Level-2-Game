import java.awt.Color;
import java.awt.Graphics;

public class TheCat extends CatGameObject {

	int speed;
	boolean up;
	boolean down;
	boolean right;
	boolean left;

	TheCat(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 3;

	}

	// TheCat cat = new TheCat();

	void update() {
		if (up) {
			y = y - speed;
		}
		if (y <= 0) {
			y = 0;
		}
		if(x <= 0){
			x = 0;
		}
		if (left) {
			x = x - speed;
		}
		if (down) {
			y = y + speed;
			System.out.println("down");
		}
		if (y >= 370) {
			y = 370;
		}
		if(x >= 715){
			x = 715;
		}
		if (right) {
			x = x + speed;
		}
	}

	void draw(Graphics g) {
		g.drawImage(CatGamePanel.OnlyCatImg, x, y, width, height, null);
	}
}
