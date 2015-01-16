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
	
}
