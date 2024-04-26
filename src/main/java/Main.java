
import controllers.GameController;
import exceptions.InvalidMoveException;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Aditya", new Symbol('X'), PlayerType.HUMAN),
                new Bot("deepaksir", new Symbol('O'), PlayerType.BOT, BoitDifficultyLevel.EASY)
        );

        Game game = GameController.StartGame(dimension, players);
        //gameController.printBoard(game);

        while (game.getState().equals(GameState.INPROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}