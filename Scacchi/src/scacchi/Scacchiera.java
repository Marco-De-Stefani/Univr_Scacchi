package scacchi;

public class Scacchiera {

	private Pedina[][] scacchiera;
	private Pedina[] mangiate;
	//////////////////////////////////////////////////////////////
	// TODO implementare nel possibleMoves l'iterator vd Gioco15
	//////////////////////////////////////////////////////////////
	
	public Scacchiera(){
		//inizializzazione della scacchiera 8x8
		scacchiera = new Pedina[8][8];
		mangiate = new Pedina[32];
		
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
		scacchiera[7][0] = new Torre(Colore.BIANCO);//funziona
		scacchiera[7][1] = new Cavallo(Colore.BIANCO);
		scacchiera[7][2] = new Alfiere(Colore.BIANCO);//funziona
		scacchiera[7][3] = new Regina(Colore.BIANCO);//funziona
		scacchiera[3][0] = new Re(Colore.BIANCO);
		scacchiera[4][5] = new Alfiere(Colore.BIANCO);
		scacchiera[5][5] = new Cavallo(Colore.BIANCO);
		scacchiera[3][7] = new Torre(Colore.BIANCO);
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
	 * 			0 = la pedina NON pu� essere spostata qui
	 * 			1 = la pedina pu� essere spostata qui
	 * 			2 = la pedina pu� mangiare l'altra pedina posizionata qui
	 */
	public int[][] getMoves(Position pos){
		int[][] moves= scacchiera[pos.getRiga()][pos.getColonna()].mossePossibili(pos, scacchiera);		
		return moves;
	}
	
	//mangio=true, senn� false
	//la position arrivo � controllata
	public boolean move(Position partenza,Position arrivo){
		int [][] a=getMoves(partenza);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				Position attuale=new Position(i, j);
				if(attuale==arrivo){
					scacchiera[i][j]=scacchiera[partenza.getRiga()][partenza.getColonna()];
					scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
					return true;
				}
			}
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		return false;
	}
	
	public Pedina[] getPedineMangiate(){
		return mangiate;
	}
	
	public int controlloVittoria(){
		//ritorna -1 se � stata vinta da g1 0 pareggio, 1 vittoria del g2 
		return 0;
	}
	
	public void evoluzionePedone(){
		  
	}
	
	
}
