import java.awt.Graphics;

public class Ghosts extends CatGameObject {

	Ghosts(int Gx, int Gy, int Gw, int Gh) {
		super(Gx, Gy, Gw, Gh);
	}

	void update() {
		x = x - 2;
	}

	void draw(Graphics g) {
		g.drawImage(CatGamePanel.GhostImg, x, y, width, height, null);
	}

}
