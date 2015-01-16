package scacchi;

import java.util.ArrayList;

public class Cavallo extends Pedina {

	public Cavallo(Colore colore) {
		super(Nome.CAVALLO, colore);
	}

	/*
	 * ritorna le posizioni posiibili del cavallo per la prossima mossa
	 * controlla le dimensioni della scacchiera ma non controlla le eventuali
	 * altre pedine
	 */
	@Override
	public ArrayList<Position> possibleMoves(Position posPedina) {
		//Position position=new Position(posPedina.getRiga(), posPedina.getColonna());
		ArrayList<Position> positions = new ArrayList<Position>();

		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() - 2));
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() - 2));
		positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() + 2));
		positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() + 2));

		positions.add(new Position(posPedina.getRiga() - 2, posPedina.getColonna() - 1));
		positions.add(new Position(posPedina.getRiga() - 2, posPedina.getColonna() + 1));
		positions.add(new Position(posPedina.getRiga() + 2, posPedina.getColonna() - 1));
		positions.add(new Position(posPedina.getRiga() + 2, posPedina.getColonna() + 1));

		// scorro l'array e cerco x o y che siano <0 || >8
		boolean b;
		do{
			b=false;
			for (int i=0;i<positions.size();i++) {
				Position pos=positions.get(i);
				if (pos.getRiga() <= 0 || pos.getColonna() <= 0 || pos.getRiga() > nRighe || pos.getColonna() > nColonne) {
					b=true;
					positions.remove(pos);
				}
			}
		}while(b);
		return positions;
	}
}
