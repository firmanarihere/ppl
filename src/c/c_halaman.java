/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.m_aset;
import v.v_dalamKandang;
import v.v_halaman;
import Musik.Play_musik;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangora
 */
public class c_halaman {

    private v_dalamKandang theVkandang;
    private v_halaman theVhalaman;
    private Play_musik play;
    private m_aset theMaset;
    private String username;
    private boolean statusButton = true;
    private int kandang;
    private int koin;
    private int syarat;
    private int hargaKandang;
    private int timeCounter = 0;
    private Random angka = new Random();
    private Thread rTime;
    int tambah;
    int kurang;

    public c_halaman(String username) throws SQLException, Exception {
        this.theVkandang = new v_dalamKandang();
        this.theVhalaman = new v_halaman();
        this.play = new Play_musik();
        this.theMaset = new m_aset();
        this.username = username;

        rumputTime rTime = new rumputTime();
        this.rTime = rTime;
        rTime.start();
        play.playHome();

        theVhalaman.buttonProfile().setVisible(false);
        theVhalaman.buttonInventori().setVisible(false);
        theVhalaman.buttonHelp().setVisible(false);
        theVhalaman.buttonAbout().setVisible(false);
        theVhalaman.buttonLogout().setVisible(false);

        koin = theVhalaman.setTeksKoin(theMaset.getJumlahKoin(username));
        theVhalaman.setTeksRumput(theMaset.getJumlahRumput(username));
        theVhalaman.setTeksSapi(theMaset.getJumlahSapi(username) + "");
        kandang = theMaset.getJumlahKandang(theMaset.cekIdPlayer(username));

        theVhalaman.tombolshop(new shopAction());

        kandangAction kandangAction = new kandangAction();
        for (int i = 0; i < 6; i++) {
            theVhalaman.getButtonKandang()[i].addActionListener(kandangAction);
        }
        for (int i = 0; i < 10; i++) {
            theVhalaman.getButtonRumput()[i].addActionListener(new rumputGratisAction());
        }
        for (int i = 0; i < 5; i++) {
            theVhalaman.getButtonPapan()[i].addActionListener(new PapanAction());
        }
        theVhalaman.buttonMenu().addActionListener(new menuAction());
        theVhalaman.buttonProfile().addActionListener(new profileAction());
        theVhalaman.buttonInventori().addActionListener(new inventoriAction());
        theVhalaman.buttonHelp().addActionListener(new helpAction());
        theVhalaman.buttonAbout().addActionListener(new aboutAction());
        theVhalaman.buttonLogout().addActionListener(new logoutAction());
        theVhalaman.cancelProfile().addActionListener(new cancelProfile());
        theVhalaman.changeProfile().addActionListener(new changeProfile());
        tampilPapan(kandang);
        tampilKandang(kandang);
        syaratBeliKandang(kandang);
        this.theVhalaman.setVisible(true);
    }

