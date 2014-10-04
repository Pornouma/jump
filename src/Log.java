import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Log {
	private Image image;
	public int x;
	public int y;
	public int centerx;
	public int centery;
	public int v; 
	public Log(int x,int y,int v) throws SlickException{
		image =new Image("pic/log.png");
		this.x=x;
		this.y=y;
		this.v=v;
	}
	 public void update(){
		 this.x += v;
		 if(x>600){
			 x=-150; 
		 }
		 centerx = x+62;
		 centery = y+17;
		 
	 }
	
	public void draw(){
		image.draw(x,y);
	}
	

}
