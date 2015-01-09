package scacchi.grafica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Position;
import scacchi.Scacchiera;

public class FrameScacchiera extends JPanel {
	private Image re=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Re.png").getImage();
	private Image regina=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\regina.png").getImage();
	private Image alfiere=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Alfiere.png").getImage();
	private Image torre=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Torre.png").getImage();
	private Image cavallo=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Cavallo.png").getImage();
	private Image pedone=new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Pedone.png").getImage();
	private Image img;
	
	int evid[][] = new int[8][8];
	int x, y;
	Scacchiera scacchiera = new Scacchiera();

	private static final long serialVersionUID = 1L;



	public FrameScacchiera(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getHeight(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				x /= 50;
				y /= 50;
				x = x % 50;
				y = y % 50;
				// val da passare al miglio (0<x<8 0<y<8)
				System.out.println("x=" + x + " y=" + y);
				Position attuale = new Position(x, y);
				// TODO: call metodo migliuz
				repaint();
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);

		// evidenzio le caselle
		for (int i = 0; i < evid.length; i++) {
			for (int j = 0; j < evid[0].length; j++) {
				switch (evid[i][j]) {
				case 1:// colora di verde
					int x1 = x * 50 + 25;
					int y1 = y * 50 + 25;

					break;
				case 2:// colora di rosso
					break;
				default:
					// nothing
				}
			}
		}

		// continuazione, devo mettere le pedine, altro metodo
		stampaPedine(g);
	}

	private void stampaPedine(Graphics g){
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				Pedina p=scacchiera.getPedina(i,j);
				int x1 = j * 50 ;
				int y1 = i * 50 ;
				
				if(p!=null){
					switch(p.getNome()){
						case RE:
							g.drawImage(re, x1, y1, null);
							break;
						case REGINA:
							g.drawImage(regina, x1, y1, null);
							break;
						case ALFIERE:
							g.drawImage(alfiere, x1, y1, null);
							break;
						case TORRE:
							g.drawImage(torre, x1, y1, null);
							break;
						case CAVALLO:
							g.drawImage(cavallo, x1, y1, null);
							break;
						case PEDONE:
							g.drawImage(pedone, x1, y1, null);
							break;
					}
					}
			}
		}
		
	}
}
