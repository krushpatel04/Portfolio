import components.map.Map;
import components.sequence.Sequence;
import components.standard.Standard;

/**
 * WeightTrackerKernel defines the core methods for the weight tracking system.
 * It is modeled as a Map where the key is the exercise name (String) and the
 * value is a sequence containing reps, sets, and weight.
 *
 * @mathmodel type WeightTrackerKernel is modeled by PARTIAL_FUNCTION
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 * @iterator <pre>
 * entries(~this.seen * ~this.unseen) = this  and
 * |~this.seen * ~this.unseen| = |this|
 * </pre>
 */
public interface WeightTrackerKernel
        extends Standard<Map<String, Sequence<Integer>>>,
        Iterable<Map.Pair<String, Sequence<Integer>>> {

    /**
     * Adds the pair (exercise, sequence) to this.
     *
     * @param exercise
     *            the exercise to be added
     * @param data
     *            the associated sequence (reps, sets, weight) to be added
     * @aliases references {@code exercise, data}
     * @updates this
     * @requires exercise is not in DOMAIN(this)
     * @ensures this = #this union {(exercise, data)}
     */
    void add(String exercise, Sequence<Integer> data);

    /**
     * Removes the pair whose first component is {@code exercise} and returns
     * it.
     *
     * @param exercise
     *            the exercise to be removed
     * @return the pair removed
     * @updates this
     * @requires exercise is in DOMAIN(this)
     * @ensures <pre>
     * remove.exercise = exercise  and
     * remove is in #this  and
     * this = #this \ {remove}
     * </pre>
     */
    Map.Pair<String, Sequence<Integer>> remove(String exercise);

    /**
     * Removes and returns an arbitrary pair from {@code this}.
     *
     * @return the pair removed from {@code this}
     * @updates this
     * @requires |this| > 0
     * @ensures <pre>
     * removeAny is in #this and
     * this = #this \ {removeAny}
     * </pre>
     */
    Map.Pair<String, Sequence<Integer>> removeAny();

    /**
     * Reports the sequence associated with {@code exercise} in {@code this}.
     *
     * @param exercise
     *            the exercise whose associated data is to be reported
     * @return the sequence (reps, sets, weight) associated with exercise
     * @aliases reference returned by {@code data}
     * @requires exercise is in DOMAIN(this)
     * @ensures (exercise, data) is in this
     */
    Sequence<Integer> value(String exercise);

    /**
     * Reports whether there is a pair in {@code this} whose first component is
     * {@code exercise}.
     *
     * @param exercise
     *            the exercise to be checked
     * @return true iff there is a pair in this whose first component is
     *         {@code exercise}
     * @ensures hasExercise = (exercise is in DOMAIN(this))
     */
    boolean hasExercise(String exercise);

    /**
     * Reports size of {@code this}.
     *
     * @return the number of pairs in {@code this}
     * @ensures size = |this|
     */
    int size();
}
