package scacchi;

import java.util.ArrayList;

public class Cavallo extends Pedina {

	/*
	 * ritorna le posizioni posiibili del cavallo per la prossima mossa
	 * controlla le dimensioni della scacchiera ma non controlla le eventuali
	 * altre pedine
	 */
	@Override
	public ArrayList<Position> possibleMoves(Position position) {
		ArrayList<Position> positions = new ArrayList<Position>();

		positions.add(new Position(position.x - 1, position.y - 2));
		positions.add(new Position(position.x + 1, position.y - 2));
		positions.add(new Position(position.x - 1, position.y + 2));
		positions.add(new Position(position.x + 1, position.y + 2));

		positions.add(new Position(position.x - 2, position.y - 1));
		positions.add(new Position(position.x - 2, position.y + 1));
		positions.add(new Position(position.x + 2, position.y - 1));
		positions.add(new Position(position.x + 2, position.y + 1));

		// scorro l'array e cerco x o y che siano <0 || >8
		boolean b;
		do{
			b=false;
			for (int i=0;i<positions.size();i++) {
				Position pos=positions.get(i);
				if (pos.x <= 0 || pos.y <= 0 || pos.x > 8 || pos.y > 8) {
					b=true;
					positions.remove(pos);
				}
			}
		}while(b);
		return positions;
	}
}
