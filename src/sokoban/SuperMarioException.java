/*
 * Copyright (C) 2014 e.bosetti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sokoban;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe gestione errori input
 * @author e.bosetti
 */
public class SuperMarioException extends Exception {
    /**
     * Costruttore senza messaggi di errore ne audio
     */
    public SuperMarioException(){
        super();
        
    }
    
    /**
     * Costruttore con messaggio di errore e audio
     * @param s messaggio si errore
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException 
     */
    public SuperMarioException(String s) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        super(s);
        System.err.println(s);
        this.doSound();
    }
    
    /**
     * Metodo che scarica e riproduce il suono
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException 
     */
    private void doSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        AudioInputStream audio = AudioSystem.getAudioInputStream(new URL("http://themushroomkingdom.net/sounds/wav/smb/smb_mariodie.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    }
}
