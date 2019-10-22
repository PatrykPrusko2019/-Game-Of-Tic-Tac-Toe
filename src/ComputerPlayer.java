
/**algorithm for the computer player*/
public class ComputerPlayer {

    private String name;
    private boolean winner;
    private Fields figurePlayerComputer;
    private Fields figurePlayer;
    private Fields[][] arrayOfFieldsTicTacToe;

    public ComputerPlayer() {
        this.name = "Computer Player";
        this.winner = false;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Fields getFigurePlayerComputer() {
        return figurePlayerComputer;
    }

    public void setFigurePlayerComputer(Fields figurePlayerComputer) {
        this.figurePlayerComputer = figurePlayerComputer; }

    public Fields getFigurePlayer() {
        return figurePlayer;
    }

    public void setFigurePlayer(Fields figurePlayer) {
        this.figurePlayer = figurePlayer;
    }


    public int choosingTheBestMoveForComputerPlayer(Fields[][] tabTicTacToe) {

        this.arrayOfFieldsTicTacToe = tabTicTacToe;

         return selectField();

    }
    //choice Field
    public int selectField() {
        int valueField = checksNextMove(getFigurePlayerComputer(), 2); // checks whether two fields are in the correct position with eight possible variations for computer player
        if (valueField == -1) {
            valueField = checksNextMove(getFigurePlayer(), 2); // checks if two fields are in the correct position of the first player
            if (valueField == -1) {
                valueField = checksNextMove(getFigurePlayerComputer(), 1); // checks if one field is in the correct position and checks if 2 are empty for the computer player
                if (valueField == -1) {
                    valueField = searchEmptyField(); // checks for a free field for computer player
                }
            }

        }
        return valueField;
    }

    private int searchEmptyField() {

        //first checks the fields where there is a greater chance of winning
        if(arrayOfFieldsTicTacToe[1][1].equals(Fields.EMPTY)) { // 4 possibilities
            return 5;
        } else if(arrayOfFieldsTicTacToe[0][0].equals(Fields.EMPTY)) { // 3 possibilities
            return 1;
        } else if(arrayOfFieldsTicTacToe[0][2].equals(Fields.EMPTY)) { // 3 possibilities
            return 3;
        } else if(arrayOfFieldsTicTacToe[2][0].equals(Fields.EMPTY)) { // 3 possibilities
            return 7;
        } else if(arrayOfFieldsTicTacToe[2][2].equals(Fields.EMPTY)) { // 3 possibilities
            return 9;
        }

        //any empty
        int counter = 0, emptyField = 0;
        for (int i = 0; i < arrayOfFieldsTicTacToe.length; i++) {
            for (int j = 0; j < arrayOfFieldsTicTacToe[i].length; j++) {
                counter++;
                if (arrayOfFieldsTicTacToe[i][j].equals(Fields.EMPTY)) {
                    emptyField = counter;
                }
            }
        }
        return emptyField;
    }

    //movement possibilities
        private int checksNextMove(Fields figure, int numberOfFields) {
            int empty = 0;
            if(numberOfFields == 2) {
                empty = 1;
            } else if (numberOfFields == 1){
                empty = 2;
            }

            // eight possibilities to arrange the fields on the board to win
            int[] one   = new int[]{1, 4, 7};
            int[] two   = new int[]{2, 5, 8};
            int[] three = new int[]{3, 6, 9};
            int[] four  = new int[]{1, 2, 3};
            int[] five  = new int[]{4, 5, 6};
            int[] six   = new int[]{7, 8, 9};
            int[] seven = new int[]{1, 5, 9};
            int[] eight = new int[]{7, 5, 3};

            boolean[] tab = new boolean[3];

            int valueReturn = - 1;

                switch (1) {
                    case 1: {
                        tab = lookForTheBestMove(1, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(1, tab, Fields.EMPTY); //checks for empty fields
                            if(checkTheTab(tab, empty)) {
                              valueReturn = freeField(tab, one);
                              break;
                            }
                        }
                    }
                    case 2: {
                        tab = lookForTheBestMove(2, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(2, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, two);
                                break;
                            }
                        }
                    }
                    case 3: {
                        tab = lookForTheBestMove(3, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(3, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, three);
                                break;
                            }
                        }
                    }
                    case 4: {
                        tab = lookForTheBestMove(4, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(4, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, four);
                                break;
                            }
                        }
                    }
                    case 5: {
                        tab = lookForTheBestMove(5, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(5, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, five);
                                break;
                            }
                        }
                    }
                    case 6: {
                        tab = lookForTheBestMove(6, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(6, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, six);
                                break;
                            }
                        }
                    }
                    case 7: {
                        tab = lookForTheBestMove(7, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(7, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, seven);
                                break;
                            }
                        }
                    }
                    case 8: {
                        tab = lookForTheBestMove(8, tab, figure);
                        if(checkTheTab(tab, numberOfFields)) {
                            tab = lookForTheBestMove(8, tab, Fields.EMPTY);
                            if(checkTheTab(tab, empty)) {
                                valueReturn = freeField(tab, eight);
                                break;
                            }
                        }
                    }
                }
             return valueReturn;
    }

    private int freeField(boolean[] tab, int[] eightMovements) {
        int result = 0;
        for(int i = 0; i < tab.length; i++) {
            if(tab[i] == true) {
                result = eightMovements[i];
            }
        }
        return result;
    }

    private boolean checkTheTab(boolean[] tab, int numberOfFields) {
        int counter = 0;
        for(int i = 0; i < tab.length; i++) {
            if(tab[i] == true) {
                counter++;
            }
        }
        if(counter == numberOfFields) {
            return true;
        } else {
            return false;
        }
    }

    // eight possible moves to win
    private boolean[] lookForTheBestMove(int possibility , boolean[] tab, Fields figure) {
        for(int i = 0; i < tab.length; i++ ) {
            tab[i] = false;
        }
        switch (possibility) {
            case 1: {
                if(arrayOfFieldsTicTacToe[0][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][0].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[2][0].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 2: {
                if(arrayOfFieldsTicTacToe[0][1].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[2][1].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 3: {
                if(arrayOfFieldsTicTacToe[0][2].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][2].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[2][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 4: {
                if(arrayOfFieldsTicTacToe[0][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[0][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[0][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 5: {
                if(arrayOfFieldsTicTacToe[1][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[1][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 6: {
                if(arrayOfFieldsTicTacToe[2][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[2][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[2][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 7: {
                if(arrayOfFieldsTicTacToe[0][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[2][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
            case 8: {
                if(arrayOfFieldsTicTacToe[2][0].equals(figure)) {
                    tab[0] = true;
                }
                if(arrayOfFieldsTicTacToe[1][1].equals(figure)) {
                    tab[1] = true;
                }
                if(arrayOfFieldsTicTacToe[0][2].equals(figure)) {
                    tab[2] = true;
                }
                break;
            }
        }
        return tab;
    }

}
