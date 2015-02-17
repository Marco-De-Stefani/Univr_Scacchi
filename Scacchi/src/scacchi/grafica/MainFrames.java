package scacchi.grafica;

import java.awt.GridLayout;
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
		FrameBase b=new FrameBase(scacchiera);
		b.setVisible(true);
		//b.setResizable(false);
		JFrame f = new JFrame();
		f.setLayout(null);//scacchiera-nome1-nome2 ?
		f.add(new PanelSceltaPedina());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();

	}

}
