package scacchi.grafica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Position;
import scacchi.Scacchiera;

/**
 * Classe che visualizza la scacchiera
 * 
 * @author Tommaso Dal Fior, Marco De Stefani, Davide Miglioranzi
 *
 */
public class PanelScacchiera extends JComponent {
	
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
	
	int evid[][];
	boolean evidenziate;
	Scacchiera scacchiera;
	Position oldPos;;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Imposta le caselle da evidenziare
	 * 
	 * @param evidenziate array di caselle da evidenziare
	 * @param evidenz true = evidenzia, false = togli evidenziato
	 */
	public void setEvidenziate(int evidenziate[][], boolean evidenz){
		this.evid=evidenziate;this.evidenziate=evidenz;
	}
	
	/**
	 * @return array con la posizione delle caselle evidenziate
	 */
	public int[][] getEvidenziate(){
		return this.evid;
	}
	
	/**
	 * Costruttore del pannello della scacchiera
	 * 
	 * @param scacchiera la struttura dati della scacchiera
	 */
	public PanelScacchiera(Scacchiera scacchiera) {
		this.scacchiera = scacchiera;	
		Dimension d=new Dimension(400,400);
		setSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
		setMinimumSize(d);
		setLayout(null);
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
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
						// non fare nulla
					}
				}
			}
		}

		// continuazione, devo disegnare le pedine
		stampaPedine(g);
	}

	// metodo che stampa le pedine

	/**
	 * disegna le pedine
	 * 
	 * @param g graphics del pannello
	 */
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
					if (p != null && p.getColore().equals(Colore.NERO)) {
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
