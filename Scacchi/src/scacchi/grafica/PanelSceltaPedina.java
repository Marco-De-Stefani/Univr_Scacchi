package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.Colore;
import scacchi.Scacchiera;

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
	
	private JButton alfiere = new JButton();
	private JButton cavallo = new JButton();
	private JButton regina = new JButton();
	private JButton torre = new JButton();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private Scacchiera scacchiera;
	
	public PanelSceltaPedina(Semaphore semaforo) {
		alfiere.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e)
		        {
		         	scacchiera.setPedinaPromozione(0);
		        	semaforo.release();
		        }
		});
		cavallo.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	System.out.println("b2");
		        	semaforo.release();
	            	scacchiera.setPedinaPromozione(1);
	            }
		});
		regina.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	System.out.println("b3");
		        	semaforo.release();
	            	scacchiera.setPedinaPromozione(2);
	            }
		});
		torre.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	System.out.println("b4");
		        	semaforo.release();
	            	scacchiera.setPedinaPromozione(3);
	            }
		});
		
		alfiere.setName("alfiere");
		cavallo.setName("cavallo");
		regina.setName("regina");
		torre.setName("torre");
		
		southPanel.setLayout(new GridLayout(2, 2));
		
		JLabel etichetta = new JLabel();
		etichetta.setText("Scegli una delle pedine");
		etichetta.setFont(new Font("Thaoma", Font.BOLD, 16));
		
		northPanel.add(etichetta);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	
	public void setScacchiera(Scacchiera scacchiera){this.scacchiera=scacchiera;}
	
	public void setColore(Colore colore){
		//remove(southPanel);
		southPanel.setLayout(new GridLayout(2, 2));
		if(colore.equals(Colore.NERO)){
			alfiere.setIcon(alfiere_nero);
			cavallo.setIcon(cavallo_nero);
			regina.setIcon(regina_nero);
			torre.setIcon(torre_nero);
		}else{
			alfiere.setIcon(alfiere_bianco);
			cavallo.setIcon(cavallo_bianco);
			regina.setIcon(regina_bianco);
			torre.setIcon(torre_bianco);
		}
		
		southPanel.add(alfiere);
		southPanel.add(cavallo);
		southPanel.add(regina);
		southPanel.add(torre);
		
		add(southPanel, BorderLayout.SOUTH);
		revalidate();	
	}
	
}
