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

	public Controller(PanelScacchiera ps, PanelInformazioni pi,
			FrameSceltaPedina fsp, Scacchiera scacchiera) {

		fsp.setVisible(true);

		// listener dela scacchiera
		ps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int y = e.getX();
				int x = e.getY();
				x /= 50;
				y /= 50;
				if (!evidenziate && scacchiera.getScacchiera()[x][y] != null) {
					System.out.println("x=" + x + " y=" + y);
					evidenziate = true;
					oldPos = new Position(x, y);
					ps.setEvidenziate(scacchiera.getMoves(new Position(x, y)),
							evidenziate);
					ps.repaint();
				} else {
					if (ps.getEvidenziate()[x][y] != 0) {
						if (scacchiera.move(oldPos, new Position(x, y)) == true) {
							pi.setPedineMangiate(scacchiera.getPedineMangiate());
							pi.repaint();
						}
						ps.setEvidenziate(
								scacchiera.getMoves(new Position(x, y)),
								evidenziate);
						ps.repaint();
					} else {
						if (scacchiera.getScacchiera()[x][y].getColore()
								.equals(scacchiera.getTurno())) {
							System.out.println("x1=" + x + " y1=" + y);
							evidenziate = true;
							oldPos = new Position(x, y);
							ps.setEvidenziate(
									scacchiera.getMoves(new Position(x, y)),
									evidenziate);
							ps.repaint();
						} else {
							System.err
									.println("ERRORACCIO; tentativo invalido di mossa");
						}
					}
					evidenziate = false;
				}
			}
		});

		// altro?

		// questa cosa funziona, vedere il metodo fsp.getContentPane.list() che
		// stampa la gerarchia
		PanelSceltaPedina pspp = (PanelSceltaPedina) fsp.getContentPane()
				.getComponents()[0];
		Component[] components = ((JPanel) pspp.getComponents()[1])
				.getComponents();

		for (Component c : components) {
			if (c instanceof JButton) {
				JButton b = (JButton) c;
				System.out.println(b.getName());

				  b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { 
				  //nomi bottoni:
				  //alfiere.cavallo.regina.torre
					  if(b.getName().equals("alfiere"))scacchiera.setPedinaPromozione(0);
					  if(b.getName().equals("cavallo"))scacchiera.setPedinaPromozione(1);
					  if(b.getName().equals("regina"))scacchiera.setPedinaPromozione(2);
					  if(b.getName().equals("torre"))scacchiera.setPedinaPromozione(3);
					  notifyAll();
				 } 
				  });
				 
			}
		}
	}
}
