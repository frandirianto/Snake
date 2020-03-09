package after;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{

	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		choose(code);
	}
	
	private void choose(int code) {
		if(code == 39 && ThreadsController.directionSnake != 2) 
			ThreadsController.directionSnake = 1;

		else if(code == 38 && ThreadsController.directionSnake != 4) 
			ThreadsController.directionSnake = 3;

		else if(code == 37 && ThreadsController.directionSnake != 1) 
			ThreadsController.directionSnake = 2;

		else if(code == 40 && ThreadsController.directionSnake != 3) 
			ThreadsController.directionSnake = 4;
	}
}
