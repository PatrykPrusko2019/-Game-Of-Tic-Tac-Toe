import java.util.Random;
import java.util.Scanner;

//game of tic tac toe
public class TicTacToe {
    private Scanner sc;
    private Fields[][] tab;
    private int[] arrayPoints;

    public TicTacToe() {
        this.sc = new Scanner(System.in);
        this.tab = new Fields[3][3];
        this.arrayPoints = new int[9];
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++ ) {
                tab[i][j] = Fields.EMPTY;
            }
        }

            System.out.printf("\n______________\n");
            for(int i = 0; i < arrayPoints.length; i++) {
                arrayPoints[i] = i+1;
                System.out.printf(" %s | ", arrayPoints[i] );
                if(arrayPoints[i] % 3 == 0) {
                    System.out.printf("\n______________\n");
                }
            }
    }
    public Fields[][] getTab() {
        return tab;
    }
    public void setTab(Fields[][] tab) {
        this.tab = tab;
    }
    public int[] getArrayPoints() {
        return arrayPoints;
    }
    public void setArrayPoints(int[] arrayPoints) {
        this.arrayPoints = arrayPoints;
    }
    public void startGame() {

        System.out.println("create new two players");

        createPlayersAndRandomWhoStartTheGame();


        System.out.println("Start game Tic Tac Toe: ");
        showTicTacToeTables();


    }
    private void createPlayersAndRandomWhoStartTheGame() {
        Player playerFirst = new Player("Patryshia");
        Player playerSecond = new Player("Patrick");
        GameLogic gameLogic = new GameLogic();

        Random rand = new Random();
        int playerDraw = rand.nextInt(2) + 1; // draws the player who starts the game

        if(playerDraw == 1) {
            playerFirst.setFigure(Fields.X);
            playerSecond.setFigure(Fields.O);
            choiceOfPlayerMovement(playerFirst, playerSecond, gameLogic);
        } else {
            playerSecond.setFigure(Fields.X);
            playerFirst.setFigure(Fields.O);
            choiceOfPlayerMovement(playerSecond, playerFirst, gameLogic);
        }
    }

    private void choiceOfPlayerMovement(Player playerFirst, Player playerSecond, GameLogic gameLogic) {

        Player[] tabPlayer = new Player[]{playerFirst, playerSecond};
        boolean exit = false;
        System.out.println("please select the available field : ");

        while(! exit) {
            for(Player player : tabPlayer) {

                int choiceOfPlayer = choiceSelection(player);

                gameLogic.checkIfPlayerHasThreeOfTheSameFigures(choiceOfPlayer, player, getTab() );


            }
        }




    }
    private int choiceSelection(Player player) {
        System.out.println("enter the value , player " + player.getName() );
        boolean isExit = false;
        int value = 0;

        while (! isExit) {
            isExit = sc.hasNextInt();
            if(isExit) {
                value = sc.nextInt();
                value--;
                sc.nextLine();
                for(int i = 0; i < getArrayPoints().length; i++) {
                    if(value == getArrayPoints()[i]) {
                        if(checksForAvailableField(value) ) {
                            isExit = true;
                        } else {
                            System.out.println("field is not empty ... please again");
                        }
                    }
                }

            } else {
                System.out.println(" it's not a number ...");
                sc.nextLine();
            }
        }

        return value;
    }


    private boolean checksForAvailableField(int value) {
        int counter = 0;
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                counter++;
                if(value == counter && tab[i][j].equals(Fields.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void showTicTacToeTables() {
        System.out.printf("\n__________________\n");
        for(int i = 0; i < tab.length; i++) {
            System.out.print("|");
            for(int j = 0; j < tab[i].length; j++) {

                    System.out.printf(" %s | ", (tab[i][j].equals(Fields.EMPTY) ? "  " : tab[i][j]) );
            }
            System.out.printf("\n__________________\n");
        }
    }
}
