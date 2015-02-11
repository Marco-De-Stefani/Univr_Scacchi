package scacchi;

import java.util.ArrayList;

public class Re extends Pedina{

	public Re(Colore colore) {
		super(Nome.RE, colore);
		
	}

	@Override
	public ArrayList<Position> possibleMoves(Position posPedina) {
		//Position position = new Position(riga, colonna);
		ArrayList<Position> positions = new ArrayList<Position>();
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna())); 		// avanti o indietro
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna())); 		// avanti o indietro
		
		positions.add(new Position(posPedina.getRiga(), posPedina.getColonna() + 1)); 		//dx o sx
		positions.add(new Position(posPedina.getRiga(), posPedina.getColonna() - 1));		//dx o sx
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() + 1));	// diagonale dx o alto o basso
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() + 1));	// diagonale dx o alto o basso
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() - 1));	// diagonale sx o alto o basso
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() - 1));	// diagonale sx o alto o basso
		
		boolean b;
		do{
			b = false;
			for (int i = 0; i < positions.size(); i++) {
				Position pos=positions.get(i);
				if (pos.getRiga() <= 0 || pos.getColonna() <= 0 || pos.getRiga() > nRighe || pos.getColonna() > nColonne) {
					b = true;
					positions.remove(pos);
				}
			}
		}while(b);
		
		return positions;
		
	}
	
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera) {
		//Position position = new Position(riga, colonna);
		ArrayList<Position> positions = new ArrayList<Position>();
		int[][] mosse = new int[8][8];
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna())); 		// avanti o indietro
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna())); 		// avanti o indietro
		
		positions.add(new Position(posPedina.getRiga(), posPedina.getColonna() + 1)); 		//dx o sx
		positions.add(new Position(posPedina.getRiga(), posPedina.getColonna() - 1));		//dx o sx
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() + 1));	// diagonale dx o alto o basso
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() + 1));	// diagonale dx o alto o basso
		
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() - 1));	// diagonale sx o alto o basso
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() - 1));	// diagonale sx o alto o basso
		

		boolean modif;
		do{
			modif = false;
			for (int i = 0; i < positions.size(); i++) {
			Position pos=positions.get(i);
				if (pos.getRiga() < 0 || pos.getColonna() < 0 || pos.getRiga() >= nRighe || pos.getColonna() >= nColonne) {
					modif = true;
					positions.remove(pos);
				}
			}
		}while(modif);
		
		for(Position p : positions)
			if(scacchiera[p.getRiga()][p.getColonna()] == null){
				mosse[p.getRiga()][p.getColonna()] = 1;
			}else{
				if(scacchiera[p.getRiga()][p.getColonna()].getColore() != this.getColore())
					mosse[p.getRiga()][p.getColonna()] = 2;
			}

		return mosse;
		
	}

}