package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerActions {

    // ask user to mark or unmark a cell
    public String[] markOrUnmarkMine(Scanner scanner) {
        String[] coordinates = new String[3];
        boolean isValidInput = false;

        do {
            System.out.println("Set/unset mine marks or claim a cell as free:");
            try {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                String command = scanner.next();
                scanner.nextLine();

                coordinates[0] = String.valueOf(x);
                coordinates[1] = String.valueOf(y);
                coordinates[2] = command;
                isValidInput = true;

            } catch (InputMismatchException e) {
                System.out.printf("%nInvalid input. Please enter valid coordinates and command (x y free/mine).%n%n");
                scanner.nextLine();
            }
        } while (!isValidInput);

        return coordinates;
    }

    // ask for number of mines
    public int askForNumberOfMines(Scanner scanner) {
        int nrOfMines;
        boolean isValidInput = false;

        do {
            System.out.print("How many mines do you want on the field? ");
            try {
                nrOfMines = scanner.nextInt();
                scanner.nextLine();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.printf("%nInvalid input. Please enter a valid number.%n%n");
                scanner.nextLine();
                nrOfMines = -1;
            }
        } while (!isValidInput);

        return nrOfMines;
    }

}
