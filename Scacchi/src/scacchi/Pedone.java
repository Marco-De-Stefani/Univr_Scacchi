package scacchi;

public class Pedone extends Pedina {

	public Pedone(Colore colore) {
		super(Nome.PEDONE, colore);
	}
	/**
	 * ritorna le mosse possibili del Pedone per la prossima mossa
	 * controllando che si possa muovere solo in avanti e possa mangiare solo in diagonale
	 * controlla, in base alla posizione in cui si trova, che le mosse 	 
	 * rimagano dentro la scacchiera 
	 */
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

}
