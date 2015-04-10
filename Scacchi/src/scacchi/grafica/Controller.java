package scacchi.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import scacchi.Colore;
import scacchi.Position;
import scacchi.Scacchiera;

public class Controller {

	boolean evidenziate = false;
	Position oldPos;
	
	public Controller(PanelScacchiera ps, PanelInformazioni pi, Scacchiera scacchiera) {
		// listener dela scacchiera
		ps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Atttenzione! Le coordinate sono invertite
				int y = e.getX();
				int x = e.getY();
				x /= 50;
				y /= 50;
				
				if (!evidenziate) {
					System.out.println("caso 1");
					if(scacchiera.getScacchiera()[x][y] == null){	//se clicco in un punto vuoto
						System.out.println("caso null");
						return;
					}
					//caso iniziale, si sceglie la pedina da muovere (evidenziate = false)
					evidenziate = true;
					oldPos = new Position(x, y);				//salvo la posizione attuale
					ps.setEvidenziate(scacchiera.getMoves(new Position(x, y)),evidenziate);
					ps.repaint();
				} else {
					//caso evidenziate = true
					if (ps.getEvidenziate()[x][y] != 0) {
						//se la posizione (x,y) è permessa (codici 1 o 2, no 0)
						if (scacchiera.move(oldPos, new Position(x, y),ps) == true) {
							//se mangio
							pi.setPedineMangiate(scacchiera.getPedineMangiate());
							pi.repaint();
						}
						//il metodo move() passa il turno, quindi bisogna cancellare le caselle evidenziate
						ps.setEvidenziate(new int[8][8],evidenziate);
						ps.repaint();
						evidenziate = false;
					} else {
						//se la posizione (x,y) non è permessa (codice 0)
						if (scacchiera.getScacchiera()[x][y] != null &&
								scacchiera.getScacchiera()[x][y].getColore().equals(scacchiera.getTurno())) {
							//System.out.println("x1=" + x + " y1=" + y);
							evidenziate = true;
							oldPos = new Position(x, y);
							ps.setEvidenziate(scacchiera.getMoves(new Position(x, y)),evidenziate);
							ps.repaint();
						} else {
							System.err.println("ERRORE; tentativo invalido di mossa");
							ps.repaint();
						}
					}
					
					
					int scacco=scacchiera.scacco();
					boolean sm=false;
					if(scacco!=0){
						sm=scacchiera.scaccoMatto();
						pi.setScacco(true);
					}else{
						pi.setScacco(false);
					}
					if(scacco!=0 && sm){
						Colore turno;
						//se c'è scacco matto, ha vinto l'avversario
						if (scacchiera.getTurno().equals(Colore.BIANCO))
							turno = Colore.NERO;
						else {
							turno = Colore.BIANCO;
						}
						int jop=JOptionPane.showConfirmDialog(null,"Complimenti giocatore " +turno+" hai vinto la partita! \n vuoi rifarne un altra?","Scacco Matto",JOptionPane.YES_NO_OPTION);

						
						if(jop==0){
							scacchiera.restart();
							ps.repaint();
							pi.repaint();
						}else{System.exit(0);}
					}

				}
				
				
				
			}
		});

		
		pi.jBrestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Sicuro di voler iniziare una nuova partita?","Nuova partita",JOptionPane.YES_NO_OPTION);
				if(a==0){
					scacchiera.restart();
					pi.repaint();
					ps.repaint();
				}
			}
		});
	}
}
