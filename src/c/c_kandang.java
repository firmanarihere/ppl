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
public class c_kandang {

    v_dalamKandang theVkandang;
    v_halaman theVhalaman;
    Play_musik play;
    m_aset theMaset;
    String username;
    String statusKandang;
    int rumput;
    int nutrisi;
    int suntik;
    int obat;
    int susu;
    int sapi;
    String sapiStatus;
    String tempatStatus;
    int menit = 0;
    //ini buat tempatMAkann
    boolean makan1 = false;
    boolean makan2 = false;
    boolean makan3 = false;
    boolean makan4 = false;
    boolean makan5 = false;
    boolean makan6 = false;

    //ini buat sapi
    boolean statusPencet1 = false;
    boolean statusPencet2 = false;
    boolean statusPencet3 = false;
    boolean statusPencet4 = false;
    boolean statusPencet5 = false;
    boolean statusPencet6 = false;

    Thread laparSakitTime;

    int hamil;
    int detik[] = {0, 0, 0, 0, 0, 0};
    int sakit[] = {0, 0, 0, 0, 0, 0};
    int lapar[] = {0, 0, 0, 0, 0, 0};
    int detikSusu[] = {0, 0, 0, 0, 0, 0};
    int detikSusuHilang[] = {0, 0, 0, 0, 0, 0};
    boolean[] susuMuncul = {false, false, false, false, false, false};
    Random random = new Random();
    boolean sapiKecil = false;
    v_halaman viewsebelumnya;

    public c_kandang(String username, String kandang, v_halaman viewsebelumnya, Play_musik play) throws SQLException, InterruptedException {
        this.theVkandang = new v_dalamKandang();
        this.theVhalaman = new v_halaman();
        this.play = play;
        this.theMaset = new m_aset();
        this.viewsebelumnya = viewsebelumnya;

        this.username = username;
        this.statusKandang = kandang;
        sakitStat cobaSakit = new sakitStat();
        laparSakitTime = cobaSakit;
        laparSakitTime.start();
        play.playKandang();
        play.playSapi1();
        play.playSapi2();
        play.playSapi3();
        rumput = theVkandang.setRumput(theMaset.getJumlahRumput(username));
        nutrisi = theVkandang.setNutrisi(theMaset.getJumlahNutrisi(username));
        suntik = theVkandang.setSuntikan(theMaset.getJumlahSuntikan(username));
        obat = theVkandang.setObat(theMaset.getJumlahObat(username));
        susu = theVkandang.setSusu(theMaset.getJumlahSusu(username));
        sapi = theMaset.getJumlahSapi(username);

        theVkandang.suntikSapi().setVisible(false);
        theVkandang.obatSapi().setVisible(false);
        theVkandang.nutrisiSapi().setVisible(false);
        theVkandang.rumputSapi().setVisible(false);
        theVkandang.airSapi().setVisible(false);

        theVkandang.homeButton().addActionListener(new homeAction());
        theVkandang.suntikSapi().addActionListener(new suntikDipakai());
        theVkandang.obatSapi().addActionListener(new obatDipakai());
        theVkandang.nutrisiSapi().addActionListener(new nutrisiDipakai());
        theVkandang.rumputSapi().addActionListener(new rumputDipakai());
        for (int i = 0; i < 6; i++) {
            theVkandang.susu()[i].addActionListener(new susuAction());
            theVkandang.getSakit()[i].setVisible(false);
            theVkandang.getLapar()[i].setVisible(false);
        }
        //sapi dan tempat makan
        for (int i = 0; i < 7; i++) {
            theVkandang.sapiButton()[i].addActionListener(new sapiAction());
            theVkandang.tempatMakanButton()[i].addActionListener(new tempatMakanAction());
            theVkandang.sapiButton()[i].setVisible(false);
        }

        tampilSapi(theMaset.getJumlahSapi(username), kandang);
        theVkandang.setVisible(true);
    }

