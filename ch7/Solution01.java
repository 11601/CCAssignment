import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 10/21/15.
 */
enum Suit{
    DIAMOND, HEART, CLUB, SPADE
}

abstract class Card{
    int value;
    Suit suit;
    boolean isAvailable;

    public Card(int val, Suit st){
        value = val;
        suit = st;
    }

    public abstract int value();
}

class Hand <T extends Card>{
    List<T> cards = new ArrayList<>();

    public void addCard(){};
    public void removeCard(Card c){};
}

class Deck <T extends Card>{
    List<Card> cards = new ArrayList<>();
    public void shuffle(List<Card> cards){};
    public void distribute(List<Card> cards, List<Hand> hands){};
}

class BlackJackCard extends Card {
    public BlackJackCard(int v, Suit s){
        super(v,s);
    }
    public int value(){// multiple values possible for ace};

}

class BlackJackHand extends Hand<BlackJackCard>{
    public boolean isBlackJack(){};


}

public class Solution01 {

}
