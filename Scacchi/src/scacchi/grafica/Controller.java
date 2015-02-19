package scacchi.grafica;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
					System.out.println("x=" + x + " y=" + y);
					evidenziate = true;
					oldPos = new Position(x, y);				//salvo la posizione attuale
					ps.setEvidenziate(scacchiera.getMoves(new Position(x, y)),evidenziate);
					ps.repaint();
				} else {
					System.out.println("caso 2");
					//caso evidenziate = true
					if (ps.getEvidenziate()[x][y] != 0) {
						//se la posizione (x,y) è permessa (codici 1 o 2, no 0)
						if (scacchiera.move(oldPos, new Position(x, y),ps) == true) {
							//se mangio
							pi.setPedineMangiate(scacchiera.getPedineMangiate());
							pi.repaint();
							//ps.repaint();
						}
						//il metodo move() passa il turno, quindi bisogna cancellare le caselle evidenziate
						ps.setEvidenziate(new int[8][8],evidenziate);
						ps.repaint();
						evidenziate = false;
					} else {
						System.out.println("caso 3");
						//se la posizione (x,y) non è permessa (codice 0)
						if (scacchiera.getScacchiera()[x][y] != null &&
								scacchiera.getScacchiera()[x][y].getColore().equals(scacchiera.getTurno())) {
							//System.out.println("x1=" + x + " y1=" + y);
							evidenziate = true;
							oldPos = new Position(x, y);
							ps.setEvidenziate(scacchiera.getMoves(new Position(x, y)),evidenziate);
							ps.repaint();
						} else {
							System.err.println("ERRORACCIO; tentativo invalido di mossa");
							ps.repaint();
						}
					}
					//evidenziate = false;
				}
				
				
				
			}
		});
	}
}
