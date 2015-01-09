package scacchi;

import java.util.ArrayList;

public class Re extends Pedina{

	public Re(Nome nome, Colore colore) {
		super(nome, colore);
		
	}

	@Override
	public ArrayList<Position> possibleMoves(int riga, int colonna) {
		Position position = new Position(riga, colonna);
		ArrayList<Position> positions = new ArrayList<Position>();
		
		positions.add(new Position(position.x, position.y + 1)); 		// avanti o indietro
		positions.add(new Position(position.x, position.y - 1)); 		// avanti o indietro
		
		positions.add(new Position(position.x + 1, position.y)); 		//dx o sx
		positions.add(new Position(position.x - 1, position.y));		//dx o sx
		
		positions.add(new Position(position.x + 1, position.y + 1));	// diagonale dx o alto o basso
		positions.add(new Position(position.x + 1, position.y - 1));	// diagonale dx o alto o basso
		
		positions.add(new Position(position.x - 1, position.y + 1));	// diagonale sx o alto o basso
		positions.add(new Position(position.x - 1, position.y - 1));	// diagonale sx o alto o basso
		
		boolean b;
		do{
			b = false;
			for (int i = 0; i < positions.size(); i++) {
				Position pos=positions.get(i);
				if (pos.x <= 0 || pos.y <= 0 || pos.x > nRows || pos.y > nColumns) {
					b = true;
					positions.remove(pos);
				}
			}
		}while(b);
		
		return positions;
		
	}

}
