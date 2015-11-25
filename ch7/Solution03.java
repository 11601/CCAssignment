import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 10/21/15.
 */

class JukeBox{
    private Screen screen;
    private PlayList playList;
    private Register register;
    private Speaker speaker;
    public JukeBox(){};

}

class Screen{
    public Screen(){};
    public void displaySong(){};
    public void selectSong(){};

}

class Coin{
    private int value;
    public Coin(int v) {
        value = v;
    }
}

 class Speaker{
     public Speaker(){};
 }

class Register{
    public Register(){};
    public boolean acceptCoin(){};
    public boolean returnChange(){};
}

class Song{
    private String title;
    private String artist;
    private int id;

    public Song(){};
    public void play(){};
}

class PlayList{
    private List<Song> songs;
    private int currentSong;

    public PlayList(){};
    public void addSong(){};
    public void removeSong(){};
    public void shuffle(){};
}

class User{
    private String name;
    private List<Coin> money;

    public User(){};
    public void selectSong(){};

}

public class Solution03 {
}
