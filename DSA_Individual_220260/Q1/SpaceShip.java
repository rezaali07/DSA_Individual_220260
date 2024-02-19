package Q1;

/**
 * SpaceShip
 * Given:
 * List of engines to be worked on
 * 1 engineer who can split into 2
 * 1 engineer works on 1 engine
 * splitting has cost associated
 * find minimum time by running thigs parallel
 * 
 */
public class SpaceShip {
    int[] engines;
    int engineerCount = 1;
    int splitCost = 1;

    SpaceShip(int[] engineArray, int noOfengineers) {
        this.engines = engineArray;
        engineerCount = noOfengineers;
    }

    int buildEngines(int engines[], int noOfengineers) {
        if (engines.length <= 1) {
            return 0; // 1 engineer
        }
        int maxEngine = 0;
        for (int i = 0; i < engines.length; i++) {
            if (engines[i] > engines[maxEngine])
                maxEngine = i;
        }

        if (engines[maxEngine] / splitCost < engines.length) {
            return engines[maxEngine] / splitCost;
        }
        // engine>=splitCost*engineerincreased;
        return engines.length - 1;
    }

    public static void main(String[] args) {
        SpaceShip ship = new SpaceShip(new int[] { 1, 2, 3 }, 1);
        for (int engines : ship.engines) {
            System.out.print(engines + "\t");
        }
        System.out.println();
        System.out.println(ship.buildEngines(ship.engines, ship.engineerCount));

    }

}