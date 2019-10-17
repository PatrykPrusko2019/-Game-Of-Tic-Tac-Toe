public class Player {

    private String name;
    private boolean winner;
    private Fields figure;

    public Player(String name) {
        this.name = name;
        this.winner = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
