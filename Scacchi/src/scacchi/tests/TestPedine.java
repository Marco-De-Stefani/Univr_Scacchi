package scacchi.tests;

import org.junit.Assert;
import org.junit.Test;

import scacchi.Alfiere;
import scacchi.Cavallo;
import scacchi.Pedone;
import scacchi.Position;
import scacchi.Re;
import scacchi.Regina;
import scacchi.Scacchiera;
import scacchi.Torre;

public class TestPedine {
	
	Scacchiera s=new Scacchiera(true);
	
	@Test
	public void testMossePossibiliAlfiere() {
		Alfiere a=(Alfiere) s.getPedina(new Position(5,6));
		int mosse[][]=a.mossePossibili(new Position(5,6), s.getScacchiera());
		Assert.assertTrue(mosse[6][5]==1);
		Assert.assertTrue(mosse[6][7]==1);
		for(int i=0;i<5;i++){
			Assert.assertTrue(mosse[i][i+1]==1);
		}
		Assert.assertTrue(mosse[4][7]==2);
	}
	
	@Test
	public void testMossePossibiliPedone() {
		Pedone p=(Pedone) s.getPedina(new Position(3, 0));
		int[][] mosse=p.mossePossibili(new Position(3, 0), s.getScacchiera());
		Assert.assertTrue(mosse[2][0]==1 && mosse[2][1]==2);
	}
	
	@Test
	public void testMossePossibiliTorre() {
		Torre t=(Torre) s.getPedina(new Position(4,7));
		int mosse[][]=t.mossePossibili(new Position(4,7), s.getScacchiera());
		for(int i=0;i<3;i++){
			Assert.assertTrue(mosse[i][7]==1);
		}
		for(int i=5;i<7;i++){
			Assert.assertTrue(mosse[i][7]==1);
		}
		for(int i=4;i<6;i++){
			Assert.assertTrue(mosse[4][i]==1);
		}
	}


	@Test
	public void testMossePossibiliCavallo() {
		Cavallo t=(Cavallo) s.getPedina(new Position(5,0));
		int mosse[][]=t.mossePossibili(new Position(5,0), s.getScacchiera());
		Assert.assertTrue(mosse[3][1]==1);
		Assert.assertTrue(mosse[7][1]==1);
	}

	@Test
	public void testMossePossibiliRe() {
		Re t=(Re) s.getPedina(new Position(0,3));
		int mosse[][]=t.mossePossibili(new Position(0,3), s.getScacchiera());
		Assert.assertTrue(mosse[0][2]==1);
		Assert.assertTrue(mosse[0][4]==1);
		Assert.assertTrue(mosse[1][2]==1);
		Assert.assertTrue(mosse[1][3]==1);
		Assert.assertTrue(mosse[1][4]==1);
	}
	
	@Test
	public void testMossePossibiliRegina() {
		Regina t=(Regina) s.getPedina(new Position(4,3));
		int mosse[][]=t.mossePossibili(new Position(4,3), s.getScacchiera());
		for(int i=1;i<7;i++){
			if(i!=4)
				Assert.assertTrue(mosse[i][3]==1);
		}
		for(int i=0;i<7;i++){
			if(i!=3)
				Assert.assertTrue(mosse[4][i]==1);
		}
		Assert.assertFalse(mosse[4][7]==1);
	}
	
	
	
}
