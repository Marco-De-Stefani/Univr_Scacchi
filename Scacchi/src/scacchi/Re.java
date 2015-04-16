package scacchi;

import java.util.ArrayList;

public class Re extends Pedina{
	/**
	 * 
	 * Costruttore della classe Re
	 * @param colore
	 */
	public Re(Colore colore) {
		super(Nome.RE, colore);
		
	}
	/**
	 * 
	 * @param posPedina
	 * @param scacchiera
	 * @return le mosse possibili che il Re per la prossima mossa
	 * ricordando che si puo' muovere solo di una casella
	 * controlla, in base alla posizione in cui si trova, che le mosse 	 
	 * rimagano dentro la scacchiera 
	 */
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera) {
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
		
		//controllo che le mosse stiano dentro la scacchiera
		boolean controllo;
		do{
			controllo = false;
			for (int i = 0; i < positions.size(); i++) {
			Position pos=positions.get(i);
				if (pos.getRiga() < 0 || pos.getColonna() < 0 || pos.getRiga() >= nRighe || pos.getColonna() >= nColonne) {
					controllo = true;
					positions.remove(pos);
				}
			}
		}while(controllo);
		//guardo se si possa muovere, mangiare o non muovere
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