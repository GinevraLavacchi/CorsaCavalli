/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavallicorsalavacchi;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Ginevra
 */
public class Corsie extends JPanel{
    public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(0,0,1000,645);
        //linee laterali
        g.setColor(Color.white);
        g.fillRect(0, 0,1000,10);
        g.fillRect(0, 100,1000,10);
        g.fillRect(0, 200,1000,10);
        g.fillRect(0, 300,1000,10);
        g.fillRect(0, 400,1000,10);
        g.fillRect(0, 500,1000,10);
        g.fillRect(0, 600,1000,10);
        //traguardo
        g.fillRect(960, 0, 5, 645);
        g.fillRect(970, 0, 5, 645);
        g.fillRect(980, 0, 5, 645);
    }
}
