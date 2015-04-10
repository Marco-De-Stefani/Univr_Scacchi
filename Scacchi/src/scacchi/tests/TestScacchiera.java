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
		int [][] mosse = new int[8][8];
		
//		for(int i = 0; i<8; i++){
//			for(int j = 0; j<8; j++)
//				System.out.print(mosse[i][j] + "-");
//			System.out.println();
//		}
		mosse = scacchiera.getMoves(new Position(1,1));
		Assert.assertFalse(mosse[2][1] == 1);	//muovono prima le pedine bianche
		
		mosse = scacchiera.getMoves(new Position(6,1));
		Assert.assertTrue(mosse[5][1] == 1);
		
	}
	
	
	@Test
	public void testMove() {
		Scacchiera scacchiera = new Scacchiera();
		
		Assert.assertTrue(scacchiera.move(new Position(1,2), new Position(5,2), null));
		//Assert.assertTrue(scacchiera.move(new Position(6,2), new Position(5,2), null));
	}

}
