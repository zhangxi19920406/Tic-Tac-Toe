import game.ThreeBaseGame;

import java.util.Scanner;

/**
 * Created by XiZhang on 2/12/17.
 *
 * 3*3 P vs P
 */
public class PvP3 {

    private static final int DRAW = 1;
    private static final int WIN_O = 2;
    private static final int WIN_X = 3;
    private static final int IS_CONTINUE = 0;

    private static final int SIZE = 3;

    public static void main(String[] args) {
        ThreeBaseGame game = new ThreeBaseGame();
        newGame(game);
    }

    private static void newGame(ThreeBaseGame game) {
        Scanner sc = new Scanner(System.in);
        game.printInCommandLine();
        System.out.print("\n");
        int currentStatus = game.currentStatus();
        while (currentStatus == IS_CONTINUE) {
            System.out.print(game.nextPlayer().getPlayerString() + "'s turn: ");
            String[] next = sc.nextLine().split(" ");
            int x = Integer.parseInt(next[0]);
            int y = Integer.parseInt(next[1]);
            if (!game.validPoint(x, y)) {
                System.out.println("Not valid point.");
                continue;
            }
            game.step(x, y);
            currentStatus = game.currentStatus();
            game.printInCommandLine();
            System.out.print("\n");
        }
        switch (currentStatus) {
            case DRAW:
                System.out.println("DRAM\n");
                break;
            case WIN_O:
                System.out.println("O Win\n");
                break;
            case WIN_X:
                System.out.println("X Win\n");
                break;
            default:
                System.out.println("Wrong\n");
        }
    }

}
