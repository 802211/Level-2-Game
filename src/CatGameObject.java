import java.awt.Graphics;

public class CatGameObject {
	int x;
	int y;
	int width;
	int height;

	CatGameObject(){
		
	}
void update(){
	x = x + 5;
}

void draw(Graphics g){
	g.fillRect(x, y, 100, 100);
	 
}

}
