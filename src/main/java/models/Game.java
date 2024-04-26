package models;

import exceptions.InvalidMoveException;
import strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private GameState state;
    private List<Player> players; ;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIndex;
    private WinningAlgorithm algorithm;



    // constructor
    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves= new ArrayList<>();
        this.winner = null;
        this.state = state.INPROGRESS;
        this.nextPlayerIndex = 0;
        this.algorithm = new WinningAlgorithm();
    }

    //methods
    public void printBoard() {
        this.board.PrintBoard();
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0  || col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    //main
    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println( currentPlayer.getName() + "'s move.");


        Move move = currentPlayer.makeMove(board);
        if (!validateMove(move)) {
            //throw an exception
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        //Check if the current move is the winning move or not.
        if (algorithm.checkWinner(board, finalMove)) {
            state = GameState.ENDED;
            winner = currentPlayer;
        }
    }

    //getter and setters

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public WinningAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(WinningAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
