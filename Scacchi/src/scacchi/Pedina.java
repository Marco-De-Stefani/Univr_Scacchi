package scacchi;

import java.util.ArrayList;


public abstract class Pedina {

	private final Nome nome;
	private final Colore colore;
	
	protected static int nRows = 8;
	protected static int nColumns = 8;
	
	public Pedina(Nome nome, Colore colore){
		this.nome = nome;
		this.colore = colore;
	}
	
	public Nome getNome(){
		return this.nome;
	}
	
	public Colore getColore(){
		return this.colore;
	}
	
	/**
	 * 
	 * @param riga | la riga dove si trova la pedina
	 * @param colonna | la colonna dove si trova la pedina
	 * @return ArrayList di pinti dove la pedina può spostarsi
	 */
	public abstract ArrayList<Position> possibleMoves(int riga, int colonna);
	
	
}
