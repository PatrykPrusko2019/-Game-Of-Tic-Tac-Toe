import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    private Scanner sc;
    private Fields[][] tabTicTacToe;
    private int[] arrayPoints;

    public TicTacToe() {

        System.out.println("game rules:");

        this.sc = new Scanner(System.in);
        this.tabTicTacToe = new Fields[3][3];
        this.arrayPoints = new int[9];
        for(int i = 0; i < tabTicTacToe.length; i++) {
            for(int j = 0; j < tabTicTacToe[i].length; j++ ) {
                tabTicTacToe[i][j] = Fields.EMPTY;
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

        System.out.println("\n- you have the choice of field 1 - 9" + "\n- there are two players\n" + "- two figures: X, O");
    }

    public Fields[][] getTabTicTacToe() {
        return tabTicTacToe;
    }
    public void setTabTicTacToe(Fields[][] tabTicTacToe) {
        this.tabTicTacToe = tabTicTacToe;
    }


    public void startGame() {
        createPlayersAndRandomWhoStartTheGame();
    }

    private void createPlayersAndRandomWhoStartTheGame() {
        Player playerFirst = new Player();
        Player playerSecond = new Player();
        System.out.println("*******************************\ncreate new two players " + playerFirst.getName() + ", " + playerSecond.getName());
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
        System.out.println("the player who starts is drawn");
        Player[] tabPlayer = new Player[]{playerFirst, playerSecond};
        boolean exit = false;
        int counter = 0;
        System.out.println("\n*******************************\nSTART GAME\nplease select the available field (range 1 - 9) : \n*******************************\n");

        while(! exit) {
            for(Player player : tabPlayer) {

                int choiceOfPlayer = choiceSelection(player);
                counter++;
                if ( gameLogic.checkIfPlayerHasThreeOfTheSameFigures(choiceOfPlayer, player, getTabTicTacToe() ) ) {
                    setTabTicTacToe( gameLogic.getTabTicTacToe() );
                    System.out.println("***************************************************");
                    showTicTacToeTables();
                    System.out.println("Winner is player -> " + player.getName() + ", figure: " + player.getFigure() );
                    System.out.print("loser is -> " );
                    if(! (playerFirst.isWinner()) ) {
                        System.out.println(playerFirst.getName() + ", figure: " + playerFirst.getFigure());
                    } else if(! (playerSecond.isWinner()) ) {
                        System.out.println(playerSecond.getName() + ", figure: " + playerSecond.getFigure());
                    }
                    System.out.println("FINISH GAME !!!");
                    System.out.println("***************************************************");
                    exit = true; //finish game
                    break;
                } else if (counter == 9){
                    System.out.println("***************************************************");
                    showTicTacToeTables();
                    System.out.println("DEAD-HEAT between first player: " + playerFirst.getName() + ", and second player: " + playerSecond.getName());
                    System.out.println("FINISH GAME !!!");
                    System.out.println("***************************************************");
                    exit = true; //finish game
                    break;
                } else {
                    showTicTacToeTables();
                }

            }
        }

    }


    public int choiceSelection(Player player) {
        System.out.println("enter the value , player " + player.getName() + ", has " + player.getFigure() + ", (range 1 - 9): " );
        boolean isExit = false;
        int value = 0;

        while (! isExit) {
            isExit = sc.hasNextInt();
            if(isExit) {
                value = sc.nextInt();
                sc.nextLine();

                    if(value > 0 && value <= arrayPoints.length ) {
                        if(checksForAvailableField(value) ) {
                            isExit = true;
                        } else {
                            System.out.println("field is not empty ... please again");
                            isExit = false;
                        }
                    } else {
                        System.out.println("wrong value range 1 - 9 ... try again");
                        isExit = false;
                    }
            } else {
                System.out.println(" it's not a number ... please again");
                sc.nextLine();
            }
        }

        return value;
    }

    private boolean checksForAvailableField(int value) {
        int counter = 0;
        for(int i = 0; i < tabTicTacToe.length; i++) {
            for(int j = 0; j < tabTicTacToe[i].length; j++) {
                counter++;
                if(value == counter && tabTicTacToe[i][j].equals(Fields.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void showTicTacToeTables() {
        System.out.printf("\n_____________\n");
        for(int i = 0; i < tabTicTacToe.length; i++) {
            System.out.printf("|");
            for(int j = 0; j < tabTicTacToe[i].length; j++) {

                    System.out.printf("%s|", (tabTicTacToe[i][j].equals(Fields.EMPTY) ? "   " : " "+tabTicTacToe[i][j]+" ") );
            }
            System.out.printf("\n_____________\n");
        }
    }
}
