package scacchi;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import scacchi.grafica.Controller;
import scacchi.grafica.FrameSceltaPedina;
import scacchi.grafica.PanelScacchiera;


public class Scacchiera {

	private Pedina[][] scacchiera;
	private Pedina[] mangiate;
	private Colore turno=Colore.BIANCO;
	private int countMangiate;
	Controller c;
 
	/**
	 * Costruttore della classe Scacchiera
	 * 
	 * @param test: se true, la scacchiera viene creata con poch pedine, utile per tutti i test JUnit
	 */
	public Scacchiera(boolean test){
		if(test){
			scacchiera = new Pedina[8][8];
			mangiate = new Pedina[32];
			countMangiate = 0;
			turno=Colore.BIANCO;
			
			scacchiera[0][3] = new Re(Colore.NERO);
			scacchiera[2][1] = new Pedone(Colore.NERO);
			scacchiera[3][0] = new Pedone(Colore.BIANCO);
			scacchiera[4][3] = new Regina(Colore.NERO);
			scacchiera[4][7] = new Torre(Colore.NERO);
			scacchiera[5][0] = new Cavallo(Colore.BIANCO);
			scacchiera[5][6] = new Alfiere(Colore.BIANCO);
			scacchiera[6][0] = new Pedone(Colore.NERO);
			scacchiera[7][3] = new Re(Colore.BIANCO);
		}else{
			restart();
		}
	}
	
	public Pedina[][] getScacchiera(){return scacchiera;}
	
	/**
	 * Metodo che setta la pedina p nella posizione pos della scacchiera
	 * usato nell'evoluzione del pedone per poter sostituire al pedone la pedina scelta
	 * 
	 * @param pos la posizione della scacchiera
	 * @param p la pedina da mettere nella posizione
	 */
	public void setScacchiera(Position pos,Pedina p){
		scacchiera[pos.getRiga()][pos.getColonna()]=p;
	}
	
	
	/**
	 * @param i la riga della scacchiera
	 * @param j la colonna della scacchiera
	 * @return la pedina in posizione (i,j)
	 */
	public Pedina getPedina(Position p){
		return scacchiera[p.getRiga()][p.getColonna()];
	}
	
	/**
	 * @param p la posizione della pedina da muovere
	 * @return una matrice di interi dove sono indicate le posizioni possibili;
	 * 		per ogni poszione viene associato un valore:
	 * 			0 = la pedina NON può essere spostata qui
	 * 			1 = la pedina può essere spostata qui
	 * 			2 = la pedina può mangiare l'altra pedina posizionata qui
	 */
	public int[][] getMoves(Position pos){
		if(scacchiera[pos.getRiga()][pos.getColonna()].getColore().equals(turno)){
			int[][] moves= scacchiera[pos.getRiga()][pos.getColonna()].mossePossibili(pos, scacchiera);	
			return moves;
		}
		else return new int[8][8];
	}
	
