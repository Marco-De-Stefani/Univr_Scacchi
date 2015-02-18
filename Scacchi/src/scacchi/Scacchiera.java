package scacchi;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import scacchi.grafica.FrameSceltaPedina;
import scacchi.grafica.PanelSceltaPedina;


public class Scacchiera {

	private Pedina[][] scacchiera;
	private Pedina[] mangiate;
	private Colore turno=Colore.BIANCO;
	private FrameSceltaPedina fsp;
	private int countMangiate;
	private Pedina pedinaPromozione;
	//////////////////////////////////////////////////////////////
	// TODO implementare nel possibleMoves l'iterator vd Gioco15
	//////////////////////////////////////////////////////////////
	
	public Scacchiera(){
		//inizializzazione della scacchiera 8x8
		fsp=new FrameSceltaPedina();
		scacchiera = new Pedina[8][8];
		mangiate = new Pedina[32];
		countMangiate = 0;
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
		scacchiera[3][0] = new Re(Colore.BIANCO);
		scacchiera[4][5] = new Alfiere(Colore.BIANCO);
		scacchiera[5][5] = new Cavallo(Colore.BIANCO);
		scacchiera[3][7] = new Torre(Colore.BIANCO);
		for(int i = 0; i < 8; i++)
			scacchiera[6][i] = new Pedone(Colore.BIANCO);
		
	}
	
