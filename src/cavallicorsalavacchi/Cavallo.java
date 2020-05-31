/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavallicorsalavacchi;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ginevra
 */
public class Cavallo extends JPanel{
    int cordx,cordy;
    Image img;
    public Cavallo(int x, int y) {
        cordx=0;
        cordy=y;
        setSize(80,81);
        Toolkit tk= Toolkit.getDefaultToolkit();
        img=tk.getImage("img/iconacavallo.png");
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(img, 1);
        try{
            mt.waitForID(1);
        }
        catch(InterruptedException e){}
       // super(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("img/iconacavallo.png"))));
        setVisible(true);
        
    }
    public void setCordx(int n)
    {
        cordx=n;
    }
    public int getCordx()
    {
        return cordx;
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,cordx,cordy,null);
    }
}
