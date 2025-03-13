

public class Tournament {

    private int roundCount;
    private int playerCount;
    private Round[] rounds;
    private Player[] players;

    private static Tournament tournament;

    private Tournament(int playerCount)
    {
        this.roundCount = playerCount-1;
        System.out.println("Rounds: "+this.roundCount);
        this.playerCount = playerCount;
        this.players = generatePlayers();
        this.rounds = new Round[roundCount];
    }
    
        
    public static Tournament getInstance(int playerCount)
    {
        if(tournament == null) tournament = new Tournament(playerCount);
        return tournament;
    }

    public static Tournament resetTournamentInstance(int playerCount)
    {
        tournament = new Tournament( playerCount);
        return tournament;

    }


    public int getRoundCount() {
        return roundCount;
    }
    public int getPlayerCount() {
        return playerCount;
    }
    public Round[] getRounds() {
        return rounds;
    }
    public Player[] getPlayers() {
        return players;
    }

    private Player[] generatePlayers() {

        Player[] players = new Player[this.playerCount];
        for(int i=0; i < this.playerCount; i++)
        {
            players[i] = new Player(i+1);
        }

        return players;

    }

    public void startTournament()
    {
        for(int i = 0; i < this.roundCount; i++)
        {
            Round round = new Round(i+1, players)
                                .setWinPoint(5)
                                .setTiePoint(2)
                                .setByeScore(1);
            if(round.isNoEligiblePairs())
            {
                System.out.println("No eligible pairs found! Tournament stoped at round : "+(i+1));
                return;
            }
            round.startRound();
            rounds[i] = round;
            rearrangePlayerList();
                        
        }
    }
            
            
        private void rearrangePlayerList() {
                    
            for(int i=0;i<players.length-1;i++)
            {
                for(int j = i+1; j<players.length;j++)
                {
                   
                    if(players[j].getScore() > players[i].getScore() ||
                     (players[j].getScore() == players[i].getScore() && players[j].getWinScore() > players[i].getWinScore()))
                    {
                        Player temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;
                        
                    }
        
                }
            }
        }

        public void printLeaderBoard()
        {
            System.out.println("\t  Leader Board! \t");
            System.out.println("----------------------------------------------------------------------");
            int count = 1;
            System.out.println("Rank \t Id \t Score \t opponents");
            for(Player player:players)
            {
                System.out.println(count +" \t "+player.getId()+" \t "+player.getScore()+" \t "+player.getOpponents());
                count++;
            }

            System.out.println("WINNER: "+players[0].getId());
        }

    





}