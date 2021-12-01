import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        boolean gamePlaying = false;

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameboard(gameBoard);

        while (true) {
            // First round of game
            boolean falseMove = false;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the position of your placement (1-9)");
            int playerPosition = scanner.nextInt();
            System.out.println("You chose position: " + playerPosition);

            // Play the piece
            boolean playerOkay = pieceThere(gameBoard, playerPosition);
            if (playerOkay){
                System.out.println("Enter the position of your placement (1-9)");
                System.out.println("You chose position: " + playerPosition);
                placePiece(gameBoard, playerPosition, "player");
            } else {
                while (!playerOkay){
                    System.out.println("Piece already there... ");
                    System.out.println("Enter the position of your placement (1-9)");
                    playerPosition = scanner.nextInt();
                    playerOkay = pieceThere(gameBoard, playerPosition);
                }
            }



            // CPUs turn
            System.out.println();
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            boolean cpuOkay = pieceThere(gameBoard, cpuPos);

            if (cpuOkay){
                placePiece(gameBoard, cpuPos, "cpu");
            } else {
                System.out.println("Piece already there... ");
                cpuPos = rand.nextInt(9) + 1;
                cpuOkay = pieceThere(gameBoard, cpuPos);
                System.out.println();
            }

        }
    }

    public static void printGameboard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    public static boolean pieceThere(char[][] gameBoard, int position) {

        switch (position) {
            case 1:
                if (gameBoard[0][0] == 'X' || gameBoard[0][0] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 2:
                if (gameBoard[0][2] == 'X' || gameBoard[0][2] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 3:
                if (gameBoard[0][4] == 'X' || gameBoard[0][4] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 4:
                if (gameBoard[2][0] == 'X' || gameBoard[2][0] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 5:
                if (gameBoard[2][2] == 'X' || gameBoard[2][2] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 6:
                if (gameBoard[2][4] == 'X' || gameBoard[2][4] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 7:
                if (gameBoard[4][0] == 'X' || gameBoard[4][0] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 8:
                if (gameBoard[4][2] == 'X' || gameBoard[4][2] == 'O') {
                    return false;
                } else {
                    return true;
                }
            case 9:
                if (gameBoard[4][4] == 'X' || gameBoard[4][4] == 'O') {
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char player = 'X';
        char cpu = 'O';
        char piece = user == "player" ? player : cpu;

        switch (position) {
            case 1:
                gameBoard[0][0] = piece;
                break;
            case 2:
                gameBoard[0][2] = piece;
                break;
            case 3:
                gameBoard[0][4] = piece;
                break;
            case 4:
                gameBoard[2][0] = piece;
                break;
            case 5:
                gameBoard[2][2] = piece;
                break;
            case 6:
                gameBoard[2][4] = piece;
                break;
            case 7:
                gameBoard[4][0] = piece;
                break;
            case 8:
                gameBoard[4][2] = piece;
                break;
            case 9:
                gameBoard[4][4] = piece;
                break;
        }
        printGameboard(gameBoard);
    }


}
