/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Rangora
 */
public class v_halaman extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public v_halaman() {
        initComponents();
        this.setLocationRelativeTo(this);
        profileFrame.setLocationRelativeTo(null);
        kandang1Button.setActionCommand("kandang1");
        kandang2Button.setActionCommand("kandang2");
        kandang3Button.setActionCommand("kandang3");
        kandang4Button.setActionCommand("kandang4");
        kandang5Button.setActionCommand("kandang5");
        kandang6Button.setActionCommand("kandang6");
        rumputGratis1.setActionCommand("rumput"+1);
        rumputGratis2.setActionCommand("rumput"+2);
        rumputGratis3.setActionCommand("rumput"+3);
        rumputGratis4.setActionCommand("rumput"+4);
        rumputGratis5.setActionCommand("rumput"+5);
        rumputGratis6.setActionCommand("rumput"+6);
        rumputGratis7.setActionCommand("rumput"+7);
        rumputGratis8.setActionCommand("rumput"+8);
        rumputGratis9.setActionCommand("rumput"+9);
        rumputGratis10.setActionCommand("rumput"+10);
        papanBeliKandang.setActionCommand("papan1");
        papanBelikandang2.setActionCommand("papan2");
        papanBelikandang3.setActionCommand("papan3");
        papanBelikandang4.setActionCommand("papan4");
        papanBelikandang5.setActionCommand("papan5");

