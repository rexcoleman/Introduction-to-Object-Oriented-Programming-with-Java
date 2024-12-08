import java.util.Scanner;

public class Battleship {
    // Helper class to handle turn results more precisely
    private static class TurnResult {
        boolean isWin;
        char[][] finalBoard;
        
        TurnResult(boolean isWin, char[][] finalBoard) {
            this.isWin = isWin;
            this.finalBoard = finalBoard;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize game boards for both players
        char[][] player1Board = new char[5][5];
        char[][] player2Board = new char[5][5];
        char[][] player1Shots = new char[5][5];
        char[][] player2Shots = new char[5][5];
        
        // Initialize all boards with empty spaces
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                player1Board[i][j] = '-';
                player2Board[i][j] = '-';
                player1Shots[i][j] = '-';
                player2Shots[i][j] = '-';
            }
        }
        
        // Print welcome message
        System.out.println("Welcome to Battleship!");
        System.out.println();
        
        // Player 1 ship placement
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(scanner, player1Board);
        
        // Clear screen with 100 lines
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        
        // Player 2 ship placement
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(scanner, player2Board);
        
        // Clear screen with 100 lines
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        
        // Main game loop
        boolean gameOver = false;
        do {
            // Player 1's turn
            TurnResult p1Result = playerTurn(scanner, 1, player2Board, player1Shots);
            if (p1Result.isWin) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
                System.out.println("Final boards:\n");
                printBattleShip(player1Board);
                System.out.println();
                printBattleShip(player2Board);
                gameOver = true;
                break;
            }
            
            // Player 2's turn
            TurnResult p2Result = playerTurn(scanner, 2, player1Board, player2Shots);
            if (p2Result.isWin) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
                System.out.println("Final boards:\n");
                printBattleShip(player1Board);
                System.out.println();
                printBattleShip(player2Board);
                gameOver = true;
                break;
            }
        } while (!gameOver);
    }
    
    private static void placeShips(Scanner scanner, char[][] board) {
        for (int i = 1; i <= 5; i++) {
            while (true) {
                System.out.println("Enter ship " + i + " location:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                
                if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
                
                if (board[row][col] == '@') {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    continue;
                }
                
                board[row][col] = '@';
                break;
            }
        }
        printBattleShip(board);
    }
    
    private static TurnResult playerTurn(Scanner scanner, int playerNum, char[][] opponentBoard, char[][] shotBoard) {
        while (true) {
            System.out.println("Player " + playerNum + ", enter hit row/column:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            
            if (shotBoard[row][col] != '-') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue;
            }
            
            if (opponentBoard[row][col] == '@' || opponentBoard[row][col] == 'X') {
                opponentBoard[row][col] = 'X';
                shotBoard[row][col] = 'X';
                System.out.println("PLAYER " + playerNum + " HIT PLAYER " + 
                    (playerNum == 1 ? "2" : "1") + "'s SHIP!");
            } else {
                opponentBoard[row][col] = 'O';
                shotBoard[row][col] = 'O';
                System.out.println("PLAYER " + playerNum + " MISSED!");
            }
            
            printBattleShip(shotBoard);
            
            // Check for win condition
            boolean isWin = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (opponentBoard[i][j] == '@') {
                        isWin = false;
                        break;
                    }
                }
                if (!isWin) break;
            }
            
            // Only print newline if not a winning move
            if (!isWin) {
                System.out.println();
            }
            
            return new TurnResult(isWin, shotBoard);
        }
    }
    
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}