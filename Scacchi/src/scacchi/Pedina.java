package scacchi;

import java.util.ArrayList;


public abstract class Pedina {

	private final Nome nome;
	private final Colore colore;
	
	protected static int nRighe = 8;
	protected static int nColonne = 8;
	
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
	
	public abstract int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera);
}
