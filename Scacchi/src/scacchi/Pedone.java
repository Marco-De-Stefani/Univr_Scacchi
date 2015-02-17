package scacchi;

import java.util.ArrayList;

public class Pedone extends Pedina {

	public Pedone(Colore colore) {
		super(Nome.PEDONE, colore);
	}

	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera) {
		int[][] mosse = new int[8][8];

		if (this.getColore() == Colore.NERO) {

			// -normale mossa del pedone.
			// se non vado fuori dalla scacchiera con le righe &&
			// davanti al pedone non ci sono altre pedine
			// marco la posizione come valida per spostarsi (1)
			if (((posPedina.getRiga() + 1) < nRighe)
					&& (scacchiera[posPedina.getRiga() + 1][posPedina
							.getColonna()] == null))
				mosse[posPedina.getRiga() + 1][posPedina.getColonna()] = 1;

			// -mangia.
			// se non vado fuori dalla scacchiera con le righe e le colonne &&
			// di fianco al pedone c'è un'altra pedina
			// se la pedina ha colore diverso, marco la posizione come valida
			// per mangiare (2)
			if (((posPedina.getRiga() + 1) < nRighe)
					&& ((posPedina.getColonna() - 1) >= 0)
					&& (scacchiera[posPedina.getRiga() + 1][posPedina
							.getColonna() - 1] != null))
				if (scacchiera[posPedina.getRiga() + 1][posPedina.getColonna() - 1]
						.getColore() != this.getColore())
					mosse[posPedina.getRiga() + 1][posPedina.getColonna() - 1] = 2;

			// -mangia.
			// se non vado fuori dalla scacchiera con le righe e le colonne &&
			// di fianco al pedone c'è un'altra pedina
			// se la pedina ha colore diverso, marco la posizione come valida
			// per mangiare (2)
			if (((posPedina.getRiga() + 1) < nRighe)
					&& ((posPedina.getColonna() + 1) < nColonne)
					&& (scacchiera[posPedina.getRiga() + 1][posPedina
							.getColonna() + 1] != null))
				if (scacchiera[posPedina.getRiga() + 1][posPedina.getColonna() + 1]
						.getColore() != this.getColore())
					mosse[posPedina.getRiga() + 1][posPedina.getColonna() + 1] = 2;

		} else { // Colore.BIANCO

			// -normale mossa del pedone.
			if (((posPedina.getRiga() - 1) >= 0)
					&& (scacchiera[posPedina.getRiga() - 1][posPedina
							.getColonna()] == null))
				mosse[posPedina.getRiga() - 1][posPedina.getColonna()] = 1;

			// -mangia.
			if (((posPedina.getRiga() - 1) >= 0)
					&& ((posPedina.getColonna() - 1) >= 0)
					&& (scacchiera[posPedina.getRiga() - 1][posPedina
							.getColonna() - 1] != null))
				if (scacchiera[posPedina.getRiga() - 1][posPedina.getColonna() - 1]
						.getColore() != this.getColore())
					mosse[posPedina.getRiga() - 1][posPedina.getColonna() - 1] = 2;

			// -mangia.
			if (((posPedina.getRiga() - 1) >= 0)
					&& ((posPedina.getColonna() + 1) < nColonne)
					&& (scacchiera[posPedina.getRiga() - 1][posPedina
							.getColonna() + 1] != null))
				if (scacchiera[posPedina.getRiga() - 1][posPedina.getColonna() + 1]
						.getColore() != this.getColore())
					mosse[posPedina.getRiga() - 1][posPedina.getColonna() + 1] = 2;

		}
		return mosse;
	}

	// modificare positions, da AL a array di 8 el.
	public int[][] mPossibili(Position posPedina, Pedina[][] scacchiera) {

		ArrayList<Position> positions = new ArrayList<Position>();
		int[][] mosse = new int[8][8];
		if (this.getColore() == Colore.NERO) {

			positions.add(new Position(posPedina.getRiga() + 1, posPedina
					.getColonna())); // normale mossa del pedone
			positions.add(new Position(posPedina.getRiga() + 1, posPedina
					.getColonna() - 1)); // mossa nel caso in cui debba mangiare
			positions.add(new Position(posPedina.getRiga() + 1, posPedina
					.getColonna() + 1)); // mossa nel caso in cui debba mangiare

		} else { // Colore.BIANCO

			positions.add(new Position(posPedina.getRiga() - 1, posPedina
					.getColonna())); // normale mossa del pedone
			positions.add(new Position(posPedina.getRiga() - 1, posPedina
					.getColonna() - 1)); // mossa nel caso in cui debba mangiare
			positions.add(new Position(posPedina.getRiga() - 1, posPedina
					.getColonna() + 1)); // mossa nel caso in cui debba mangiare

		}

		// scorro l'array e cerco x o y che siano <0 || >8 (fuori range)
		boolean modif;
		do {
			modif = false;

			for (int i = 0; i < positions.size(); i++) {
				Position pos = positions.get(i);
				if (pos.getRiga() < 0 || pos.getColonna() < 0
						|| pos.getRiga() >= nRighe
						|| pos.getColonna() >= nColonne) {
					positions.remove(pos);
					modif = true;
				}
			}
			/*
			 * for(Position pos : positions){ if (pos.getRiga() < 0 ||
			 * pos.getColonna() < 0 || pos.getRiga() >= nRighe ||
			 * pos.getColonna() >= nColonne) { positions.remove(pos); modif =
			 * true; } }
			 */
		} while (modif);

		// marco le posizioni possibili con i codici:
		// 1_posizione dove muoversi
		// 2_posizione dove mangiare
		for (Position p : positions)
			if (scacchiera[p.getRiga()][p.getColonna()] == null)
				mosse[p.getRiga()][p.getColonna()] = 1;
			else {
				if (scacchiera[p.getRiga()][p.getColonna()].getColore() != this
						.getColore())
					mosse[p.getRiga()][p.getColonna()] = 2;
				// i campi non marcati sono posizioni non possibili
			}

		return mosse; // ok
	}

}
