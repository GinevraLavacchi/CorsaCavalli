package escavalli;
import java.util.Scanner;
import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class CorsaCavalli extends JFrame {
	int ps;
	Cavallo[] partecipanti;
	CavalliInCorsa[] thread_partecipanti;
	Campo pista;
	Graphics offscreen;
	Image bf;
	int n=0;
	
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
	
	public void visualizzaClassifica() {
		JLabel[] arrivi;
		arrivi = new JLabel[n];
		JFrame classifica = new JFrame("Classifica Cavalli");
		classifica.setSize(500, 500);
		classifica.setLocation(280, 130);
		classifica.setBackground(Color.BLUE);
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(6,1 ));
		
		for(int xx=1; xx<7; xx++) {
			for (int yy=0; yy<n; yy++) {
				if (thread_partecipanti[yy].posizione==xx){
					arrivi[yy]=new JLabel(xx+"' Classificato in gara " + (yy+1)+"' corsia");
					arrivi[yy].setFont(new Font("arial", Font.BOLD, 18));
					arrivi[yy].setForeground(Color.BLACK);
					classifica.getContentPane().add(arrivi[yy]);
				}
			}
		}
		classifica.setVisible(true);
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
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
	
	public static void main(String[] a) {
		/*Scanner d = new Scanner(System.in);
		int scelta=0;
		System.out.println("inserisci il numero di cavalli");
		do {
			scelta = d.nextInt();
		}while(scelta<2 || scelta>6);
		CorsaCavalli m=new CorsaCavalli(scelta);*/
            JFrame f=new JFrame("Corsa Cavalli");
            JPanel pannello=new JPanel();
            pannello.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.anchor = GridBagConstraints.CENTER;
            c.gridx=0;
            c.gridy=0;
            c.insets =  new Insets(0,0,0,0);
            JLabel b=new JLabel("BENVENUTO");
            pannello.add(b,c);
            JLabel n=new JLabel("Quanti sono i partecipanti?");
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
	}
}