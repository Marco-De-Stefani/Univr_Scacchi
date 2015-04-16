package scacchi.grafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe di main che avvia il progetto
 * 
 * @author Tommaso Dal Fior, Marco De Stefani, Davide Miglioranzi
 *
 */
public class MainFrames {

	public static void main(String[] args) {
		
		 JTextField nome1 = new JTextField(15);
	     JTextField nome2 = new JTextField(15);

	      JPanel panel = new JPanel();
	      panel.setLayout(new GridLayout(2,1));
	      panel.add(new JLabel("Nome giocatore 1:"),BorderLayout.EAST);
	      panel.add(nome1,BorderLayout.NORTH);
	      panel.add(new JLabel("Nome giocatore 2:"),BorderLayout.EAST);
	      panel.add(nome2,BorderLayout.SOUTH);
	      int result = JOptionPane.showConfirmDialog(null, panel, "Inserire i nomi", JOptionPane.OK_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  FrameBase b = new FrameBase(nome1.getText(),nome2.getText());
	    	  b.setVisible(true);
	      }
	}

}
