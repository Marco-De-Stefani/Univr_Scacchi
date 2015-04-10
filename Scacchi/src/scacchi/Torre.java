package scacchi;

public class Torre extends Pedina{

	public Torre(Colore colore){
		super(Nome.TORRE, colore);
	}
	/**
	 * ritorna le mosse possibili della Torre per la prossima mossa
	 * ricordando che puo' muoversi solo in orizzontale e verticale
	 * controlla, in base alla posizione in cui si trova, che le mosse 	 
	 * rimagano dentro la scacchiera 
	 */
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera){
		int[][] mosse = new int[8][8];
		int k;
		
		//la torre può muoversi per tutta la riga i
		//colonne sopra/sotto la posizione attuale
		for(k = posPedina.getColonna() + 1; k < nColonne; k++){
			if(scacchiera[posPedina.getRiga()][k] == null)
				mosse[posPedina.getRiga()][k] = 1;
			else{
				if(scacchiera[posPedina.getRiga()][k].getColore() != this.getColore())
					mosse[posPedina.getRiga()][k] = 2;
				break;
			}
		}
		for(k = posPedina.getColonna() - 1; k >= 0; k--){
			if(scacchiera[posPedina.getRiga()][k] == null)
				mosse[posPedina.getRiga()][k] = 1;
			else{
				if(scacchiera[posPedina.getRiga()][k].getColore() != this.getColore())
					mosse[posPedina.getRiga()][k] = 2;
				break;
			}
		}
		
		
		//la torre può muoversi per tutta la colonna j
		//righe dx/sx della posizione attuale
		for(k = posPedina.getRiga() + 1; k < nRighe; k++){
			if(scacchiera[k][posPedina.getColonna()] == null)
				mosse[k][posPedina.getColonna()] = 1;
			else{
				if(scacchiera[k][posPedina.getColonna()].getColore() != this.getColore())
					mosse[k][posPedina.getColonna()] = 2;
				break;
			}
		}
		for(k = posPedina.getRiga() - 1; k >= 0; k--){
			if(scacchiera[k][posPedina.getColonna()] == null)
				mosse[k][posPedina.getColonna()] = 1;
			else{
				if(scacchiera[k][posPedina.getColonna()].getColore() != this.getColore())
					mosse[k][posPedina.getColonna()] = 2;
				break;
			}
		}
		
		return mosse;
	}
	
}
