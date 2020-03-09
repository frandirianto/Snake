package after;
import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {
	
	private ArrayList<Color> listColor;
	public SquarePanel square;
	
	public DataOfSquare(int color){
		listColor = new ArrayList<Color>();
		listColor.add(Color.darkGray);
		listColor.add(Color.BLUE);    
		listColor.add(Color.white);  
		square = new SquarePanel(listColor.get(color));
	}
	
	public void lightMeUp(int c){
		square.changeColor(listColor.get(c));
	}
}
