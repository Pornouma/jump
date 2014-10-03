import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ground {
	public Image image;
	public int x;
	public int y;

	public Ground(int x, int y) throws SlickException {
		image = new Image("pic/ground2.png");
		this.x = x;
		this.y = y;

	}
	public void draw(){
		image.draw(x,y);
	}


}
