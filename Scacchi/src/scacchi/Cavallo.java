package scacchi;

import java.util.ArrayList;

public class Cavallo extends Pedina {

	/**
	 * 
	 * Costruttore della classe Cavallo
	 * 
	 * @param colore
	 */
	public Cavallo(Colore colore) {
		super(Nome.CAVALLO, colore);
	}

	/**
	 * 
	 * @param posPedina
	 * @param scacchiera
	 * @return le mosse possibili del Cavallo per la prossima mossa ricordando
	 *         che si muove solo a L. Inoltre controlla in base alla posizione
	 *         in cui si trova guarda che le mosse rimagano dentro la scacchiera
	 */
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera) {

		ArrayList<Position> positions = new ArrayList<Position>();
		int[][] mosse = new int[8][8];

		positions.add(new Position(posPedina.getRiga() - 1, posPedina
				.getColonna() - 2));
		positions.add(new Position(posPedina.getRiga() + 1, posPedina
				.getColonna() - 2));
		positions.add(new Position(posPedina.getRiga() - 1, posPedina
				.getColonna() + 2));
		positions.add(new Position(posPedina.getRiga() + 1, posPedina
				.getColonna() + 2));

		positions.add(new Position(posPedina.getRiga() - 2, posPedina
				.getColonna() - 1));
		positions.add(new Position(posPedina.getRiga() - 2, posPedina
				.getColonna() + 1));
		positions.add(new Position(posPedina.getRiga() + 2, posPedina
				.getColonna() - 1));
		positions.add(new Position(posPedina.getRiga() + 2, posPedina
				.getColonna() + 1));

		// scorro l'array e cerco x o y che siano <0 || >8
		boolean controllo;
		do {
			controllo = false;
			for (int i = 0; i < positions.size(); i++) {
				Position pos = positions.get(i);
				if (pos.getRiga() < 0 || pos.getColonna() < 0
						|| pos.getRiga() >= nRighe
						|| pos.getColonna() >= nColonne) {
					controllo = true;
					positions.remove(pos); // punti ok dentro il range della
											// scacchiera
				}
			}
		} while (controllo);

		for (Position p : positions)
			if (scacchiera[p.getRiga()][p.getColonna()] == null)
				mosse[p.getRiga()][p.getColonna()] = 1;
			else {
				if (scacchiera[p.getRiga()][p.getColonna()].getColore() != this
						.getColore())
					mosse[p.getRiga()][p.getColonna()] = 2;
			}

		return mosse;
	}

}