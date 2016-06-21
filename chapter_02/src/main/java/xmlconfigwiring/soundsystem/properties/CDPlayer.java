package xmlconfigwiring.soundsystem.properties;

import org.springframework.beans.factory.annotation.Autowired;

import xmlconfigwiring.soundsystem.CompactDisc;
import xmlconfigwiring.soundsystem.MediaPlayer;

public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
