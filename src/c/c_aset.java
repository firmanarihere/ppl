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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import m.m_aset;
import v.v_shopPopUp;
import v.v_shop;
import Musik.Play_musik;
import v.v_halaman;

/**
 *
 * @author Rangora
 */
public class c_aset {
    
    v_shop theVshop;
    v_shopPopUp theVpopUp;
    Play_musik play;
    m_aset theMaset;
    String username;
    String statusShop = "buy";
    boolean statusRumput = false;
    boolean statusSapi = false;
    boolean statusNutrisi = false;
    boolean statusSuntikan = false;
    boolean statusMedic = false;
    boolean statusSusu = false;
    int koin;
    int sapi;
    int rumput;
    int nutrisi;
    int suntik;
    int obat;
    int susu;
    int jumlah = 1;
    AudioInputStream audio;
    Clip clip;
    v_halaman viewsebelumnya;
    
    public c_aset(String username, v_halaman viewsebelumnya,Play_musik play) throws SQLException {
        theVshop = new v_shop();
        theVpopUp = new v_shopPopUp();
        theMaset = new m_aset();
        this.play = play;
        this.username = username;
        this.viewsebelumnya = viewsebelumnya;
        
        sapi = theVshop.setSapi(theMaset.getJumlahSapi(username));
        koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
        rumput = theVshop.setRumput(theMaset.getJumlahRumput(username));
        nutrisi = theVshop.setNutrisi(theMaset.getJumlahNutrisi(username));
        suntik = theVshop.setSuntikan(theMaset.getJumlahSuntikan(username));
        obat = theVshop.setObat(theMaset.getJumlahObat(username));
        susu = theVshop.setSusu(theMaset.getJumlahSusu(username));
        jumlah = theVpopUp.getTeksJumlah();
        
        theVshop.homeButton(new homeAction());
        theVshop.getBuyButton().addActionListener(new buyAction());
        theVshop.getSellButton().addActionListener(new sellAction());
        
        theVshop.sapiButton(new sapiClick());
        theVshop.rumputButton(new rumputClick());
        theVshop.nutrisiButton(new nutrisiClick());
        theVshop.suntikanButton(new suntikClick());
        theVshop.obatButton(new obatClick());
        theVshop.susuButton(new susuClick());
        //popUp
        theVpopUp.arahKiri(new panahKiriButton());
        theVpopUp.arahKanan(new panahKananButton());
        theVpopUp.tombolBuy(new buyPopUp());
        theVpopUp.tombolSell(new buyPopUp());
        theVpopUp.tombolCancel(new cancelButton());
        
        theVshop.getBuyLabel().setVisible(true);
        theVshop.getBuyButton().setVisible(false);
        theVshop.getSellLabel().setVisible(false);
        theVshop.getSusuIcon().setVisible(false);
        theVshop.getSusuPrice().setVisible(false);
        theVshop.getSusuButton().setVisible(false);
        theVshop.getKoinIcon().setVisible(false);
        theVshop.setVisible(true);
    }
    
    public v_shop getview() {
        return theVshop;
    }
    
