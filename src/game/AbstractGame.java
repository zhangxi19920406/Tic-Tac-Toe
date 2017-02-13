package game;

import component.Board;
import component.Player;

/**
 * Created by XiZhang on 2/12/17.
 */
public abstract class AbstractGame implements Game {

    protected static final int DRAW = 1;
    protected static final int WIN_O = 2;
    protected static final int WIN_X = 3;
    protected static final int IS_CONTINUE = 0;

    protected static final int BLANKT = 0;
    protected static final int PLAYER_O_NUM = 1;
    protected static final int PLAYER_X_NUM = 2;

    protected final int size;
    protected final Board board;
    protected final Player playerO;
    protected final Player playerX;

    private boolean xTurn; // false for O, true for X

    public AbstractGame(int size) {
        this.size = size;
        board = new Board(size);
        playerO = new Player(board, "o", PLAYER_O_NUM);
        playerX = new Player(board, "x", PLAYER_X_NUM);
        xTurn = false;
    }

    public void step(int x, int y) {
        if (xTurn) {
            playerX.newStep(x, y);
        } else {
            playerO.newStep(x, y);
        }
        xTurn = !xTurn;
    }

    @Override
    public void resetGame() {
        board.resetBoard();
    }

    @Override
    public boolean validPoint(int x, int y) {
        return board.getBoardValie(x, y) == BLANKT;
    }

    @Override
    public abstract int currentStatus();

    @Override
    public void printInCommandLine() {
        board.printInCommandLine();
    }

    @Override
    public Player nextPlayer() {
        return xTurn ? playerX : playerO;
    }
}
