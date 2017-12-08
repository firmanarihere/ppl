/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import Musik.Play_musik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import v.v_about_team;
import v.v_halaman;

/**
 *
 * @author Rangora
 */
public class c_about {

    private v_halaman viewsebelumnya;
    private v_about_team theVabout;
    private Play_musik play;

    public c_about(v_halaman viewsebelumnya, Play_musik play) {
        this.theVabout = new v_about_team();
        this.viewsebelumnya = viewsebelumnya;
        this.play = play;
        
        theVabout.buttonKembali().addActionListener(new kembaliAction());
        theVabout.setVisible(true);
    }

    public v_about_team getview() {
        return theVabout;
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playHome();
            play.stopAbout();
            theVabout.setVisible(false);
            viewsebelumnya.setVisible(true);
        }

    }
}
