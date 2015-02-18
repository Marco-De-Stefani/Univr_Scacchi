package scacchi.grafica;

import javax.swing.JFrame;

import scacchi.Scacchiera;

class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame() {
		super("Promozione");
		add(new PanelSceltaPedina());
		this.setSize(250, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class MainFrames {

	public static void main(String[] args) {
		/*
		 * TEST TENTATIVO DI DISEGNARE UNA SCACCHIERA
		 */
		Scacchiera scacchiera = new Scacchiera();
		FrameBase b = new FrameBase(scacchiera);
		b.setVisible(true);
		// b.setResizable(false);
		MyFrame m=new MyFrame();

	}

}
