package BehaviorTree;

import java.util.ArrayList;

/**
 * A Node with a set condtion and state. The state is used to evaluate the condition and figure out which child to call
 */
public class ConditionalNode extends Node {

    /**
     * The condition to be evaluated when deciding which leaf to traverse down
     */
    private Condition condition;

    /**
     * The relevant states of the condition, update this when conditions change so the condition is properly evaluated
     */
    private Object[] state;

    /**
     * Creates a new Conditional Node with a set condition and state
     *
     * @param state Initial state of the Node which is used for condition evaluation
     * @param condition Condition to evaluate when deciding which leaf node to pursue, ensure this has the same number of arguments as your state
     */
    public ConditionalNode(Object[] state, Condition condition) {
        this.condition = condition;
        this.state = state;
    }

    /**
     * Adds a child node
     * @param n the node to be added
     */
    public void addChild(Node n) {
        children.add(n);
    }

    /**
     * returns the child at the index
     * @param i the index of the child
     * @return Node reference to the child
     */
    public Node getChild(int i) {
        return children.get(i);
    }

    /**
     * Returns the current state of the Node
     * @return the array of arguments used for the condition check
     */
    public Object[] getState() {
        return state;
    }

    /**
     * Sets the state of the Node
     * @param state the array of arguments used for the condition check
     */
    public void setState(Object[] state) {
        this.state = state;
    }

    /**
     * Evaluates the condition then executes the node whose index is returned by the condition
     */
    @Override
    public void action() {
        children.get(condition.evaluate(state)).action();
    }
}
