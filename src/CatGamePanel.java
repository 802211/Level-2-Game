import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CatGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	public static BufferedImage CatImg;
	Timer t;
	// CatGameObject cgo;

	public void paintComponent(Graphics g) {

		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}


	}

	void updateMenuState(){
		
	}
	void updateGameState(){
		
	}
	void updateEndState(){
		
	}
	
	
	void drawMenuState(Graphics g){
		
	}
	void drawGameState(Graphics g){
		g.drawImage(CatImg, 0, 0, 800, 500, null);
	}
	void drawEndState(Graphics g){
		
	}
	
	CatGamePanel() {

		t = new Timer(1000 / 60, this);
		try{
			CatImg = ImageIO.read(this.getClass().getResourceAsStream("cat.jpeg"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		// cgo = new CatGameObject();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
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
		drawGameState(g);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("This is keyReleased");
	}

}
