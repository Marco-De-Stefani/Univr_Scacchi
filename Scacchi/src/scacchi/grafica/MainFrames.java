package scacchi.grafica;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import scacchi.Scacchiera;

public class MainFrames {

	public static void main(String[] args) {
		/*
		 * TEST TENTATIVO DI DISEGNARE UNA SCACCHIERA
		 */
		Scacchiera scacchiera=new Scacchiera();
		Image img = new ImageIcon("C:\\Users\\Deste\\git\\Univr_Scacchi\\Scacchi\\src\\scacchi\\grafica\\immagini\\scacchiera.png").getImage();
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelScacchiera(img, scacchiera));
		frame.setSize(img.getWidth(null)+50, img.getHeight(null)+50);
		frame.setVisible(true);
	}

}
