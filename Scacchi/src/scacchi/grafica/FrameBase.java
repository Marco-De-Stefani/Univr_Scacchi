package scacchi.grafica;

import java.awt.GridLayout;
import javax.swing.JFrame;

import scacchi.Scacchiera;

public class FrameBase extends JFrame{
	private static final long serialVersionUID = 1L;

	public FrameBase(String nome1,String nome2){
		Scacchiera scacchiera=new Scacchiera(true);
		PanelScacchiera ps=new PanelScacchiera(scacchiera);
		PanelInformazioni pi= new PanelInformazioni(scacchiera, nome1, nome2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Controller(ps, pi, scacchiera);
		setLayout(new GridLayout(1,0));
		setResizable(false);
		add(ps);
		add(pi);
		pack();
		setVisible(true);
		
	}
	
	

	
}
