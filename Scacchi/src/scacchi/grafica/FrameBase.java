package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import scacchi.Scacchiera;

public class FrameBase extends JFrame{
	String nome1="pippo",nome2="claudio";
	private static final long serialVersionUID = 1L;

	public FrameBase(Scacchiera scacchiera){
		PanelScacchiera ps=new PanelScacchiera(scacchiera);
		FrameSceltaPedina fsp=new FrameSceltaPedina();
		PanelInformazioni pi= new PanelInformazioni(scacchiera, nome1, nome2);
		
		Controller c=new Controller(ps, pi, fsp, scacchiera);

		setLayout(new GridLayout(1,2));//scacchiera-nome1-nome2 ?
		add(ps);
		add(pi);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
}
