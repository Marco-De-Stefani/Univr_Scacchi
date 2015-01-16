package scacchi.grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.Scacchiera;

public class PanelInformazioni extends JPanel{
	Scacchiera scacchiera;
	String nome1,nome2;
	private static final long serialVersionUID = 1L;
	
	public PanelInformazioni(Scacchiera scacchiera, String n1,String n2) {
		this.nome1=n1;
		this.nome2=n2;
		this.scacchiera = scacchiera;
		JLabel jLn1=new JLabel();
		jLn1.setText(nome1);
		JLabel jLn2=new JLabel();
		jLn2.setText(nome2);
		jLn1.setForeground(Color.BLUE);
		setLayout(new GridLayout(1,3));
		add(jLn1);
		add(jLn2);
		
	}

	//per stampare le pedine mangiate
	public void paintComponent(Graphics g) {
		

	}
	
	
}
