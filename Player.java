import java.util.HashSet;
import java.util.Set;

public class Player {

    private int id;
    private int score;
    private int byePoints;
    private int winScore;
   
    private Set<Integer> opponents;

    public Player(int id)
    {
        this.id = id;
        opponents = new HashSet<>();
    }


    public int getId() {
        return id;
    }
    public int getScore() {
        return score;
    }
    public int getByePoints() {
        return byePoints;
    }
    public int getWinScore() {
        return winScore;
    }


    public boolean isPreviousOpponent(int opponentId)
    {
        return opponents.contains(opponentId);
    }

    public void addOpponentId(int opponentId)
    {
        opponents.add(opponentId);
    }

    public void addByeScore(int point)
    {
        score+= point;
        byePoints+= point;
    }

    public void addWinScore(int point)
    {
        score+= point;
        winScore+= point;
    }


    
}
