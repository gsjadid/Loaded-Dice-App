package Practice;

public class LoadedDice {
    // Method to roll the loaded dice
    public static int rollLoadedDice() {
        double r = Math.random(); // Random number between 0.0 and 1.0

        if (r < 1.0 / 8.0) return 1;
        else if (r < 2.0 / 8.0) return 2;
        else if (r < 3.0 / 8.0) return 3;
        else if (r < 4.0 / 8.0) return 4;
        else if (r < 5.0 / 8.0) return 5;
        else return 6; // Probability of 6 is 3/8
    }
}
