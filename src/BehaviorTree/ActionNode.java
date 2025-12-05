package BehaviorTree;


/**
 * An ActionNode performs an action provided by the functional interface (Action) when it is called<br><br>
 *
 * Note that ActionNodes cannot have children, use a SequenceNode to split up behaviors
 */
public class ActionNode extends Node {
    /**
     * Functional interface storing an execute() method which executes dynamic code when called
     */
    private Action action;

    /**
     * Creates a new ActionNode with a set Action
     * @param action functional interface with code to execute when called
     */
    public ActionNode(Action action) {
        this.action = action;  // Action can be a lambda function or a method reference
    }

    /**
     * Performs the action defined by the functional interface
     */
    public void action() {
        action.execute();
    }
}
