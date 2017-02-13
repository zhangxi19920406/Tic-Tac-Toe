package game;

import component.Board;
import component.Player;

/**
 * Created by XiZhang on 2/12/17.
 *
 * Normal 3*3 tic-tac-toe Game
 */
public class ThreeBaseGame extends AbstractGame {

    public ThreeBaseGame() {
        super(3);
    }

    @Override
    public int currentStatus() {
        for (int i = 0; i < size; i++) {
            if (validPoint(i, 0)) {
                continue;
            }
            boolean isO = board.getBoardValie(i, 0) == PLAYER_O_NUM;
            int value = isO ? PLAYER_O_NUM : PLAYER_X_NUM;
            boolean isWin = true;
            for (int j = 1; j < size; j++) {
                if (board.getBoardValie(i, j) != value) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return isO ? WIN_O : WIN_X;
            }
        }
        for (int i = 0; i < size; i++) {
            if (validPoint(0, i)) {
                continue;
            }
            boolean isO = board.getBoardValie(0, i) == PLAYER_O_NUM;
            int value = isO ? PLAYER_O_NUM : PLAYER_X_NUM;
            boolean isWin = true;
            for (int j = 1; j < size; j++) {
                if (board.getBoardValie(j, i) != value) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return isO ? WIN_O : WIN_X;
            }
        }

        if (!validPoint(0, 0)) {
            boolean isO = board.getBoardValie(0, 0) == PLAYER_O_NUM;
            int value = isO ? PLAYER_O_NUM : PLAYER_X_NUM;
            boolean isWin = true;
            for (int i = 1; i < size; i++) {
                if (board.getBoardValie(i, i) != value) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return isO ? WIN_O : WIN_X;
            }
        }
        if (!validPoint(0, size - 1)) {
            boolean isO = board.getBoardValie(0, size - 1) == PLAYER_O_NUM;
            int value = isO ? PLAYER_O_NUM : PLAYER_X_NUM;
            boolean isWin = true;
            for (int i = 1; i < size; i++) {
                if (board.getBoardValie(i, size - 1 - i) != value) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return isO ? WIN_O : WIN_X;
            }
        }

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
        return isContinue ? IS_CONTINUE : DRAW;
    }
}
