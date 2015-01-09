package scacchi;

import java.util.ArrayList;

public class Torre extends Pedina{

	public Torre(Colore colore){
		super(Nome.TORRE, colore);
	}
	
	public ArrayList<Position> possibleMoves(int riga, int colonna){
		ArrayList<Position> punti = new ArrayList<>();	//AL che conterr� tutti i punti dove la torre port� muoversi
		int k;
		
		//la torre pu� muoversi per tutta la riga i
		for(k = 0; k < nColumns; k++)
			if(k != colonna)
				punti.add(new Position(riga, k));
		
		//la torre pu� muoversi per tutta la colonna j
		for(k = 0; k < nRows; k++)
			if(k != riga)
				punti.add(new Position(k, colonna));
		
		return punti;
	}
	
}
