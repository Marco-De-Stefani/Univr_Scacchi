package scacchi.grafica;

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

public class PanelInformazioni extends JPanel{
	Scacchiera scacchiera;
	String nome1,nome2;
	private static final long serialVersionUID = 1L;
	
	public PanelInformazioni(Scacchiera scacchiera, String n1,String n2) {
		this.nome1=n1;
		this.nome2=n2;
		this.scacchiera = scacchiera;
		//mi serve il mouse listener? per ora no, am lo lascio
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});

	}

	//per stampare le pedine mangiate
	public void paintComponent(Graphics g) {
		

	}
	
	
}
