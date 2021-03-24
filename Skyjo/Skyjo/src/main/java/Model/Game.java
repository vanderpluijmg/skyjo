package Model;

/**
 * 
 * @author Gregory
 */
public class Game implements Model{
    
    private Deck deck;
    private Player [] players;
    
    
    @Override
    public Card piocheCarte (){
        if (deck.isEmpty())
            throw new IllegalArgumentException("Deck is emtpy");
        return this.deck.hitDeck(true);
    }
    
    public void showCard (Card card){
        card.setVisibility(true);
    }
    
    @Override
    public String getPlayerTot(int p){
        return Integer.toString(players[p].getNbOFPointsVisCards());
    }
    
    /**
     * Distributes initial 12 cards to both players
     */
    @Override
    public void distribInit (){
        for (int i=0; i<12; i++){
            try {
                Card cardP1 = this.deck.removeLast();
                Card cardP2 = this.deck.removeLast();
                this.players[0].addCard(cardP1);
                this.players[0].addPoints(cardP1);
                this.players[1].addCard(cardP2);
                this.players[1].addPoints(cardP2);
            } catch (Exception e) {
                throw new IllegalArgumentException("Deck is empty");
            }
    
        }
    }

}