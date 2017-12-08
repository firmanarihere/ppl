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

    private v_dalamKandang theVkandang;
    private v_halaman theVhalaman;
    private Play_musik play;
    private m_aset theMaset;
    private String username;
    private String statusKandang;
    public int sapi;
    private String sapiStatus;
    private String tempatStatus;
    private int menit = 0;
    //ini buat tempatMAkann
    private boolean makan0 = false;
    private boolean makan1 = false;
    private boolean makan2 = false;
    private boolean makan3 = false;
    private boolean makan4 = false;
    private boolean makan5 = false;
    private boolean makan6 = false;

    //ini buat sapi
    private boolean statusPencet0 = false;
    private boolean statusPencet1 = false;
    private boolean statusPencet2 = false;
    private boolean statusPencet3 = false;
    private boolean statusPencet4 = false;
    private boolean statusPencet5 = false;
    private boolean statusPencet6 = false;

    private Thread laparSakitTime;

    private int jumlahSapiDiKandang;
    private int hamil;
    private int detik[] = {0, 0, 0, 0, 0, 0};
    private int sakit[] = {0, 0, 0, 0, 0, 0};
    private int lapar[] = {0, 0, 0, 0, 0, 0};
    private int detikSusu[] = {0, 0, 0, 0, 0, 0};
    private int detikSusuHilang[] = {0, 0, 0, 0, 0, 0};
    private boolean[] susuMuncul = {false, false, false, false, false, false};
    private boolean sapiKecil = false;
    private boolean suntikProgres = false;
    private Random random = new Random();
    private v_halaman viewsebelumnya;
    private c_halaman controllersebelumnya;
    private boolean[] sapiHidup = {false, false, false, false, false, false};
    private int laparKecil = 0;
    private int dewasaStatus;
    private boolean sapiKecilLahir = false;

    public c_kandang(String username, String kandang, c_halaman controllersebelumnya, v_halaman viewsebelumnya, Play_musik play) throws SQLException, InterruptedException {
        this.theVkandang = new v_dalamKandang();
        this.theVhalaman = new v_halaman();
        this.play = play;
        this.theMaset = new m_aset();
        this.viewsebelumnya = viewsebelumnya;
        this.controllersebelumnya = controllersebelumnya;

        this.username = username;
        this.statusKandang = kandang;
        sakitStat cobaSakit = new sakitStat();
        laparSakitTime = cobaSakit;
        laparSakitTime.start();
        theVkandang.setRumput(theMaset.getJumlahRumput(username));
        theVkandang.setNutrisi(theMaset.getJumlahNutrisi(username));
        theVkandang.setSuntikan(theMaset.getJumlahSuntikan(username));
        theVkandang.setObat(theMaset.getJumlahObat(username));
        theVkandang.setSusu(theMaset.getJumlahSusu(username));
        sapi = theMaset.getJumlahSapi(username);
        for (int i = 0; i < cekJumlahSapiDiKandang(); i++) {
            sapiHidup[i] = true;
        }

        theVkandang.suntikSapi().setVisible(false);
        theVkandang.obatSapi().setVisible(false);
        theVkandang.nutrisiSapi().setVisible(false);
        theVkandang.rumputSapi().setVisible(false);
        theVkandang.counterBar().setVisible(false);

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

        tampilSapi(sapi, kandang);
        theVkandang.setVisible(true);
    }

    public v_dalamKandang getview() {
        return theVkandang;
    }

    public void tampilSapi(int jumlahSapi, String noKandang) {
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
            play.playHome();
            theVkandang.setVisible(false);
            viewsebelumnya.setVisible(true);
            try {
                viewsebelumnya.setTeksRumput(theMaset.getJumlahRumput(username));
                viewsebelumnya.setTeksSapi(theMaset.getJumlahSapi(username) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int cekJumlahSapiDiKandang() {
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

    public int kandangKosong() {
        int kosong = 0;
        for (int i = 0; i < 6; i++) {
            if (!sapiHidup[i]) {
                kosong++;
            }
        }
        return kosong;
    }

    public int kandangBerisi() {
        int berisi = 0;
        for (int i = 0; i < 6; i++) {
            if (sapiHidup[i]) {
                berisi++;
            }
        }
        return berisi;
    }

    public void tambahSapi(int sapiTambahan) throws SQLException {
        for (int i = 0; i < sapiHidup.length; i++) {
            if (!sapiHidup[i]) {
                if (sapiTambahan != 0) {
                    sapiHidup[i] = true;
                    sapiTambahan--;
                    System.out.println("sapi hidup " + (i + 1) + " " + sapiHidup[i]);
                }
            }
        }
        sapi = theMaset.getJumlahSapi(username);
    }

    public void kurangSapi(int sapiKurang) throws SQLException {
        for (int i = sapiHidup.length - 1; i >= 0; i--) {
            if (sapiHidup[i]) {
                if (sapiKurang != 0) {
                    sapiHidup[i] = false;
                    sapiKurang--;
                    System.out.println("sapi hidup " + (i + 1) + " " + sapiHidup[i]);
                }
            }
        }
        sapi = theMaset.getJumlahSapi(username);
    }

    private class sakitStat extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    for (int i = 0; i < sapiHidup.length; i++) {
                        if (sapiHidup[i]) {
                            detik[i]++;
                            detikSusu[i]++;
                            theVkandang.sapiButton()[i + 1].setVisible(true);
                        } else {
                            theVkandang.sapiButton()[i + 1].setVisible(false);
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(c_halaman.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < sapiHidup.length; i++) {
                    if (detik[i] % 3 == 0 && detik[i] > 0) {
                        lapar[i] += 2;
                        if (lapar[i] >= 25) {
                            sakit[i] += 2;
                            ///sk ubah disni
                            if (i < 3) {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi pucet kiri.png")));
                            } else {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi pucet kanan.png")));
                            }
//                            theVkandang.getLapar()[i].setVisible(true);
                        }
                        if (sakit[i] >= 50 && sakit[i] < 100) {
//                            theVkandang.getSakit()[i].setText("Sapi Sakit");
                            if (i < 3) {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi sakit kiri.png")));
                            } else {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi sakit kanan.png")));
                            }
//                            theVkandang.getSakit()[i].setVisible(true);
//                            theVkandang.getLapar()[i].setVisible(false);
                        } else if (sakit[i] >= 100) {
                            try {
//                                theVkandang.getSakit()[i].setText("Sapi mati");
//                                theVkandang.getSakit()[i].setVisible(true);
                                theVkandang.getLapar()[i].setVisible(false);
                                theVkandang.sapiButton()[i + 1].setVisible(false);
                                theMaset.deleteSapi(theMaset.getIdSapi(theMaset.cekIdPlayer(username)), theMaset.cekIdPlayer(username));
                                theVhalaman.setTeksSapi(theMaset.getJumlahSapi(username) + "");
                                jumlahSapiDiKandang--;
                                sapi = theMaset.getJumlahSapi(username);
                                detik[i] = 0;
                                sakit[i] = 0;
                                lapar[i] = 0;
                                sapiHidup[i] = false;
                            } catch (SQLException ex) {
                                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (sakit[i] < 50 && lapar[i] < 25) {
                            if (i < 3) {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi dalam kandang.png")));
                            } else if (i >= 3) {
                                theVkandang.sapiButton()[i + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sapi dewasa.png")));
                            }
                        }
                    }

                    ///susu
                    if (detikSusu[i] % 30 == 0 && detikSusu[i] > 0 && sakit[i] < 50) {
                        theVkandang.susu()[i].setVisible(true);
                        susuMuncul[i] = true;
                    }
                    if (susuMuncul[i]) {
                        detikSusuHilang[i]++;
                        if (detikSusuHilang[i] % 15 == 0 && detikSusuHilang[i] > 0) {
                            theVkandang.susu()[i].setVisible(false);
                            detikSusuHilang[i] = 0;
                            detikSusu[i] = 0;
                            susuMuncul[i] = false;
                            sakit[i] += 25;
                        }
                    }
                    System.out.println(statusKandang + "hidup : " + sapiHidup[i] + sakit[i]);
                }
                System.out.println("");
            }
        }
    }

    private class sapiHamil extends Thread {

        boolean run = true;
        int banyakRandom;
        int count = 5;

        public sapiHamil(int banyakRandom) {
            this.banyakRandom = banyakRandom;
        }

        @Override
        public void run() {
            if (JOptionPane.OK_OPTION == 0) {
                hamil = random.nextInt(banyakRandom);
                theVhalaman.tampilPesan("Sapi telah di suntik \n Setelah menekan ok \n Tunggu 5 detik");
                while (run) {
                    suntikProgres = true;
                    try {
                        Thread.sleep(1000);
                        if (count >= 1) {
                            theVkandang.counter().setVisible(true);
                            theVkandang.counterBar().setVisible(true);
                            theVkandang.counterBar().setValue(count);
                            theVkandang.counter().setText(count + "");
                            count--;
                        } else {
                            run = false;
                            theVkandang.counterBar().setVisible(false);
                            theVkandang.counter().setVisible(false);
                            if (hamil == 1) {
                                sapiKecilLahir = true;
                                theVhalaman.tampilPesan("Suntik sapi berhasil, tunggu beberapa saat \n hingga sapi melahirkan");
                                Thread.sleep(30000);
                                //insert sapi here
                                theVkandang.sapiButton()[0].setVisible(true);
                                suntikProgres = false;
                                sapiKecil = true;
                                count = 0;
                            } else {
                                suntikProgres = false;
                                theVhalaman.tampilPesan("Suntik sapi gagal");
                                for (int i = 1; i < theVkandang.sapiButton().length; i++) {
                                    if (theVkandang.sapiButton()[i].getActionCommand() == sapiStatus) {
                                        sakit[i - 1] += 10;
                                    }
                                }
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    private class laparKecil extends Thread {

        @Override
        public void run() {
            try {
                while (sapiKecilLahir) {
                    Thread.sleep(1000);
                    laparKecil++;
                    if (laparKecil < 20) {
                        dewasaStatus++;
                        if (dewasaStatus >= 50) {
                            theVhalaman.tampilPesan("Sapi kecil sudah besar");
                            theVkandang.sapiButton()[0].setVisible(false);
                            dewasaStatus = 0;
                            sapiKecilLahir = false;
                            if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 1 && theMaset.getJumlahSapi(username) < 6) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 2 && theMaset.getJumlahSapi(username) < 12) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 3 && theMaset.getJumlahSapi(username) < 18) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 4 && theMaset.getJumlahSapi(username) < 24) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 5 && theMaset.getJumlahSapi(username) < 30) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else if (theMaset.getJumlahKandang(theMaset.cekIdPlayer(username)) == 6 && theMaset.getJumlahSapi(username) < 36) {
                                theMaset.insertDataSapi(theMaset.cekIdSapi(), theMaset.cekIdPlayer(username));
                                controllersebelumnya.setTambah(1);
                            } else {
                                theVhalaman.tampilPesan("Kapasitas kandang full, sapi langsung dijual");
                                theMaset.updateDataKoin(1750, username);
                            }
                        }
                    } else if (laparKecil >= 20) {
                        theVkandang.getLapar()[0].setVisible(true);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class suntikDipakai implements ActionListener {

        int suntik;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("suntik untuk: " + sapiStatus);
            if (!suntikProgres && !sapiKecilLahir) {
                for (int i = 1; i < theVkandang.sapiButton().length; i++) {
                    if (theVkandang.sapiButton()[i].getActionCommand() == sapiStatus) {
                        if (i < 4) {
                            theVkandang.sapiButton()[0].setLocation(theVkandang.sapiButton()[i].getX() - 50, theVkandang.sapiButton()[i].getY() + 60);
                            theVkandang.counter().setLocation(theVkandang.sapiButton()[i].getX() + 200, theVkandang.sapiButton()[i].getY() + 50);
                            theVkandang.counterBar().setLocation(theVkandang.sapiButton()[i].getX() + 40, theVkandang.sapiButton()[i].getY() + 10);
                        } else {
                            theVkandang.sapiButton()[0].setLocation(theVkandang.sapiButton()[i].getX() + 180, theVkandang.sapiButton()[i].getY() + 50);
                            theVkandang.counter().setLocation(theVkandang.sapiButton()[i].getX(), theVkandang.sapiButton()[i].getY() + 50);
                            theVkandang.counterBar().setLocation(theVkandang.sapiButton()[i].getX() + 40, theVkandang.sapiButton()[i].getY() + 10);
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (sapiStatus.equalsIgnoreCase("sapi" + (i + 1))) {
                        if (!sapiKecil) {
                            try {
                                suntik = theMaset.getJumlahSuntikan(username) - 1;
                            } catch (SQLException ex) {
                                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
                            }
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
                        }
                    }
                }
            } else if (sapiKecilLahir) {
                theVhalaman.tampilPesan("Tidak bisa lanjut suntik sapi krn sapi kecil sudah lahir");
            } else {
                theVhalaman.tampilPesan("Sedang dalam prses menyuntik");
            }
            try {
                theMaset.updateDataSuntikan(suntik, theMaset.cekIdPlayer(username));
                theVkandang.setSuntikan(theMaset.getJumlahSuntikan(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        int obat;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("obat untuk: " + sapiStatus);
            for (int i = 0; i < 6; i++) {
                if (sapiStatus.equalsIgnoreCase("sapi" + (i + 1))) {
                    try {
                        if (theMaset.getJumlahObat(username) > 0) {
                            sakit[i] = 0;
                            lapar[i] = 20;
                            theVkandang.getSakit()[i].setVisible(false);
                            obat = theMaset.getJumlahObat(username) - 1;
                        } else {
                            theVhalaman.tampilPesan("Jumlah obat anda tidak mencukupi");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
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

        int nutrisi;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("nutrisi untuk: " + sapiStatus);
            for (int i = 0; i < 6; i++) {
                if (sapiStatus.equalsIgnoreCase("sapi" + (i + 1))) {
                    try {
                        if (theMaset.getJumlahNutrisi(username) > 0) {
                            nutrisi = theMaset.getJumlahNutrisi(username) - 1;
                            lapar[i] -= 10;
                            sakit[i] -= 25;
                            if (lapar[i] < 0 || sakit[i] < 0) {
                                lapar[i] = 0;
                                sakit[i] = 0;
                            }
                        } else {
                            theVhalaman.tampilPesan("Jumlah nutrisi anda tidak mencukupi");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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

        int rumput;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (tempatStatus.equalsIgnoreCase("tempat0")) {
                    if (theMaset.getJumlahRumput(username) > 0) {
                        laparKecil = 0;
                        rumput = theMaset.getJumlahRumput(username) - 1;
                        theVkandang.getLapar()[0].setVisible(false);
                    } else {
                        theVhalaman.tampilPesan("Jumlah rumput anda tidak mencukupi");
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (tempatStatus.equalsIgnoreCase("tempat" + (i + 1))) {
                        if (theMaset.getJumlahRumput(username) > 0) {
                            detik[i] = 0;
                            lapar[i] = 0;
                            rumput = theMaset.getJumlahRumput(username) - 1;
                        } else {
                            theVhalaman.tampilPesan("Jumlah rumput anda tidak mencukupi");
                        }

                    }
                }
                theMaset.updateDataRumput(rumput, theMaset.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
            theVkandang.setRumput(rumput);
            theVkandang.rumputSapi().setVisible(false);
            makan1 = false;
            makan2 = false;
            makan3 = false;
            makan4 = false;
            makan5 = false;
            makan6 = false;
        }

    }

    private class sapiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sapi = e.getActionCommand();
            switch (sapi) {
                case "sapi0":
                    if (sapiKecil) {
                        laparKecil laparKecil = new laparKecil();
                        laparKecil.start();
                        theVkandang.sapiButton()[0].setLocation(630, 110);
                        theVhalaman.tampilPesan("Sapi kecil telah di pindahkan");
                        sapiKecil = false;
                    } else {
                        theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[0].getX() + 10, theVkandang.sapiButton()[0].getY() - 50);
                        theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[0].getX() + 70, theVkandang.sapiButton()[0].getY() - 50);
                        theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[0].getX() + 130, theVkandang.sapiButton()[0].getY() - 50);
                        if (statusPencet0 == false) {
                            theVkandang.suntikSapi().setVisible(false);
                            theVkandang.obatSapi().setVisible(true);
                            theVkandang.nutrisiSapi().setVisible(true);
                            statusPencet0 = true;
                            statusPencet1 = false;
                            statusPencet2 = false;
                            statusPencet3 = false;
                            statusPencet4 = false;
                            statusPencet5 = false;
                            statusPencet6 = false;
                        } else {
                            theVkandang.obatSapi().setVisible(false);
                            theVkandang.nutrisiSapi().setVisible(false);
                            statusPencet0 = false;
                        }

                    }
                    break;
                case "sapi1":
                    theVkandang.suntikSapi().setLocation(theVkandang.sapiButton()[1].getX() + 10, theVkandang.sapiButton()[1].getY() - 50);
                    theVkandang.obatSapi().setLocation(theVkandang.sapiButton()[1].getX() + 70, theVkandang.sapiButton()[1].getY() - 50);
                    theVkandang.nutrisiSapi().setLocation(theVkandang.sapiButton()[1].getX() + 130, theVkandang.sapiButton()[1].getY() - 50);
                    if (statusPencet1 == false) {
                        theVkandang.suntikSapi().setVisible(true);
                        theVkandang.obatSapi().setVisible(true);
                        theVkandang.nutrisiSapi().setVisible(true);
                        statusPencet0 = false;
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
                        statusPencet0 = false;
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
                        statusPencet0 = false;
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
                        statusPencet0 = false;
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
                        statusPencet0 = false;
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
                        statusPencet0 = false;
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
                case "tempat0":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[0].getX() - 50, theVkandang.tempatMakanButton()[0].getY() - 30);
                    if (makan0 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = true;
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan0 = false;
                    }
                    break;
                case "tempat1":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[1].getX() + 50, theVkandang.tempatMakanButton()[1].getY() - 30);
                    if (makan1 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = true;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan1 = false;
                    }
                    break;
                case "tempat2":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[2].getX() + 50, theVkandang.tempatMakanButton()[2].getY() - 30);
                    if (makan2 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = false;
                        makan2 = true;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan2 = false;
                    }
                    break;
                case "tempat3":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[3].getX() + 50, theVkandang.tempatMakanButton()[3].getY() - 30);
                    if (makan3 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = false;
                        makan2 = false;
                        makan3 = true;
                        makan4 = false;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan3 = false;
                    }
                    break;
                case "tempat4":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[4].getX() - 50, theVkandang.tempatMakanButton()[4].getY() - 30);
                    if (makan4 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = true;
                        makan5 = false;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan4 = false;
                    }
                    break;
                case "tempat5":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[5].getX() - 50, theVkandang.tempatMakanButton()[5].getY() - 30);
                    if (makan5 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = true;
                        makan6 = false;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan5 = false;
                    }
                    break;
                case "tempat6":
                    theVkandang.rumputSapi().setLocation(theVkandang.tempatMakanButton()[6].getX() - 50, theVkandang.tempatMakanButton()[6].getY() - 30);
                    if (makan6 == false) {
                        theVkandang.rumputSapi().setVisible(true);
                        makan0 = false;
                        makan1 = false;
                        makan2 = false;
                        makan3 = false;
                        makan4 = false;
                        makan5 = false;
                        makan6 = true;
                    } else {
                        theVkandang.rumputSapi().setVisible(false);
                        makan6 = false;
                    }
                    break;
            }
            tempatStatus = tempat;
        }

    }

    private class susuAction implements ActionListener {

        int susu;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                susu = theMaset.getJumlahSusu(username) + 1;
                theMaset.updateDataSusu(susu, theMaset.cekIdPlayer(username));
                theVkandang.setSusu(theMaset.getJumlahSusu(username));
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

    public v_dalamKandang getView() {
        return theVkandang;
    }

}
