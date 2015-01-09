package scacchi.grafica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FrameScacchiera extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image img;

	public FrameScacchiera(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getHeight(null),img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}
