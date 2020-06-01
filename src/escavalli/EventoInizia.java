/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escavalli;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ginevra
 */
public class EventoInizia implements ActionListener
{
    JComboBox n;
    public EventoInizia(JComboBox num)
    {
       //String n=num.getText();
       n=num;
       /*try
       {
            n=Integer.parseInt(nn);
           
       }
       catch(Exception e)
       {
           n=2;
       }*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CorsaCavalli m=new CorsaCavalli((int)n.getSelectedItem());
    }
    
}
