package scacchi;

import java.util.ArrayList;

public class Pedone extends Pedina {

	public Pedone(Nome nome, Colore colore) {
		super(nome, colore);
	}

	@Override
	public ArrayList<Position> possibleMoves(int riga, int colonna) {
		
		Position position = new Position(riga, colonna);
		ArrayList<Position> positions = new ArrayList<Position>();
		if(this.getColore()==Colore.NERO){
			
			positions.add(new Position(position.x, position.y + 1));		//normale mossa del pedone
			positions.add(new Position(position.x - 1, position.y + 1));	//mossa nel caso in cui debba mangiare
			positions.add(new Position(position.x + 1, position.y + 1));	//mossa nel caso in cui debba mangiare
		
		}else{		//Colore.BIANCO
		
			positions.add(new Position(position.x, position.y - 1));		//normale mossa del pedone
			positions.add(new Position(position.x - 1, position.y - 1));	//mossa nel caso in cui debba mangiare
			positions.add(new Position(position.x + 1, position.y - 1));	//mossa nel caso in cui debba mangiare
		
		}
		
		// scorro l'array e cerco x o y che siano <0 || >8
				boolean b;
				do{
					b = false;
					for (int i = 0; i < positions.size(); i++) {
						Position pos=positions.get(i);
						if (pos.x <= 0 || pos.y <= 0 || pos.x > nRows || pos.y > nColumns) {
							b = true;
							positions.remove(pos);
						}
					}
				}while(b);
				return positions;
			}
		
	}

	
	
	

