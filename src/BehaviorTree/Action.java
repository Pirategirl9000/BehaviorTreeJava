package BehaviorTree;

/**
 * Defines an action for an ActionNode
 */
@FunctionalInterface
public interface Action {
    /**
     * Action for the Node to perform
     */
    void execute();
}
