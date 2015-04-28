package scacchi.grafica;

import java.awt.GridLayout;
import javax.swing.JFrame;
import scacchi.Scacchiera;

/**
 * Classe chiamata da main che crea e inizializza i vari pannelli e li inserisce
 * in un frame
 * 
 * @author Tommaso Dal Fior, Marco De Stefani, Davide Miglioranzi
 *
 */
public class FrameBase extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore del frame di base
	 * 
	 * @param nome1 nome del giocatore 1
	 * @param nome2 nome del giocatore 2
	 */
	public FrameBase(String nome1, String nome2) {
		Scacchiera scacchiera = new Scacchiera(false);
		PanelScacchiera ps = new PanelScacchiera(scacchiera);
		PanelInformazioni pi = new PanelInformazioni(scacchiera, nome1, nome2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Controller(ps, pi, scacchiera);
		setLayout(new GridLayout(1, 0));
		setResizable(false);
		add(ps);
		add(pi);
		pack();
		setVisible(true);
	}

}

