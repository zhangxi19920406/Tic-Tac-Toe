package artificial;

import component.Board;
import component.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by XiZhang on 2/13/17.
 *
 * The AI part for computer next step
 */
public class ThreeBaseAI {

    private final Player aiPlayer;
    private final Board board;

    public ThreeBaseAI(Player player) {
        aiPlayer = player;
        board = player.getBoard();
    }

    public void nextStep() {
        if (board.getBoardValie(1, 1) == 0) {
            aiPlayer.newStep(1, 1);
        } else {
            ArrayList<int[]> canWin = new ArrayList<>();
            ArrayList<int[]> otherCanWin = new ArrayList<>();
            ArrayList<int[]> nextStepWin = new ArrayList<>(); //再议
            //TODO

            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; i < board.getSize(); j++) {
                    if (board.getBoardValie(i, j) == 0) {
                        break;
                    }
                    int winStatus = winStatus(i, j);
                    int[] point = new int[]{i, j};
                    if (winStatus == 1) {
                        canWin.add(point);
                    } else if (winStatus == 2) {
                        otherCanWin.add(point);
                    } else if (nextStepWin(i, j)) {
                        nextStepWin.add(point);
                    }
                }
            }


            // 随机取点
        }
    }

    // 0 = no one can win, 1 = ai can win, 2 = player can win
    private int winStatus(int x, int y) {
        return 0;
    }

    private boolean nextStepWin(int x, int y) {
        return true;
    }

}
