package scacchi;

public class Position {
	
	private int riga;
	private int colonna;

	public Position(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	/**
	 * 
	 * @return riga il numero di riga
	 */
	public int getRiga(){
		return riga;
	}
	/**
	 * 
	 * @return colonna il numero della colonna
	 */
	public int getColonna(){
		return colonna;
	}
	
}
