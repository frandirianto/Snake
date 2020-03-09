package after;

import java.awt.event.KeyListener;

public class Snake {

	public Snake() {
		Tuple position = new Tuple(10,10);
		ThreadsController control = new ThreadsController(position);
		control.start();
	}

}
