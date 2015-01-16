package scacchi;

import java.util.ArrayList;

public class Torre extends Pedina{

	public Torre(Colore colore){
		super(Nome.TORRE, colore);
	}
	
	public ArrayList<Position> possibleMoves(Position posPedina){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove la torre portà muoversi
		int k;
		
		//la torre può muoversi per tutta la riga i
		for(k = 0; k < nColonne; k++)
			if(k != posPedina.getColonna())
				punti.add(new Position(posPedina.getRiga(), k));
		
		//la torre può muoversi per tutta la colonna j
		for(k = 0; k < nRighe; k++)
			if(k != posPedina.getRiga())
				punti.add(new Position(k, posPedina.getColonna()));
		
		return punti;
	}
	
	
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera){
		int[][] mosse = new int[8][8];
		int k;
		
		//la torre può muoversi per tutta la riga i
		//for(k = 0; k < nColonne; k++)
		//	if(k != posPedina.getColonna())
		//		punti.add(new Position(posPedina.getRiga(), k));
		
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
		//for(k = 0; k < nRighe; k++)
		//	if(k != posPedina.getRiga())
		//		punti.add(new Position(k, posPedina.getColonna()));
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
