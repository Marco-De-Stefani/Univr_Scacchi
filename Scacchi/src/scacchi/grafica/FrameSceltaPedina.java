package scacchi.grafica;

import javax.swing.JFrame;

import scacchi.Colore;


public class FrameSceltaPedina extends JFrame {

	private static final long serialVersionUID = 1L;

	public FrameSceltaPedina() {
		super("Promozione pedone");
		PanelSceltaPedina psppp = new PanelSceltaPedina();
		psppp.setColore(Colore.NERO);
		add(psppp);
		this.setSize(250, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}
}