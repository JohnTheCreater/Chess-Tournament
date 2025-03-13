import java.util.Random;

public class Pair {

    Player player1;
    Player player2;
    Player winner;
    boolean isTie;

    public Pair(Player player1,Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        winner = null;
        isTie = false;
    }

    public Player getWinner()
    {
        return this.winner;
    }

    public void startMatch(int winPoint,int tiePoint)
    {
        Random random = new Random();
        int option = random.nextInt(3);
        switch(option)
        {
            case 0:
                player1.addWinScore(winPoint);
                winner = player1;
                break;
            case 1:
                player2.addWinScore(winPoint);
                winner = player2;
                break;
            case 2:
                isTie = true;
                player1.addWinScore(tiePoint);
                player2.addWinScore(tiePoint);
                break;
                


        }
      
    }

    
}