    private class homeAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            viewsebelumnya.setVisible(true);
            theVshop.setVisible(false);
            play.playHome();
        }
        
    }
    
    private class buyAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            theVshop.getSusuIcon().setVisible(false);
            theVshop.getSusuPrice().setVisible(false);
            theVshop.getSusuButton().setVisible(false);
            theVshop.getKoinIcon().setVisible(false);
            statusShop = "buy";
            theVshop.setSapiPrice(1000);
            theVshop.setRumputPrice(1000);
            theVshop.setNutrisiPrice(1000);
            theVshop.setSuntikPrice(1000);
            theVshop.setObatPrice(1000);
            theVshop.setSusuPrice(1000);
            theVshop.getBuyLabel().setVisible(true);
            theVshop.getBuyButton().setVisible(false);
            theVshop.getSellLabel().setVisible(false);
            theVshop.getSellButton().setVisible(true);
        }
        
    }
    
    private class sellAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            theVshop.getSusuIcon().setVisible(true);
            theVshop.getSusuPrice().setVisible(true);
            theVshop.getSusuButton().setVisible(true);
            theVshop.getKoinIcon().setVisible(true);
            statusShop = "sell";
            theVshop.setSapiPrice(500);
            theVshop.setRumputPrice(500);
            theVshop.setNutrisiPrice(500);
            theVshop.setSuntikPrice(500);
            theVshop.setObatPrice(500);
            theVshop.setSusuPrice(500);
            theVshop.getSellLabel().setVisible(true);
            theVshop.getSellButton().setVisible(false);
            theVshop.getBuyLabel().setVisible(false);
            theVshop.getBuyButton().setVisible(true);
        }
        
    }
    
    private class rumputClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusRumput = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Rumput.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private class sapiClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusSapi = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sapi dewasa.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private class nutrisiClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusNutrisi = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nutrisi.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private class suntikClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusSuntikan = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/suntik sapi.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private class obatClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusMedic = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/medic.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private class susuClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusSusu = true;
            if (statusShop.equalsIgnoreCase("buy")) {
                theVpopUp.getButtonBuy().setVisible(true);
                theVpopUp.getButtonSell().setVisible(false);
            } else if (statusShop.equalsIgnoreCase("sell")) {
                theVpopUp.getButtonBuy().setVisible(false);
                theVpopUp.getButtonSell().setVisible(true);
            }
            theVpopUp.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/susu.png")));
            theVpopUp.getButtonKiri().setEnabled(false);
            theVpopUp.setVisible(true);
        }
        
    }
    
    private int jumlahSapiMaksimal(int jumlahKandang) {
        int jumlahK = 0;
        if (jumlahKandang == 1) {
            jumlahK = 6;
        } else if (jumlahKandang == 2) {
            jumlahK = 12;
        } else if (jumlahKandang == 3) {
            jumlahK = 18;
        } else if (jumlahKandang == 4) {
            jumlahK = 24;
        } else if (jumlahKandang == 5) {
            jumlahK = 30;
        } else if (jumlahKandang == 6) {
            jumlahK = 36;
        }
        return jumlahK;
    }
    
    private void sapiAction() {
        int id = 1;
        try {
            if (statusShop.equalsIgnoreCase("buy")) {
                if ((sapi + jumlah) <= jumlahSapiMaksimal(theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)))) {
                    if (koin >= (jumlah * 1000)) {
                        for (int i = 0; i < jumlah; i++) {
                            if (theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username))) {
                                koin = koin - 1000;
                                theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                            } else {
                                System.out.println("beli gagal");
                            }
                        }
                        theVshop.tampilPesan("Transkasi berhasil");
                        koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
                        sapi = theVshop.setSapi(theMaset.getJumlahSapi(username));
                    } else {
                        theVshop.tampilPesan("Koin Anda Tidak Mencukupi");
                    }
                } else {
                    theVshop.tampilPesan("Ruang dalam tidak cukup");
                    
                }
            } else if (statusShop.equalsIgnoreCase("sell")) {
                if (jumlah <= sapi) {
                    for (int i = 0; i < jumlah; i++) {
                        if (theMaset.deleteSapi(theMaset.getIdSapi(theMaset.cekIdPlayer(username)), theMaset.cekIdPlayer(username))) {
                            koin = koin + 500;
                            theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        }
                    }
                    theVshop.tampilPesan("Transkasi berhasil");
                    koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
                    sapi = theVshop.setSapi(theMaset.getJumlahSapi(username));
                } else {
                    theVshop.tampilPesan("Jumlah yang anda masukkan tidak sesuai");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void rumputAction() {
        try {
            if (statusShop.equalsIgnoreCase("buy")) {
                if (koin >= (jumlah * 1000)) {
                    rumput = rumput + jumlah;
                    if (theMaset.updateDataRumput(rumput, theMaset.cekIdPlayer(username))) {
                        koin = koin - (1000 * jumlah);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Koin Anda Tidak Mencukupi");
                }
            } else if (statusShop.equalsIgnoreCase("sell")) {
                if (rumput >= jumlah) {
                    rumput = rumput - jumlah;
                    if (theMaset.updateDataRumput(rumput, theMaset.cekIdPlayer(username))) {
                        koin = koin + (jumlah * 500);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Jumlah yg anda masukkan tidak sesuai");
                }
            }
            koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
            rumput = theVshop.setRumput(theMaset.getJumlahRumput(username));
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nutrisiAction() {
        try {
            if (statusShop.equalsIgnoreCase("buy")) {
                if (koin >= (jumlah * 1000)) {
                    nutrisi = nutrisi + jumlah;
                    if (theMaset.updateDataNutisi(nutrisi, theMaset.cekIdPlayer(username))) {
                        koin = koin - (jumlah * 1000);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Koin Anda Tidak Mencukupi");
                }
            } else if (statusShop.equalsIgnoreCase("sell")) {
                if (nutrisi >= jumlah) {
                    nutrisi = nutrisi - jumlah;
                    if (theMaset.updateDataNutisi(nutrisi, theMaset.cekIdPlayer(username))) {
                        koin = koin + (jumlah * 500);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Jumlah anda yg anda masukkan tidak sesuai");
                }
            }
            koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
            nutrisi = theVshop.setNutrisi(theMaset.getJumlahNutrisi(username));
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void suntikAction() {
        try {
            if (statusShop.equalsIgnoreCase("buy")) {
                if (koin >= (jumlah * 1000)) {
                    suntik = suntik + jumlah;
                    if (theMaset.updateDataSuntikan(suntik, theMaset.cekIdPlayer(username))) {
                        koin = koin - (jumlah * 1000);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Koin Anda Tidak Mencukupi");
                    
                }
            } else if (statusShop.equalsIgnoreCase("sell")) {
                if (suntik >= jumlah) {
                    suntik = suntik - jumlah;
                    if (theMaset.updateDataSuntikan(suntik, theMaset.cekIdPlayer(username))) {
                        koin = koin + (jumlah * 500);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Jumlah yg anda masukkan tidak sesuai");
                }
            }
            koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
            suntik = theVshop.setSuntikan(theMaset.getJumlahSuntikan(username));
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void obatAction() {
        try {
            if (statusShop.equalsIgnoreCase("buy")) {
                if (koin >= (jumlah * 1000)) {
                    obat = obat + jumlah;
                    if (theMaset.updateDataObat(obat, theMaset.cekIdPlayer(username))) {
                        koin = koin - (jumlah * 1000);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Koin Anda Tidak Mencukupi");
                }
            } else if (statusShop.equalsIgnoreCase("sell")) {
                if (obat >= jumlah) {
                    obat = obat - jumlah;
                    if (theMaset.updateDataObat(obat, theMaset.cekIdPlayer(username))) {
                        koin = koin + (jumlah * 500);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Jumlah yg anda masukkan tidak sesuai");
                    
                }
            }
            koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
            obat = theVshop.setObat(theMaset.getJumlahObat(username));
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void susuAction() {
        try {
            if (statusShop.equalsIgnoreCase("sell")) {
                if (susu >= jumlah) {
                    susu = susu - jumlah;
                    if (theMaset.updateDataSusu(susu, theMaset.cekIdPlayer(username))) {
                        koin = koin + (jumlah * 500);
                        theMaset.updateDataKoin(koin, theMaset.cekIdPlayer(username));
                        theVshop.tampilPesan("Transkasi berhasil");
                    } else {
                        System.out.println("gagal");
                    }
                } else {
                    theVshop.tampilPesan("Jumlah yg anda masukkan tidak sesuai");
                    
                }
            }
            koin = theVshop.setKoin(theMaset.getJumlahKoin(username));
            susu = theVshop.setSusu(theMaset.getJumlahSusu(username));
        } catch (SQLException ex) {
            Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //pop up
    private class panahKiriButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jumlah <= 2) {
                theVpopUp.getButtonKiri().setEnabled(false);
            }
            jumlah = jumlah - 1;
            theVpopUp.setTeksJumlah(jumlah + "");
        }
    }
    
    private class panahKananButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            theVpopUp.getButtonKiri().setEnabled(true);
            jumlah = jumlah + 1;
            theVpopUp.setTeksJumlah(jumlah + "");
        }
        
    }
    
    private class buyPopUp implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                audio = AudioSystem.getAudioInputStream(new File("src//sound//Coin achieve.wav"));
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            } catch (Exception ex) {
                Logger.getLogger(c_aset.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (statusRumput) {
                rumputAction();
            } else if (statusSapi) {
                sapiAction();
            } else if (statusNutrisi) {
                nutrisiAction();
            } else if (statusSuntikan) {
                suntikAction();
            } else if (statusMedic) {
                obatAction();
            } else if (statusSusu) {
                susuAction();
            }
            statusRumput = false;
            statusSapi = false;
            statusNutrisi = false;
            statusSuntikan = false;
            statusMedic = false;
            statusSusu = false;
            jumlah = 1;
            theVpopUp.setTeksJumlah(jumlah + "");
            theVpopUp.dispose();
        }
        
    }
    
    private class cancelButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            statusRumput = false;
            statusSapi = false;
            statusNutrisi = false;
            statusSuntikan = false;
            statusMedic = false;
            statusSusu = false;
            jumlah = 1;
            theVpopUp.setTeksJumlah(jumlah + "");
            theVpopUp.dispose();
        }
        
    }
    
}
