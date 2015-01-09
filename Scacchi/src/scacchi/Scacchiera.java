package scacchi;

public class Scacchiera {

	private Pedina[][] scacchiera;
	
	public Scacchiera(){
		//inizializzazione della scacchiera 8x8
		scacchiera = new Pedina[8][8];
		
		//carico la squadra nera
		scacchiera[0][0] = new Torre(Colore.NERO);
		scacchiera[0][1] = new Cavallo(Colore.NERO);
		scacchiera[0][2] = new Alfiere(Colore.NERO);
		scacchiera[0][3] = new Re(Colore.NERO);
		scacchiera[0][4] = new Regina(Colore.NERO);
		scacchiera[0][5] = new Alfiere(Colore.NERO);
		scacchiera[0][6] = new Cavallo(Colore.NERO);
		scacchiera[0][7] = new Torre(Colore.NERO);
		for(int i = 0; i < 8; i++)
			scacchiera[1][i] = new Pedone(Colore.NERO);
		
		//carico la squadra bianca
		scacchiera[7][0] = new Torre(Colore.BIANCO);
		scacchiera[7][1] = new Cavallo(Colore.BIANCO);
		scacchiera[7][2] = new Alfiere(Colore.BIANCO);
		scacchiera[7][3] = new Re(Colore.BIANCO);
		scacchiera[7][4] = new Regina(Colore.BIANCO);
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
	 * @return la pedina in 
	 */
	public Pedina getPedina(int i, int j){
		return scacchiera[i][j];
	}
	
	
	
}
