/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import Musik.Play_musik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.m_aset;
import v.v_aset;
import v.v_halaman;

/**
 *
 * @author Rangora
 */
public class c_profile  {

    private String username;
    private v_aset theVaset;
    private m_aset theMaset;
    private v_halaman viewsebelumnya;
    Play_musik play;

    public c_profile(String username, v_halaman viewsebelumnya, Play_musik play) throws SQLException {
        this.theVaset = new v_aset();
        this.theMaset = new m_aset();
        this.username = username;
        this.play = play;
        this.viewsebelumnya = viewsebelumnya;

        theVaset.setTeksSapiBesar(theMaset.getJumlahSapi(username) + "");
        theVaset.setTeksSuntikan(theMaset.getJumlahSuntikan(username) + "");
        theVaset.setTeksRumput(theMaset.getJumlahRumput(username) + "");
        theVaset.setTeksSusu(theMaset.getJumlahSusu(username) + "");
        theVaset.setTeksObat(theMaset.getJumlahObat(username) + "");
        theVaset.setTeksNutrisi(theMaset.getJumlahNutrisi(username) + "");
        theVaset.setTeksKandang(theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) + "");

        theVaset.kembaliBtn().addActionListener(new kembaliAction());
        theVaset.setVisible(true);
    }

    public v_aset getview() {
        return theVaset;
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playHome();
            theVaset.setVisible(false);
            viewsebelumnya.setVisible(true);
        }

    }

}