	/**
	 * Metodo che ritorna le mosse possibili come ArrayList, usato in scacco() e scaccoMatto() 
	 * per evitare di complicare ulteriormente il codice e per motivi di efficenza
	 * 
	 * @param pos la posizione della pedina
	 * @return ArrayList con le mosse disponibili della pedina in posizione pos
	 */
	public ArrayList<Position> getMovesArrayList(Position pos){
		ArrayList<Position> mosse=new ArrayList<Position>();
		if(scacchiera[pos.getRiga()][pos.getColonna()].getColore().equals(turno)){
			int[][] moves= scacchiera[pos.getRiga()][pos.getColonna()].mossePossibili(pos, scacchiera);
			for(int i=0;i<moves.length;i++)
				for(int j=0;j<moves[0].length;j++){
					if(moves[i][j]!=0){
						mosse.add(new Position(i, j));
					}
				}
		}
		
		return mosse;
	}
		
	
	/**
	 * 
	 * @param partenza: posizione attuale della pedina
	 * @param arrivo: posizione di arrivo, pur avendo una posizione tra le mosse disponibili già valida, 
	 * è stato aggiunto il controllo per coerenza 
	 * @param ps pannello della scacchiera, per il repaint()
	 * @return true se sono riuscito a muovere, altrimenti c'è stato un errore, ad esempio se il mio re è sotto scacco
	 */
	public boolean move(Position partenza,Position arrivo,PanelScacchiera ps){
		
		if(!canMove(partenza, arrivo)){	//se non può muovere, non fa niente
			JOptionPane.showMessageDialog(null,"Mossa non valida, metterebbe il re sotto scacco!","Mossa non valida",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(getMoves(partenza)[arrivo.getRiga()][arrivo.getColonna()] == 0){	//mossa non valida
			return false;
		}
		
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()] != null){
			mangiate[countMangiate] = scacchiera[arrivo.getRiga()][arrivo.getColonna()];
			countMangiate++;
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		
		//qundo muovo, controllo se il pedone si evolve
		if(turno==Colore.BIANCO && scacchiera[arrivo.getRiga()][arrivo.getColonna()] instanceof Pedone && arrivo.getRiga()==0){
			evoluzionePedone(new Position(arrivo.getRiga(),arrivo.getColonna()),ps);
			ps.setEnabled(false);
			ps.revalidate();
			ps.repaint();
		}
		
		if(turno==Colore.NERO && scacchiera[arrivo.getRiga()][arrivo.getColonna()] instanceof Pedone && arrivo.getRiga()==7){
			evoluzionePedone(new Position(arrivo.getRiga(),arrivo.getColonna()),ps);
			ps.setEnabled(false);
			ps.revalidate();
			ps.repaint();
		}
		
		//se non ho provocato lo scacco, passo il turno
		if(turno.equals(Colore.BIANCO))turno=Colore.NERO;
		else{turno=Colore.BIANCO;}
		
		return true;
	}
	
	
	/**
	 * Simula la mossa e verifica se provoca scacco al re del proprio colore
	 * successivamente ripristina la situazione precedente
	 * 
	 * @param partenza la posizione di partenza per poter provare a muovere
	 * @param arrivo la posizione di arrivo
	 * @return true se posso muovere senza mettere sotto scacco il mio re
	 */
	public boolean canMove(Position partenza,Position arrivo){
		boolean mangiato = false;
		boolean canMove = true;
		Pedina p = null;
		if(scacchiera[arrivo.getRiga()][arrivo.getColonna()] != null){
			mangiato = true;
			p=scacchiera[arrivo.getRiga()][arrivo.getColonna()];
		}
		scacchiera[arrivo.getRiga()][arrivo.getColonna()]=scacchiera[partenza.getRiga()][partenza.getColonna()];
		scacchiera[partenza.getRiga()][partenza.getColonna()]=null;
		
		//controllo se la mossa provoca lo scacco del re con lo stesso colore

		if(turno==Colore.BIANCO){
			if(scacco()==1)canMove = false;
		}else{
			if(scacco()==-1)canMove = false;
		}
		
		//rollback, ripristino la situazione precedente alla mossa
		scacchiera[partenza.getRiga()][partenza.getColonna()]=scacchiera[arrivo.getRiga()][arrivo.getColonna()];
		scacchiera[arrivo.getRiga()][arrivo.getColonna()] = null;
		if(mangiato){
			scacchiera[arrivo.getRiga()][arrivo.getColonna()] = p;
		}
		return canMove;
	}
	
	/**
	 * @return il turno corrente
	 */
	public Colore getTurno(){return turno;}
	
	/**
	 * @return Pedina[], array di pedine mangiate fino ad ora
	 */
	public Pedina[] getPedineMangiate(){
		return mangiate;
	}
	
	/**
	 * @param pos la posizione attuale, dove devo evolvere la pedina
	 * @param ps il pannello della scacchiera, serve per poter fare il repaint() una volta modificata la scacchiera
	 */
	public void evoluzionePedone(Position pos,PanelScacchiera ps){
			FrameSceltaPedina fsp=new FrameSceltaPedina(turno,this,pos,ps);
			fsp.setVisible(true);
	}
	
	/**
	 * Cerca i re nella scacchiera e controlla se, nelle mosse possibili delle pedine avversarie, è presente il re.  
	 * @return 1 se il re bianco è sotto scacco, -1 se il re nero è sotto scacco, 0 se non è sotto scacco nessun re
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

		int [][] mosPos = null;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j] != null){
					if(scacchiera[i][j].getColore() == Colore.NERO){				//controllo se la pedina che dà scacco è di colore nero
						mosPos = scacchiera[i][j].mossePossibili(new Position(i, j),scacchiera);
						if(mosPos[reBianco.getRiga()][reBianco.getColonna()] == 2)		//se è uguale alla posizione del re bianco, allora il re sarà sotto scacco
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

		return 0;
	}
	
	/**
	 * Funzione chiamata solo in caso di scacco, prova tutte le mosse possibili del re
	 * se ne trova una dove non è sotto scacco, significa che non è scacco matto, ma non è sufficente
	 * bisogna anche controllare che nessun'altra pedina possa salvare il re
	 * 
	 * @return true se il giocatore del turno corrente è sotto scacco matto
	 */
	public boolean scaccoMatto(){
		
		Position re = null;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(scacchiera[i][j] != null && scacchiera[i][j] instanceof Re && scacchiera[i][j].getColore() == turno){
					re=new Position(i,j);
				}
			}
		}
		
