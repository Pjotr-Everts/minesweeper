package minesweeper;

public class Cell {

    private String visual;
    private final int y;
    private final int x;
    private boolean containsMine;
    private boolean revealed;
    private int helper;

    public Cell(String visual, int y, int x, boolean containsMine, boolean revealed, int helper) {
        this.visual = visual;
        this.y = y;
        this.x = x;
        this.containsMine = containsMine;
        this.revealed = revealed;
        this.helper = helper;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isContainsMine() {
        return containsMine;
    }

    public void setContainsMine(boolean containsMine) {
        this.containsMine = containsMine;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public int getHelper() {
        return helper;
    }

    public void setHelper(int helper) {
        this.helper = helper;
    }

}
