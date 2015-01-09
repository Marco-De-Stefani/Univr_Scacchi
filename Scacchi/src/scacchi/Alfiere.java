package scacchi;

import java.util.ArrayList;

public class Alfiere extends Pedina {

	public Alfiere(Colore colore){
		super(Nome.ALFIERE, colore);
	}
	
	public ArrayList<Position> possibleMoves(int riga, int colonna){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove l'alfiere portà muoversi
		int k;
		int l;
		
		//l'alfiere può muoversi in obliquo
		//obliquo dx su
		k = riga - 1;
		l = colonna + 1;
		while(k > 0 || l < nColumns){
			punti.add(new Position(k, l));
			k--;
			l++;
		}
		
		//obliquo sx su
		k = riga - 1;
		l = colonna - 1;
		while(k > 0 || l > 0){
			punti.add(new Position(k, l));
			k--;
			l--;
		}
		
		//obliquo dx giu
		k = riga + 1;
		l = colonna + 1;
		while(k < nRows || l < nColumns){
			punti.add(new Position(k, l));
			k++;
			l++;
		}
		
		//obliquo sx giu
		k = riga + 1;
		l = colonna - 1;
		while(k < nRows || l > 0){
			punti.add(new Position(k, l));
			k++;
			l--;
		}
		
		return punti;
	}
}
