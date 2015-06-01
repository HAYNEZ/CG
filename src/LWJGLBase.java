import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
 
public abstract class LWJGLBase {
	
	protected int width = 800;
	protected int height = 600;
	protected long lastFrame;
	protected int xPosition= 400;
	protected int yPosition = 300;
	
	
	
	
	
	
	public long getTime(){
		return(Sys.getTime()*1000) / Sys.getTimerResolution();
	}
	
	
	
	public int getDelta(){
		long time = getTime();
		int delta = (int) (time- lastFrame);
		lastFrame = time;
		return delta;
	}
	
	
	public void update(int delta) {
	if(Keyboard.isKeyDown(Keyboard.KEY_UP)) yPosition += 0.35 * delta;
	if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) yPosition -= 0.35 * delta;
	if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) xPosition += 0.35 * delta;
	if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) xPosition -= 0.35 * delta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void start(){
	
	try {
		Display.setDisplayMode(new DisplayMode(800,600));
		Display.create();
	} catch (LWJGLException e) {
		e.printStackTrace();
		System.exit(0);
		
	
	}
	
	initOpenGL();
	
	
while (!Display.isCloseRequested()) {
	
	int delta = getDelta();
	update(delta);
	
	render();
	
	
	
	Display.update();
	Display.sync(60);
}
Display.destroy();
	}
	
	
	
	
	
	protected abstract void initOpenGL();
	protected abstract void render();
	
	
	
}