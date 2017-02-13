package component;

/**
 * Created by XiZhang on 2/12/17.
 *
 * The board of the Tic-Tac-Toe Game
 */
public class Board {

    public static final String X = "x";
    public static final String O = "o";
    public static final String[] BOARD_VALUE = new String[]{" ", X, O};

    public static void main(String[] str) {
        Board b = new Board(3);
        b.printInCommandLine();
        b.setValue(1,1, 1);
        b.setValue(0,2, 1);
        b.setValue(2,0, 2);
        b.printInCommandLine();
    }

    private final int[][] board;
    private final int size;

    public Board() {
        this(1);
    }

    public Board(int size) {
        board = size <= 0 ? new int[1][1] : new int[size][size];
        this.size = size <= 0 ? 1 : size;
    }

    public void setValue(int x, int y, int value) {
        board[x][y] = value;
    }

    public int getBoardValie(int x, int y) {
        return board[x][y];
    }

    public void resetBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setValue(i, j, 0);
            }
        }
    }

    public void printInCommandLine() {
        for (int i = 0; i < size; i++) {
            System.out.print("+");
            for (int j = 0; j < size; j++) {
                System.out.print("-+");
            }
            System.out.print("\n");
            for (int j = 0; j < size; j++) {
                System.out.print("|" + BOARD_VALUE[board[i][j]]);
            }
            System.out.print("|\n");
        }
        System.out.print("+");
        for (int j = 0; j < size; j++) {
            System.out.print("-+");
        }
        System.out.print("\n");
    }

}
