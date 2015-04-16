package scacchi;



public abstract class Pedina {

	private final Nome nome;
	private final Colore colore;
	
	protected static int nRighe = 8;
	protected static int nColonne = 8;
	/**
	 * 
	 * Costruttore della classe Pedina 
	 * @param nome
	 * @param colore
	 */
	public Pedina(Nome nome, Colore colore){
		this.nome = nome;
		this.colore = colore;
	}
	
	/**
	 * 
	 * @return nome, il nome della pedina
	 */
	public Nome getNome(){
		return this.nome;
	}
	/**
	 * 
	 * @return colore, il colore della pedina
	 */
	public Colore getColore(){
		return this.colore;
	}
	/**
	 * 
	 * @param posPedina
	 * @param scacchiera
	 * @return matrice che indica le mosse possibili della pedina
	 * 		0 se NON si può muovere
	 * 		1 se può fare la mossa
	 * 		2 se può mangiare
	 */
	public abstract int[][] mossePossibili(Position posPedina, Pedina[][] scacchiera);
}