        for (int i = 0; i < 10; i++) {
            getButtonRumput()[i].setVisible(false);
        }
        for (int i = 0; i < 5; i++) {
            getButtonPapan()[i].setVisible(false);
        }
        
        
    }

    public void tombolshop(ActionListener action) {
        this.shopButton.addActionListener(action);
    }

    public JButton buttonMenu() {
        return buttonMenu;
    }

    public JButton buttonProfile() {
        return buttonProfile;
    }

    public JButton buttonInventori() {
        return buttonInventori;
    }

    public JButton buttonHelp() {
        return buttonHelp;
    }

    public JButton buttonAbout() {
        return buttonAbout;
    }

    public JButton buttonLogout() {
        return buttonLogout;
    }

    public int setTeksRumput(int teks) {
        rumput.setText(teks + "");
        return teks;
    }

    public int setTeksKoin(int teks) {
        koin.setText(teks + "");
        return teks;
    }

    public void setTeksSapi(String teks) {
        sapi.setText(teks);
    }

    public JButton[] getButtonKandang() {
        JButton kandang[] = new JButton[6];
        kandang[0] = kandang1Button;
        kandang[1] = kandang2Button;
        kandang[2] = kandang3Button;
        kandang[3] = kandang4Button;
        kandang[4] = kandang5Button;
        kandang[5] = kandang6Button;
        return kandang;
    }

    public JButton[] getButtonPapan() {
        JButton papan[] = new JButton[5];
        papan[0] = papanBeliKandang;
        papan[1] = papanBelikandang2;
        papan[2] = papanBelikandang3;
        papan[3] = papanBelikandang4;
        papan[4] = papanBelikandang5;
        return papan;
    }

    public JButton[] getButtonRumput() {
        JButton rumputGratis[] = new JButton[10];
        rumputGratis[0] = rumputGratis1;
        rumputGratis[1] = rumputGratis2;
        rumputGratis[2] = rumputGratis3;
        rumputGratis[3] = rumputGratis4;
        rumputGratis[4] = rumputGratis5;
        rumputGratis[5] = rumputGratis6;
        rumputGratis[6] = rumputGratis7;
        rumputGratis[7] = rumputGratis8;
        rumputGratis[8] = rumputGratis9;
        rumputGratis[9] = rumputGratis10;
        return rumputGratis;
    }
    
    public void tampilPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    public int tampilYesNo(String pesan) {
        return JOptionPane.showConfirmDialog(this, pesan, null, JOptionPane.YES_NO_OPTION);
    }
    
    public JFrame profile(){
        return profileFrame;
    }
    
    public JLabel usernmaeProfile(){
        return usernameProfile;
    }
     
    public JPasswordField oldPass(){
        return oldpass;
    }
    
    public JPasswordField newPass(){
        return newpass;
    }
    
    public JButton cancelProfile(){
        return cancelProfile;
    }
    
    public JButton changeProfile(){
        return change;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileFrame = new javax.swing.JFrame();
        newpass = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        change = new javax.swing.JButton();
        cancelProfile = new javax.swing.JButton();
        username1 = new javax.swing.JLabel();
        usernameProfile = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        koin = new javax.swing.JLabel();
        sapi = new javax.swing.JLabel();
        rumput = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        buttonInventori = new javax.swing.JButton();
        buttonProfile = new javax.swing.JButton();
        buttonMenu = new javax.swing.JButton();
        rumputGratis1 = new javax.swing.JButton();
        rumputGratis2 = new javax.swing.JButton();
        rumputGratis3 = new javax.swing.JButton();
        rumputGratis4 = new javax.swing.JButton();
        rumputGratis5 = new javax.swing.JButton();
        rumputGratis6 = new javax.swing.JButton();
        rumputGratis7 = new javax.swing.JButton();
        rumputGratis8 = new javax.swing.JButton();
        rumputGratis9 = new javax.swing.JButton();
        rumputGratis10 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusBar = new javax.swing.JLabel();
        shopButton = new javax.swing.JButton();
        kandang6Button = new javax.swing.JButton();
        papanBeliKandang = new javax.swing.JButton();
        papanBelikandang2 = new javax.swing.JButton();
        papanBelikandang3 = new javax.swing.JButton();
        papanBelikandang4 = new javax.swing.JButton();
        papanBelikandang5 = new javax.swing.JButton();
        kandang5Button = new javax.swing.JButton();
        kandang4Button = new javax.swing.JButton();
        kandang3Button = new javax.swing.JButton();
        kandang2Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kandang1Button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bgHome = new javax.swing.JLabel();

        profileFrame.setMinimumSize(new java.awt.Dimension(676, 341));
        profileFrame.setUndecorated(true);
        profileFrame.setPreferredSize(new java.awt.Dimension(676, 341));
        profileFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newpass.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        newpass.setBorder(null);
        newpass.setOpaque(false);
        profileFrame.getContentPane().add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 200, 40));

        oldpass.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        oldpass.setBorder(null);
        oldpass.setOpaque(false);
        profileFrame.getContentPane().add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 200, 40));

        change.setBorderPainted(false);
        change.setContentAreaFilled(false);
        change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        change.setFocusPainted(false);
        change.setFocusable(false);
        profileFrame.getContentPane().add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 90, 40));

        cancelProfile.setBorderPainted(false);
        cancelProfile.setContentAreaFilled(false);
        cancelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelProfile.setFocusPainted(false);
        cancelProfile.setFocusable(false);
        cancelProfile.setOpaque(false);
        profileFrame.getContentPane().add(cancelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 90, 40));

        username1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        username1.setText("PROFILE");
        profileFrame.getContentPane().add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 100, 40));

        usernameProfile.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        usernameProfile.setText("jLabel2");
        profileFrame.getContentPane().add(usernameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 200, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/s.png"))); // NOI18N
        profileFrame.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 340));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        koin.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        koin.setText("koin");
        getContentPane().add(koin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 60, -1));

        sapi.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        sapi.setText("sapi");
        getContentPane().add(sapi, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 40, -1));

        rumput.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        rumput.setText("rumput");
        getContentPane().add(rumput, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sapi dewasa Cilik.png"))); // NOI18N
        jLabel10.setText(":");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/coin dalam colom.png"))); // NOI18N
        jLabel11.setText(":");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, 40));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        jLabel1.setText(":");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, 40));

        buttonHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon help.png"))); // NOI18N
        buttonHelp.setBorderPainted(false);
        buttonHelp.setContentAreaFilled(false);
        buttonHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonHelp.setFocusPainted(false);
        buttonHelp.setFocusable(false);
        buttonHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/helpOver.png"))); // NOI18N
        getContentPane().add(buttonHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 260, 80, 90));

        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon logout.png"))); // NOI18N
        buttonLogout.setBorderPainted(false);
        buttonLogout.setContentAreaFilled(false);
        buttonLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogout.setFocusPainted(false);
        buttonLogout.setFocusable(false);
        buttonLogout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoutOver.png"))); // NOI18N
        getContentPane().add(buttonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 80, 80));

        buttonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon about.png"))); // NOI18N
        buttonAbout.setBorderPainted(false);
        buttonAbout.setContentAreaFilled(false);
        buttonAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAbout.setFocusPainted(false);
        buttonAbout.setFocusable(false);
        buttonAbout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aboutOver.png"))); // NOI18N
        getContentPane().add(buttonAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 350, 80, 80));

        buttonInventori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon Inventory.png"))); // NOI18N
        buttonInventori.setBorderPainted(false);
        buttonInventori.setContentAreaFilled(false);
        buttonInventori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonInventori.setFocusPainted(false);
        buttonInventori.setFocusable(false);
        buttonInventori.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon Inventory rollover.png"))); // NOI18N
        getContentPane().add(buttonInventori, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 180, 80, 90));

        buttonProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon profil.png"))); // NOI18N
        buttonProfile.setBorderPainted(false);
        buttonProfile.setContentAreaFilled(false);
        buttonProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProfile.setFocusPainted(false);
        buttonProfile.setFocusable(false);
        buttonProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profileOver.png"))); // NOI18N
        getContentPane().add(buttonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, 80, 80));

        buttonMenu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        buttonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu.png"))); // NOI18N
        buttonMenu.setBorderPainted(false);
        buttonMenu.setContentAreaFilled(false);
        buttonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMenu.setFocusPainted(false);
        buttonMenu.setFocusable(false);
        buttonMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menuOver.png"))); // NOI18N
        getContentPane().add(buttonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 80, 80));

        rumputGratis1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis1.setBorderPainted(false);
        rumputGratis1.setContentAreaFilled(false);
        rumputGratis1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis1.setFocusPainted(false);
        rumputGratis1.setFocusable(false);
        rumputGratis1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 50, 40));

        rumputGratis2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis2.setBorderPainted(false);
        rumputGratis2.setContentAreaFilled(false);
        rumputGratis2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis2.setFocusPainted(false);
        rumputGratis2.setFocusable(false);
        rumputGratis2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 60, 60));

        rumputGratis3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis3.setBorderPainted(false);
        rumputGratis3.setContentAreaFilled(false);
        rumputGratis3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis3.setFocusPainted(false);
        rumputGratis3.setFocusable(false);
        rumputGratis3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 40, -1));

        rumputGratis4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis4.setBorderPainted(false);
        rumputGratis4.setContentAreaFilled(false);
        rumputGratis4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis4.setFocusPainted(false);
        rumputGratis4.setFocusable(false);
        rumputGratis4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 490, 40, -1));

        rumputGratis5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis5.setBorderPainted(false);
        rumputGratis5.setContentAreaFilled(false);
        rumputGratis5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis5.setFocusPainted(false);
        rumputGratis5.setFocusable(false);
        rumputGratis5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 60, 50));

        rumputGratis6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis6.setBorderPainted(false);
        rumputGratis6.setContentAreaFilled(false);
        rumputGratis6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis6.setFocusPainted(false);
        rumputGratis6.setFocusable(false);
        rumputGratis6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 60, 50));

        rumputGratis7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis7.setBorderPainted(false);
        rumputGratis7.setContentAreaFilled(false);
        rumputGratis7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis7.setFocusPainted(false);
        rumputGratis7.setFocusable(false);
        rumputGratis7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 40, -1));

        rumputGratis8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis8.setBorderPainted(false);
        rumputGratis8.setContentAreaFilled(false);
        rumputGratis8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis8.setFocusPainted(false);
        rumputGratis8.setFocusable(false);
        rumputGratis8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 650, 40, -1));

        rumputGratis9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis9.setBorderPainted(false);
        rumputGratis9.setContentAreaFilled(false);
        rumputGratis9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis9.setFocusPainted(false);
        rumputGratis9.setFocusable(false);
        rumputGratis9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumputcilik RollOver.png"))); // NOI18N
        getContentPane().add(rumputGratis9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 40, -1));

        rumputGratis10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput cilik.png"))); // NOI18N
        rumputGratis10.setBorderPainted(false);
        rumputGratis10.setContentAreaFilled(false);
        rumputGratis10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rumputGratis10.setFocusPainted(false);
        rumputGratis10.setFocusable(false);
        getContentPane().add(rumputGratis10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 120, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pohon2.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 160, 210));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/animasi-bergerak-tanaman-tumbuhan-0076.gif"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 120));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pohon3.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 540, 150, 180));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/animasi-bergerak-bunga-kembang-0440.gif"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 170, 110, 150));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/animasi-bergerak-kupu-kupu-0017.gif"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, 160, 140));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pohon1.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 110, 210));

        statusBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/status Bar di Home.png"))); // NOI18N
        getContentPane().add(statusBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 630, 40));

        shopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shop button.png"))); // NOI18N
        shopButton.setBorderPainted(false);
        shopButton.setContentAreaFilled(false);
        shopButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shopButton.setFocusable(false);
        shopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shopButton.setRequestFocusEnabled(false);
        shopButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopOver.png"))); // NOI18N
        getContentPane().add(shopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 180));

        kandang6Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan.png"))); // NOI18N
        kandang6Button.setBorderPainted(false);
        kandang6Button.setContentAreaFilled(false);
        kandang6Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang6Button.setFocusable(false);
        kandang6Button.setRequestFocusEnabled(false);
        kandang6Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan over.png"))); // NOI18N
        getContentPane().add(kandang6Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 340, 240));

        papanBeliKandang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeli.png"))); // NOI18N
        papanBeliKandang.setBorderPainted(false);
        papanBeliKandang.setContentAreaFilled(false);
        papanBeliKandang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        papanBeliKandang.setFocusPainted(false);
        papanBeliKandang.setFocusable(false);
        papanBeliKandang.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeliRollover.png"))); // NOI18N
        getContentPane().add(papanBeliKandang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        papanBelikandang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeli.png"))); // NOI18N
        papanBelikandang2.setBorderPainted(false);
        papanBelikandang2.setContentAreaFilled(false);
        papanBelikandang2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        papanBelikandang2.setFocusPainted(false);
        papanBelikandang2.setFocusable(false);
        papanBelikandang2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeliRollover.png"))); // NOI18N
        getContentPane().add(papanBelikandang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        papanBelikandang3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeli.png"))); // NOI18N
        papanBelikandang3.setBorderPainted(false);
        papanBelikandang3.setContentAreaFilled(false);
        papanBelikandang3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        papanBelikandang3.setFocusPainted(false);
        papanBelikandang3.setFocusable(false);
        papanBelikandang3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        papanBelikandang3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeliRollover.png"))); // NOI18N
        getContentPane().add(papanBelikandang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 240, -1));

        papanBelikandang4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeli.png"))); // NOI18N
        papanBelikandang4.setBorderPainted(false);
        papanBelikandang4.setContentAreaFilled(false);
        papanBelikandang4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        papanBelikandang4.setFocusPainted(false);
        papanBelikandang4.setFocusable(false);
        papanBelikandang4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeliRollover.png"))); // NOI18N
        getContentPane().add(papanBelikandang4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, -1, -1));

        papanBelikandang5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeli.png"))); // NOI18N
        papanBelikandang5.setBorderPainted(false);
        papanBelikandang5.setContentAreaFilled(false);
        papanBelikandang5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        papanBelikandang5.setFocusPainted(false);
        papanBelikandang5.setFocusable(false);
        papanBelikandang5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/papanBeliRollover.png"))); // NOI18N
        papanBelikandang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                papanBelikandang5ActionPerformed(evt);
            }
        });
        getContentPane().add(papanBelikandang5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, -1, -1));

        kandang5Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan.png"))); // NOI18N
        kandang5Button.setBorderPainted(false);
        kandang5Button.setContentAreaFilled(false);
        kandang5Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang5Button.setFocusable(false);
        kandang5Button.setRequestFocusEnabled(false);
        kandang5Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan over.png"))); // NOI18N
        getContentPane().add(kandang5Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 261, 340, 240));

        kandang4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan.png"))); // NOI18N
        kandang4Button.setBorderPainted(false);
        kandang4Button.setContentAreaFilled(false);
        kandang4Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang4Button.setFocusable(false);
        kandang4Button.setRequestFocusEnabled(false);
        kandang4Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kanan over.png"))); // NOI18N
        getContentPane().add(kandang4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 330, 240));

        kandang3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri.png"))); // NOI18N
        kandang3Button.setBorderPainted(false);
        kandang3Button.setContentAreaFilled(false);
        kandang3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang3Button.setFocusPainted(false);
        kandang3Button.setFocusable(false);
        kandang3Button.setRequestFocusEnabled(false);
        kandang3Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri over.png"))); // NOI18N
        getContentPane().add(kandang3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 350, 250));

        kandang2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri.png"))); // NOI18N
        kandang2Button.setBorderPainted(false);
        kandang2Button.setContentAreaFilled(false);
        kandang2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang2Button.setFocusable(false);
        kandang2Button.setRequestFocusEnabled(false);
        kandang2Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri over.png"))); // NOI18N
        getContentPane().add(kandang2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 350, 240));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/burung.GIF"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 110, 150));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pohon2.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 160, 210));

        kandang1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri.png"))); // NOI18N
        kandang1Button.setBorderPainted(false);
        kandang1Button.setContentAreaFilled(false);
        kandang1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kandang1Button.setFocusPainted(false);
        kandang1Button.setRequestFocusEnabled(false);
        kandang1Button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kandang sebelah kiri over.png"))); // NOI18N
        getContentPane().add(kandang1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 320, 250));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cuks.gif"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 100, 90));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cupu.gif"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 100, 90));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cuks.gif"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 90));

        bgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background game play.png"))); // NOI18N
        getContentPane().add(bgHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void papanBelikandang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_papanBelikandang5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_papanBelikandang5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(v_halaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_halaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_halaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_halaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_halaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgHome;
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonInventori;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonMenu;
    private javax.swing.JButton buttonProfile;
    private javax.swing.JButton cancelProfile;
    private javax.swing.JButton change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton kandang1Button;
    private javax.swing.JButton kandang2Button;
    private javax.swing.JButton kandang3Button;
    private javax.swing.JButton kandang4Button;
    private javax.swing.JButton kandang5Button;
    private javax.swing.JButton kandang6Button;
    private javax.swing.JLabel koin;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JButton papanBeliKandang;
    private javax.swing.JButton papanBelikandang2;
    private javax.swing.JButton papanBelikandang3;
    private javax.swing.JButton papanBelikandang4;
    private javax.swing.JButton papanBelikandang5;
    private javax.swing.JFrame profileFrame;
    private javax.swing.JLabel rumput;
    private javax.swing.JButton rumputGratis1;
    private javax.swing.JButton rumputGratis10;
    private javax.swing.JButton rumputGratis2;
    private javax.swing.JButton rumputGratis3;
    private javax.swing.JButton rumputGratis4;
    private javax.swing.JButton rumputGratis5;
    private javax.swing.JButton rumputGratis6;
    private javax.swing.JButton rumputGratis7;
    private javax.swing.JButton rumputGratis8;
    private javax.swing.JButton rumputGratis9;
    private javax.swing.JLabel sapi;
    private javax.swing.JButton shopButton;
    private javax.swing.JLabel statusBar;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel usernameProfile;
    // End of variables declaration//GEN-END:variables
}
