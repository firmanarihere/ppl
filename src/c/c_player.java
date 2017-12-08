/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import m.m_aset;
import m.m_player;
import v.v_halaman;
import v.v_login;

/**
 *
 * @author Rangora
 */
public class c_player {

    private v_halaman theVhalaman;
    private v_login theV;
    private m_player theM;
    private m_aset theMaset;
    private AudioInputStream audio;
    private Clip clip;
    private int timeCounter = 0;
    private Random angka = new Random();

    public c_player() throws SQLException {
        this.theVhalaman = new v_halaman();
        this.theV = new v_login();
        this.theM = new m_player();
        this.theMaset = new m_aset();
        music();
        theV.tombolLogin(new loginAction());
        theV.tombolCreateAccount(new createAccountAction());
        theV.cancelButton().addActionListener(new cancelCreateAction());
        theV.createButton().addActionListener(new createAction());

        this.theV.setVisible(true);
    }

    public void music() {
        try {
            audio = AudioSystem.getAudioInputStream(new File("src//sound//Awal game.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theV.getUsername().isEmpty()) {
                    theV.tampilPesan("Silahkan isi username dahulu");
                } else if (theV.getPassword().isEmpty()) {
                    theV.tampilPesan("Silahkan isi password dulu");
                } else if (theM.getPlayer(theV.getUsername(), theV.getPassword())) {
                    if (theM.getUsername(theV.getUsername()).equals(theV.getUsername()) && theMaset.getPassword(theM.getUsername(theV.getUsername())).equals(theV.getPassword())) {
                        new c_halaman(theV.getUsername());
                        clip.stop();
                        theV.dispose();
                    }else{
                        theV.tampilPesan("Username/Password Salah");
                    }
                } else {
                    theV.tampilPesan("Username/Password Salah");
                }
            } catch (SQLException ex) {
                System.out.println("ada sesuatu");
            } catch (Exception ex) {
                Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class createAccountAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theV.createAccount().setVisible(true);
            theV.disable();
        }

    }

    private class cancelCreateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theV.enable();
            theV.createAccount().dispose();
        }

    }

    private boolean usernameSama(String usernameDatabase, String username) throws SQLException {
        boolean status = false;
        try {
            if (theM.getUsername(usernameDatabase).equalsIgnoreCase(username)) {
                status = true;
            }
        } catch (SQLException e) {
            status = false;
        }

        return status;
    }

    private class createAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idPlayer = theM.cekId();
                if (theV.getUsernameCreate().isEmpty() || theV.getPasswordCreate().isEmpty()) {
                    theV.tampilPesan("Username/Password Tidak Boleh Kosong");
                } else if (usernameSama(theV.getUsernameCreate(), theV.getUsernameCreate())) {
                    theV.tampilPesan("Username sudah ada");
                } else if (theM.insertDataPlayer(idPlayer, theV.getUsernameCreate(), theV.getPasswordCreate())) {
                    theV.tampilPesan("Akun berhasil dibuat");
                    theV.setUsernameCreate("");
                    theV.setPasswordCreate("");
                    theMaset.insertDataAsetPlayerBaru(theMaset.cekIdAset(), idPlayer);
                    for (int i = 0; i < 2; i++) {
                        theMaset.insertDataSapi(theMaset.cekIdSapi(), (idPlayer + ""));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
