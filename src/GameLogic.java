//logic game
public class GameLogic {

    private int choiceOfPlayer;
    private Player player;
    private Fields[][] tabTicTacToe;

    public Fields[][] getTabTicTacToe() {
        return tabTicTacToe;
    }

    public boolean checkIfPlayerHasThreeOfTheSameFigures(int choiceOfPlayer, Player player, Fields[][] tabTicTacToe) {

        this.choiceOfPlayer = choiceOfPlayer;
        this.player = player;
        this.tabTicTacToe = tabTicTacToe;

        setsNewPlayerMove();
        boolean isWinner = checksIfThePlayerHasWon();

        return isWinner;
    }


    //eight options for placing the given figure on the board
    private boolean checksIfThePlayerHasWon() {

        switch(1) {
            case 1: {
                if( (tabTicTacToe[0][0].equals(player.getFigure()) ) && (tabTicTacToe[1][0].equals(player.getFigure()) )
                        && (tabTicTacToe[2][0].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 2: {
                if( (tabTicTacToe[0][1].equals(player.getFigure()) ) && (tabTicTacToe[1][1].equals(player.getFigure()) )
                        && (tabTicTacToe[2][1].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 3: {
                if( (tabTicTacToe[0][2].equals(player.getFigure()) ) && (tabTicTacToe[1][2].equals(player.getFigure()) )
                        && (tabTicTacToe[2][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 4: {
                if( (tabTicTacToe[0][0].equals(player.getFigure()) ) && (tabTicTacToe[0][1].equals(player.getFigure()) )
                        && (tabTicTacToe[0][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 5: {
                if( (tabTicTacToe[1][0].equals(player.getFigure()) ) && (tabTicTacToe[1][1].equals(player.getFigure()) )
                        && (tabTicTacToe[1][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 6: {
                if( (tabTicTacToe[2][0].equals(player.getFigure()) ) && (tabTicTacToe[2][1].equals(player.getFigure()) )
                        && (tabTicTacToe[2][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 7: {
                if( (tabTicTacToe[0][0].equals(player.getFigure()) ) && (tabTicTacToe[1][1].equals(player.getFigure()) )
                        && (tabTicTacToe[2][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
            case 8: {
                if( (tabTicTacToe[2][0].equals(player.getFigure()) ) && (tabTicTacToe[1][1].equals(player.getFigure()) )
                        && (tabTicTacToe[0][2].equals(player.getFigure()) ) ) {
                    player.setWinner(true);
                    break;
                }
            }
        }
        return player.isWinner();

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
}
