package scacchi.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import scacchi.Colore;
import scacchi.Nome;
import scacchi.Position;
import scacchi.Scacchiera;

public class TestScacchiera {

	@Test
	public void testGetPedina() {
		Scacchiera scacchiera = new Scacchiera();
		
		Assert.assertTrue(scacchiera.getPedina(new Position(0,0)).getNome().equals(Nome.TORRE)
				&& scacchiera.getPedina(new Position(0,0)).getColore().equals(Colore.NERO));
		
		Assert.assertTrue(scacchiera.getPedina(new Position(7,0)).getNome().equals(Nome.TORRE)
				&& scacchiera.getPedina(new Position(7,0)).getColore().equals(Colore.BIANCO));
	}
	
	
	@Test
	public void testGetMoves() {
		Scacchiera scacchiera = new Scacchiera();
		int [][] mosse = scacchiera.getMoves(new Position(1,0));
		System.out.println(mosse[2][0]);
		//Assert.assertTrue(mosse[2][0] == 1);
		//Assert.assertFalse(mosse[2][0] == 2);
		//Assert.assertFalse(mosse[2][0] == 0);
		//Assert.assertFalse(mosse[3][0] == 1);
	}

}
