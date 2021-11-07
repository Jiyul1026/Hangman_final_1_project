package hang;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class Hangman_bgmSound {
	    
	public void abc() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
	    Clip clip;
	    
	    //bgm = new File("e:/ee/Operatic_3.wav"); 
	    bgm = new File("mainbgm.wav"); 
	    
	    try {
	           stream = AudioSystem.getAudioInputStream(bgm);
	           format = stream.getFormat();
	           info = new DataLine.Info(Clip.class, format);
	           clip = (Clip)AudioSystem.getLine(info);
	           clip.open(stream);
	           clip.start();
	           
	    } catch (Exception e) {
	           System.out.println("err : " + e);
	           }
	    
	}

	public static void main(String[] args) {
		Hangman_bgmSound test = new Hangman_bgmSound();
	    while(true) {
	           try {
	                 test.abc();
	                 Thread.sleep(194000); 
	           } catch(Exception e) {
	                 
	           }
	    }
	}
}