/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavallicorsalavacchi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Ginevra
 */
public class GaraCavallo extends JFrame {
    int pos;
    /*ArrayList<Cavallo> partecipanti;
    ArrayList<CavalloInGara> threadp;*/
    Cavallo[] partecipanti;
    CavalloInGara[] threadp;
    Corsie pista;
    Graphics offscreen;
    Image b_virt;
    public GaraCavallo()
    {
        //creazione del percorso
        super("Gara equestre");
        setSize(1000,654);
        setLocation(10,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista=new Corsie();
        /*partecipanti=new ArrayList<Cavallo>();
        threadp=new ArrayList<CavalloInGara>();*/
        partecipanti= new Cavallo[6];
        threadp= new CavalloInGara[6];
        pos=1;
        //aggiungo le icone ai concorrenti e li associio ai vari thread
        int partenza=15;
        for(int i=0;i<6;i++)
        {
            /*partecipanti.set(i, new Cavallo(partenza,i+1));
            threadp.set(i, new CavalloInGara(partecipanti.get(i),this));*/
            partecipanti[i]=new Cavallo(partenza,i+1);
            threadp[i]=new  CavalloInGara(partecipanti[i],this);
            partenza=partenza+100;
        }
        this.add(pista);
        setVisible(true);
    }
    public synchronized int getPosizione()
    {
        return pos++;
    }
    public synchronized void controlloArrivi()
    {
        boolean a=true;
        for(int i=0;i<6;i++)
        {
            if(threadp[i].p==0)
            {
                a=false;
            }
        }
        if(a)
        {
            visualizzaClassifica();
        }
    }
    public void visualizzaClassifica()
    {
        JLabel[] arrivi=new JLabel[6];
        //ArrayList<JLabel> arrivi=new ArrayList<JLabel>();
        JFrame classifica=new JFrame("Classifica");
        classifica.setSize(500,500);
        classifica.setLocation(260,130);
        classifica.setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(6,1));
        //visualizzazione
        for(int i=1;i<7;i++)
        {
            for(int y=0;y<6;y++)
            {
                if(threadp[i].p==i)
                {
                    arrivi[y]=new JLabel(i+ " classificato cavallo in "+(y++)+ " corsia");
                    arrivi[y].setFont(new Font("Times New Roman", Font.ITALIC,20));
                    arrivi[y].setForeground(Color.blue);
                    classifica.getContentPane().add(arrivi[y]);
                }
            }
        }
        classifica.setVisible(true);
    }
    public void update(Graphics g)
    {
        paint(g);
    }
    public void paint(Graphics g)
    {
        if(partecipanti!=null)
        {
            Graphics2D screen=(Graphics2D)g;
            b_virt=createImage(1000,645);
            offscreen=b_virt.getGraphics();
            Dimension d=getSize();
            pista.paint(offscreen);
            for(int i=0;i<6;i++)
            {
                partecipanti[i].paint(offscreen);
            }
            screen.drawImage(b_virt, 0,20, this);
            offscreen.dispose();
        }
    }
    public static void main(String[] V)
    {
        GaraCavallo gc=new GaraCavallo();
        gc.setVisible(true);
    }
}
