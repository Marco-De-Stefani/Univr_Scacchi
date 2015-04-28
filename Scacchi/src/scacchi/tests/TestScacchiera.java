package scacchi.tests;

import org.junit.Assert;
import org.junit.Test;

import scacchi.Colore;
import scacchi.Nome;
import scacchi.Position;
import scacchi.Scacchiera;

/**
 * Classe di test per i principali metodi della classe Scacchiera
 * 
 * @author Tommaso Dal Fior, Marco De Stefani, Davide Miglioranzi
 *
 */

public class TestScacchiera {

	@Test
	public void testGetPedina() {
		Scacchiera scacchiera = new Scacchiera(false);
		
		Assert.assertTrue(scacchiera.getPedina(new Position(0,0)).getNome().equals(Nome.TORRE)
				&& scacchiera.getPedina(new Position(0,0)).getColore().equals(Colore.NERO));
		
		Assert.assertTrue(scacchiera.getPedina(new Position(7,0)).getNome().equals(Nome.TORRE)
				&& scacchiera.getPedina(new Position(7,0)).getColore().equals(Colore.BIANCO));
	}
	
	
	@Test
	public void testGetMoves() {
		Scacchiera scacchiera = new Scacchiera(true);
		int [][] mosse = new int[8][8];
		
		mosse = scacchiera.getMoves(new Position(0,3));
		Assert.assertFalse(mosse[1][3] == 1);	//muovono prima le pedine bianche
		
		mosse = scacchiera.getMoves(new Position(5,6));
		Assert.assertFalse(mosse[1][3] == 1);
		Assert.assertTrue(mosse[1][2] == 1);
		Assert.assertTrue(mosse[4][7] == 2);
	}
	
	
	@Test
	public void testMove() {
		Scacchiera scacchiera = new Scacchiera(false);
		
		Assert.assertFalse(scacchiera.move(new Position(1,2), new Position(2,2), null));
		Assert.assertTrue(scacchiera.move(new Position(6,2), new Position(5,2), null));
		Assert.assertFalse(scacchiera.move(new Position(1,2), new Position(5,2), null));
		Assert.assertTrue(scacchiera.move(new Position(1,2), new Position(2,2), null));
	}
	
	
	@Test
	public void testCanMove() {
		Scacchiera scacchiera = new Scacchiera(true);
		Assert.assertFalse(scacchiera.canMove(new Position(5,6), new Position(4,5)));
		Assert.assertTrue(scacchiera.canMove(new Position(7,3), new Position(7,4)));
	}
	
	
	@Test
	public void testScacco() {
		Scacchiera scacchiera = new Scacchiera(true);
		
		Assert.assertTrue(scacchiera.scacco() == 1);	//scacco a re bianco
		
		scacchiera.move(new Position(7,3), new Position(7,4), null);
		Assert.assertTrue(scacchiera.scacco() == 0);	//nessuno scacco
		
		scacchiera.move(new Position(0,3), new Position(1,3), null);
		scacchiera.move(new Position(5,6), new Position(6,5), null);
		scacchiera.move(new Position(1,3), new Position(2,3), null);
		scacchiera.move(new Position(6,5), new Position(5,6), null);
		Assert.assertTrue(scacchiera.scacco() == -1);	//scacco a re nero
	}
	
	
	@Test
	public void testScaccoMatto() {
		Scacchiera scacchiera = new Scacchiera(true);
		
		scacchiera.move(new Position(7,3), new Position(6,2), null);
		scacchiera.move(new Position(4,7), new Position(6,7), null);
		scacchiera.move(new Position(6,2), new Position(5,1), null);
		scacchiera.move(new Position(6,7), new Position(6,1), null);
		Assert.assertTrue(scacchiera.scaccoMatto());
	}
	
	
	
}
