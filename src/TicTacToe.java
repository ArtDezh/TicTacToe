import java.util.Random;
import java.util.Scanner;

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
        char[][] exampleTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        printGameTable(exampleTable);
    }

    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    private static void makeUserMove(char[][] gameTable) {
        while (true) {
            System.out.println("Пожалуйста, введите число от 1 до 9 ");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char ch = string.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    char[][] exampleTable = {
                            {'7', '8', '9'},
                            {'4', '5', '6'},
                            {'1', '2', '3'}
                    };
                    boolean flag = true;
                    for (int i = 0; i < exampleTable.length; i++) {
                        for (int j = 0; j < exampleTable[i].length; j++) {
                            if (exampleTable[i][j] == ch) {
                                if (gameTable[i][j] == ' ') {
                                    gameTable[i][j] = 'X';
                                    return;
                                } else {
                                    System.out.println("Нельзя сделать ход, потому что выбранная ячейка не пуста. Попробуйте снова!\n");
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void makeComputerMove(char[][] gameTable) {
        Random random = new Random();
        while (true) {
            int raw = random.nextInt(3);
            int col = random.nextInt(3);

            if (gameTable[raw][col] == ' ') {
                gameTable[raw][col] = '0';
                return;
            }
        }
    }

    private static boolean isUserWin(char[][] gameTable) {
        return isWinner(gameTable, 'X');
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return isWinner(gameTable, '0');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {

        for (int i = 0; i < 3; i++) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] == ch) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gameTable[0][i] == gameTable[1][i] && gameTable[0][i] == gameTable[2][i] && gameTable[0][i] == ch) {
                return true;
            }
        }

        if (gameTable[0][0] == gameTable[1][1] && gameTable[0][0] == gameTable[2][2] && gameTable[0][0] == ch) {
            return true;
        }

        if (gameTable[0][2] == gameTable[1][1] && gameTable[0][2] == gameTable[2][0] && gameTable[0][2] == ch) {
            return true;
        }
        return false;
    }

    private static boolean isDraw(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
