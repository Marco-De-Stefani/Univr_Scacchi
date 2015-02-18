package scacchi.grafica;

import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

import scacchi.Colore;
import scacchi.Scacchiera;


public class FrameSceltaPedina extends JFrame {

	private static final long serialVersionUID = 1L;
	PanelSceltaPedina psppp;
	
	public FrameSceltaPedina(Semaphore semaforo) {
		super("Promozione pedone");
		psppp=new PanelSceltaPedina(semaforo);
		psppp.setColore(Colore.NERO);
		add(psppp);
		this.setSize(250, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public void setColore(Colore turno) {
		psppp.setColore(turno);
		this.setVisible(true);
	}
	
	public void setScacchiera(Scacchiera scacchiera){psppp.setScacchiera(scacchiera);}
}