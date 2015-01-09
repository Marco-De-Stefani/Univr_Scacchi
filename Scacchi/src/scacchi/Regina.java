package scacchi;

import java.util.ArrayList;


public class Regina extends Pedina {	

	public Regina(Colore colore){
		super(Nome.REGINA, colore);
	}
	
	public ArrayList<Position> possibleMoves(int riga, int colonna){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterrà tutti i punti dove la regina portà muoversi
		int k;
		int l;
		
		//la regina può muoversi per tutta la riga i
		for(k = 0; k < nColumns; k++)
			if(k != colonna)
				punti.add(new Position(riga, k));
		
		//la regina può muoversi per tutta la colonna j
		for(k = 0; k < nRows; k++)
			if(k != riga)
				punti.add(new Position(k, colonna));
		
		//la regina può muoversi in obliquo
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
