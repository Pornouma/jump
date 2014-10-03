import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Lake {
	public Image image;
	int x;
	int y;

	public Lake(int x, int y) throws SlickException {
		image = new Image("pic/lake.PNG");
		this.x = x;
		this.y = y;

	}
	
	public void draw(){
		image.draw(x,y);
	}

}
