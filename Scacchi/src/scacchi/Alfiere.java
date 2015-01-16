package scacchi;

import java.util.ArrayList;

public class Alfiere extends Pedina {

	public Alfiere(Colore colore){
		super(Nome.ALFIERE, colore);
	}
	
	public ArrayList<Position> possibleMoves(Position posPedina){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove l'alfiere portà muoversi
		int k;
		int l;
		
		//l'alfiere può muoversi in obliquo
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
		int[][] mosse = new int[8][8];
		int k;
		int l;
		
		//l'alfiere può muoversi in obliquo
		//obliquo dx su
		k = posPedina.getRiga() - 1;
		l = posPedina.getColonna() + 1;
		//while(k > 0 || l < nColonne){
		//	punti.add(new Position(k, l));
		//	k--;
		//	l++;
		//}
		while(k >= 0 || l < nColonne){
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
		while(k >= 0 || l >= 0){
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
		while(k < nRighe || l >= 0){
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
