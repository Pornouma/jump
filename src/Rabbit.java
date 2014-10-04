import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rabbit {
	public Image image;
	public int x;
	public int y;

	public Rabbit(int x, int y) throws SlickException {

		image = new Image("pic/rabbit.png");
		this.x = x;
		
		this.y = y;

	}

	public void draw() {
		image.draw(x, y);
	}
	public void update(){
		if(x>600){
			x=0;
		}
	}

}
