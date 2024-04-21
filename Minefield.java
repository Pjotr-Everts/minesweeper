package minesweeper;
import java.util.Scanner;

public class Minefield {

    Cell[][] minefield;
    Scanner scanner = new Scanner(System.in);

    // fill the minefield array
    public void createMinefield(int rows, int columns) {
        minefield = new Cell[rows][columns];
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                minefield[i][j] = new Cell(".", i, j, false, false, 0);
            }
        }
    }

    // place the mines
    public void placeMines(int nrOfMines) {
        for (int i = 0; i < nrOfMines; i++) {
            int x = CoordinateGenerator.generateCoordinate();
            int y = CoordinateGenerator.generateCoordinate();
            if (!minefield[x][y].isContainsMine()) {
                minefield[x][y].setContainsMine(true);
            } else {
                i--;
            }
        }
    }

    // print the minefield
    public void printMinefield() {
        System.out.println();
        System.out.println(" | 1 2 3 4 5 6 7 8 9 |");
        System.out.println("-|-------------------|");
        for (int i = 0; i < minefield.length; i++) {
            System.out.print(i+1 + "| ");
            for (int j = 0; j < minefield[0].length; j++) {
                System.out.print(minefield[i][j].getVisual() + " ");
            }
            System.out.println("|");
        }
        System.out.println("-|-------------------|");
    }

    // reveal empty cells
    public void revealEmptyCells(int y, int x) {

        if (y < 0 || y >= minefield.length || x < 0 || x >= minefield[0].length) {
            return;
        }

        if (minefield[y][x].isRevealed()) {
            return;
        }

        minefield[y][x].setRevealed(true);

        if (minefield[y][x].getHelper() == 0) {
            minefield[y][x].setVisual("/");
        }
        if (minefield[y][x].getHelper() > 0) {
            String nr = String.valueOf(minefield[y][x].getHelper());
            minefield[y][x].setVisual(nr);
        }

        // if the cell is empty, reveal neighboring cells
        if (minefield[y][x].getHelper() == 0) {
            revealEmptyCells(y - 1, x); // reveal up
            revealEmptyCells(y - 1, x + 1); // reveal up/right
            revealEmptyCells(y, x + 1); // reveal right
            revealEmptyCells(y + 1, x + 1); // reveal down/right
            revealEmptyCells(y + 1, x); // reveal down
            revealEmptyCells(y + 1, x - 1); // reveal down/left
            revealEmptyCells(y, x - 1); // reveal left
            revealEmptyCells(y - 1, x - 1); // reveal left/up
        }
    }

    // visualize all mines
    public void visualizeAllMines() {
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                if (minefield[i][j].isContainsMine()) {
                    minefield[i][j].setVisual("X");
                }
            }
        }
    }

}
