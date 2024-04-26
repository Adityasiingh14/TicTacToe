package models;

import java.util.List;

public class Bot extends Player {
    private BoitDifficultyLevel boitDifficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BoitDifficultyLevel boitDifficultyLevel) {
        super(name, symbol, playerType);
        this.boitDifficultyLevel = boitDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
