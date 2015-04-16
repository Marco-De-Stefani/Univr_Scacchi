package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.Alfiere;
import scacchi.Cavallo;
import scacchi.Colore;
import scacchi.Position;
import scacchi.Regina;
import scacchi.Scacchiera;
import scacchi.Torre;

public class FrameSceltaPedina extends JFrame {

	private ImageIcon regina_bianco = new ImageIcon(this.getClass()
			.getResource("\\immagini\\regina_b.png"));
	private ImageIcon alfiere_bianco = new ImageIcon(this.getClass()
			.getResource("\\immagini\\alfiere_b.png"));
	private ImageIcon torre_bianco = new ImageIcon(this.getClass().getResource(
			"\\immagini\\torre_b.png"));
	private ImageIcon cavallo_bianco = new ImageIcon(this.getClass()
			.getResource("\\immagini\\cavallo_b.png"));

	private ImageIcon regina_nero = new ImageIcon(this.getClass().getResource(
			"\\immagini\\regina_n.png"));
	private ImageIcon alfiere_nero = new ImageIcon(this.getClass().getResource(
			"\\immagini\\alfiere_n.png"));
	private ImageIcon torre_nero = new ImageIcon(this.getClass().getResource(
			"\\immagini\\torre_n.png"));
	private ImageIcon cavallo_nero = new ImageIcon(this.getClass().getResource(
			"\\immagini\\cavallo_n.png"));

	private JButton alfiere = new JButton();
	private JButton cavallo = new JButton();
	private JButton regina = new JButton();
	private JButton torre = new JButton();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private static final long serialVersionUID = 1L;

	/**
	 * In base alla scelta della pedina (cioe' tra Regina, Torre, Alfiere e
	 * Cavallo), sostituisce il Pedone e modifica la scacchiera. L'utilizzo di
	 * repaint() è usato per aggiornare l'icona della nuova pedina nella
	 * scacchiera
	 * 
	 * @param turno
	 * @param scacchiera
	 * @param pos
	 * @param ps
	 */
	public FrameSceltaPedina(Colore turno, Scacchiera scacchiera, Position pos,
			PanelScacchiera ps) {
		super("Promozione pedone");

		alfiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scacchiera.setScacchiera(pos, new Alfiere(turno));
				ps.repaint();
				dispose();
			}
		});
		cavallo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scacchiera.setScacchiera(pos, new Cavallo(turno));
				ps.repaint();
				dispose();
			}
		});
		regina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scacchiera.setScacchiera(pos, new Regina(turno));
				ps.repaint();
				dispose();
			}
		});
		torre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scacchiera.setScacchiera(pos, new Torre(turno));
				ps.repaint();
				dispose();
			}
		});

		alfiere.setName("alfiere");
		cavallo.setName("cavallo");
		regina.setName("regina");
		torre.setName("torre");

		southPanel.setLayout(new GridLayout(2, 2));

		JLabel etichetta = new JLabel();
		etichetta.setText("Scegli una delle pedine");
		etichetta.setFont(new Font("Thaoma", Font.BOLD, 16));

		northPanel.add(etichetta);

		setColore(turno);

		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	/**
	 * In base al pedone che arriva in fondo alla scacchiera mostra le pedine
	 * dello stesso colore che si possono scegliere
	 * 
	 * @param colore
	 */
	public void setColore(Colore colore) {

		southPanel.setLayout(new GridLayout(2, 2));
		if (colore.equals(Colore.NERO)) {
			alfiere.setIcon(alfiere_nero);
			cavallo.setIcon(cavallo_nero);
			regina.setIcon(regina_nero);
			torre.setIcon(torre_nero);
		} else {
			alfiere.setIcon(alfiere_bianco);
			cavallo.setIcon(cavallo_bianco);
			regina.setIcon(regina_bianco);
			torre.setIcon(torre_bianco);
		}

		southPanel.add(alfiere);
		southPanel.add(cavallo);
		southPanel.add(regina);
		southPanel.add(torre);

		add(southPanel, BorderLayout.SOUTH);
		revalidate();
	}
}