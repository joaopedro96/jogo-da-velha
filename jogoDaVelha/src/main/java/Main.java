import model.Board;
import view.GameView;


public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        GameView view = new GameView();

        view.showBoard(board);


    }
}