import components.sequence.Sequence;

/**
 * {@code WeightTrackerKernel} enhanced with secondary methods.
 */
public interface WeightTracker extends WeightTrackerKernel {

    /**
     * Replaces the exercise data (data) associated with {@code exercise} in
     * {@code this} with {@code data} and returns the old data.
     *
     * @param exercise
     *            the exercise whose data is to be replaced
     * @param data
     *            the new exercise data (sequence of reps, sets, weight)
     * @return the old exercise data associated with the given exercise
     * @aliases reference {@code data}
     * @updates this
     * @requires exercise is in DOMAIN(this)
     * @ensures <pre>
     * this = (#this \ {(exercise, replaceData)}) union {(exercise, data)}  and
     * (exercise, replaceData) is in #this
     * </pre>
     */
    Sequence<Integer> replaceData(String exercise, Sequence<Integer> data);

    /**
     * Reports the exercise name associated with {@code data} in {@code this}.
     *
     * @param data
     *            the exercise data whose associated exercise name is to be
     *            reported
     * @return the exercise name associated with the data
     * @aliases reference returned by {@code exercise}
     * @requires data is in RANGE(this)
     * @ensures (exercise, data) is in this
     */
    String getExerciseName(Sequence<Integer> data);

    /**
     * Reports whether there is an exercise in {@code this} whose data is
     * {@code data}.
     *
     * @param data
     *            the exercise data to be checked
     * @return true iff there is an exercise in {@code this} whose data is
     *         {@code data}
     * @ensures hasdata = (data is in RANGE(this))
     */
    boolean hasExerciseData(Sequence<Integer> data);

    /**
     * Reports whether {@code this} and {@code otherTracker} have any exercises
     * in common.
     *
     * @param otherTracker
     *            the other weight tracker to be compared
     * @return true iff there are common exercises between {@code this} and
     *         {@code otherTracker}
     * @ensures sharesExerciseWith = (DOMAIN(this) intersection
     *          DOMAIN(otherTracker) /= {})
     */
    boolean sharesExerciseWith(WeightTracker otherTracker);

    /**
     * Combines {@code otherTracker} with {@code this}.
     *
     * @param otherTracker
     *            the weight tracker to be combined with {@code this}
     * @updates this
     * @clears otherTracker
     * @requires DOMAIN(this) intersection DOMAIN(otherTracker) = {}
     * @ensures this = #this union #otherTracker
     */
    void combineWith(WeightTracker otherTracker);
}
