package minesweeper;
import java.util.Random;

public class CoordinateGenerator {

    // generate a number between 1 and 9
    public static int generateCoordinate() {
        int min = 0;
        int max = 8;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
