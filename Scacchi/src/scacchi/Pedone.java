package scacchi;

import java.util.ArrayList;

public class Pedone extends Pedina {

	public Pedone(Colore colore) {
		super(Nome.PEDONE, colore);
	}

	@Override
	public ArrayList<Position> possibleMoves(Position posPedina) {
		
		//Position position = new Position(riga, colonna);
		ArrayList<Position> positions = new ArrayList<Position>();
		if(this.getColore()==Colore.NERO){
			
			positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna()));		//normale mossa del pedone
			positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() - 1));	//mossa nel caso in cui debba mangiare
			positions.add(new Position(posPedina.getRiga() + 1, posPedina.getColonna() + 1));	//mossa nel caso in cui debba mangiare
		
		}else{		//Colore.BIANCO
		
			positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna()));		//normale mossa del pedone
			positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() - 1));	//mossa nel caso in cui debba mangiare
			positions.add(new Position(posPedina.getRiga() - 1, posPedina.getColonna() + 1));	//mossa nel caso in cui debba mangiare
		
		}
		
		// scorro l'array e cerco x o y che siano <0 || >8
				boolean b;
				do{
					b = false;
					for (int i = 0; i < positions.size(); i++) {
						Position pos=positions.get(i);
						if (pos.getRiga() <= 0 || pos.getColonna() <= 0 || pos.getRiga() > nRighe || pos.getColonna() > nColonne) {
							b = true;
							positions.remove(pos);
						}
					}
				}while(b);
				return positions;
			}
		
	}

	
	
	

