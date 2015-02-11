package scacchi;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		/*
		 * TEST TENTATIVO DI DISEGNARE UNA SCACCHIERA
		 */

		Image img = new ImageIcon("C:\\Users\\Deste\\git\\Scacchi\\src\\images\\scacchiera.png").getImage();
		JFrame frame = new JFrame();
		//frame.getContentPane().add(new FrameScacchiera(img));
		frame.setSize(img.getWidth(null)+50, img.getHeight(null)+50);
		frame.setVisible(true);
	}

}
