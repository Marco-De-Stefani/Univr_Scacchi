package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSceltaPedina extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon regina_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\regina_b.png"));
	private ImageIcon alfiere_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\alfiere_b.png"));
	private ImageIcon torre_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\torre_b.png"));
	private ImageIcon cavallo_bianco = new ImageIcon(this.getClass().getResource("\\immagini\\cavallo_b.png"));
	
	private ImageIcon regina_nero = new ImageIcon(this.getClass().getResource("\\immagini\\regina_n.png"));
	private ImageIcon alfiere_nero = new ImageIcon(this.getClass().getResource("\\immagini\\alfiere_n.png"));
	private ImageIcon torre_nero = new ImageIcon(this.getClass().getResource("\\immagini\\torre_n.png"));
	private ImageIcon cavallo_nero = new ImageIcon(this.getClass().getResource("\\immagini\\cavallo_n.png"));
	
	public PanelSceltaPedina() {
		JPanel jp1 = new JPanel();

		JPanel jp2 = new JPanel();
		
		jp2.setLayout(new GridLayout(2, 2));
		
		JButton alfiere = new JButton();
		alfiere.setIcon(alfiere_bianco);
		jp2.add(alfiere);
		JButton cavallo = new JButton();
		cavallo.setIcon(cavallo_bianco);
		jp2.add(cavallo);
		JButton regina = new JButton();
		regina.setIcon(regina_bianco);
		jp2.add(regina);
		JButton torre = new JButton();
		torre.setIcon(torre_bianco);
		jp2.add(torre);
		
		JLabel jLn1 = new JLabel();
		jLn1.setText("Scegli una delle della pedina");
		jLn1.setFont(new Font("Thaoma", Font.PLAIN, 15));
	
		jp1.add(jLn1);
		
		add(jp1, BorderLayout.CENTER);
		add(jp2, BorderLayout.CENTER);
		
	}
	
}
