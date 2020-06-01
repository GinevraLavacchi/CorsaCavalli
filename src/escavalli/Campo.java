package escavalli;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Campo extends JPanel {
    private BufferedImage image;
	public void paint(Graphics g) {
		g.setColor(Color.green);
                
		g.fillRect(0, 0, 1000, 645);
		//Linee laterali
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 10);
		g.fillRect(0, 50, 1000, 10);
		g.fillRect(0, 100, 1000, 10);
		g.fillRect(0, 150, 1000, 10);
		g.fillRect(0, 200, 1000, 10);
		g.fillRect(0, 250, 1000, 10);
		g.fillRect(0, 300, 1000, 10);
                g.fillRect(0, 350, 1000, 10);
                g.fillRect(0, 400, 1000, 10);
                g.fillRect(0, 450, 1000, 10);
                g.fillRect(0, 500, 1000, 10);
                
		// Traguardo
		g.fillRect(960, 0, 5, 645);
		g.fillRect(970, 0, 5, 645);
		g.fillRect(980, 0, 5, 645);
                //this.setSize(550, 990);
	}
}