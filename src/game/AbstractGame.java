package game;

import component.Board;
import component.Player;

/**
 * Created by XiZhang on 2/12/17.
 *
 */
public abstract class AbstractGame implements Game {

    static final int DRAW = 1;
    static final int WIN_O = 2;
    static final int WIN_X = 3;
    static final int IS_CONTINUE = 0;

    private static final int BLANKT = 0;
    static final int PLAYER_O_NUM = 1;
    private static final int PLAYER_X_NUM = 2;

    final int size;
    final Board board;
    private final int winNum;
    private final Player playerO;
    private final Player playerX;

    private static final int[] RIGHT = new int[]{1, 0};
    private static final int[] DOWN = new int[]{0, 1};
    private static final int[] RIGHT_DOWN = new int[]{1, 1};
    private static final int[] LEFT_DOWN = new int[]{-1, 1};

    private boolean xTurn; // false for O, true for X

    AbstractGame(int size, int winNum) {
        this.size = size;
        board = new Board(size);
        this.winNum = winNum;
        playerO = new Player(board, "o", PLAYER_O_NUM);
        playerX = new Player(board, "x", PLAYER_X_NUM);
        xTurn = true;
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
    public int currentStatus() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!validPoint(i, j)) {
                    if (isWin(new int[]{i, j}))
                        return board.getBoardValie(i, j) == PLAYER_O_NUM ? WIN_O : WIN_X;
                }
            }
        }
        return isContinue() ? IS_CONTINUE : DRAW;
    }

    @Override
    public void printInCommandLine() {
        board.printInCommandLine();
    }

    @Override
    public Player nextPlayer() {
        return xTurn ? playerX : playerO;
    }

    boolean isContinue() {
        boolean isContinue = false;
        for (int i = 0; i < size; i++) {
            if (isContinue) {
                break;
            }
            for (int j = 0; j < size; j++) {
                if (board.getBoardValie(i, j) == BLANKT) {
                    isContinue = true;
                    break;
                }
            }
        }
        return isContinue;
    }

    boolean isWin(int[] location) {
        return isWin(location, RIGHT) || isWin(location, DOWN) || isWin(location, LEFT_DOWN)
                || isWin(location, RIGHT_DOWN);
    }

    private boolean isWin(int[] location, int[] direction) {
        if (direction[0] < 0) {
            if (location[0] - winNum + 1 < 0)
                return false;
        }
        if (location[0] + (winNum - 1) * direction[0] >= size || location[1] + (winNum - 1) * direction[1] >= size)
            return false;
        int cur = board.getBoardValie(location[0], location[1]);
        int i = location[0], j = location[1];
        for (int c = 0; c < winNum; c++) {
            if (board.getBoardValie(i, j) != cur)
                return false;
            i += direction[0];
            j += direction[1];
        }
        return true;
    }
}
