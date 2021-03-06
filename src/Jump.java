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
	private int x = 50;
	private int y = 40;
	private Log[][] logs;
	private int v = 3;
	private boolean underWater;
	private boolean isOnLog;
	private Bgdoor bgdoor;
	private boolean indoor;

	public Jump(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		bgdoor.draw();
		for (Door door : doors) {
			door.draw();
		}
		// door.draw();
		lake.draw();
		ground.draw();

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				logs[y][x].draw();

			}
		}
		rabbit.draw();

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		doors = new Door[3];
		for (int i = 0; i < 3; i++) {
			doors[i] = new Door(x, y);
			x += 150;
		}
		lake = new Lake(0, 160);
		ground = new Ground(0, 380);

		logs = new Log[3][3];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				logs[y][x] = new Log(235 * x, 170 + 70 * y, 2 * v);
			}
			v -= 1;
		}
		rabbit = new Rabbit(260, 360);
		bgdoor = new Bgdoor(1, 1);

	}

	@Override
	public void update(GameContainer containner, int arg1)
			throws SlickException {
		rabbitUpdate(containner);

		underWater = false;
		isOnLog = false;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				logs[y][x].update();
				if (Math.abs(rabbit.centerx - logs[y][x].centerx) < 92
						&& Math.abs(rabbit.centery - logs[y][x].centery) < 47) {
					isOnLog = true;
					rabbit.x += logs[y][x].v;
				} else if (Math.abs(rabbit.centerx - logs[y][x].centerx) >= 92
						&& Math.abs(rabbit.centery - logs[y][x].centery) < 47) {
					underWater = true;
				}
			}
		}
		if (underWater && !isOnLog) {
			rabbit.x = 260;
			rabbit.y = 360;
		}
		rabbit.update();

		/*
		 * for(int i=0;i<3;i++){ if(Math.abs(rabbit.centerx-door.centerx)< 113
		 * && Math.abs(rabbit.centery-door.centery)<81 ){ indoor = true; } }
		 */
	}

	private void rabbitUpdate(GameContainer containner) {
		Input input = containner.getInput();
		if (input.isKeyDown(Input.KEY_LEFT)) {
			rabbit.x -= 5;
			// rabbit.image.setRotation(270);

		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			rabbit.x += 5;
			// rabbit.image.setRotation(90);
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			rabbit.y -= 70;
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			rabbit.y += 70;
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
