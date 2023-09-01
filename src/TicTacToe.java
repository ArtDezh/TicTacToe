import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Для выбора ячейки используйте числа от 1 до 9 в соответствии с таблицей ниже!");
        printTable();
        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        if (new Random().nextBoolean()) {
            makeComputerMove(gameTable);
            printGameTable(gameTable);
        }
        while (true) {
            makeUserMove(gameTable);
            printGameTable(gameTable);
            if (isUserWin(gameTable)) {
                System.out.println("YOU WIN!!!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!!!");
                break;
            }
            makeComputerMove(gameTable);
            printGameTable(gameTable);
            if (isComputerWin(gameTable)) {
                System.out.println("COMPUTER WIN!!!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!!!");
                break;
            }
        }
        System.out.println("GAME OVER!!!");
    }

    private static void printTable() {
        System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");
    }

    private static void printGameTable(char[][] gameTable) {

    }

    private static void makeUserMove(char[][] gameTable) {

    }

    private static void makeComputerMove(char[][] gameTable) {

    }

    private static boolean isUserWin(char[][] gameTable) {
        return false;
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return false;
    }

    private static boolean isDraw(char[][] gameTable) {
        return false;
    }
}
