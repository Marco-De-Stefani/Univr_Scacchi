package scacchi;

import java.util.ArrayList;


public class Regina extends Pedina {	

	public Regina(Colore colore){
		super(Nome.REGINA, colore);
	}
	
	public ArrayList<Position> possibleMoves(Position posPedina){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove la regina portà muoversi
		int k;
		int l;
		
		//la regina può muoversi per tutta la riga i
		for(k = 0; k < nColonne; k++)
			if(k != posPedina.getColonna())
				punti.add(new Position(posPedina.getRiga(), k));
		
		//la regina può muoversi per tutta la colonna j
		for(k = 0; k < nRighe; k++)
			if(k != posPedina.getRiga())
				punti.add(new Position(k, posPedina.getColonna()));
		
		//la regina può muoversi in obliquo
		//obliquo dx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() + 1;
		while(k > 0 || l < nColonne){
			punti.add(new Position(k, l));
			k--;
			l++;
		}
		
		//obliquo sx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() - 1;
		while(k > 0 || l > 0){
			punti.add(new Position(k, l));
			k--;
			l--;
		}
		
		//obliquo dx giu
		k = posPedina.getRiga() + 1;
		l = posPedina.getColonna() + 1;
		while(k < nRighe || l < nColonne){
			punti.add(new Position(k, l));
			k++;
			l++;
		}
		
		//obliquo sx giu
		k = posPedina.getRiga() + 1;
		l = posPedina.getColonna() - 1;
		while(k < nRighe || l > 0){
			punti.add(new Position(k, l));
			k++;
			l--;
		}
		
		return punti;
	}
	
	public int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera){
		//ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove la regina portà muoversi
		int[][] mosse = new int[8][8];
		int k;
		int l;
		
		//la regina può muoversi per tutta la riga i
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
		for(k = posPedina.getColonna() - 1; k > 0; k--){
			if(scacchiera[posPedina.getRiga()][k] == null)
				mosse[posPedina.getRiga()][k] = 1;
			else{
				if(scacchiera[posPedina.getRiga()][k].getColore() != this.getColore())
					mosse[posPedina.getRiga()][k] = 2;
				break;
			}
		}
		
		
		//la regina può muoversi per tutta la colonna j
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
		for(k = posPedina.getRiga() - 1; k > 0; k--){
			if(scacchiera[k][posPedina.getColonna()] == null)
				mosse[k][posPedina.getColonna()] = 1;
			else{
				if(scacchiera[k][posPedina.getColonna()].getColore() != this.getColore())
					mosse[k][posPedina.getColonna()] = 2;
				break;
			}
		}
		
		//la regina può muoversi in obliquo
		//obliquo dx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() + 1;
		//while(k > 0 || l < nColonne){
		//	punti.add(new Position(k, l));
		//	k--;
		//	l++;
		//}
		while(k > 0 || l < nColonne){
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
		//while(k > 0 || l > 0){
		//	punti.add(new Position(k, l));
		//	k--;
		//	l--;
		//}
		while(k > 0 || l > 0){
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
		//while(k < nRighe || l < nColonne){
		//	punti.add(new Position(k, l));
		//	k++;
		//	l++;
		//}
		while(k < nRighe || l < nColonne){
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
		//while(k < nRighe || l > 0){
		//	punti.add(new Position(k, l));
		//	k++;
		//	l--;
		//}
		while(k < nRighe || l > 0){
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
