package scacchi;

import java.util.ArrayList;

public abstract class Pedina {
	String name;
	int color; //1-2
	int c;
	public abstract ArrayList<Position> possibleMoves(Position position);
	
}
