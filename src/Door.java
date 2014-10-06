import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Door {
	public Image image;
	public int x;
	public int y;
	public int weigthdoor = 200;
	public int centerx;
	public int centery;

	public Door(int x, int y) throws SlickException {
		image = new Image("pic/door.png");
		this.x = x;
		this.y = y;

	}

	public void draw() {
		image.draw(x, y);

	}

	public void update() {

		centerx = x+88;
		centery = y+51;
	}

}
