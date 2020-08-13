import players.PlayerComp;
import players.PlayerHuman;
import statistics.WinStatistics;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Gra w odgadywanie wylosowanej liczby.
 * <p>
 * Zasady:
 * - komputer rzuca kostką (losuje liczby z zakresu 1..6)
 * - gracz (też komputer) stara się odgadnąć liczbę (też losuje)
 * - jeżeli odgadnie, gra się kończy
 * - jeżeli nie odgadnie, rozpoczyna się kolejna runda (komputer losuje kolejną liczbę i gracz stara się ją odgadnąć)
 */
public class PioGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game game = new Game(new WinStatistics());


        System.out.println("Witaj ! Wybierz tryb gry");
        System.out.println("---------------------");
        System.out.println();
        System.out.println("1.Tryb multiplayer: wybierz 1 ");
        System.out.println();
        System.out.println("2.Tryb singleplayer: wybierz 2 ");
        Scanner cin = new Scanner(System.in);
        int liczba = cin.nextInt();

        switch (liczba) {
            case 1:
                System.out.println("Wybrałeś tryb multiplayer");
                System.out.println("---------------------");
                System.out.println();
                System.out.println("Wprowadź nick pierwszego gracza");
                String name1 = cin.next();
                System.out.println("---------------------");
                System.out.println("Wprowadź nick drugiego gracza");
                String name2 = cin.next();
                game.addPlayer(new PlayerHuman(name1));
                game.addPlayer(new PlayerHuman(name2));
                break;
            case 2:
                System.out.println("Wybrałeś tryb singleplayer");
                System.out.println("---------------------");
                System.out.println();
                System.out.println("Wprowadź swój nick");
                String singlePlayerName = cin.next();
                game.addPlayer(new PlayerHuman(singlePlayerName));
                game.addPlayer(new PlayerComp("Komputer"));
                break;

            default:
                game.addPlayer(new PlayerComp("Komputer"));
        }


        game.printPlayers();

        for (int i = 0; i < 4; ++i) {
            game.play();
        }

        game.stats.print();

    }

}
