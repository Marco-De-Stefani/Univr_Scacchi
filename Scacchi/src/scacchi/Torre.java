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
	
}
