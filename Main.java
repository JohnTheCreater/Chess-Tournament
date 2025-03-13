import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int playerCount = scan.nextInt();
        Tournament tournament = Tournament.getInstance( playerCount);
        tournament.startTournament();
        tournament.printLeaderBoard();

        scan.close();


    }
    
}
