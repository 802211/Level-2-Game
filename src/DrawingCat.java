import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingCat {

	CatGamePanel cgp;
	
	DrawingCat(){
		f = new JFrame();
		cgp = new CatGamePanel();
		setup();
	}
	JFrame f;
	JPanel p;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	
	public static void main(String[] args) {
	DrawingCat dc = new DrawingCat();
	}
	
	
	void setup(){
		f.add(cgp);
		f.setVisible(true);
		 f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		cgp.startGame();
		f.addKeyListener(cgp);
		}
	
}