    private void tampilKandang(int jumlahKandang) {
        if (jumlahKandang == 1) {
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        } else if (jumlahKandang == 2) {
            for (int i = 0; i < 6; i++) {
                if (i <= 1) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        } else if (jumlahKandang == 3) {
            for (int i = 0; i < 6; i++) {
                if (i <= 2) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        } else if (jumlahKandang == 4) {
            for (int i = 0; i < 6; i++) {
                if (i <= 3) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        } else if (jumlahKandang == 5) {
            for (int i = 0; i < 6; i++) {
                if (i <= 4) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        } else if (jumlahKandang == 6) {
            for (int i = 0; i < 6; i++) {
                if (i <= 5) {
                    theVhalaman.getButtonKandang()[i].setVisible(true);
                } else {
                    theVhalaman.getButtonKandang()[i].setVisible(false);
                }
            }
        }
    }

    private void syaratBeliKandang(int jumlahKandang) {
        if (jumlahKandang == 1) {
            syarat = 50;
            hargaKandang = 5000;
        } else if (jumlahKandang == 2) {
            syarat = 100;
            hargaKandang = 7000;
        } else if (jumlahKandang == 3) {
            syarat = 200;
            hargaKandang = 10000;
        } else if (jumlahKandang == 4) {
            syarat = 400;
            hargaKandang = 14000;
        } else if (jumlahKandang == 5) {
            syarat = 800;
            hargaKandang = 19000;
        }
    }

    private void tampilPapan(int jumlahKandang) {
        if (jumlahKandang == 1) {
            theVhalaman.getButtonPapan()[0].setVisible(true);
            theVhalaman.getButtonPapan()[1].setVisible(false);
            theVhalaman.getButtonPapan()[2].setVisible(false);
            theVhalaman.getButtonPapan()[3].setVisible(false);
            theVhalaman.getButtonPapan()[4].setVisible(false);
        } else if (jumlahKandang == 2) {
            theVhalaman.getButtonPapan()[0].setVisible(false);
            theVhalaman.getButtonPapan()[1].setVisible(true);
            theVhalaman.getButtonPapan()[2].setVisible(false);
            theVhalaman.getButtonPapan()[3].setVisible(false);
            theVhalaman.getButtonPapan()[4].setVisible(false);
        } else if (jumlahKandang == 3) {
            theVhalaman.getButtonPapan()[0].setVisible(false);
            theVhalaman.getButtonPapan()[1].setVisible(false);
            theVhalaman.getButtonPapan()[2].setVisible(true);
            theVhalaman.getButtonPapan()[3].setVisible(false);
            theVhalaman.getButtonPapan()[4].setVisible(false);
        } else if (jumlahKandang == 4) {
            theVhalaman.getButtonPapan()[0].setVisible(false);
            theVhalaman.getButtonPapan()[1].setVisible(false);
            theVhalaman.getButtonPapan()[2].setVisible(false);
            theVhalaman.getButtonPapan()[3].setVisible(true);
            theVhalaman.getButtonPapan()[4].setVisible(false);
        } else if (jumlahKandang == 5) {
            theVhalaman.getButtonPapan()[0].setVisible(false);
            theVhalaman.getButtonPapan()[1].setVisible(false);
            theVhalaman.getButtonPapan()[2].setVisible(false);
            theVhalaman.getButtonPapan()[3].setVisible(false);
            theVhalaman.getButtonPapan()[4].setVisible(true);
        }

    }

    private class PapanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theVhalaman.tampilYesNo("Yakin beli kandang baru ?") == JOptionPane.YES_OPTION) {
                syaratBeliKandang(kandang);
                try {
                    if (theMaset.getJumlahKoin(username) >= hargaKandang && theMaset.getJumlahSusu(username) >= syarat) {
                        if (e.getActionCommand().equalsIgnoreCase("papan1")) {
                            theVhalaman.getButtonPapan()[0].setVisible(false);
                            theVhalaman.getButtonPapan()[1].setVisible(true);
                        } else if (e.getActionCommand().equalsIgnoreCase("papan2")) {
                            theVhalaman.getButtonPapan()[1].setVisible(false);
                            theVhalaman.getButtonPapan()[2].setVisible(true);
                        } else if (e.getActionCommand().equalsIgnoreCase("papan3")) {
                            theVhalaman.getButtonPapan()[2].setVisible(false);
                            theVhalaman.getButtonPapan()[3].setVisible(true);
                        } else if (e.getActionCommand().equalsIgnoreCase("papan4")) {
                            theVhalaman.getButtonPapan()[3].setVisible(false);
                            theVhalaman.getButtonPapan()[4].setVisible(true);
                        } else if (e.getActionCommand().equalsIgnoreCase("papan5")) {
                            for (int i = 0; i < 5; i++) {
                                theVhalaman.getButtonPapan()[i].setVisible(false);
                            }
                        }
                        koin -= hargaKandang;
                        kandang += 1;
                        try {
                            theMaset.updateDataKandang(kandang, theMaset.cekIdPlayer(username));
                            theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                            theVhalaman.setTeksKoin(theMaset.getJumlahKoin(username));
                            kandang = theMaset.getJumlahKandang(theMaset.cekIdPlayer(username));
                        } catch (SQLException ex) {
                            Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tampilPapan(kandang);
                        tampilKandang(kandang);
                        theVhalaman.tampilPesan("Beli Kandang Berhasil");
                    } else {
                        theVhalaman.tampilPesan("SYARAT BELI KANDANG \n Koin yg diperlukan: " + hargaKandang + " \n Jumlah susu yg diperlukan: " + syarat);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private class rumputGratisAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < theVhalaman.getButtonRumput().length; i++) {
                if (e.getActionCommand().equalsIgnoreCase("rumput" + (i + 1))) {
                    try {
                        theMaset.updateDataRumput(theMaset.getJumlahRumput(username) + 1, theMaset.cekIdPlayer(username));
                    } catch (SQLException ex) {
                        Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    theVhalaman.getButtonRumput()[i].setVisible(false);
                }
            }
            try {
                theVhalaman.setTeksRumput(theMaset.getJumlahRumput(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class menuAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusButton) {
                theVhalaman.buttonProfile().setVisible(true);
                theVhalaman.buttonInventori().setVisible(true);
                theVhalaman.buttonHelp().setVisible(true);
                theVhalaman.buttonAbout().setVisible(true);
                theVhalaman.buttonLogout().setVisible(true);
                statusButton = false;
            } else {
                theVhalaman.buttonProfile().setVisible(false);
                theVhalaman.buttonInventori().setVisible(false);
                theVhalaman.buttonHelp().setVisible(false);
                theVhalaman.buttonAbout().setVisible(false);
                theVhalaman.buttonLogout().setVisible(false);
                statusButton = true;
            }
        }

    }

    private class profileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theVhalaman.profile().setVisible(true);
            theVhalaman.usernmaeProfile().setText(username);
        }

    }

    private class cancelProfile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theVhalaman.profile().dispose();
        }

    }

    private class changeProfile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theVhalaman.oldPass().getText().isEmpty()) {
                    theVhalaman.tampilPesan("Silakan masukkan password lama anda dulu !!!");
                } else if (!theVhalaman.oldPass().getText().equalsIgnoreCase(theMaset.getPassword(username))) {
                    theVhalaman.tampilPesan("Password lama anda salah");
                } else if (theVhalaman.newPass().getText().isEmpty()) {
                    theVhalaman.tampilPesan("Silakan masukkan password baru anda dulu !!!");
                } else if (theMaset.updatePassword(theVhalaman.newPass().getText(), username)) {
                    theVhalaman.tampilPesan("Password berhasil diganti");
                    theVhalaman.profile().dispose();
                } else {
                    System.out.println("query salah");
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class inventoriAction implements ActionListener {

        private c_inventori profile;

        public inventoriAction() throws SQLException {
            profile = new c_inventori(username, theVhalaman, play);
            profile.getview().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                profile.theVinventori.setTeksSuntikan(theMaset.getJumlahSuntikan(username) + "");
                profile.theVinventori.setTeksRumput(theMaset.getJumlahRumput(username) + "");
                profile.theVinventori.setTeksSusu(theMaset.getJumlahSusu(username) + "");
                profile.theVinventori.setTeksObat(theMaset.getJumlahObat(username) + "");
                profile.theVinventori.setTeksNutrisi(theMaset.getJumlahNutrisi(username) + "");
                profile.theVinventori.setTeksKandang(theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) + "");
                profile.theVinventori.setTeksSapiBesar(theMaset.getJumlahSapi(username) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            }
            play.playInventori();
            play.StopMusik();
            theVhalaman.setVisible(false);
            profile.getview().setVisible(true);
        }

    }

    private class helpAction implements ActionListener {

        private c_help help;

        public helpAction() {
            help = new c_help(theVhalaman, play);
            help.getview().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playHelp();
            play.StopMusik();
            theVhalaman.setVisible(false);
            help.getview().setVisible(true);
        }

    }

    private class aboutAction implements ActionListener {

        private c_about about;

        public aboutAction() {
            about = new c_about(theVhalaman, play);
            about.getview().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            play.playAbout();
            play.StopMusik();
            theVhalaman.setVisible(false);
            about.getview().setVisible(true);
        }

    }

    private class logoutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theVhalaman.tampilYesNo("Yakin keluar akun") == JOptionPane.YES_OPTION) {
                play.StopMusik();
                play.playKeluarKandang();
                try {
                    new c_player();
                    rTime.stop();
                } catch (SQLException ex) {
                    Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                }
                theVhalaman.dispose();
            }
        }

    }

    private class shopAction implements ActionListener {

        private c_aset shop;

        public shopAction() throws SQLException {
            shop = new c_aset(username, c_halaman.this, theVhalaman, play);
            shop.getview().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                shop.theVshop.setRumput(theMaset.getJumlahRumput(username));
                shop.theVshop.setNutrisi(theMaset.getJumlahNutrisi(username));
                shop.theVshop.setSuntikan(theMaset.getJumlahSuntikan(username));
                shop.theVshop.setObat(theMaset.getJumlahObat(username));
                shop.theVshop.setSusu(theMaset.getJumlahSusu(username));
                shop.theVshop.setSapi(theMaset.getJumlahSapi(username));
                play.playShop();
                play.StopMusik();
                theVhalaman.setVisible(false);
                shop.getview().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setTambah(int jumlah) {
        tambah = jumlah;
    }

    public void setKurang(int jumlah) {
        kurang = jumlah;
    }

    public class kandangAction implements ActionListener {

        c_kandang kandang[] = new c_kandang[6];

        public kandangAction() throws Exception {
            for (int i = 0; i < 6; i++) {
                kandang[i] = new c_kandang(username, "kandang" + (i + 1), c_halaman.this, theVhalaman, play);
                kandang[i].getview().setVisible(false);
            }
            updateSapi us = new updateSapi();
            us.start();
        }

        private class updateSapi extends Thread {

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        System.out.println("tambah : " + tambah);
                        System.out.println("kurang : " + kurang);
                        for (int i = 0; i < 6; i++) {
                            if (tambah > 0) {
                                System.out.println(kandang[i].kandangKosong());
                                if (kandang[i].kandangKosong() != 0) {
                                    if (tambah > kandang[i].kandangKosong()) {
                                        System.out.println(kandang[i].kandangKosong());
                                        tambah = tambah - kandang[i].kandangKosong();
                                        kandang[i].tambahSapi(kandang[i].kandangKosong());
                                        System.out.println(tambah);
                                        System.out.println("this");
                                    } else {
                                        System.out.println(tambah);
                                        kandang[i].tambahSapi(tambah);
                                        tambah = 0;
                                        System.out.println(tambah);
                                        System.out.println("else");
                                    }
                                }
                            }
                        }
                        for (int i = 5; i >= 0; i--) {
                            if (kurang > 0) {
                                System.out.println(kandang[i].kandangBerisi());
                                if (kandang[i].kandangBerisi() != 0) {
                                    if (kurang > kandang[i].kandangBerisi()) {
                                        System.out.println(kandang[i].kandangBerisi());
                                        kurang = kurang - kandang[i].kandangBerisi();
                                        kandang[i].kurangSapi(kandang[i].kandangBerisi());
                                        System.out.println(kurang);
                                        System.out.println("this");
                                    } else {
                                        System.out.println(kurang);
                                        kandang[i].kurangSapi(kurang);
                                        kurang = 0;
                                        System.out.println(kurang);
                                        System.out.println("else");
                                    }
                                }
                            }
                        }
                        tambah = 0;
                        System.out.println("done");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String t = e.getActionCommand();
                for (int i = 0; i < 6; i++) {
                    if (t.equalsIgnoreCase("kandang" + (i + 1))) {
                        kandang[i].getview().setVisible(true);
                        kandang[i].getView().setRumput(theMaset.getJumlahRumput(username));
                        kandang[i].getView().setNutrisi(theMaset.getJumlahNutrisi(username));
                        kandang[i].getView().setSuntikan(theMaset.getJumlahSuntikan(username));
                        kandang[i].getView().setObat(theMaset.getJumlahObat(username));
                        kandang[i].getView().setSusu(theMaset.getJumlahSusu(username));
                        kandang[i].sapi = theMaset.getJumlahSapi(username);
                    }
                }
                play.playKandang();
                play.playSapi1();
                play.playSapi2();
                play.playSapi3();
                theVhalaman.setVisible(false);
                play.StopMusik();
            } catch (InterruptedException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class rumputTime extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    theVhalaman.setTeksRumput(theMaset.getJumlahRumput(username));
                    theVhalaman.setTeksSapi(theMaset.getJumlahSapi(username) + "");
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
                }
                timeCounter += 1;
                int randomRumput = angka.nextInt(10);//masi ada bug
                if (timeCounter % 20 == 0 && timeCounter > 0) {
                    theVhalaman.getButtonRumput()[randomRumput].setVisible(true);
                }
                if (timeCounter == 150) {
                    timeCounter = 0;
                    for (int i = 0; i < theVhalaman.getButtonRumput().length; i++) {
                        theVhalaman.getButtonRumput()[i].setVisible(false);
                    }
                }
            }
        }
    }
}
