/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import Musik.Play_musik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import v.v_halaman;
import v.v_help;

/**
 *
 * @author Rangora
 */
public class c_help {

    private v_help theVhelp;
    private v_halaman viewsebelumnya;
    private Play_musik play;

    public c_help(v_halaman viewsebelumnya, Play_musik play) {
        this.theVhelp  = new v_help();
        this.viewsebelumnya = viewsebelumnya;
        this.play = play;
        
        theVhelp.buttonKembali().addActionListener(new kembaliAction());
        theVhelp.setVisible(true);
    }

    public v_help getview() {
        return theVhelp;
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playHome();
            theVhelp.setVisible(false);
            viewsebelumnya.setVisible(true);
        }

    }

}
