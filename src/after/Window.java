package after;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


class Window extends JFrame{
	
	private static final long serialVersionUID = -2542001418764869760L;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	public static ArrayList<ArrayList<DataOfSquare>> grid;
	private ArrayList<DataOfSquare> data;
	
	public Window(){
		grid = new ArrayList<ArrayList<DataOfSquare>>();
		init();
		draw();
		new Snake();
		this.addKeyListener((KeyListener) new KeyboardListener());
	}
	
	private void init() {
		for(int i=0;i<WIDTH;i++){
			data= new ArrayList<DataOfSquare>();
			for(int j=0;j<HEIGHT;j++){
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			grid.add(data);
		}
	}
	
	private void draw() {
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		for(int i=0;i<WIDTH;i++){
			for(int j=0;j<HEIGHT;j++){
				getContentPane().add(grid.get(i).get(j).square);
			}
		}
	}
}
