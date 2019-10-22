import java.util.Scanner;

public class Player {

    private String name;
    private boolean winner;
    private Fields figure;
    private Scanner sc;
    public Player() {
        this.sc = new Scanner(System.in);
        boolean exit = false;
        while(! exit) {
            System.out.println("\n\nplease give me a name of player: ");
            String name = sc.nextLine();
            if ( (! name.isEmpty()) && ( checksName(name) ) ) {
                this.name = name;
                exit = true;
            } else {
                System.out.println("wrong value ... try again");
            }
        }

        this.winner = false;
    }
    private boolean checksName(String name) {
        char[] tabChar = name.toCharArray();
        for(int i = 0; i < tabChar.length; i++) {
            if(tabChar[i] != ' ') {
                return true;
            }
        }
        return false;
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

    public Fields getFigure() {
        return figure;
    }
    public void setFigure(Fields figure) {
        this.figure = figure;
    }
}
