package component;

/**
 * Created by XiZhang on 2/12/17.
 *
 * Player O or X
 */
public class Player {

    private final String player;
    private final int playerValue;
    private final Board board;

    public Player(Board board, String player, int playerValue) {
        this.board = board;
        this.player = player;
        this.playerValue = playerValue;
    }

    public void newStep(int x, int y) {
        board.setValue(x, y, playerValue);
    }

    public String getPlayerString() {
        return player;
    }
}