    public v_dalamKandang getview() {
        return theVkandang;
    }

    private void tampilSapi(int jumlahSapi, String noKandang) {
        if (jumlahSapi > 0 && jumlahSapi < 6) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                System.out.println(jumlahSapi);
                if (jumlahSapi == 0) {
                    for (int i = 1; i < 7; i++) {
                        theVkandang.sapiButton()[i].setVisible(false);
                    }
                } else if (jumlahSapi == 1) {
                    theVkandang.sapiButton()[1].setVisible(true);
                } else if (jumlahSapi == 2) {
                    theVkandang.sapiButton()[1].setVisible(true);
                    theVkandang.sapiButton()[2].setVisible(true);
                } else if (jumlahSapi == 3) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 4) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            }
        } else if (jumlahSapi >= 6 && jumlahSapi < 12) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                if (jumlahSapi == 7) {
                    theVkandang.sapiButton()[1].setVisible(true);
                } else if (jumlahSapi == 8) {
                    theVkandang.sapiButton()[1].setVisible(true);
                    theVkandang.sapiButton()[2].setVisible(true);
                } else if (jumlahSapi == 9) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 10) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 11) {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            }
        } else if (jumlahSapi >= 12 && jumlahSapi < 18) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                if (jumlahSapi == 12) {
                    for (int i = 1; i < 7; i++) {
                        theVkandang.sapiButton()[i].setVisible(false);
                    }
                } else if (jumlahSapi == 13) {
                    theVkandang.sapiButton()[1].setVisible(true);
                } else if (jumlahSapi == 14) {
                    theVkandang.sapiButton()[1].setVisible(true);
                    theVkandang.sapiButton()[2].setVisible(true);
                } else if (jumlahSapi == 15) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 16) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            }
        } else if (jumlahSapi >= 18 && jumlahSapi < 24) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                if (jumlahSapi == 18) {
                    for (int i = 1; i < 7; i++) {
                        theVkandang.sapiButton()[i].setVisible(false);
                    }
                } else if (jumlahSapi == 19) {
                    theVkandang.sapiButton()[1].setVisible(true);
                } else if (jumlahSapi == 20) {
                    theVkandang.sapiButton()[1].setVisible(true);
                    theVkandang.sapiButton()[2].setVisible(true);
                } else if (jumlahSapi == 21) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 22) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            }
        } else if (jumlahSapi >= 24 && jumlahSapi < 30) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                if (jumlahSapi == 24) {
                    for (int i = 1; i < 7; i++) {
                        theVkandang.sapiButton()[i].setVisible(false);
                    }
                } else if (jumlahSapi == 25) {
                    theVkandang.sapiButton()[1].setVisible(false);
                } else if (jumlahSapi == 26) {
                    theVkandang.sapiButton()[1].setVisible(false);
                    theVkandang.sapiButton()[2].setVisible(false);
                } else if (jumlahSapi == 27) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 28) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(false);
                }
            }
        } else if (jumlahSapi >= 30 && jumlahSapi <= 36) {
            if (noKandang.equalsIgnoreCase("kandang1")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang2")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang3")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang4")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang5")) {
                for (int i = 1; i < 7; i++) {
                    theVkandang.sapiButton()[i].setVisible(true);
                }
            } else if (noKandang.equalsIgnoreCase("kandang6")) {
                if (jumlahSapi == 30) {
                    for (int i = 1; i < 7; i++) {
                        theVkandang.sapiButton()[i].setVisible(false);
                    }
                } else if (jumlahSapi == 31) {
                    theVkandang.sapiButton()[1].setVisible(false);
                } else if (jumlahSapi == 32) {
                    theVkandang.sapiButton()[1].setVisible(false);
                    theVkandang.sapiButton()[2].setVisible(false);
                } else if (jumlahSapi == 33) {
                    for (int i = 1; i < 4; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else if (jumlahSapi == 34) {
                    for (int i = 1; i < 5; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                } else {
                    for (int i = 1; i < 6; i++) {
                        theVkandang.sapiButton()[i].setVisible(true);
                    }
                }
            }
        }
    }

    private class homeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.StopMusik();
            play.StopKandang();
            play.playKeluarKandang();
            play.stopSuara1();
            play.stopSuara2();
            play.stopSuara3();
            laparSakitTime.stop();
            play.playHome();
            theVkandang.dispose();
            viewsebelumnya.setVisible(true);
        }

    }

    private int cekJumlahSapiDiKandang() {
        int jumlahSapiDiKandang = 0;
        if (statusKandang.equalsIgnoreCase("kandang1")) {
            if (sapi >= 6) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 0) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        } else if (statusKandang.equalsIgnoreCase("kandang2")) {
            if (sapi >= 12) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 6) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        } else if (statusKandang.equalsIgnoreCase("kandang3")) {
            if (sapi >= 18) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 12) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        } else if (statusKandang.equalsIgnoreCase("kandang4")) {
            if (sapi >= 24) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 18) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        } else if (statusKandang.equalsIgnoreCase("kandang5")) {
            if (sapi >= 30) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 24) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        } else if (statusKandang.equalsIgnoreCase("kandang6")) {
            if (sapi >= 36) {
                jumlahSapiDiKandang = 6;
            } else if (sapi <= 30) {
                sapi = 0;
            } else {
                jumlahSapiDiKandang = sapi % 6;
            }
        }
        return jumlahSapiDiKandang;
    }

    private class sakitStat extends Thread {

        @Override
        public void run() {
            while (true) {
                int jumlahSapi = cekJumlahSapiDiKandang();
                System.out.println("sapi======" + jumlahSapi);
                try {
                    Thread.sleep(1000);
                    for (int i = 0; i < jumlahSapi; i++) {
                        detik[i]++;
                        detikSusu[i]++;
                        System.out.println("detik " + i + ": " + detik[i]);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < jumlahSapi; i++) {
                    if (detik[i] % 5 == 0 && detik[i] > 0) {
                        lapar[i] += 2;
                        if (lapar[i] >= 20) {
                            sakit[i] += 2;
                            theVkandang.getLapar()[i].setText("Sapi Lapar");
                            theVkandang.getLapar()[i].setVisible(true);
                        } else {
                            theVkandang.getLapar()[i].setVisible(false);
                        }
                        if (sakit[i] >= 50 && sakit[i] < 100) {
                            theVkandang.getSakit()[i].setText("Sapi Sakit");
                            theVkandang.getSakit()[i].setVisible(true);
                            theVkandang.getLapar()[i].setVisible(false);
                        } else if (sakit[i] >= 100) {
                            theVkandang.getSakit()[i].setText("Sapi mati");
                            theVkandang.getSakit()[i].setVisible(true);
                            theVkandang.getLapar()[i].setVisible(false); 
                            theVkandang.sapiButton()[i + 1].setVisible(false);
                        } else {
                            theVkandang.getSakit()[i].setVisible(true);
                            theVkandang.getSakit()[i].setText(sakit[i]+"");
                        }
                    }
                    if (detikSusu[i] % 30 == 0 && detikSusu[i] > 0 && sakit[i] < 50) {
                        theVkandang.susu()[i].setVisible(true);
                        susuMuncul[i] = true;
                    }
                    if (susuMuncul[i]) {
                        detikSusuHilang[i]++;
                        if (detikSusuHilang[i] % 15 == 0 && detikSusuHilang[i] > 0) {
                            theVkandang.susu()[i].setVisible(false);
                            detikSusuHilang[i] = 0;
                            detikSusu[i]=0;
                            susuMuncul[i] = false;
                            sakit[i]+=25;
                        }
                    }

//                    if (sakit[i] < 50 && lapar[i] < 20 && detik[i] % 5 == 0 && detik[i] > 0) {
//                        theVkandang.susu()[i].setVisible(true);
//                        detikSusu[i]++;
//                        System.out.println("susu: " + detikSusu[i]);
//                        if (detikSusu[i] >= 4) {
//                            detikSusu[i] = 0;
//                            sakit[i] = 60;
//                            lapar[i] = 60;
//                        }
//                    }
                    System.out.println("Lapar " + i + ": " + lapar[i]);
                    System.out.println("Sakit " + i + ": " + sakit[i]);
                }
            }
        }
    }

    private class sapiHamil extends Thread {

        int banyakRandom;

        public sapiHamil(int banyakRandom) {
            this.banyakRandom = banyakRandom;
        }

        @Override
        public void run() {
            theVhalaman.tampilPesan("Sapi telah di suntik \n Setelah menekan ok \n Tunggu 5 detik");
            hamil = random.nextInt(banyakRandom);
            suntik = suntik - 1;
            try {
                Thread.sleep(5000);
                if (hamil == 1) {
                    theVhalaman.tampilPesan("Suntik sapi berhasil, tunggu hingga sapi melahirkan");
                    Thread.sleep(3000);
//                theVkandang.sapiButton()[0].setLocation(theVkandang.sapiButton()[0].getX(), theVkandang.sapiButton()[0].getY());
                    theVkandang.sapiButton()[0].setVisible(true);
                    sapiKecil = true;
                } else {
                    theVhalaman.tampilPesan("Suntik sapi gagal");
                    for (int i = 0; i < sakit.length; i++) {
                        sakit[i] += 5;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class gameTime extends Thread {

        @Override
        public void run() {
            while (true) {
            }
        }
    }

    private class suntikDipakai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("suntik untuk: " + sapiStatus);
            for (int i = 0; i < 6; i++) {
                if (sapiStatus.equalsIgnoreCase("sapi" + (i + 1))) {
                    if (!sapiKecil) {
                        if (suntik > 0 && lapar[i] < 30 && sakit[i] < 60) {
                            new sapiHamil(2).start();
                        } else if (lapar[i] >= 30 && theVhalaman.tampilYesNo("Sapi dalam kondisi LAPAR, persentase keberhasilan mungkin menurun \n "
                                + "tetap lanjut suntik?") == JOptionPane.YES_OPTION) {
                            new sapiHamil(3).start();
                        } else if (sakit[i] >= 60 && theVhalaman.tampilYesNo("Sapi dalam kondisi SAKIT, persentase keberhasilan mungkin menurun \n "
                                + "tetap lanjut suntik?") == JOptionPane.YES_OPTION) {
                            new sapiHamil(10).start();
                        } else if (suntik <= 0) {
                            theVhalaman.tampilPesan("Jumlah suntikan anda tidak mencukupi");
                        }
                    } else {
                        theVhalaman.tampilPesan("Tidak bisa lanjut suntik sapi krn kandang kecil sudah di tempati");
                    }
                }
            }
            try {
                theMaset.updateDataSuntikan(suntik, theMaset.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            theVkandang.setSuntikan(suntik);
            theVkandang.suntikSapi().setVisible(false);
            theVkandang.obatSapi().setVisible(false);
            theVkandang.nutrisiSapi().setVisible(false);
            statusPencet1 = false;
            statusPencet2 = false;
            statusPencet3 = false;
            statusPencet4 = false;
            statusPencet5 = false;
            statusPencet6 = false;
        }
    }

    private class obatDipakai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("obat untuk: " + sapiStatus);
            for (int i = 0; i < 6; i++) {
                if (sapiStatus.equalsIgnoreCase("sapi" + (i + 1))) {
                    if (obat > 0) {
                        sakit[i] = 0;
                        lapar[i] = 20;
                        theVkandang.getSakit()[i].setVisible(false);
                        obat = obat - 1;
                    } else {
                        theVhalaman.tampilPesan("Jumlah obat anda tidak mencukupi");
                    }
                }
            }

            try {
                theMaset.updateDataObat(obat, theMaset.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            theVkandang.setObat(obat);
            theVkandang.suntikSapi().setVisible(false);
            theVkandang.obatSapi().setVisible(false);
            theVkandang.nutrisiSapi().setVisible(false);
            statusPencet1 = false;
            statusPencet2 = false;
            statusPencet3 = false;
            statusPencet4 = false;
            statusPencet5 = false;
            statusPencet6 = false;
        }

    }

    private class nutrisiDipakai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("nutrisi untuk: " + sapiStatus);
            if (nutrisi > 0) {
                nutrisi = nutrisi - 1;
            } else {
                theVhalaman.tampilPesan("Jumlah nutrisi anda tidak mencukupi");
            }
            try {
                theMaset.updateDataNutisi(nutrisi, theMaset.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            theVkandang.setNutrisi(nutrisi);
            theVkandang.suntikSapi().setVisible(false);
            theVkandang.obatSapi().setVisible(false);
            theVkandang.nutrisiSapi().setVisible(false);
            statusPencet1 = false;
            statusPencet2 = false;
            statusPencet3 = false;
            statusPencet4 = false;
            statusPencet5 = false;
            statusPencet6 = false;
        }

    }

    private class rumputDipakai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 6; i++) {
                if (tempatStatus.equalsIgnoreCase("tempat" + (i + 1))) {
                    if (rumput > 0) {
                        detik[i] = 0;
                        lapar[i] = 0;
                        theVkandang.getLapar()[i].setVisible(false);
                        rumput = rumput - 1;
                    } else {
                        theVhalaman.tampilPesan("Jumlah rumput anda tidak mencukupi");
                    }
                }
            }
            try {
                theMaset.updateDataRumput(rumput, theMaset.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            theVkandang.setRumput(rumput);
        }

    }

    private class sapiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sapi = e.getActionCommand();
            switch (sapi) {
                case "sapi0":
                    theVkandang.sapiButton()[0].setLocation(630, 110);
                    theVhalaman.tampilPesan("Sapi kecil telah di pindahkan");
                    break;
                case "sapi1":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[1].getX() + 10, theVkandang.sapiButton()[1].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[1].getX() + 70, theVkandang.sapiButton()[1].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[1].getX() + 130, theVkandang.sapiButton()[1].getY() - 50);
                    if (statusPencet1 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = true;
                        statusPencet2 = false;
                        statusPencet3 = false;
                        statusPencet4 = false;
                        statusPencet5 = false;
                        statusPencet6 = false;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet1 = false;
                    }
                    break;
                case "sapi2":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[2].getX() + 10, theVkandang.sapiButton()[2].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[2].getX() + 70, theVkandang.sapiButton()[2].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[2].getX() + 130, theVkandang.sapiButton()[2].getY() - 50);
                    if (statusPencet2 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = false;
                        statusPencet2 = true;
                        statusPencet3 = false;
                        statusPencet4 = false;
                        statusPencet5 = false;
                        statusPencet6 = false;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet2 = false;
                    }
                    break;
                case "sapi3":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[3].getX() + 10, theVkandang.sapiButton()[3].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[3].getX() + 70, theVkandang.sapiButton()[3].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[3].getX() + 130, theVkandang.sapiButton()[3].getY() - 50);
                    if (statusPencet3 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = false;
                        statusPencet2 = false;
                        statusPencet3 = true;
                        statusPencet4 = false;
                        statusPencet5 = false;
                        statusPencet6 = false;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet3 = false;
                    }
                    break;
                case "sapi4":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[4].getX() + 10, theVkandang.sapiButton()[4].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[4].getX() + 70, theVkandang.sapiButton()[4].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[4].getX() + 130, theVkandang.sapiButton()[4].getY() - 50);
                    if (statusPencet4 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = false;
                        statusPencet2 = false;
                        statusPencet3 = false;
                        statusPencet4 = true;
                        statusPencet5 = false;
                        statusPencet6 = false;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet4 = false;
                    }
                    break;
                case "sapi5":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[5].getX() + 10, theVkandang.sapiButton()[5].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[5].getX() + 70, theVkandang.sapiButton()[5].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[5].getX() + 130, theVkandang.sapiButton()[5].getY() - 50);
                    if (statusPencet5 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = false;
                        statusPencet2 = false;
                        statusPencet3 = false;
                        statusPencet4 = false;
                        statusPencet5 = true;
                        statusPencet6 = false;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet5 = false;
                    }
                    break;
                case "sapi6":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[6].getX() + 10, theVkandang.sapiButton()[6].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[6].getX() + 70, theVkandang.sapiButton()[6].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[6].getX() + 130, theVkandang.sapiButton()[6].getY() - 50);
                    if (statusPencet6 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet1 = false;
                        statusPencet2 = false;
                        statusPencet3 = false;
                        statusPencet4 = false;
                        statusPencet5 = false;
                        statusPencet6 = true;
                    } else {
                        theVkandang.suntikSapi().setVisible(false);
                        theVkandang.obatSapi().setVisible(false);
                        theVkandang.nutrisiSapi().setVisible(false);
                        statusPencet6 = false;
                    }
                    break;
            }
            sapiStatus = sapi;
        }

    }

    private class tempatMakanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempat = e.getActionCommand();
            System.out.println(tempat);
            switch (tempat) {
                case "tempat1":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[1].getX() + 50, theVkandang.tempatMakanButton()[1].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[1].getX() + 40, theVkandang.tempatMakanButton()[1].getY() + 40);
                    if (makan1 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = true;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan1 = false;
                    }
                    break;
                case "tempat2":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[2].getX() + 50, theVkandang.tempatMakanButton()[2].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[2].getX() + 40, theVkandang.tempatMakanButton()[2].getY() + 40);
                    if (makan2 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = false;
                        makan2 = true;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan2 = false;
                    }
                    break;
                case "tempat3":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[3].getX() + 50, theVkandang.tempatMakanButton()[3].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[3].getX() + 40, theVkandang.tempatMakanButton()[3].getY() + 40);
                    if (makan3 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = false;
                        makan2 = false;
                        makan3 = true;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan3 = false;
                    }
                    break;
                case "tempat4":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[4].getX() - 50, theVkandang.tempatMakanButton()[4].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[4].getX() - 60, theVkandang.tempatMakanButton()[4].getY() + 40);
                    if (makan4 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = true;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan4 = false;
                    }
                    break;
                case "tempat5":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[5].getX() - 50, theVkandang.tempatMakanButton()[5].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[5].getX() - 60, theVkandang.tempatMakanButton()[5].getY() + 40);
                    if (makan5 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = true;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan5 = false;
                    }
                    break;
                case "tempat6":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[6].getX() - 50, theVkandang.tempatMakanButton()[6].getY() - 30);
                    theVkandang.airSapi().setLocation(theVkandang.tempatMakanButton()[6].getX() - 60, theVkandang.tempatMakanButton()[6].getY() + 40);
                    if (makan6 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        theVkandang.airSapi().setVisible(true);
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = true;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        theVkandang.airSapi().setVisible(false);
                        makan6 = false;
                    }
                    break;
            }
            tempatStatus = tempat;
        }

    }

    private class susuAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            susu++;
            try {
                theMaset.updateDataSusu(susu, theMaset.cekIdPlayer(username));
                theVkandang.setSusu(susu);
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < 6; i++) {
                if (e.getActionCommand().equalsIgnoreCase(i + 1 + "")) {
                    theVkandang.susu()[i].setVisible(false);
                    detikSusu[i] = 0;
                    detikSusuHilang[i] = 0;
                    susuMuncul[i] = false;
                }
            }
        }

    }

}
