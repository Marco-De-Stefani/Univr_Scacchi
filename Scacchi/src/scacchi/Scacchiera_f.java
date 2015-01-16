package scacchi;

public class Scacchiera_f {

	private Pedina[][] scacchiera;

	private int mosse=0;	//mi serve in caso di patta
	
	public Scacchiera_f(){
		//inizializzazione della scacchiera 8x8
		scacchiera = new Pedina[8][8];
		
		//carico la squadra nera
		scacchiera[2][0] = new Torre(Colore.NERO);
		scacchiera[2][1] = new Cavallo(Colore.NERO);
		scacchiera[2][2] = new Alfiere(Colore.NERO);
		scacchiera[2][3] = new Regina(Colore.NERO);
		scacchiera[2][4] = new Re(Colore.NERO);
		scacchiera[0][5] = new Alfiere(Colore.NERO);
		scacchiera[0][6] = new Cavallo(Colore.NERO);
		scacchiera[0][7] = new Torre(Colore.NERO);
		for(int i = 0; i < 8; i++)
			scacchiera[1][i] = new Pedone(Colore.NERO);
		
		//carico la squadra bianca
		scacchiera[7][0] = new Torre(Colore.BIANCO);
		scacchiera[7][1] = new Cavallo(Colore.BIANCO);
		scacchiera[7][2] = new Alfiere(Colore.BIANCO);
		scacchiera[5][3] = new Regina(Colore.BIANCO);
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
		return scacchiera[p.getRiga()][p.getColonna()];
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
		if(scacchiera[partenza.getRiga()][partenza.getColonna()].getNome() != Nome.PEDONE && scacchiera[arrivo.getRiga()][arrivo.getColonna()] == null)
			mosse++;
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()]!=null){
			scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
			scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param
	 * @return 1 se il re bianco è sotto scacco, -1 se il re nero è sotto scacco, 0 se non è sotto scacco nessun re
	 */
	public int scacco(){
		//scacco bianco 1
		//scacco nero -1
		Position reNero = null;
		Position reBianco = null;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.BIANCO)
					reBianco = new Position(i, j);	// salvo posizione del re bianco
				else if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.NERO)
					reNero = new Position(i, j);	// salvo la posizione del re nero
			}
		}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j].getColore() == Colore.NERO)				//controllo se la pedina che dà scacco è di colore nero
					for(Position p : scacchiera[i][j].possibleMoves(new Position(i, j)))	//scorro l'array delle possibleMoves
						if(p == reBianco)								//se è uguale alla posizione del re bianco, allora il re sarà sotto scacco
							return 1;
				if(scacchiera[i][j].getColore() == Colore.BIANCO)
					for(Position p : scacchiera[i][j].possibleMoves(new Position(i, j)))
						if(p == reNero)
							return -1;
			}
		}
				
		return 0;
	}
	
	/**
	 * 
	 * @param
	 * @return 	1 se la vittoria è del giocatore bianco cioè se il re nero è sotto scacco matto e le sue possibili mosse sono 0,
	 * 			-1 se la vittoria è del giocatore nero cioè i re bianco è sotto scacco e le sue possibili mosse sono 0
	 * 			0 se la partita finisce in parita', cioè o se in gioco rimangono solo i due re o se nelle 50 mosse di ciascun giocatore
	 * 				non si è mosso un pedone e non si è mangiata nessuna pedina
	 * 			se non si è neancora in una di queste situazioni allora si avra' 7
	 */
	public int controlloVittoria(){
		//ritorna -1 se è stata vinta da g1(nero) 0 pareggio, 1 vittoria del g2(bianco)
		Position reNero = null;
		Position reBianco = null;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.BIANCO)
					reBianco = new Position(i, j);	// salvo posizione del re bianco
				else if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.NERO)
					reNero = new Position(i, j);	// salvo la posizione del re nero
			}
		}
		if(scacco() == 1 && scacchiera[reBianco.getRiga()][reBianco.getColonna()].possibleMoves(new Position(reBianco.getRiga(), reBianco.getColonna())).size() == 0 ){
			return -1;		//vittoria da parte del nero
		}else if(scacco() == -1 && scacchiera[reNero.getRiga()][reNero.getColonna()].possibleMoves(new Position(reNero.getRiga(), reNero.getColonna())).size() == 0){
			return 1;		//vittoria da parte del bianco
		}else if(scacchiera.length==2 || mosse == 100){
			return 0;
		}
		return 7;	//valore di default non so che mettere
	}
	
	/**
	 * 
	 * @param
	 * @return 
	 * modifica il pedone trasformandolo in regina ???
	 */
	public void evoluzionePedone(){
		for(int i = 0; i < 8; i++){
			if(scacchiera[i][7].getNome()==Nome.PEDONE)
				scacchiera[i][7]= new Regina(scacchiera[i][7].getColore());
			if(scacchiera[i][0].getNome()==Nome.PEDONE)
				scacchiera[i][0]= new Regina(scacchiera[i][0].getColore());
		}
	}	
}