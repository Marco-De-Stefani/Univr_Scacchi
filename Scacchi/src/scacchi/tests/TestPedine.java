package scacchi.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import scacchi.Alfiere;
import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Position;

public class TestPedine {

	@Test
	public void testMossePossibiliAlfiere() {
		Alfiere a=new Alfiere(Colore.BIANCO);
		int[][] mosse=a.mossePossibili(new Position(0, 0), new Pedina [8][8]);
		for(int i=1;i<8;i++){
			Assert.assertTrue(mosse[i][i]==1);
		}
	}

}
