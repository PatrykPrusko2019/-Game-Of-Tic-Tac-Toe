
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    private Scanner sc;
    private Fields[][] tabTicTacToe;
    private int[] arrayPoints;

    public TicTacToe() {
        System.out.println("Game of Tic-Tac-Toe: ");
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

        System.out.println("\n- you have the choice of field 1 - 9" + "\n- there are two players -> first player vs second player or player vs computer player\n" + "- two figures: X, O");
    }

    public Fields[][] getTabTicTacToe() {
        return tabTicTacToe;
    }
    public void setTabTicTacToe(Fields[][] tabTicTacToe) {
        this.tabTicTacToe = tabTicTacToe;
    }


    public void startGame() {

        System.out.println("Two game options:\n" +
                "1. first player vs second player\n" +
                "2. player vs computer player");

        switch ( choiceUser() ) {
            case 1: {
                createPlayersAndRandomWhoStartTheGameVersionFirst();
                break;
            }
            case 2: {
                createPlayersAndRandomWhoStartTheGameVersionSecond();
                break;
            }
        }

    }

    private int choiceUser() {
        boolean exit = false;
        int value = 0;
        while(! exit) {
            System.out.println("Choose a value: (range 1 - 2)");
            exit = sc.hasNextInt();
            if(exit) {
                value = sc.nextInt();
                sc.nextLine();
                if(value > 0 && value < 3) {
                    System.out.println("good choice !!! start game ");
                } else {
                    System.out.println("is not in the range 1 - 2 ... try again");
                    exit = false;
                }
            } else {
                System.out.println("it's not a number ... try again");
                exit = false;
                sc.nextLine();
            }
        }
        return value;
    }

    //first player vs second player
    private void createPlayersAndRandomWhoStartTheGameVersionFirst() {
        Player playerFirst = new Player();
        Player playerSecond = new Player();
        System.out.println("*******************************\ncreate new two players " + playerFirst.getName() + ", " + playerSecond.getName());
        GameLogic gameLogic = new GameLogic();

        Random rand = new Random();
        int playerDraw = rand.nextInt(2) + 1; // draws the player who starts the game

        if(playerDraw == 1) {
            playerFirst.setFigure(Fields.X);
            playerSecond.setFigure(Fields.O);
            choiceOfPlayerMovementPlayerVsPlayer(playerFirst, playerSecond, gameLogic);
        } else {
            playerSecond.setFigure(Fields.X);
            playerFirst.setFigure(Fields.O);
            choiceOfPlayerMovementPlayerVsPlayer(playerSecond, playerFirst, gameLogic);
        }
    }

    //player vs computer player
    private void createPlayersAndRandomWhoStartTheGameVersionSecond() {
        Player playerFirst = new Player();
        ComputerPlayer computerPlayerSecond = new ComputerPlayer();
        System.out.println("*******************************\ncreate new two players " + playerFirst.getName() + ", " + computerPlayerSecond.getName());
        GameLogic gameLogic = new GameLogic();

        Random rand = new Random();
        int playerDraw = rand.nextInt(2) + 1; // draws the player who starts the game

        if(playerDraw == 1) {
            playerFirst.setFigure(Fields.X);
            computerPlayerSecond.setFigurePlayerComputer(Fields.O);
        } else {
            computerPlayerSecond.setFigurePlayerComputer(Fields.X);
            playerFirst.setFigure(Fields.O);
        }

        choiceOfPlayerMovementPlayerVsComputerPlayer(playerFirst ,computerPlayerSecond, gameLogic);
    }

    //choice computer player vs normal player
    private void choiceOfPlayerMovementPlayerVsComputerPlayer(Player playerFirst, ComputerPlayer computerPlayerSecond, GameLogic gameLogic) {

        System.out.println("the player who starts is drawn");
        boolean exit = false;
        int counter = 0;
        computerPlayerSecond.setFigurePlayer(playerFirst.getFigure());

            if(computerPlayerSecond.getFigurePlayerComputer().equals(Fields.X)) {
                System.out.println("\n*******************************\nSTART GAME\nstart computer player first move: \n*******************************\n");

                while (!exit) {
                                gameLogic.checkIfComputerPlayerHasThreeOfTheSameFigures( computerPlayerSecond, getTabTicTacToe());//player computer
                                counter++;
                                if(checkWhoWon(gameLogic,playerFirst, computerPlayerSecond, counter) ) {
                                    break; //finish game !!!
                                }
                                showTicTacToeTables();
                                int choiceOfPlayer = choiceSelection(playerFirst);
                                gameLogic.checkIfPlayerHasThreeOfTheSameFigures(choiceOfPlayer, playerFirst, getTabTicTacToe());
                                counter++;

                                if(checkWhoWon(gameLogic,playerFirst, computerPlayerSecond, counter) ) {
                                    exit = true;
                                }

                    }

            } else { // start normal player
                System.out.println("\n*******************************\nSTART GAME\nstart normal player please select the available field (range 1 - 9) : \n*******************************\n");

                while (! exit) {
                    showTicTacToeTables();
                    int choiceOfPlayer = choiceSelection(playerFirst);
                    gameLogic.checkIfPlayerHasThreeOfTheSameFigures(choiceOfPlayer, playerFirst, getTabTicTacToe());
                    counter++;
                    if(checkWhoWon(gameLogic,playerFirst, computerPlayerSecond, counter) ) {
                        break; //finish game !!!
                    }

                    gameLogic.checkIfComputerPlayerHasThreeOfTheSameFigures( computerPlayerSecond, getTabTicTacToe()); //computer player
                    counter++;

                    if(checkWhoWon(gameLogic,playerFirst, computerPlayerSecond, counter) ) {
                        exit = true;
                    }
                }
            }
    }

    //computer vs player
    private boolean checkWhoWon( GameLogic gameLogic, Player playerFirst, ComputerPlayer computerPlayerSecond, int counter) {
        boolean exit = false;
        if (computerPlayerSecond.isWinner() || playerFirst.isWinner()) {
            setTabTicTacToe(gameLogic.getTabTicTacToe());
            System.out.println("***************************************************");
            showTicTacToeTables();
            System.out.println("Winner is player -> " + (computerPlayerSecond.isWinner() ? computerPlayerSecond.getName() + ", figure: " + computerPlayerSecond.getFigurePlayerComputer()
                    : playerFirst.getName() + ", figure: " + playerFirst.getFigure() ));
            System.out.print("loser is -> ");
            if (!(playerFirst.isWinner())) {
                System.out.println(playerFirst.getName() + ", figure: " + playerFirst.getFigure());
            } else if (!(computerPlayerSecond.isWinner())) {
                System.out.println(computerPlayerSecond.getName() + ", figure: " + computerPlayerSecond.getFigurePlayerComputer());
            }
            System.out.println("FINISH GAME !!!");
            System.out.println("***************************************************");
            exit = true; //finish game
        } else if (counter == 9) {
            System.out.println("***************************************************");
            showTicTacToeTables();
            System.out.println("DEAD-HEAT between first player: " + playerFirst.getName() + ", and second player: " + computerPlayerSecond.getName());
            System.out.println("FINISH GAME !!!");
            System.out.println("***************************************************");
            exit = true; //finish game
        }
        return exit;
    }


    //firstPlayer vs secondPlayer
    private void choiceOfPlayerMovementPlayerVsPlayer(Player playerFirst, Player playerSecond, GameLogic gameLogic) {
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
