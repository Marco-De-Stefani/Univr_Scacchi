package scacchi.grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Scacchiera;

/**
 * Classe che visualizza le informazioni di base della partita e permette mediante l'uso di un bottone di
 * cominciare una nuova partita
 * 
 * @author Tommaso Dal Fior, Marco De Stefani, Davide Miglioranzi
 *
 */
public class PanelInformazioni extends JComponent {

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

	private Image sfondo = new ImageIcon(this.getClass().getResource("\\immagini\\sfondo_info.png")).getImage();
    private Image imgScacco = new ImageIcon(this.getClass().getResource("\\immagini\\imgScacco.png")).getImage();

	private int n1 = 0, n2 = 0;
	Scacchiera scacchiera;
	String nome1, nome2;
	Pedina[] mangiate;
	JLabel jLn1 = new JLabel();
	JLabel jLn2 = new JLabel();
	JButton jBrestart = new JButton();

	Color c1 = Color.RED;
	Color c2 = Color.GREEN;
	boolean scacco;

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore del pannello delle informazioni
	 * 
	 * @param sccacchiera la struttura dati usata per memorizzare la situazione corrente della scacchiera
	 * @param n1 il nome del giocatore 1
	 * @param n2 il nome del giocatore 2
	 */
	public PanelInformazioni(Scacchiera scacchiera, String n1, String n2) {
		mangiate = new Pedina[32];
		this.nome1 = n1;
		this.nome2 = n2;
		this.scacchiera = scacchiera;
		setSize(new Dimension(400,400));
		setLayout(null);

		jLn1.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn1.setText(nome1);
		jLn1.setBounds(new Rectangle(10, 290, 100, 40));

		jLn2.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn2.setText(nome2);
		jLn2.setBounds(new Rectangle(10, 0, 100, 40));

		jLn1.setForeground(new Color(255, 255, 218));
		jLn2.setForeground(new Color(45, 34, 23));

		jBrestart.setBounds(new Rectangle(270, 150, 100, 80));
		jBrestart.setText("Ricomincia");

		add(jBrestart);
		add(jLn1);
		add(jLn2);
		repaint();

	}

	/**
	 * Imposta le pedine mangiate
	 * 
	 * @param mangiate l'array di pedine mangiate
	 */
	public void setPedineMangiate(Pedina[] mangiate) {
		this.mangiate = mangiate;
	}

	/**
	 * Usato per impostare la scritta "scacco" senza dover ogni volta richiamare il metodo scacco
	 * 
	 * @param scacco un booleano che indica se c'è scacco
	 */
	public void setScacco(boolean scacco) {
		this.scacco = scacco;
	}

	/**
	 * Disegna le pedine mangiate e alcune informazioni
	 */
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(sfondo, 0, 0, 400, 400, null);

		if (scacchiera.getTurno() == Colore.BIANCO) {
			g.setColor(c1);
			g.fillOval(120, 9, 20, 20);
			g.setColor(c2);
			g.fillOval(120, 300, 20, 20);
		} else {
			g.setColor(c2);
			g.fillOval(120, 9, 20, 20);
			g.setColor(c1);
			g.fillOval(120, 300, 20, 20);
		}

		if (scacco) {
			 g.drawImage(imgScacco, 20, 150, 200, 80, null);
		}

		stampaPedineMangiate(g);

	}

	/**
	 * Disegna le pedine mangiate
	 * 
	 * @param g2 il graphics del pannello
	 */
	private void stampaPedineMangiate(Graphics g2) {
		n1 = 0;
		n2 = 0;
		int x=20, y=40, x1=20, y1=330;
	
		for (Pedina p : mangiate) {
			if (p != null && p.getColore().equals(Colore.BIANCO)) {
				switch (p.getNome()) {
				case RE:
					if (n1 < 12)
						g2.drawImage(re_bianco, x1 + (n1 * 30), y1, 30, 30,
								null);
					else
						g2.drawImage(re_bianco, x1 + ((n1 - 12) * 30), y1 + 30,
								30, 30, null);
					break;
				case REGINA:
					if (n1 < 12)
						g2.drawImage(regina_bianco, x1 + (n1 * 30), y1, 30, 30,
								null);
					else
						g2.drawImage(regina_bianco, x1 + ((n1 - 12) * 30),
								y1 + 30, 30, 30, null);
					break;
				case ALFIERE:
					if (n1 < 12)
						g2.drawImage(alfiere_bianco, x1 + (n1 * 30), y1, 30,
								30, null);
					else
						g2.drawImage(alfiere_bianco, x1 + ((n1 - 12) * 30),
								y1 + 30, 30, 30, null);
					break;
				case TORRE:
					if (n1 < 12)
						g2.drawImage(torre_bianco, x1 + (n1 * 30), y1, 30, 30,
								null);
					else
						g2.drawImage(torre_bianco, x1 + ((n1 - 12) * 30),
								y1 + 30, 30, 30, null);
					break;
				case CAVALLO:
					if (n1 < 12)
						g2.drawImage(cavallo_bianco, x1 + (n1 * 30), y1, 30,
								30, null);
					else
						g2.drawImage(cavallo_bianco, x1 + ((n1 - 12) * 30),
								y1 + 30, 30, 30, null);
					break;
				case PEDONE:
					if (n1 < 12)
						g2.drawImage(pedone_bianco, x1 + (n1 * 30), y1, 30, 30,
								null);
					else
						g2.drawImage(pedone_bianco, x1 + ((n1 - 12) * 30),
								y1 + 30, 30, 30, null);
					break;
				}
				n1++;
			}
			if (p != null && p.getColore().equals(Colore.NERO)) {
				switch (p.getNome()) {
				case RE:
					if (n2 < 12)
						g2.drawImage(re_nero, x + (n2 * 30), y, 30, 30, null);
					else
						g2.drawImage(re_nero, x + ((n2 - 12) * 30), y + 30, 30,
								30, null);
					break;
				case REGINA:
					if (n2 < 12)
						g2.drawImage(regina_nero, x + (n2 * 30), y, 30, 30,
								null);
					else
						g2.drawImage(regina_nero, x + ((n2 - 12) * 30), y + 30,
								30, 30, null);
					break;
				case ALFIERE:
					if (n2 < 12)
						g2.drawImage(alfiere_nero, x + (n2 * 30), y, 30, 30,
								null);
					else
						g2.drawImage(alfiere_nero, x + ((n2 - 12) * 30),
								y + 30, 30, 30, null);
					break;
				case TORRE:
					if (n2 < 12)
						g2.drawImage(torre_nero, x + (n2 * 30), y, 30, 30, null);
					else
						g2.drawImage(torre_nero, x + ((n2 - 12) * 30), y + 30,
								30, 30, null);
					break;
				case CAVALLO:
					if (n2 < 12)
						g2.drawImage(cavallo_nero, x + (n2 * 30), y, 30, 30,
								null);
					else
						g2.drawImage(cavallo_nero, x + ((n2 - 12) * 30),
								y + 30, 30, 30, null);
					break;
				case PEDONE:
					if (n2 < 12)
						g2.drawImage(pedone_nero, x1 + (n2 * 30), y, 30, 30,
								null);
					else
						g2.drawImage(pedone_nero, x + ((n2 - 12) * 30), y + 30,
								30, 30, null);
					break;
				}
				n2++;
			}
		}
	}

}
