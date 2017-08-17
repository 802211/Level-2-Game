import java.awt.Graphics;

public class Ghosts extends CatGameObject {
int speedofGhosts = 2;
	Ghosts(int Gx, int Gy, int Gw, int Gh) {
		super(Gx, Gy, Gw, Gh);
	}

	void update() {
		super.update();
		x = x - speedofGhosts;
	}

	void draw(Graphics g) {
		g.drawImage(CatGamePanel.GhostImg, x, y, width, height, null);
	}

}
