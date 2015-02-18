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
		
		fsp.setScacchiera(scacchiera);
		fsp.setVisible(false);

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
	}
}
