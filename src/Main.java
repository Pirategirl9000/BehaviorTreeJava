import BehaviorTree.*;


public class Main {
    public static void main(String[] args) {
        // I will admit this is a horrible way of writing this test-code, but it's just test code anyway
        // Double brace initialization is a terrible way to handle things but for the sake of testing we will use it here
        // In practice you might want to avoid using this and maybe try using a method or just normal setting
        // There is also the potential for an enum to be used with methods to help abstractify this and make it more obvious what each node connects to
        


        SequenceNode root = new SequenceNode();

        // See's player if 60 units or fewer away
        ConditionalNode seesPlayer = new ConditionalNode(
                new Object[] {50},  // Player starts at 50 units away
                arg -> ((Integer) arg[0] <= 60) ? 1 : 0
        ) {{
            // When they see the player
            SequenceNode actionSeePlayer = new SequenceNode() {{
                ActionNode enemyShout = new ActionNode(
                        () -> {
                            System.out.println("Enemy Spotted!!!");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {/* Ignore */}
                        }
                );

                ActionNode runTowardPlayer = new ActionNode(
                        () -> {
                            System.out.println("Runs toward player");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {/* Ignore */}
                        }
                );

                ActionNode attackPlayer = new ActionNode(
                        () -> {
                            System.out.println("Attacking player");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {/* Ignore */}
                        }
                );

                this.addChild(enemyShout);
                this.addChild(runTowardPlayer);
                this.addChild(attackPlayer);
            }};


            // When they don't see the player
            ActionNode actionNoSeePlayer = new ActionNode(
                    () -> System.out.println("Boring job, don't even get to kill anyone...")
            );

            this.addChild(actionNoSeePlayer);
            this.addChild(actionSeePlayer);
        }};

        ActionNode backToBase = new ActionNode(
                () -> System.out.println("Back to base I go")
        );


        root.addChild(seesPlayer);
        root.addChild(backToBase);

        root.action();
    }
}
