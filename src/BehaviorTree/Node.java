package BehaviorTree;


import java.util.ArrayList;

public abstract class Node {
    /**
     * Child nodes of this node
     */
    public ArrayList<Node> children = new ArrayList<Node>();

    /**
     * A small description of what this node does
     */
    private String description;  // Serves as a debug tool

    /**
     * Sets the description of the node
     * @param description Short string describing the node
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description for this node
     * @return short description of this node
     */
    public String getDescription() {
        return description;
    }

    /**
     * Action to be performed by the node<br><br>
     *
     * Conditional Nodes will evaluate conditions and execute based on a boolean expression<br>
     * Sequence Nodes will perform the actions of all their children<br>
     * Action Nodes will perform some code action
     */
    public abstract void action();

    /**
     * Override the string parser so it returns the description helping with debugging
     * @return the description of the node if set
     */
    @Override
    public String toString() {
        if (description == null) {
            return "No Description for this node has been set";
        }

        return description;
    }
}
