import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    static boolean playing = true;

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameboard(gameBoard);

        while (playing) {
            System.out.println(playerPositions.size());
            System.out.println(cpuPositions.size());
            // First round of game

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the position of your placement (1-9)");
            int playerPosition = scanner.nextInt();
            System.out.println("You chose position: " + playerPosition);

            // Play the piece
            boolean playerOkay = pieceThere(gameBoard, playerPosition);
            if (playerOkay && playing) {
                System.out.println("Enter the position of your placement (1-9)");
                System.out.println("You chose position: " + playerPosition);
                placePiece(gameBoard, playerPosition, "player");
                playerPositions.add(playerPosition);
                checkWinner();
            } else {
                while (!playerOkay && playing) {
                    System.out.println("Piece already there... ");
                    System.out.println("Enter the position of your placement (1-9)");
                    playerPosition = scanner.nextInt();
                    playerOkay = pieceThere(gameBoard, playerPosition);
                }
                placePiece(gameBoard, playerPosition, "player");
                checkWinner();
            }


            // CPUs turn
            System.out.println();
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            boolean cpuOkay = pieceThere(gameBoard, cpuPos);

            if (cpuOkay && playing) {
                placePiece(gameBoard, cpuPos, "cpu");
                cpuPositions.add(cpuPos);
                checkWinner();
            } else {
                while (!cpuOkay && playing) {
                    System.out.println("Piece already there... ");
                    System.out.println(playerPositions.size());
                    System.out.println(cpuPositions.size());
                    cpuPos = rand.nextInt(9) + 1;
                    cpuOkay = pieceThere(gameBoard, cpuPos);
                    System.out.println();
                }
                placePiece(gameBoard, cpuPos, "cpu");
                checkWinner();
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
                return gameBoard[0][0] != 'X' && gameBoard[0][0] != 'O';
            case 2:
                return gameBoard[0][2] != 'X' && gameBoard[0][2] != 'O';
            case 3:
                return gameBoard[0][4] != 'X' && gameBoard[0][4] != 'O';
            case 4:
                return gameBoard[2][0] != 'X' && gameBoard[2][0] != 'O';
            case 5:
                return gameBoard[2][2] != 'X' && gameBoard[2][2] != 'O';
            case 6:
                return gameBoard[2][4] != 'X' && gameBoard[2][4] != 'O';
            case 7:
                return gameBoard[4][0] != 'X' && gameBoard[4][0] != 'O';
            case 8:
                return gameBoard[4][2] != 'X' && gameBoard[4][2] != 'O';
            case 9:
                return gameBoard[4][4] != 'X' && gameBoard[4][4] != 'O';
        }
        return false;
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char player = 'X';
        char cpu = 'O';
        char piece = Objects.equals(user, "player") ? player : cpu;

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

    public static void checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);

        List firstCol = Arrays.asList(1, 4, 7);
        List secCol = Arrays.asList(2, 5, 8);
        List thirdCol = Arrays.asList(3, 6, 9);

        List crossLeft = Arrays.asList(1, 5, 9);
        List crossRight = Arrays.asList(3, 5, 7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(firstCol);
        winningConditions.add(secCol);
        winningConditions.add(thirdCol);
        winningConditions.add(crossLeft);
        winningConditions.add(crossRight);

        for (List l : winningConditions) {
            if (playerPositions.containsAll(l)) {
                System.out.println("Congratulations you won!");
                return;
            } else if (cpuPositions.containsAll(l)) {
                playing = false;
                System.out.println("CPU wins :(...");
                return;
            } else if (playerPositions.size() + cpuPositions.size() == 8 && playing) {
                playing = false;
                System.out.println("DRAW!");
                return;
            }
        }
    }
}
