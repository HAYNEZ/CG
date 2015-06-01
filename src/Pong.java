import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
public class Pong extends LWJGLBase {

	
	
	
	
	
	public static void main(String [] args){
		new Pong().start();
	}



	private long lastFrame;
	
	protected void initOpenGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, 0, height, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	
	private void drawRect(int xs, int xe, int ys, int ye){
		
		GL11.glColor3f(0.5f, 0.5f, 1.0f);
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(xs, ys);
		GL11.glVertex2f(xs, ye);
		GL11.glVertex2f(xe, ye);
		GL11.glVertex2f(xe, ys);
		GL11.glEnd();
	}
	
	
	
	
	
	
	

	
	
	
	protected void render() {
		int xPlayerPos = 400;
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glColor3f(1, 0.5f, 0);
		drawRect(xPosition,xPosition+50,yPosition,yPosition+50);
		
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Display.destroy();	
		
		
		
		
	}

}
