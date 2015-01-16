package scacchi.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.Pedina;
import scacchi.Scacchiera;

public class PanelInformazioni extends JPanel{
	Scacchiera scacchiera;
	String nome1,nome2;
	Pedina[] mangiate=new Pedina[32];
	
	private static final long serialVersionUID = 1L;
	
	public PanelInformazioni(Scacchiera scacchiera, String n1,String n2) {
		this.nome1=n1;
		this.nome2=n2;
		this.scacchiera = scacchiera;
		setLayout(null);
		JLabel jLn1=new JLabel();
		
		jLn1.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn1.setText(nome1);
		jLn1.setBounds(new Rectangle(10,0,100,40));
		JLabel jLn2=new JLabel();
		
		jLn2.setFont(new Font("Thaoma", Font.PLAIN, 19));
		jLn2.setText(nome2);
		jLn2.setBounds(new Rectangle(210,0,300,40));
		
		add(jLn1);
		add(jLn2);
		
	}

	//per stampare le pedine mangiate
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.RED);
		stampaPedineMangiate();
		//g2.fill(new Rectangle(0,0,400,400));
		g2.drawRect(10, 150, 380, 60);
		g2.setColor(Color.GREEN);
		g2.drawRect(10, 150+70, 380, 60);
		

	}

	private void stampaPedineMangiate() {
		
		for(Pedina p:mangiate){
			
		}
	}
	
	
}
