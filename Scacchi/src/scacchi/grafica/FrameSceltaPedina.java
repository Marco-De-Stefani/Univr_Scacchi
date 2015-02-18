package scacchi.grafica;

import javax.swing.JFrame;

public class FrameSceltaPedina extends JFrame {

	private static final long serialVersionUID = 1L;

	public FrameSceltaPedina() {
		super("Promozione");
		add(new PanelSceltaPedina());
		this.setSize(250, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}
}