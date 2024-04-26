package models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;
    //getter and setter

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Player getPlayer() {
        return player;
    }

    public CellState getCellState() {
        return cellState;
    }

    //constructor
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState=CellState.EMPTY;
    }
}
