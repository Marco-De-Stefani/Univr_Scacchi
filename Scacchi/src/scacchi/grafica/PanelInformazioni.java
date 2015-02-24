package scacchi.grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import scacchi.Colore;
import scacchi.Pedina;
import scacchi.Pedone;
import scacchi.Re;
import scacchi.Regina;
import scacchi.Scacchiera;


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
	
	private Image sfondo=new ImageIcon(this.getClass().getResource("\\immagini\\sfondo_info.png")).getImage();
	
	private int n1=0,n2=0;
	int nStampate=0;
	Scacchiera scacchiera;
	String nome1, nome2;
	Pedina[] mangiate;
	JLabel jLn1 = new JLabel();
	JLabel jLn2 = new JLabel();
	JButton jBrestart=new JButton();
	JButton jBstatistiche=new JButton();
	
	int x,y,x1,y1;
	
	
	Color c1=Color.RED;
	Color c2=Color.GREEN;
	
	private static final long serialVersionUID = 1L;

	public PanelInformazioni(Scacchiera scacchiera, String n1, String n2) {
		mangiate=new Pedina[32];
		
		Dimension size = new Dimension(400,400);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);		
		
		this.nome1 = n1;
		this.nome2 = n2;
		this.scacchiera=scacchiera;
		
		setLayout(null);
		

		jLn1.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn1.setText(nome1);
		jLn1.setBounds(new Rectangle(10, 290, 100, 40));


		jLn2.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn2.setText(nome2);
		jLn2.setBounds(new Rectangle(10, 0, 100, 40));
		
		jLn1.setForeground(new Color(255,255,218));
		jLn2.setForeground(new Color(45,34,23));
		
		
		jBrestart.setBounds(new Rectangle(75,150,100,80));
		jBstatistiche.setBounds(new Rectangle(225,150,100,80));
		jBrestart.setText("Ricomincia");
		jBstatistiche.setText("Statistiche");
		
		
		add(jBstatistiche);
		add(jBrestart);
		add(jLn1);
		add(jLn2);
		repaint();

	}

	
	public void setPedineMangiate(Pedina[] mangiate){this.mangiate=mangiate;}
	
	
	// per stampare le pedine mangiate e l'interfaccia utente
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(sfondo, 0, 0, 400, 400,null);
		
		if(scacchiera.getTurno()==Colore.BIANCO){
			g.setColor(c1);
			g.fillOval(120, 9, 20, 20);
			g.setColor(c2);
			g.fillOval(120, 299, 20, 20);
		}else{
			g.setColor(c2);
			g.fillOval(120, 9, 20, 20);
			g.setColor(c1);
			g.fillOval(120, 299, 20, 20);
		}
		
		g2.setColor(Color.RED);
		x=10;
		y=40;
		x1=10;
		y1=400-70;
		//g2.drawRect(x, y, 380, 60);
		//g2.drawRect(x1,y1, 380, 60);
		
		stampaPedineMangiate(g);
		
	}

	
	
	
	private void stampaPedineMangiate(Graphics g2) {
		n1=0;n2=0;
		for (Pedina p:mangiate) {
			if (p!=null && p.getColore().equals(Colore.BIANCO)) {
				switch (p.getNome()) {
				case RE:
					if(n1<12)
						g2.drawImage(re_bianco,x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(re_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				case REGINA:
					if(n1<12)
						g2.drawImage(regina_bianco,x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(regina_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				case ALFIERE:
					if(n1<12)
						g2.drawImage(alfiere_bianco, x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(alfiere_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				case TORRE:
					if(n1<12)
						g2.drawImage(torre_bianco, x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(torre_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				case CAVALLO:
					if(n1<12)
						g2.drawImage(cavallo_bianco, x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(cavallo_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				case PEDONE:
					if(n1<12)
						g2.drawImage(pedone_bianco, x1+(n1*30), y1, 30, 30, null);
					else
						g2.drawImage(pedone_bianco,x1+((n1-12)*30), y1+30, 30, 30, null);
					break;
				}
				n1++;
			}
			if (p!=null && p.getColore().equals(Colore.NERO)) {
				switch (p.getNome()) {
				case RE:
					if(n2<12)
						g2.drawImage(re_nero,x+(n2*30),y, 30, 30, null);
					else
						g2.drawImage(re_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				case REGINA:
					if(n2<12)
						g2.drawImage(regina_nero,x+(n2*30), y, 30, 30, null);
					else
						g2.drawImage(regina_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				case ALFIERE:
					if(n2<12)
						g2.drawImage(alfiere_nero, x+(n2*30), y, 30, 30, null);
					else
						g2.drawImage(alfiere_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				case TORRE:
					if(n2<12)
						g2.drawImage(torre_nero, x+(n2*30), y, 30, 30, null);
					else
						g2.drawImage(torre_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				case CAVALLO:
					if(n2<12)
						g2.drawImage(cavallo_nero, x+(n2*30), y, 30, 30, null);
					else
						g2.drawImage(cavallo_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				case PEDONE:
					if(n2<12)
						g2.drawImage(pedone_nero, x1+(n2*30), y, 30, 30, null);
					else
						g2.drawImage(pedone_nero,x+((n2-12)*30), y+30, 30, 30, null);
					break;
				}
				n2++;
			}
		}//for
	}
}
