/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavallicorsalavacchi;


/**
 *
 * @author Ginevra
 */
public class CavalloInGara implements Runnable{
    Cavallo cavallo;
    GaraCavallo campo;
    Thread t;
    int p;
    public CavalloInGara(Cavallo c, GaraCavallo cc)
    {
        cavallo=c;
        campo=cc;
        t=new Thread(this);
        t.start();
        p=0;
    }
    @Override
    public void run() {
        int dimImmagine=79;
        int dimPista=960;
        while(cavallo.getCordx()+ dimImmagine<dimPista)
        {
            cavallo.setCordx(cavallo.getCordx()+10);
            try
            {
                Thread.sleep(75);
            }
            catch(Exception e){}
            campo.repaint();
        }
        p=campo.getPosizione();
        campo.controlloArrivi();
    }
    
}
