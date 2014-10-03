import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Jump extends BasicGame {

	private Rabbit rabbit;
	private Ground ground;
	private Lake lake;
	private Door[] doors;
	private Door door;
	private int x=50;
	private int y=40;

	public Jump(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		for(Door door:doors)
		{
			door.draw();
		}
		//door.draw();
		lake.draw();
		ground.draw();
		rabbit.draw();

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		doors = new Door[3];
		for(int i = 0 ; i < 3 ; i++)
		{
			doors[i] = new Door(x,y);
			x+=200;
		}
		lake = new Lake(0, 160);
		ground = new Ground(0, 380);
		rabbit = new Rabbit(260, 300);

	}

	@Override
	public void update(GameContainer containner, int arg1)
			throws SlickException {
		Input input = containner.getInput();
		if (input.isKeyDown(Input.KEY_LEFT)) {
			rabbit.x -= 5;
			rabbit.image.setRotation(90);

		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			rabbit.x += 5;
			rabbit.image.setRotation(180);
		}

	}

	public static void main(String[] args) {
		try {
			Jump game = new Jump("Game");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(600, 500, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
