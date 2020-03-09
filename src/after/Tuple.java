package after;

public class Tuple { 

	private int x; 
	private int y; 
	private int xf;
	private int yf;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

	public void setYf(int yf) {
		this.yf = yf;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getXf(){
		return xf;
	}
	
	public int getYf(){
		return yf;
	}

	public Tuple(int x, int y) { 
		this.x = x; 
		this.y = y; 
	} 
	
	public void changeData(int x, int y){
		this.x = x; 
		this.y = y; 
	}

} 