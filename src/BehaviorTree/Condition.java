package BehaviorTree;

/**
 * Defines a condition for a ConditionalNode
 */
public interface Condition {
    /**
     * The condition to be evaluated
     * @param args arguments used in your condition
     * @return index for the child Node you want to execute
     */
    int evaluate(Object... args);
}
