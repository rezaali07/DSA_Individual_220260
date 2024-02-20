package Q2;
// a)
// You are the manager of a clothing manufacturing factory with a production line of super sewing machines. The
// production line consists of n super sewing machines placed in a line. Initially, each sewing machine has a certain
// number of dresses or is empty.
// For each move, you can select any m (1 <= m <= n) consecutive sewing machines on the production line and pass
// one dress from each selected sewing machine to its adjacent sewing machine simultaneously.
// Your goal is to equalize the number of dresses in all the sewing machines on the production line. You need to
// determine the minimum number of moves required to achieve this goal. If it is not possible to equalize the number
// of dresses, return -1.
// Input: [2, 1, 3, 0, 2]
// Output: 5



public class SuperSewingMachines {
    int dresses[]; // Array to store the number of dresses in each sewing machine
    final int noOfSewingMachines; // Number of sewing machines
    final int totalDressCount, idealDressCount; // Total dress count and ideal dress count per machine
    final boolean isEquilizable; // Flag indicating if the dresses can be equalized

    // Constructor to initialize sewing machines and calculate properties
    SuperSewingMachines(int[] dresses) {
        this.dresses = dresses;
        noOfSewingMachines = dresses.length;
        // Check if dresses can be equally distributed
        int[] totalCount_solvable = checkEquilizabililty();
        // Determine if dresses can be equally distributed
        isEquilizable = totalCount_solvable[1] == 1 ? true : false;
        // Total dress count
        totalDressCount = totalCount_solvable[0];
        // Ideal dress count per machine
        idealDressCount = totalDressCount / noOfSewingMachines;
    }

    // Method to check if dresses can be equally distributed
    int[] checkEquilizabililty() {
        // Calculate total dress count
        int totalDresses = 0;
        for (int sewingMachine = 0; sewingMachine < noOfSewingMachines; sewingMachine++) {
            totalDresses += dresses[sewingMachine];
        }
        // If total dress count is divisible by the number of machines, return true, otherwise false
        if (totalDresses % noOfSewingMachines == 0) {
            return new int[] { totalDresses, 1 }; // Dresses can be equally distributed
        }
        return new int[] { totalDresses, 0 }; // Dresses cannot be equally distributed
    }

    // Method to find the sewing machine with the minimum and maximum number of dresses
    int[] minDress_maxDress() {
        int min = 0; // Index of machine with minimum dresses
        int max = 0; // Index of machine with maximum dresses
        for (int sewingMachine = 1; sewingMachine < noOfSewingMachines; sewingMachine++) {
            if (dresses[sewingMachine] < dresses[min]) {
                min = sewingMachine; // Update min index
            }
            if (dresses[sewingMachine] > dresses[max]) {
                max = sewingMachine; // Update max index
            }
        }
        return new int[] { min, max }; // Return indices of min and max machines
    }

    // Method to check if all machines have ideal dress count
    boolean ifEqualized() {
        for (int sewingMachine = 1; sewingMachine < noOfSewingMachines; sewingMachine++) {
            if (dresses[sewingMachine] != idealDressCount) {
                return false; // Return false if any machine doesn't have ideal dress count
            }
        }
        return true; // Return true if all machines have ideal dress count
    }

    // Method to equalize dresses among machines
    int equalize() {
        if (!isEquilizable) {
            return -1; // If dresses cannot be equally distributed, return -1
        }
        int moveCounter = 0; // Counter for moves to equalize dresses
        // Loop until dresses are equalized
        while (!ifEqualized()) {
            int[] min_max = minDress_maxDress(); // Get indices of min and max machines
            // If max machine has more dresses than ideal, redistribute dresses
            if (dresses[min_max[1]] - dresses[min_max[0]] > 0) {
                while (dresses[min_max[1]] != idealDressCount && dresses[min_max[0]] != idealDressCount) {
                    for (int i = min_max[1]; i > min_max[0]; i--) {
                        dresses[i]--; // Decrease dresses in max machine
                        dresses[i - 1]++; // Increase dresses in adjacent machine
                    }
                    moveCounter++; // Increment move counter
                }
            }
            // If min machine has fewer dresses than ideal, redistribute dresses
            else if (dresses[min_max[1]] - dresses[min_max[0]] < 0) {
                while (dresses[min_max[1]] != idealDressCount && dresses[min_max[0]] != idealDressCount) {
                    for (int i = min_max[1]; i < min_max[0]; i++) {
                        dresses[i]++; // Increase dresses in min machine
                        dresses[i + 1]--; // Decrease dresses in adjacent machine
                    }
                    moveCounter++; // Increment move counter
                }
            } else {
                return moveCounter; // Return move counter if dresses are equalized
            }
        }
        return moveCounter; // Return move counter after equalization
    }

    // Method to print the number of dresses in each machine
    void printer() {
        System.out.println();
        for (int sewingMachine = 0; sewingMachine < noOfSewingMachines; sewingMachine++) {
            System.out.print(dresses[sewingMachine] + "\t");
        }
        System.out.println();
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        SuperSewingMachines sp = new SuperSewingMachines(new int[]{2, 1, 3, 0, 2});
        System.out.println("Number of sewing machines:"+sp.noOfSewingMachines); 
        System.out.println("Number of moves required for equalization:"+sp.equalize()); 
        sp.printer(); // Print final distribution of dresses
    }
}

// OutPut:
// Number of sewing machines:5
// Number of moves required for equalization-1

// 2       1       3       0       2
