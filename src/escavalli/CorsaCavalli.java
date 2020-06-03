package escavalli;
import java.util.Scanner;
import java.awt.*;
import java.util.Vector;
import javax.imageio.ImageIO;

import javax.swing.*;

/**
 * @author Lavacchi Ginevra
 */
public class CorsaCavalli extends JFrame {
	int ps;
	Cavallo[] partecipanti;
	CavalliInCorsa[] thread_partecipanti;
	Campo pista;
	Graphics offscreen;
	Image bf;
	int n=0;
	/**
     * il costruttore parametrizzato
     * @param scelta il numero dei partecipanti
     */
	public CorsaCavalli(int scelta) {
		super("Corsa Cavalli");
		n=scelta;
		setSize(1000, 645);
		setLocation(10, 40);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pista = new Campo();
		partecipanti = new Cavallo[n];
		thread_partecipanti = new CavalliInCorsa[n];
		ps = 1;
		
		int partenza = 15;
		for (int xx=0; xx<n; xx++) {
			partecipanti[xx] = new Cavallo(partenza,  xx);
			thread_partecipanti[xx] = new CavalliInCorsa(partecipanti[xx], this);
			partenza = partenza+50;			
		}
		// visualizza la gara
		this.add(pista);
		setVisible(true);
                this.setSize(990, 545);
	}
	
	public synchronized int getPosizione() {
		return ps++;
	}
	/**
     * il metodo che controlla se i cavalli sono arrivati
     */
	public synchronized void controllaArrivi() {
		boolean arrivati=true;
		for (int xx=0; xx<n; xx++) {
			if (thread_partecipanti[xx].posizione==0) {
				arrivati=false;
			}
		}
		if(arrivati) {
			visualizzaClassifica();
		}
	}
	/**
         * il metodo che visualizza la classifica degli arrivi
         */
	public void visualizzaClassifica() {
		JLabel[] arrivi;
		arrivi = new JLabel[n];
		JFrame classifica = new JFrame("Classifica Cavalli");
		classifica.setSize(500, 500);
		classifica.setLocation(280, 130);;
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(6,1 ));
                classifica.getContentPane().setBackground(Color.magenta);
		for(int xx=1; xx<7; xx++) {
			for (int yy=0; yy<n; yy++) {
				if (thread_partecipanti[yy].posizione==xx){
					arrivi[yy]=new JLabel(xx+"' Classificato in gara " + (yy+1)+"' corsia");
					arrivi[yy].setFont(new Font("Times new Roman", Font.BOLD, 18));
					arrivi[yy].setForeground(Color.white);
					classifica.getContentPane().add(arrivi[yy]);
				}
			}
		}
		classifica.setVisible(true);
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	/**
         * metodo relativo al disegno
         * @param g 
         */
	public void paint(Graphics g) {
		if (partecipanti != null) {
			Graphics2D screen = (Graphics2D) g;
			bf= createImage(1000, 645);
			offscreen = bf.getGraphics();
			Dimension d=getSize();
			pista.paint(offscreen);
			for (int xx=0; xx<n; xx++) {
				partecipanti[xx].paint(offscreen);
			}
			screen.drawImage(bf, 0, 30, this);
			offscreen.dispose();
		}
	}
        
	/**
     * il metodo main che gestisce la creazione della finestra di inizio per permettere di scegliere il numero di partecipanti
     * @param args the command line arguments
     */
	public static void main(String[] args)
        {
            JFrame f=new JFrame("Corsa Cavalli");
            JPanel pannello=new JPanel();
            pannello.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.anchor = GridBagConstraints.CENTER;
            c.gridx=0;
            c.gridy=0;
            c.insets =  new Insets(0,0,0,0);
            JLabel b=new JLabel("BENVENUTO!!!");
            pannello.add(b,c);
            b.setFont(new Font("Times new Roman",Font.BOLD, 18));
            b.setForeground(Color.red);
            JLabel n=new JLabel("Quanti sono i fantini?");
            //JTextField numero=new JTextField(20);
            c.gridy++;
            pannello.add(n,c);
            Vector numpart=new Vector();
            numpart.add(2);
            numpart.add(3);
            numpart.add(4);
            numpart.add(5);
            numpart.add(6);
            numpart.add(7);
            numpart.add(8);
            numpart.add(9);
            numpart.add(10);
        
        JComboBox elencop=new JComboBox(numpart);
           c.gridy++;
            pannello.add(elencop,c);
            JButton bottone=new JButton("Inizia");
            EventoInizia ei=new EventoInizia(elencop);
            bottone.addActionListener(ei);
            c.gridy++;
            pannello.add(bottone,c);
            f.add(pannello);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(500,300);
            bottone.setBackground(Color.pink);
            elencop.setBackground(Color.pink);
	}
        
}