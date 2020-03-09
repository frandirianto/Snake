package after;
import java.util.ArrayList;

public class ThreadsController extends Thread {

	ArrayList<ArrayList<DataOfSquare>> squares= new ArrayList<ArrayList<DataOfSquare>>();
	Tuple headSnakePos;
	int sizeSnake;
	long speed;
	public static int directionSnake;

	ArrayList<Tuple> positions = new ArrayList<Tuple>();
	Tuple foodPosition;

	ThreadsController(Tuple positionDepart){
		squares = Window.grid;
		headSnakePos = new Tuple(positionDepart.getX(),positionDepart.getY());
		directionSnake = 1;

		Tuple headPosition = new Tuple(headSnakePos.getX(),headSnakePos.getY());
		positions.add(headPosition);

		foodPosition= new Tuple(Window.HEIGHT-1,Window.WIDTH-1);
		spawnFood(foodPosition);
	}

	private void spawnFood(Tuple foodPositionIn){
		squares.get(foodPositionIn.getX()).get(foodPositionIn.getY()).lightMeUp(1);
	}
	
	public void init(){
		sizeSnake = 3;
		speed = 50;
	}

	public void run() {
		init();
		while(true){
			moveInternal();
			checkCollision();
			moveExternal();
			deleteTail();
			speed();
		}
	}

	private void moveInternal(){
		if(directionSnake == 1) changeMove(Math.abs(headSnakePos.getX()+1)%20, headSnakePos.getY());
		else if(directionSnake == 2) {
			if(headSnakePos.getX()-1 < 0) changeMove(19, headSnakePos.getY());
			else changeMove(Math.abs(headSnakePos.getX()-1)%20, headSnakePos.getY());
		}
		else if(directionSnake == 3) {
			if(headSnakePos.getY()-1 < 0) changeMove(headSnakePos.getX(), 19);
			else changeMove(headSnakePos.getX(), Math.abs(headSnakePos.getY()-1)%20);
		}
		else if(directionSnake == 4) changeMove(headSnakePos.getX(), (headSnakePos.getY()+1)%20);
		
		positions.add(new Tuple(headSnakePos.getX(), headSnakePos.getY()));
	}

	private void changeMove(int x, int y) {
		headSnakePos.changeData(x, y);
	}
	
	private void moveExternal(){
		for(Tuple t : positions){
			int y = t.getX();
			int x = t.getY();
			squares.get(x).get(y).lightMeUp(0);
		}
	}
	
	private void speed(){
		try {
			sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkCollision() {
		Tuple posCritique = positions.get(positions.size()-1);
		for(int i = 0; i<=positions.size()-2 ; i++){
			bitSelf(posCritique, i);
		}
		eatFood(posCritique);
	}

	private void bitSelf(Tuple posCritique, int index) {
		Tuple position = positions.get(index);
		if(posCritique.getX() == position.getX() && posCritique.getY() == position.getY()){
			stopTheGame();
		}
	}

	private void eatFood(Tuple posCritique) {
		if(posCritique.getX() == foodPosition.getY() && posCritique.getY() == foodPosition.getX()){
			System.out.println("Yummy!");
			sizeSnake += 1;
			foodPosition = getValAleaNotInSnake();
			spawnFood(foodPosition);	
		}
	}

	private void stopTheGame(){
		System.out.println("COLISION! \n");
		while(true){
			speed();
		}
	}

	private Tuple getValAleaNotInSnake(){
		Tuple position = randomTuple();
		for(int i = 0;i<=positions.size()-1;i++){
			if(position.getY()==positions.get(i).getX() && position.getX()==positions.get(i).getY()){
				position = randomTuple();
				i=0;
			}
		}
		return position;
	}

	private Tuple randomTuple() {
		int ranX = (int) (Math.random()*19); 
		int ranY = (int) (Math.random()*19);
		return new Tuple(ranX , ranY);
	}

	private void deleteTail(){
		int size = sizeSnake;
		for(int i = positions.size()-1; i>=0 ;i--){
			if(size == 0){
				Tuple position = positions.get(i);
				squares.get(position.getY()).get(position.getX()).lightMeUp(2);
			}
			else size--;
		}
		size = sizeSnake;
		for(int i = positions.size()-1 ; i >= 0 ;i--){
			if(size == 0) positions.remove(i);
			else size--;
		}
	}
}