	public Pedina[][] getScacchiera(){return scacchiera;}
	
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
		if(scacchiera[pos.getRiga()][pos.getColonna()].getColore().equals(turno)){
			int[][] moves= scacchiera[pos.getRiga()][pos.getColonna()].mossePossibili(pos, scacchiera);	
			return moves;
		}
		else return new int[8][8];
	}
	
	public ArrayList<Position> getMovesArrayList(Position pos){
		ArrayList<Position> mosse=new ArrayList<Position>();
		if(scacchiera[pos.getRiga()][pos.getColonna()].getColore().equals(turno)){
			int[][] moves= scacchiera[pos.getRiga()][pos.getColonna()].mossePossibili(pos, scacchiera);
			for(int i=0;i<moves.length;i++)
				for(int j=0;j<moves.length;j++){
					if(moves[i][j]!=0)mosse.add(new Position(i, j));
				}
		}
		return mosse;
	}
	
	
	//mangio=true, senn� false
	//la position arrivo � controllata
	public boolean moveOld(Position partenza,Position arrivo){
		canMove(partenza, arrivo);
		boolean mangiato = false;
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()] != null){
			mangiato = true;
			mangiate[countMangiate] = scacchiera[arrivo.getRiga()][arrivo.getColonna()];
			countMangiate++;
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		
		//se la mossa provoca lo scacco del re con lo stesso colore, la mossa non vale (rollback)
		if(scacco() == 1 &&
				scacchiera[arrivo.getRiga()][arrivo.getColonna()].getColore().equals(Colore.BIANCO)
				|| scacco() == -1 &&
				scacchiera[arrivo.getRiga()][arrivo.getColonna()].getColore().equals(Colore.NERO)){
			
			scacchiera[partenza.getRiga()][partenza.getColonna()]=scacchiera[arrivo.getRiga()][arrivo.getColonna()];
			scacchiera[arrivo.getRiga()][arrivo.getColonna()] = null;
			if(mangiato){
				countMangiate--;
				scacchiera[arrivo.getRiga()][arrivo.getColonna()] = mangiate[countMangiate];
			}
			return false;
		}
		
		//se non ho provocato lo scacco
		//passo il turno
		if(turno.equals(Colore.BIANCO))turno=Colore.NERO;
		else{turno=Colore.BIANCO;}
		
		System.out.println(mangiato);
		return mangiato;
	}
	
	
	//mangio=true, senn� false
	//la position arrivo � controllata
	public boolean move(Position partenza,Position arrivo){
		
		if(!canMove(partenza, arrivo))	//se non pu� muovere, non fa niente
			return false;
		
		boolean mangiato = false;
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()] != null){
			mangiato = true;
			mangiate[countMangiate] = scacchiera[arrivo.getRiga()][arrivo.getColonna()];
			countMangiate++;
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		
		//se non ho provocato lo scacco, passo il turno
		if(turno.equals(Colore.BIANCO))turno=Colore.NERO;
		else{turno=Colore.BIANCO;}
		
		return true;
	}
	
	
	//simula la mossa e verifica se provoca scacco al re del proprio colore
	//return: se scacco -> false, altrimenti true
	public boolean canMove(Position partenza,Position arrivo){
		boolean mangiato = false;
		boolean canMove = true;
		
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()] != null){
			mangiato = true;
			mangiate[countMangiate] = scacchiera[arrivo.getRiga()][arrivo.getColonna()];
			countMangiate++;
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		
		//controllo se la mossa provoca lo scacco del re con lo stesso colore
		if(scacco() == 1 &&
				scacchiera[arrivo.getRiga()][arrivo.getColonna()].getColore().equals(Colore.BIANCO)
				|| scacco() == -1 &&
				scacchiera[arrivo.getRiga()][arrivo.getColonna()].getColore().equals(Colore.NERO))
			canMove = false;
		
		//rollback
		scacchiera[partenza.getRiga()][partenza.getColonna()]=scacchiera[arrivo.getRiga()][arrivo.getColonna()];
		scacchiera[arrivo.getRiga()][arrivo.getColonna()] = null;
		if(mangiato){
			countMangiate--;
			scacchiera[arrivo.getRiga()][arrivo.getColonna()] = mangiate[countMangiate];
		}
		System.out.println("canMove: " + canMove);
		return canMove;
	}
	

	public void setPedinaPromozione(int n){
		switch(n){
		case 0:
			pedinaPromozione = new Alfiere(turno);
			break;
		case 1:
			pedinaPromozione = new Cavallo(turno);
			break;
		case 2:
			pedinaPromozione = new Regina(turno);
			break;
		case 3:
			pedinaPromozione = new Torre(turno);
			break;
		}
		notifyAll();
	}
	
	public Colore getTurno(){return turno;}
	
	public Pedina[] getPedineMangiate(){
		return mangiate;
	}
	
	public int controlloVittoria(){
		//ritorna -1 se � stata vinta da g1 0 pareggio, 1 vittoria del g2 
		return 0;
	}
	
	public void evoluzionePedone(Position pos){
	//	fsp.setColore(turno);
		fsp.setVisible(true);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//la finestra ha finito
		fsp.setVisible(false);
		scacchiera[pos.getRiga()][pos.getColonna()]=pedinaPromozione;
	}
	
	/**
	 * 
	 * @param
	 * @return 1 se il re bianco � sotto scacco, -1 se il re nero � sotto scacco, 0 se non � sotto scacco nessun re
	 */
	
	public int scacco(){
		//scacco bianco 1
		//scacco nero -1
		Position reNero = null;
		Position reBianco = null;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j] != null){
					if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.BIANCO)
						reBianco = new Position(i, j);	// salvo posizione del re bianco
					else if(scacchiera[i][j].getNome() == Nome.RE && scacchiera[i][j].getColore() == Colore.NERO)
						reNero = new Position(i, j);	// salvo la posizione del re nero
				}
			}
		}
		//System.out.println("trovati re");
		
		int [][] mosPos = null;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j] != null){
					if(scacchiera[i][j].getColore() == Colore.NERO){				//controllo se la pedina che d� scacco � di colore nero
						mosPos = scacchiera[i][j].mossePossibili(new Position(i, j),scacchiera);
						if(mosPos[reBianco.getRiga()][reBianco.getColonna()] == 2)		//se � uguale alla posizione del re bianco, allora il re sar� sotto scacco
							return 1;
					}
					if(scacchiera[i][j].getColore() == Colore.BIANCO){
						mosPos = scacchiera[i][j].mossePossibili(new Position(i, j),scacchiera);
						if( mosPos[reNero.getRiga()][reNero.getColonna()] == 2)
							return -1;
					}
				}
			}
		}
		//System.out.println("no scaghi ai re");
		return 0;
	}
	
	
	//metodo che restituisce true solo se, con una mossa posso fare in modo che il re non sia pi� sotto scacco
	public boolean salvataggioRe(){
		
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				if(scacchiera[i][j]!=null && scacchiera[i][j].getColore().equals(turno)){
					//per ogni mia pedina, se posso salvare il re
					ArrayList<Position> r=getMovesArrayList(new Position(i, j));
					for(Position p:r){
						//METODO DEL MIGLIOOOOOOOOOOOOOOO
						if(canMove(new Position(i, j), p))
							//se true, esiste una mossa che mi salva dallo scacco
							return true;
					}
				}
			}
		return false;
	}
}
