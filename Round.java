import java.util.ArrayList;
import java.util.List;

public class Round {

    private int roundNumber;
    
    private int winPoint;
    private int tiePoint;
    private int byeScore;
    private boolean isNoEligiblePairs;
    

   

    private List<Pair> pairs;

    public Round(int roundNumber,Player[] players)
    {
        this.winPoint = 10;
        this.tiePoint = 5;
        this.byeScore = 2;
        this.roundNumber = roundNumber;
        this.pairs = generatePairs(players);
        this.isNoEligiblePairs = pairs.size()==0;
    }

            public Round setWinPoint(int winPoint) {
                this.winPoint = winPoint;
                return this;
            }
        
        
            public Round setTiePoint(int tiePoint) {
                this.tiePoint = tiePoint;
                return this;
            }
        
        
            public Round setByeScore(int byeScore) {
                this.byeScore = byeScore;
                return this;
            }
            
        
    private List<Pair> generatePairs(Player[] players) {

            List<Pair> pairs = new ArrayList<>();
            for(int i = 0; i < players.length-1; i+=2)
            {
                Player player1 = players[i];
                Player player2 = getOpponentFor(player1,players);
                if(player2!=null)
                {
                Pair pair = new Pair(player1, player2);
                pairs.add(pair);
                }
            }
            if(players.length%2 != 0)
                    players[players.length-1].addByeScore(byeScore);

            return pairs;
     }

     private Player getOpponentFor(Player player,Player[] players)
     {

            for(Player oppPlayer:players)
            {
                if( player!=oppPlayer && !(oppPlayer.isPreviousOpponent(player.getId())) )
                {
                    return oppPlayer;
                }
            }
            return null;
     }
        
        
     public boolean isNoEligiblePairs() {
        return isNoEligiblePairs;
    }
    public int getRoundNumber() {
        return roundNumber;
    }

    public int getWinPoint() {
        return winPoint;
    }

    public int getTiePoint() {
        return tiePoint;
    }

    public void startRound()
    {
        for(Pair pair:pairs)
        {
            pair.startMatch(winPoint, tiePoint);
        }
    }


    
    

    
}
