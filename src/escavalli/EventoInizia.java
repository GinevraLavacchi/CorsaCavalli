
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
    /**
     * costruttore con parametri
     * @param num l'elenco del numero di partecipanti
     */
    public EventoInizia(JComboBox num)
    {
       n=num;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CorsaCavalli m=new CorsaCavalli((int)n.getSelectedItem());
    }
    
}
