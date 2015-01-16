package scacchi.grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.*;


public class PanelInformazioni extends JComponent {

	private Image re_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Re.png").getImage();
	private Image regina_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\regina.png").getImage();
	private Image alfiere_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Alfiere.png").getImage();
	private Image torre_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Torre.png").getImage();
	private Image cavallo_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Cavallo.png").getImage();
	private Image pedone_bianco = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\Pedone.png").getImage();
	
	
	
	

	Scacchiera scacchiera;
	String nome1, nome2;
	Pedina[] mangiate = new Pedina[32];

	private static final long serialVersionUID = 1L;

	public PanelInformazioni(Scacchiera scacchiera, String n1, String n2) {
		Dimension size = new Dimension(400,400);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		mangiate[0]=new Re(Colore.BIANCO);
		mangiate[1]=new Regina(Colore.BIANCO);
		mangiate[2]=new Pedone(Colore.BIANCO);
		
		
		
		this.nome1 = n1;
		this.nome2 = n2;
		this.scacchiera = scacchiera;
		setLayout(null);
		JLabel jLn1 = new JLabel();

		jLn1.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn1.setText(nome1);
		jLn1.setBounds(new Rectangle(10, 0, 100, 40));
		JLabel jLn2 = new JLabel();

		jLn2.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn2.setText(nome2);
		jLn2.setBounds(new Rectangle(210, 0, 300, 40));

		add(jLn1);
		add(jLn2);
		repaint();

	}

	// per stampare le pedine mangiate
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		
		stampaPedineMangiate(g2);	
		
		g2.drawRect(10, 150, 380, 60);
		g2.setColor(Color.GREEN);
		g2.drawRect(10, 150 + 70, 380, 60);
		
		
		
		
	}

	private void stampaPedineMangiate(Graphics2D g2) {
		int n = 0;	
		
		for (Pedina p : mangiate) {
			if (p!=null && p.getColore().equals(Colore.BIANCO)) {
				switch (p.getNome()) {
				case RE:
					g2.drawImage(re_bianco,10+(n*30), 150, 30, 30, null);
					//g2.drawRect(10+(n*30), 150, 30, 30);
					break;
				case REGINA:
					g2.drawImage(pedone_bianco,10+(n*30), 150, 30, 30, null);
					break;
				case ALFIERE:
					g2.drawImage(regina_bianco, 10+(n*30), 150, 30, 30, null);
					break;
				case TORRE:
					g2.drawImage(alfiere_bianco, 10+(n*30), 150, 30, 30, null);
					break;
				case CAVALLO:
					g2.drawImage(torre_bianco, 10+(n*30), 150, 30, 30, null);
					break;
				case PEDONE:
					g2.drawImage(cavallo_bianco, 10+(n*30), 150, 30, 30, null);
					break;
				}
				n++;
			}
		}//for
	}
}
