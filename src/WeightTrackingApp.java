import java.util.Scanner;

import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * WeightTrackingApp stores exercises with reps, sets, and weight data.
 */
public class WeightTrackingApp {
    // Map where the key is the exercise name and the value is a sequence of reps, sets, weight
    private Map<String, Sequence<Integer>> exerciseData;

    /**
     * Constructor for WeightTrackingApp.
     */
    public WeightTrackingApp() {
        this.exerciseData = new Map1L<>();
    }

    /**
     * Adds or updates exercise data in the map.
     */
    public void addExercise(String exercise, int reps, int sets, int weight) {
        Sequence<Integer> exerciseStats = new Sequence1L<>();
        exerciseStats.add(0, reps); // Add reps at position 0
        exerciseStats.add(1, sets); // Add sets at position 1
        exerciseStats.add(2, weight); // Add weight at position 2
        this.exerciseData.add(exercise, exerciseStats); // Add to the map
    }

    /**
     * Prints all stored exercise data.
     */
    public void printAllExercises() {
        SimpleWriter out = new SimpleWriter1L();
        for (Map.Pair<String, Sequence<Integer>> pair : this.exerciseData) {
            String exercise = pair.key();
            Sequence<Integer> stats = pair.value();
            out.println(exercise + ": Reps=" + stats.entry(0) + ", Sets="
                    + stats.entry(1) + ", Weight=" + stats.entry(2) + " lbs");
        }
        out.close();
    }

    /**
     * Main method to demonstrate usage.
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        Scanner in = new Scanner(System.in);
        WeightTrackingApp app = new WeightTrackingApp();

        // Example usage
        out.print("Enter exercise name: ");
        String exercise = in.nextLine();
        out.print("Enter reps: ");
        int reps = in.nextInt();
        out.print("Enter sets: ");
        int sets = in.nextInt();
        out.print("Enter weight: ");
        int weight = in.nextInt();

        // Add exercise data
        app.addExercise(exercise, reps, sets, weight);

        // Print all exercises
        app.printAllExercises();
    }
}