		ArrayList<Position> mosseRe= getMovesArrayList(re);
		for(Position p:mosseRe){
			if(canMove(re,p))return false;
		}
			//il re non ha mosse possibili
			if(!salvataggioRe())
				return true;
			else
				return false;
		}

	/**
	 * Metodo per controllare che nessuna pedina possa salvare il re
	 * @return true solo se con una mossa posso fare in modo che il re non sia più sotto scacco
	 */
	public boolean salvataggioRe(){
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				if(scacchiera[i][j]!=null && scacchiera[i][j].getColore().equals(turno)){
					//per ogni mia pedina, se posso salvare il re
					ArrayList<Position> r=getMovesArrayList(new Position(i, j));
					for(Position p:r){
						if(turno==Colore.BIANCO){
							if(canMove(new Position(i, j), p) && scacco()!=1)
								//se true, esiste una mossa che mi salva dallo scacco
								return true;
						}else{
							if(canMove(new Position(i, j), p) && scacco()!=-1)
								//se true, esiste una mossa che mi salva dallo scacco
								return true;
						}
					}
				}
			}
		return false;
	}
	
	/**
	 * Metodo per inizializzare la scacchiera
	 * @return void  
	 * Modifica direttamente la scacchiera, e viene chiamato anche in caso si volesse ricominciare una nuova partita
	 */
	public void restart() {
		scacchiera = new Pedina[8][8];
		mangiate = new Pedina[32];
		countMangiate = 0;
		turno = Colore.BIANCO;
		// carico la squadra nera
		scacchiera[0][0] = new Torre(Colore.NERO);
		scacchiera[0][1] = new Cavallo(Colore.NERO);
		scacchiera[0][2] = new Alfiere(Colore.NERO);
		scacchiera[0][3] = new Regina(Colore.NERO);
		scacchiera[0][4] = new Re(Colore.NERO);
		scacchiera[0][5] = new Alfiere(Colore.NERO);
		scacchiera[0][6] = new Cavallo(Colore.NERO);
		scacchiera[0][7] = new Torre(Colore.NERO);
		for (int i = 0; i < 8; i++)
			scacchiera[1][i] = new Pedone(Colore.NERO);

		// carico la squadra bianca
		scacchiera[7][0] = new Torre(Colore.BIANCO);
		scacchiera[7][1] = new Cavallo(Colore.BIANCO);
		scacchiera[7][2] = new Alfiere(Colore.BIANCO);
		scacchiera[7][3] = new Regina(Colore.BIANCO);
		scacchiera[7][4] = new Re(Colore.BIANCO);
		scacchiera[7][5] = new Alfiere(Colore.BIANCO);
		scacchiera[7][6] = new Cavallo(Colore.BIANCO);
		scacchiera[7][7] = new Torre(Colore.BIANCO);

		for (int i = 0; i < 8; i++)
			scacchiera[6][i] = new Pedone(Colore.BIANCO);

	}
}
