import java.util.Objects;

import components.map.Map;
import components.sequence.Sequence;

public abstract class WeightTrackerSecondary extends Object
        implements WeightTracker {

    @Override
    public Sequence<Integer> replaceData(String exercise,
            Sequence<Integer> data) {
        assert exercise != null : "Violation of: exercise is not null";
        assert data != null : "Violation of: data is not null";
        assert this.hasExercise(
                exercise) : "Violation of: exercise is in DOMAIN(this)";

        // Use remove to get the old data, then add the new data
        Sequence<Integer> oldData = this.getData(exercise);
        this.remove(exercise);
        this.add(exercise, data);

        return oldData;
    }

    @Override
    public String getExerciseName(Sequence<Integer> data) {
        assert data != null : "Violation of: data is not null";

        // Iterate over all exercises to find the matching data
        for (Map.Pair<String, Sequence<Integer>> entry : this) {
            if (Objects.equals(entry.value(), data)) {
                return entry.key();
            }
        }
        return null; // Should not reach here if precondition is met
    }

    @Override
    public boolean hasExerciseData(Sequence<Integer> data) {
        assert data != null : "Violation of: data is not null";

        // Check if there is an exercise in this whose data matches
        for (Map.Pair<String, Sequence<Integer>> entry : this) {
            if (Objects.equals(entry.value(), data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sharesExerciseWith(WeightTracker otherTracker) {
        assert otherTracker != null : "Violation of: otherTracker is not null";

        // Check for common exercises using hasExercise
        for (Map.Pair<String, Sequence<Integer>> entry : this) {
            if (otherTracker.hasExercise(entry.key())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void combineWith(WeightTracker otherTracker) {
        assert otherTracker != null : "Violation of: otherTracker is not null";
        assert !this.sharesExerciseWith(
                otherTracker) : "Violation of: DOMAIN(this) intersection DOMAIN(otherTracker) = {}";

        // Use add to combine all exercises from otherTracker into this
        for (Map.Pair<String, Sequence<Integer>> entry : otherTracker) {
            this.add(entry.key(), entry.value());
        }

        // Clear otherTracker
        otherTracker.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeightTracker)) {
            return false;
        }
        WeightTracker other = (WeightTracker) obj;

        // Check if both have the same number of exercises
        if (this.size() != other.size()) {
            return false;
        }

        // Iterate through all exercises and compare the data
        for (Map.Pair<String, Sequence<Integer>> exercise : this) {
            if (!other.hasExercise(exercise.key())) {
                return false;
            }
            Sequence<Integer> thisData = this.getData(exercise.key());
            Sequence<Integer> otherData = other.getData(exercise.key());
            if (!Objects.equals(thisData, otherData)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;

        for (Map.Pair<String, Sequence<Integer>> exercise : this) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(exercise).append(": ")
                    .append(this.getData(exercise.key()));
            first = false;
        }

        sb.append("}");
        return sb.toString();
    }
}
