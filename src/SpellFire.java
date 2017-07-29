import java.awt.Graphics;

public class SpellFire extends CatGameObject {

	int speed;
	boolean space;
	/*
	 * int SFx; int SFy; int SFw; int SFh;
	 */

	SpellFire(int SFx, int SFy, int SFw, int SFh) {
		super(SFx, SFy, SFw, SFh);
		speed = 7;

	}

	void update() {
		if (space) {
			x = x + speed;
		}
	}

	void draw(Graphics g) {
		g.drawImage(CatGamePanel.StarImg, x, y, width, height, null);
	}

}
