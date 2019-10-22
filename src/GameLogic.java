//logic game
public class GameLogic {

    private int choiceOfPlayer;
    private Player player;
    private ComputerPlayer computerPlayer;
    private Fields[][] tabTicTacToe;

    public Fields[][] getTabTicTacToe() {
        return tabTicTacToe;
    }

    //computer player
    public boolean checkIfComputerPlayerHasThreeOfTheSameFigures( ComputerPlayer player, Fields[][] tabTicTacToe) {
        this.computerPlayer = player;
        this.tabTicTacToe = tabTicTacToe;

        this.choiceOfPlayer = computerPlayer.choosingTheBestMoveForComputerPlayer(tabTicTacToe);

        setsNewComputerPlayerMove();
        boolean isWinner = checksIfThePlayerHasWon(computerPlayer.getFigurePlayerComputer());

        computerPlayer.setWinner(isWinner);

        return isWinner;
    }

    // first player and second player
    public boolean checkIfPlayerHasThreeOfTheSameFigures(int choiceOfPlayer, Player playerFirst, Fields[][] tabTicTacToe) {

        this.choiceOfPlayer = choiceOfPlayer;
        this.player = playerFirst;
        this.tabTicTacToe = tabTicTacToe;

        setsNewPlayerMove();
        boolean isWinner = checksIfThePlayerHasWon(player.getFigure());
        player.setWinner(isWinner);
        return isWinner;
    }




    //eight possibilities for the arrangement of figures
    private boolean checksIfThePlayerHasWon(Fields figure) {
        boolean winner = false;
        switch(1) {
            case 1: {
                if( (tabTicTacToe[0][0].equals(figure) ) && (tabTicTacToe[1][0].equals(figure) ) // fields one, four, seven
                        && (tabTicTacToe[2][0].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 2: {
                if( (tabTicTacToe[0][1].equals(figure) ) && (tabTicTacToe[1][1].equals(figure) ) // fields two, five, eight
                        && (tabTicTacToe[2][1].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 3: {
                if( (tabTicTacToe[0][2].equals(figure) ) && (tabTicTacToe[1][2].equals(figure) ) // fields three, six, nine
                        && (tabTicTacToe[2][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 4: {
                if( (tabTicTacToe[0][0].equals(figure) ) && (tabTicTacToe[0][1].equals(figure) ) //fields one, two, three
                        && (tabTicTacToe[0][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 5: {
                if( (tabTicTacToe[1][0].equals(figure) ) && (tabTicTacToe[1][1].equals(figure) ) // fields four, five, six
                        && (tabTicTacToe[1][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 6: {
                if( (tabTicTacToe[2][0].equals(figure) ) && (tabTicTacToe[2][1].equals(figure) ) // fields seven, eight, nine
                        && (tabTicTacToe[2][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 7: {
                if( (tabTicTacToe[0][0].equals(figure) ) && (tabTicTacToe[1][1].equals(figure) ) // fields one, five, nine
                        && (tabTicTacToe[2][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
            case 8: {
                if( (tabTicTacToe[2][0].equals(figure) ) && (tabTicTacToe[1][1].equals(figure) ) // fields seven, five, three
                        && (tabTicTacToe[0][2].equals(figure) ) ) {
                    winner = true;
                    break;
                }
            }
        }
        return winner;
    }


    public boolean setsNewPlayerMove() {
        int counter = 0;
        for(int i = 0; i < tabTicTacToe.length; i++) {
            for(int j = 0; j < tabTicTacToe[i].length; j++) {
                counter++;
                if( (counter == choiceOfPlayer) && (tabTicTacToe[i][j].equals(Fields.EMPTY)) ) {
                    tabTicTacToe[i][j] = player.getFigure();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setsNewComputerPlayerMove() {
        int counter = 0;
        for(int i = 0; i < tabTicTacToe.length; i++) {
            for(int j = 0; j < tabTicTacToe[i].length; j++) {
                counter++;
                if( (counter == choiceOfPlayer) && (tabTicTacToe[i][j].equals(Fields.EMPTY)) ) {
                    tabTicTacToe[i][j] = computerPlayer.getFigurePlayerComputer();
                    return true;
                }
            }
        }
        return false;
    }
}
