package escavalli;
/**
 * @author Lavacchi Ginevra
 */
public class CavalliInCorsa implements Runnable {
	private Cavallo Cavallo;
	private CorsaCavalli campo;
	private int velocita;
	private Thread t;
	private int conta;
	private int posizione;
	/**
	* costruttore con parameri
	* @param c 
	* @param g 
	*/
	public CavalliInCorsa(Cavallo c, CorsaCavalli g) {
		Cavallo=c;
		campo=g;
		conta=0;velocita=2;t = new Thread(this);
		t.start();
		posizione=0;
	}
	
	@Override
	public void run() {
		int dimImmagine=79;
		int dimPista=960;
		//while((Cavallo.))
		while((Cavallo.getCoordx()+dimImmagine)<dimPista) {
			if ((conta%10)==0)
				velocita=(int)(Math.random()*4+1);
			Cavallo.setCoordx(Cavallo.getCoordx()+velocita);
			conta++;
			try {Thread.sleep(75);}
			catch (Exception e) {}
			campo.repaint();
		}
		
		posizione=campo.getPosizione();
		campo.controllaArrivi();
	}
	
}