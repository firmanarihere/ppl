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
import v.v_inventori;
import v.v_halaman;

/**
 *
 * @author Rangora
 */
public class c_inventori {
    private String username;
    public v_inventori theVinventori;
    private m_aset theMaset;
    private v_halaman viewsebelumnya;
    private Play_musik play;

    public c_inventori(String username, v_halaman viewsebelumnya, Play_musik play) throws SQLException {
        this.theVinventori = new v_inventori();
        this.theMaset = new m_aset();
        this.username = username;
        this.play = play;
        this.viewsebelumnya = viewsebelumnya;

        theVinventori.setTeksSapiBesar(theMaset.getJumlahSapi(username) + "");
        theVinventori.setTeksSuntikan(theMaset.getJumlahSuntikan(username) + "");
        theVinventori.setTeksRumput(theMaset.getJumlahRumput(username) + "");
        theVinventori.setTeksSusu(theMaset.getJumlahSusu(username) + "");
        theVinventori.setTeksObat(theMaset.getJumlahObat(username) + "");
        theVinventori.setTeksNutrisi(theMaset.getJumlahNutrisi(username) + "");
        theVinventori.setTeksKandang(theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) + "");

        theVinventori.kembaliBtn().addActionListener(new kembaliAction());
        theVinventori.setVisible(true);
    }

    public v_inventori getview() {
        return theVinventori;
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playHome();
            theVinventori.setVisible(false);
            viewsebelumnya.setVisible(true);
        }

    }

}
