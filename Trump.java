import java.util.Random;

public class Trump {
    private Card[] deck = new Card[52];

    public Trump(){
        String[] suits = new String[]{"Heart", "Spade", "Diamond", "Club"};
        int cardNum = 0;
        for(int i=0; i<suits.length; i++){
            for(int j=1; j<=13; j++){
                Card newOne = new Card(suits[i], j);
                deck[cardNum] = newOne;
                cardNum++;
            }
        }
    }

    public Card[] remove(Card[] deck, int index){
        Card[] temp = new Card[deck.length-1];
        if (index == 0){
            System.arraycopy(this.deck, 1, temp, 0, temp.length);
        }
        else if(index == deck.length){
            System.arraycopy(this.deck, 0, temp, 0, temp.length);
        }
        else{
            System.arraycopy(this.deck, 0, temp, 0, index);
            System.arraycopy(this.deck, index+1, temp, index, deck.length-index-1);
        }
        return temp;
    }

    public Card draw(){
        Random rand = new Random();
        int num = rand.nextInt(deck.length);
        Card picked = deck[num];
        //deck[num] = null; //how can I delete the item?
        deck = remove(deck, num);
        return picked;
    }

    public void reSet(){
        this.deck = null;
        String[] suits = new String[]{"Heart", "Spade", "Diamond", "Club"};
        int cardNum = 0;
        for(int i=0; i<suits.length; i++){
            for(int j=1; j<=13; j++){
                Card newOne = new Card(suits[i], j);
                deck[cardNum] = newOne;
            }
        }
    }

    public Card[] getDeck() {
        return deck;
    }
}
