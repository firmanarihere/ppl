/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Musik;

import c.c_player;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Play_musik {

    private AudioInputStream audio , sapi1, sapi2, sapi3, pintu, shop, inventori, help, about;
    private Clip clipKandang, clipHome, clipsapi1, clipsapi2, clipsapi3, clipPintuKeluar, clipShop, clipInventori, clipHelp, clipAbout;

    public Play_musik() {
    }

    public void playKandang() {
        try {
            audio = AudioSystem.getAudioInputStream(new File("src//sound//Dalam kandang pakek.wav"));
            clipKandang = AudioSystem.getClip();
            clipKandang.open(audio);
            clipKandang.start();
            clipKandang.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playHome() {
        try {
            audio = AudioSystem.getAudioInputStream(new File("src//sound//HomePlay.wav"));
            clipHome = AudioSystem.getClip();
            clipHome.open(audio);
            clipHome.start();
            clipHome.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playShop(){
        try {
            shop = AudioSystem.getAudioInputStream(new File("src//sound//shop.wav"));
            clipShop = AudioSystem.getClip();
            clipShop.open(shop);
            clipShop.start();
            clipShop.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void playInventori(){
        try {
            inventori = AudioSystem.getAudioInputStream(new File("src//sound//inventori.wav"));
            clipInventori = AudioSystem.getClip();
            clipInventori.open(inventori);
            clipInventori.start();
            clipInventori.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void playHelp(){
        try {
            help = AudioSystem.getAudioInputStream(new File("src//sound//help.wav"));
            clipHelp = AudioSystem.getClip();
            clipHelp.open(help);
            clipHelp.start();
            clipHelp.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void playAbout(){
        try {
            about = AudioSystem.getAudioInputStream(new File("src//sound//about.wav"));
            clipAbout = AudioSystem.getClip();
            clipAbout.open(about);
            clipAbout.start();
            clipAbout.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playKeluarKandang() {
        try {
            pintu = AudioSystem.getAudioInputStream(new File("src//sound//Keluar dari kandang.wav"));
            clipPintuKeluar = AudioSystem.getClip();
            clipPintuKeluar.open(pintu);
            clipPintuKeluar.start();
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSapi1() throws InterruptedException {
        try {
            sapi1 = AudioSystem.getAudioInputStream(new File("src//sound//sapi1.wav"));
            clipsapi1 = AudioSystem.getClip();
            clipsapi1.open(sapi1);
            clipsapi1.start();
            clipsapi1.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSapi2() throws InterruptedException {
        try {
            sapi2 = AudioSystem.getAudioInputStream(new File("src//sound//sapi2.wav"));
            clipsapi2 = AudioSystem.getClip();
            clipsapi2.open(sapi2);
            clipsapi2.start();
            clipsapi2.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSapi3() throws InterruptedException {
        try {
            sapi3 = AudioSystem.getAudioInputStream(new File("src//sound//sapi3.wav"));
            clipsapi3 = AudioSystem.getClip();
            clipsapi3.open(sapi3);
            clipsapi3.start();
            clipsapi3.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playMakan(){
//        try {
//            makan = AudioSystem.getAudioInputStream(new File("src//sound//makan klik.wav"));
//            clipMakan = AudioSystem.getClip();
//            clipMakan.open(makan);
//            clipMakan.start();
//        } catch (Exception ex) {
//            Logger.getLogger(c_player.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void StopMusik() {
        clipHome.stop();
    }
    public void StopKandang() {        
        clipKandang.stop();
    }

    public void stopSuara1() {
        clipsapi1.stop();
    }

    public void stopSuara2() {
        clipsapi2.stop();

    }

    public void stopSuara3() {
        clipsapi3.stop();
    }
    public void stopShop(){
        clipShop.stop();
    }
    public void stopInventori(){
        clipInventori.stop();
    }
    public void stopHelp(){
        clipHelp.stop();
    }
    public void stopAbout(){
        clipAbout.stop();
    }

}
