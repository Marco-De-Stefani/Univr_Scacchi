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
}
