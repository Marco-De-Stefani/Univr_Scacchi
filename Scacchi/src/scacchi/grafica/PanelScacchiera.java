package scacchi.grafica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Position;
import scacchi.Scacchiera;

public class PanelScacchiera extends JComponent {
	private String basePath = new File("").getAbsolutePath();
	
	private Image re_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\re_b.png")).getImage();
	private Image regina_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\regina_b.png")).getImage();
	private Image alfiere_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\alfiere_b.png")).getImage();
	private Image torre_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\torre_b.png")).getImage();
	private Image cavallo_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\cavallo_b.png")).getImage();
	private Image pedone_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\pedone_b.png")).getImage();
	
	private Image re_nero = new ImageIcon(this.getClass().getResource("\\immagini\\re_n.png")).getImage();
	private Image regina_nero = new ImageIcon(this.getClass().getResource("\\immagini\\regina_n.png")).getImage();
	private Image alfiere_nero = new ImageIcon(this.getClass().getResource("\\immagini\\alfiere_n.png")).getImage();
	private Image torre_nero = new ImageIcon(this.getClass().getResource("\\immagini\\torre_n.png")).getImage();
	private Image cavallo_nero = new ImageIcon(this.getClass().getResource("\\immagini\\cavallo_n.png")).getImage();
	private Image pedone_nero = new ImageIcon(this.getClass().getResource("\\immagini\\pedone_n.png")).getImage();
	
	private Image evid_rosso = new ImageIcon(this.getClass().getResource("\\immagini\\ev_rosso.png")).getImage();
	private Image evid_verde = new ImageIcon(this.getClass().getResource("\\immagini\\ev_verde.png")).getImage();

	private Image img= new ImageIcon(this.getClass().getResource("\\immagini\\scacchiera.png")).getImage();
	//private Image img= new ImageIcon("..\\immagini\\scacchiera.png").getImage();;
	// caselle evidenziate, x e y del click, scacchiera (passata dal frame)
	
	int evid[][];
	boolean evidenziate=false;
	int x, y;
	Scacchiera scacchiera;
	Position oldPos;;
	
	private static final long serialVersionUID = 1L;

	public PanelScacchiera(Scacchiera scacchiera) {
		
		this.scacchiera = scacchiera;
		
		Dimension size = new Dimension(img.getHeight(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				y = e.getX();
				x = e.getY();
				x /= 50;
				y /= 50;
				//x = x % 50;
				//y = y % 50; non serve a una sega, perchè ci sono?
				if (!evidenziate) {
					System.out.println("x=" + x + " y=" + y);
					oldPos=new Position(x, y);
					evid = scacchiera.getMoves(oldPos);
					evidenziate = true;
					repaint();
				} else {
					if(evid[x][y]!=0){
						scacchiera.move(oldPos, new Position(x, y));
						repaint();
					}else{
						System.err.println("ERRORACCIO; tentativo invalido di mossa");
					}
					evidenziate=false;
				}
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
		//metodo miglio riceve le mosse possibili
		
		if (evidenziate) {
			// evidenzio le caselle
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					switch (evid[i][j]) {
					case 1:// colora di verde
						g.drawImage(evid_verde, j * 50, i * 50, null);
						break;
					case 2:// colora di rosso
						g.drawImage(evid_rosso, j * 50, i * 50, null);
						break;
					default:
						// nothing
					}
				}
			}
		}

		// continuazione, devo mettere le pedine, altro metodo
		stampaPedine(g);
	}

	// metodo che stampa le pedine

	private void stampaPedine(Graphics g) {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Pedina p = scacchiera.getPedina(new Position(i, j));
				int x1 = j * 50;
				int y1 = i * 50;

				if (p != null && p.getColore().equals(Colore.BIANCO)) {//
					switch (p.getNome()) {
					case RE:
						g.drawImage(re_bianco, x1, y1, null);
						break;
					case REGINA:
						g.drawImage(regina_bianco, x1, y1, null);
						break;
					case ALFIERE:
						g.drawImage(alfiere_bianco, x1, y1, null);
						break;
					case TORRE:
						g.drawImage(torre_bianco, x1, y1, null);
						break;
					case CAVALLO:
						g.drawImage(cavallo_bianco, x1, y1, null);
						break;
					case PEDONE:
						g.drawImage(pedone_bianco, x1, y1, null);
						break;
					}
				}
				else{
					if (p != null && p.getColore().equals(Colore.NERO)) {//
						switch (p.getNome()) {
						case RE:
							g.drawImage(re_nero, x1, y1, null);
							break;
						case REGINA:
							g.drawImage(regina_nero, x1, y1, null);
							break;
						case ALFIERE:
							g.drawImage(alfiere_nero, x1, y1, null);
							break;
						case TORRE:
							g.drawImage(torre_nero, x1, y1, null);
							break;
						case CAVALLO:
							g.drawImage(cavallo_nero, x1, y1, null);
							break;
						case PEDONE:
							g.drawImage(pedone_nero, x1, y1, null);
							break;
						}
					}
				}
			}
		}

	}

}
