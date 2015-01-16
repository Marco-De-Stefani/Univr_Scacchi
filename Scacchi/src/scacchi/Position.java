package scacchi;

public class Position {
	
	private int riga;
	private int colonna;

	public Position(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	
	public int getRiga(){
		return riga;
	}
	
	public int getColonna(){
		return colonna;
	}
	
}
