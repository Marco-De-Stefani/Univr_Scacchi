package scacchi;

public class Regina extends Pedina {	
	/**
	 * 
	 * Costruttore della classe Regina
	 * @param colore
	 */
	public Regina(Colore colore){
		super(Nome.REGINA, colore);
	}
	/**
	 * 
	 * @param posPedina
	 * @param scacchiera
	 * @return le mosse possibili della Regina per la prossima mossa
	 * ricordando che la regina muove in qualsiasi direzione
	 * controlla, in base alla posizione in cui si trova, che le mosse 	 
	 * rimagano dentro la scacchiera 
	 */
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera){
		int[][] mosse = new int[8][8];
		int k;
		int l;
		
		//la regina può muoversi per tutta la riga i
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
			
		//la regina può muoversi per tutta la colonna j
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
		//obliquo dx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() + 1;
		while(k >= 0 && l < nColonne){
			if(scacchiera[k][l] == null){
				mosse[k][l] = 1;
				k--;
				l++;
			}else{
				if(scacchiera[k][l].getColore() != this.getColore())
					mosse[k][l] = 2;
				break;
			}
		}
		//obliquo sx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() - 1;
		while(k >= 0 && l >= 0){
			if(scacchiera[k][l] == null){
				mosse[k][l] = 1;
				k--;
				l--;
			}else{
				if(scacchiera[k][l].getColore() != this.getColore())
					mosse[k][l] = 2;
				break;
			}
		}
		//obliquo dx giu
		k = posPedina.getRiga() + 1;
		l = posPedina.getColonna() + 1;
		while(k < nRighe && l < nColonne){
			if(scacchiera[k][l] == null){
				mosse[k][l] = 1;
				k++;
				l++;
			}else{
				if(scacchiera[k][l].getColore() != this.getColore())
					mosse[k][l] = 2;
				break;
			}
		}
		//obliquo sx giu
		k = posPedina.getRiga() + 1;
		l = posPedina.getColonna() - 1;
		while(k < nRighe && l >= 0){
			if(scacchiera[k][l] == null){
				mosse[k][l] = 1;
				k++;
				l--;
			}else{
				if(scacchiera[k][l].getColore() != this.getColore())
					mosse[k][l] = 2;
				break;
			}
		}
		return mosse;
	}
	
}
