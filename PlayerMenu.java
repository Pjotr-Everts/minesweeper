package minesweeper;
import java.util.Scanner;

public class PlayerMenu {

    static int nrOfMarks = 0;
    static int nrOfCorrectMarks = 0;
    static int nrOfMines;
    static boolean withSpaces = false;

    public void mainMenu() {

        // create instances of classes
        Minefield field = new Minefield();
        PlayerActions actions = new PlayerActions();
        Scanner scanner = new Scanner(System.in);
        Marker marker = new Marker();

        // create the minefield
        field.createMinefield(9, 9);

        // ask for number of mines and show user the starting field
        nrOfMines = actions.askForNumberOfMines(scanner);
        field.placeMines(nrOfMines);
        marker.checkAndPlaceNumbers(field.minefield);
        field.printMinefield();

        // main part of the menu which asks to add/remove marks
        while (nrOfCorrectMarks != nrOfMines && nrOfMarks != nrOfMines) {

            String[] x_y_command = actions.markOrUnmarkMine(scanner);
            int x = Integer.parseInt(x_y_command[0]);
            int y = Integer.parseInt(x_y_command[1]);
            String command = x_y_command[2];

            if (command.equals("free") && field.minefield[y][x].isContainsMine()) {
                field.visualizeAllMines();
                field.printMinefield();
                System.out.println("You stepped on a mine and failed!");
                System.exit(0);
            } else if (command.equals("free") && field.minefield[y][x].getHelper() == 0) {
                field.revealEmptyCells(y, x);
                field.printMinefield();
            } else if (command.equals("free") && field.minefield[y][x].getHelper() > 0) {
                String nr = String.valueOf(field.minefield[y][x].getHelper());
                field.minefield[y][x].setVisual(nr);
                field.printMinefield();
            } else if (command.equals("mine") && field.minefield[y][x].isContainsMine()) {
                if (field.minefield[y][x].getVisual().equals("*")) {
                    field.minefield[y][x].setVisual(".");
                    nrOfMarks--;
                    nrOfCorrectMarks--;
                    field.printMinefield();
                } else {
                    field.minefield[y][x].setVisual("*");
                    nrOfMarks++;
                    nrOfCorrectMarks++;
                    field.printMinefield();
                }
            } else if (command.equals("mine") && !field.minefield[y][x].isContainsMine()) {
                if (field.minefield[y][x].getVisual().equals("*")) {
                    field.minefield[y][x].setVisual(".");
                    nrOfMarks--;
                    field.printMinefield();
                } else {
                    field.minefield[y][x].setVisual("*");
                    nrOfMarks++;
                    field.printMinefield();
                }
            }

        }

        System.out.println("Congratulations! You found all the mines!");
        scanner.close();

    }
}