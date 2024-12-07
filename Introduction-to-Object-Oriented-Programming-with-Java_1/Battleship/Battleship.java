import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message
        System.out.println("Welcome to Battleship!");
        
        // Initialize game boards
        // Location boards track ship positions and hits/misses
        char[][] player1LocationBoard = new char[5][5];
        char[][] player2LocationBoard = new char[5][5];
        // Target history boards track each player's shots
        char[][] player1TargetHistory = new char[5][5];
        char[][] player2TargetHistory = new char[5][5];
        
        // Initialize all boards with empty spaces
        initializeBoard(player1LocationBoard);
        initializeBoard(player2LocationBoard);
        initializeBoard(player1TargetHistory);
        initializeBoard(player2TargetHistory);
        
        // Get ship placements for both players
        System.out.println("\nPLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(scanner, player1LocationBoard, 1);
        
        // Print 100 blank lines to hide Player 1's ship locations
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(scanner, player2LocationBoard, 2);
        
        // Main game loop
        boolean gameOver = false;
        do {
            // Player 1's turn
            gameOver = playerTurn(scanner, 1, player2LocationBoard, player1TargetHistory);
            if (gameOver) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                break;
            }
            
            // Player 2's turn
            gameOver = playerTurn(scanner, 2, player1LocationBoard, player2TargetHistory);
            if (gameOver) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                break;
            }
        } while (!gameOver);
        
        // Print final boards
        System.out.println("\nFinal boards:\n");
        printBattleShip(player1LocationBoard);
        System.out.println();
        printBattleShip(player2LocationBoard);
        
        scanner.close();
    }
    
    // Initialize board with empty spaces
    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    // Handle ship placement for a player
    private static void placeShips(Scanner scanner, char[][] board, int playerNum) {
        for (int i = 1; i <= 5; i++) {
            boolean validPlacement = false;
            do {
                System.out.println("Enter ship " + i + " location:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                
                // Validate coordinates
                if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
                
                // Check if space is already occupied
                if (board[row][col] == '@') {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    continue;
                }
                
                // Place ship
                board[row][col] = '@';
                validPlacement = true;
            } while (!validPlacement);
        }
        
        // Print the board after all ships are placed
        printBattleShip(board);
    }
    
    // Handle a player's turn
    private static boolean playerTurn(Scanner scanner, int playerNum, char[][] opponentBoard, char[][] targetHistory) {
        boolean validShot = false;
        do {
            System.out.println("Player " + playerNum + ", enter hit row/column:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            // Validate coordinates
            if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            
            // Check if already fired at these coordinates
            if (targetHistory[row][col] != '-') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue;
            }
            
            // Process the shot
            if (opponentBoard[row][col] == '@') {
                // Hit
                opponentBoard[row][col] = 'X';
                targetHistory[row][col] = 'X';
                System.out.println("PLAYER " + playerNum + " HIT PLAYER " + 
                    (playerNum == 1 ? "2" : "1") + "'s SHIP!");
            } else {
                // Miss
                opponentBoard[row][col] = 'O';
                targetHistory[row][col] = 'O';
                System.out.println("PLAYER " + playerNum + " MISSED!");
            }
            
            // Print updated target history
            printBattleShip(targetHistory);
            validShot = true;
            
            // Check if all ships are sunk
            return checkWin(opponentBoard);
        } while (!validShot);
        
        return false;
    }
    
    // Check if all ships have been sunk
    private static boolean checkWin(char[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == '@') {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Use this method to print game boards to the console.
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