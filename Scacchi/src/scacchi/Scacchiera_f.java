package scacchi;

public class Scacchiera_f {

	private Pedina[][] scacchiera;
	
	public Scacchiera_f(){
		//inizializzazione della scacchiera 8x8
		scacchiera = new Pedina[8][8];
		
		//carico la squadra nera
		scacchiera[0][0] = new Torre(Colore.NERO);
		scacchiera[0][1] = new Cavallo(Colore.NERO);
		scacchiera[0][2] = new Alfiere(Colore.NERO);
		scacchiera[0][3] = new Regina(Colore.NERO);
		scacchiera[0][4] = new Re(Colore.NERO);
		scacchiera[0][5] = new Alfiere(Colore.NERO);
		scacchiera[0][6] = new Cavallo(Colore.NERO);
		scacchiera[0][7] = new Torre(Colore.NERO);
		for(int i = 0; i < 8; i++)
			scacchiera[1][i] = new Pedone(Colore.NERO);
		
		//carico la squadra bianca
		scacchiera[7][0] = new Torre(Colore.BIANCO);
		scacchiera[7][1] = new Cavallo(Colore.BIANCO);
		scacchiera[7][2] = new Alfiere(Colore.BIANCO);
		scacchiera[7][3] = new Regina(Colore.BIANCO);
		scacchiera[7][4] = new Re(Colore.BIANCO);
		scacchiera[7][5] = new Alfiere(Colore.BIANCO);
		scacchiera[7][6] = new Cavallo(Colore.BIANCO);
		scacchiera[7][7] = new Torre(Colore.BIANCO);
		for(int i = 0; i < 8; i++)
			scacchiera[6][i] = new Pedone(Colore.BIANCO);
	}
	
	/**
	 * 
	 * @param i la riga della scacchiera
	 * @param j la colonna della scacchiera
	 * @return la pedina in posizione (i,j)
	 */
	public Pedina getPedina(Position p){
		return scacchiera[p.x][p.y];
	}
	
	/**
	 * 
	 * @param p la posizione della pedina da muovere
	 * @return una matrice di interi dove sono indicate le posizioni possibili;
	 * 		per ogni poszione viene associato un valore:
	 * 			0 = la pedina NON può essere spostata qui
	 * 			1 = la pedina può essere spostata qui
	 * 			2 = la pedina può mangiare l'altra pedina posizionata qui
	 */
	public int[][] getMoves(Position p){
		int[][] moves = new int[8][8];
		//ArrayList<Position> = this.getPedina(p).possibleMoves(riga, colonna);
		
		
		
		return moves;
	}
	
	public boolean move(Position partenza,Position arrivo){
		//se mangi ritorni true
		return false;
	}
	
	public int controlloVittoria(){
		//ritorna -1 se è stata vinta da g1 0 pareggio, 1 vittoria del g2 
		return 0;
	}
	
	public void evoluzionePedone(){
		  
	}
	
	/**
	 * 
	 * @param
	 * @return 1 se il re bianco è sotto scacco, -1 se il re nero è sotto scacco, 0 se non è sotto scacco nessun re
	 */
	public int scacco(){
		//scacco bianco 1
		//scacco nero -1
		Position ReNero = null;
		Position ReBianco = null;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.BIANCO)
					ReBianco = new Position(i, j);	// salvo posizione del re bianco
				else if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.NERO)
					ReNero = new Position(i, j);	// salvo la posizione del re nero
			}
		}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j].getColore() == Colore.NERO)				//controllo se la pedina che dà scacco è di colore nero
					for(Position p : scacchiera[i][j].possibleMoves(i, j))	//scorro l'array delle possibleMoves
						if(p == ReBianco)									//se è uguale alla posizione del re bianco, allora il re sarà sotto scacco
							return 1;
				if(scacchiera[i][j].getColore() == Colore.BIANCO)
					for(Position p : scacchiera[i][j].possibleMoves(i, j))
						if(p == ReNero)
							return -1;
			}
		}
				
		return 0;
	}
	
	
}
