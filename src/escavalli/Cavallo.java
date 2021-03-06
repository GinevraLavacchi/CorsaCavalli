package escavalli;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
/**
 * @author Lavacchi Ginevra
 */
public class Cavallo extends JPanel {
	int coordx;
	int coordy;
	Image img;
        /**
         * costruttore con parametri
         * @param yy
         * @param xx 
         */
	public Cavallo(int yy, int xx) {
		coordx = 0;
		coordy = yy;
		Toolkit tk = Toolkit.getDefaultToolkit();

            try {
                img=ImageIO.read(getClass().getResource("../img/unicorno1.png"));
            } catch (IOException ex) {
                Logger.getLogger(Cavallo.class.getName()).log(Level.SEVERE, null, ex);
            }
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void setCoordx(int n) {
		coordx = n;
	}
	
	public int getCoordx() {
		return coordx;
	}
	/**
         * metodo per la creazione dell'immagine
         * @param g 
         */
	
	public void paint(Graphics g) {
		g.drawImage(img,  coordx,  coordy, null);
	}
}