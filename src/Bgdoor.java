import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Bgdoor {
	private Image image;
	public int x;
	public int y;
	
	public Bgdoor(int x,int y)throws SlickException{
		image = new Image("pic/bgdoor.jpg");
		this.x=x;
		this.y=y;
		
		
	}
	public void draw(){
		image.draw(x,y);
	}

}
