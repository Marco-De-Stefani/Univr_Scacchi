package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import scacchi.Scacchiera;

public class FrameBase extends JFrame{
	String nome1="pippo",nome2="claudio";
	private static final long serialVersionUID = 1L;

	public FrameBase(Scacchiera scacchiera){
		setLayout(new GridLayout(1,2));//scacchiera-nome1-nome2 ?? 
		add(new PanelScacchiera(scacchiera));
		add(new PanelInformazioni(scacchiera, "claudio", "giovanni"));
		//add(new PanelInformazioni(scacchiera, nome1,nome2));
		pack();
	}
	
}
