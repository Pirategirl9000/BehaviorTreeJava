package BehaviorTree;

import java.util.ArrayList;

/**
 * Sequence Nodes perform the actions of all their children in order of sequence
 */
public class SequenceNode extends Node {

    /**
     * Adds a child node
     * @param n the node to be added
     */
    public void addChild(Node n) {
        children.add(n);
    }

    /**
     * Performs the action of all child nodes, these can be conditional nodes or more sequence nodes
     */
    @Override
    public void action() {
        for (Node child : children) {
            child.action();
        }
    }
}
