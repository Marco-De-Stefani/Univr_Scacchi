package scacchi;


public class Alfiere extends Pedina {

	public Alfiere(Colore colore){
		super(Nome.ALFIERE, colore);
	}
	/**
	 * ritorna le mosse possibili dell' alfiere per la prossima mossa
	 * ricordando che si muove solo in diagonale
	 * controlla, in base alla posizione in cui si trova, che le mosse 	 
	 * rimagano dentro la scacchiera
	 */
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera){
		int[][] mosse = new int[8][8];
		int r;	//riga
		int c;	//colonna
		
		//obliquo dx su
		r = posPedina.getRiga() - 1;
		c = posPedina.getColonna() + 1;
		while(r >= 0 && c < nColonne){
			if(scacchiera[r][c] == null){
				mosse[r][c] = 1;
				r--;
				c++;
			}else{
				if(scacchiera[r][c].getColore() != this.getColore())
					mosse[r][c] = 2;
				break;
			}
		}
		
		//obliquo sx su
		r = posPedina.getRiga() - 1;
		c = posPedina.getColonna() - 1;
		while(r >= 0 && c >= 0){
			if(scacchiera[r][c] == null){
				mosse[r][c] = 1;
				r--;
				c--;
			}else{
				if(scacchiera[r][c].getColore() != this.getColore())
					mosse[r][c] = 2;
				break;
			}
		}
		
		//obliquo dx giu
		r = posPedina.getRiga() + 1;
		c = posPedina.getColonna() + 1;
		while(r < nRighe && c < nColonne){
			if(scacchiera[r][c] == null){
				mosse[r][c] = 1;
				r++;
				c++;
			}else{
				if(scacchiera[r][c].getColore() != this.getColore())
					mosse[r][c] = 2;
				break;
			}
		}
		
		//obliquo sx giu
		r = posPedina.getRiga() + 1;
		c = posPedina.getColonna() - 1;
		while(r < nRighe && c >= 0){
			if(scacchiera[r][c] == null){
				mosse[r][c] = 1;
				r++;
				c--;
			}else{
				if(scacchiera[r][c].getColore() != this.getColore())
					mosse[r][c] = 2;
				break;
			}
		}
		
		
		return mosse;
	}
	
	
}
