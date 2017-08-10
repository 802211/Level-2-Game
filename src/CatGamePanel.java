import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CatGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int EXPLAIN1_STATE = 1;
	final int EXPLAIN2_STATE = 2;
	final int DRAWINSTRUCTIONS_STATE = 3;
	final int GAME_STATE = 4;
	final int END_STATE = 5;
	int currentState = MENU_STATE;
	public static BufferedImage CatImg;
	public static BufferedImage StartcatImg;
	public static BufferedImage Explain2Img;
	// public static BufferedImage DrawInstructionsImg;
	public static BufferedImage GameBackgroundImg;
	public static BufferedImage OnlyCatImg;
	public static BufferedImage StarImg;
	public static BufferedImage GhostImg;
	Timer t;
	Boolean lost = true;
	String result;
	Font youlost;
	Font score;
	Font instructions;
	Font words;
	Font small;
	ObjectManager om = new ObjectManager();
	TheCat cat = new TheCat(100, 150, 80, 110);
	SpellFire sf;
	// CatGameObject cgo;

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == EXPLAIN1_STATE) {
			drawExplainState1(g);
		} else if (currentState == EXPLAIN2_STATE) {
			drawExplainState2(g);
		}

		else if (currentState == DRAWINSTRUCTIONS_STATE) {
			drawInstructionsState(g);
		}

		else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	CatGamePanel() {

		t = new Timer(1000 / 60, this);
		try {
			CatImg = ImageIO.read(this.getClass().getResourceAsStream("cat.jpg"));
			StartcatImg = ImageIO.read(this.getClass().getResourceAsStream("startcat.jpg"));
			Explain2Img = ImageIO.read(this.getClass().getResourceAsStream("Explain2.jpg"));
			// DrawInstructionsImg =
			// ImageIO.read(this.getClass().getResourceAsStream("drawInstructions.png"));
			GameBackgroundImg = ImageIO.read(this.getClass().getResourceAsStream("game background.png"));
			OnlyCatImg = ImageIO.read(this.getClass().getResourceAsStream("OnlyCat.Png"));
			StarImg = ImageIO.read(this.getClass().getResourceAsStream("Star.png"));
			GhostImg = ImageIO.read(this.getClass().getResourceAsStream("Ghost.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// cgo = new CatGameObject();
		youlost = new Font("Ariel", Font.BOLD, 100);
		score = new Font("Ariel", Font.PLAIN, 75);
		instructions = new Font("Merienda", Font.BOLD, 80);
		words = new Font("TimesNewRoman", Font.PLAIN, 50);
		small = new Font("TimesNewRoman", Font.PLAIN, 40);
		om.addObject(cat);

	}

	void updateMenuState() {

	}

	void updateExplainState1() {

	}

	void updateExplainState2() {

	}

	void updateDrawInstructionsState() {

	}

	void updateGameState() {
		if (om.getScore() >= 1) {
			lost = false;
			result = "YOU WON";
		} else if (om.getScore() < 1) {
			lost = true;
			result = "YOU LOST";
		}
		cat.update();
		om.update();
		om.manageEnemies();
		om.checkCollision();
		if (cat.isAlive == false) {
			currentState = END_STATE;
			// om.getScore();
			om.reset();
			cat = new TheCat(100, 150, 80, 110);
			om.addObject(this.cat = cat);
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.drawImage(StartcatImg, 0, 0, 800, 500, null);
	}

	void drawExplainState1(Graphics g) {
		g.drawImage(CatImg, 0, 0, 800, 500, null);
	}

	void drawExplainState2(Graphics g) {
		g.drawImage(Explain2Img, 0, 0, 800, 500, null);
	}

	void drawInstructionsState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 800, 500);
		g.setColor(Color.MAGENTA);
		g.setFont(instructions);
		g.drawString("Instructions", 133, 90);
		g.setColor(Color.cyan);
		g.setFont(words);
		g.drawString("Press Space to Fire", 150, 150);
		g.setColor(Color.ORANGE);
		g.setFont(words);
		g.drawString("Fire at the Ghosts", 175, 200);
		g.setColor(Color.BLACK);
		g.setFont(small);
		g.drawString("Don't Let the Ghosts Touch the Cat", 70, 250);
		g.setColor(Color.GREEN);
		g.setFont(small);
		g.drawString("Use the Arrow Keys to Move the Cat", 65, 300);
		g.setColor(Color.yellow);
		g.setFont(words);
		g.drawString("Good Luck!", 200, 350);
		g.setColor(Color.RED);
		g.setFont(words);
		g.drawString("Press ENTER to Play", 130, 400);
	}

	void drawGameState(Graphics g) {
		g.drawImage(GameBackgroundImg, 0, 0, 800, 500, null);
		om.draw(g);
		// g.drawImage(OnlyCatImg, 100, 150, 80, 110, null);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 800, 500);
		g.setColor(Color.BLACK);
		g.setFont(youlost);
		g.drawString(result, 133, 100);
		g.setColor(Color.CYAN);
		g.setFont(score);
		g.drawString("Score = " + om.getScore(), 150, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == EXPLAIN1_STATE) {
			updateExplainState1();
		} else if (currentState == EXPLAIN2_STATE) {
			updateExplainState2();
		}
		/*
		 * else if (currentState == DRAWINSTRUCTIONS_STATE) {
		 * updateDrawInstructionsState(); }
		 */
		else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		t.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("This is keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("This is keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = currentState + 1;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			cat.up = true;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cat.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cat.left = true;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cat.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			sf = new SpellFire(cat.x + 63, cat.y + 25, 20, 20);
			om.addObject(sf);
			sf.space = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("This is keyReleased");

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			cat.up = false;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cat.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cat.left = false;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cat.right = false;
		}
	}

}
