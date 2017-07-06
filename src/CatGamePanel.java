import java.awt.Color;
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
	final int EXPLAIN1_STATE = 1;
	final int EXPLAIN2_STATE = 2;
	final int GAME_STATE = 3;
	final int END_STATE = 4;
	int currentState = MENU_STATE;
	public static BufferedImage CatImg;
	public static BufferedImage StartcatImg;
	public static BufferedImage Explain2Img;
	Timer t;
	// CatGameObject cgo;

	public void paintComponent(Graphics g) {

		if(currentState == MENU_STATE){
			drawMenuState(g);
		}
		else if(currentState == EXPLAIN1_STATE){
			drawExplainState1(g);
		}else if(currentState == EXPLAIN2_STATE){
			drawExplainState2(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}


	}
CatGamePanel() {

		t = new Timer(1000 / 60, this);
		try{
			CatImg = ImageIO.read(this.getClass().getResourceAsStream("cat.jpeg"));
			StartcatImg = ImageIO.read(this.getClass().getResourceAsStream("startcat.jpg"));
			Explain2Img = ImageIO.read(this.getClass().getResourceAsStream("Explain2.jpg"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		// cgo = new CatGameObject();

	}
	void updateMenuState(){
		
	}
	void updateExplainState1(){
		
	}
	void updateExplainState2(){
		
	}
	void updateGameState(){
		
	}
	void updateEndState(){
		
	}
	
	
	void drawMenuState(Graphics g){
		g.drawImage(StartcatImg, 0, 0, 800, 500, null);
	}
	void drawExplainState1(Graphics g){
			g.drawImage(CatImg, 0, 0, 800, 500, null);
	}
	void drawExplainState2(Graphics g){
		g.drawImage(Explain2Img, 0, 0, 800, 500, null);
	}
	void drawGameState(Graphics g){
	
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, 800, 500);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == EXPLAIN1_STATE){
			updateExplainState1();
			}
	else if(currentState == EXPLAIN2_STATE){
		updateExplainState2();
	}
		else if(currentState == GAME_STATE){
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = currentState + 1;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("This is keyReleased");
	}

}
