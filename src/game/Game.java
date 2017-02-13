package game;

import component.Player;

/**
 * Created by XiZhang on 2/12/17.
 *
 * Interface of tic-tac-game
 */
public interface Game {

    int currentStatus();
    boolean validPoint(int x, int y);
    void step(int x, int y);
    void resetGame();
    void printInCommandLine();
    Player nextPlayer();

}
