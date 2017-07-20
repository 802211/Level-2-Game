import java.awt.Color;
import java.awt.Graphics;

public class TheCat extends CatGameObject{
	
		int speed;	
		boolean up;
		boolean down;
		
	TheCat(int x, int y, int width, int height){
		super(x, y, width, height);
		speed = 5;
		
	}
	
//	TheCat cat = new TheCat(); 
	
	
	
	void update(){
		if (up) {
			y = y - speed;
		}
		if(y <= 0){
			y = 0;
		}
		if (down) {
			y = y + speed;
			System.out.println("down");
		}
		if(y >= 410){
			y = 410;
		}

	}
	 void draw(Graphics g){
		 g.setColor(Color.black);
		 g.fillRect(x, y ,width, height); 
	 }
}
