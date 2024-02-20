package Q1;


// Question 1 (b)

// You are the captain of a spaceship and you have been assigned a mission to explore a distant galaxy. Your
// spaceship is equipped with a set of engines, where each engine represented by a block. Each engine requires a
// specific amount of time to be built and can only be built by one engineer.
// Your task is to determine the minimum time needed to build all the engines using the available engineers. The
// engineers can either work on building an engine or split into two engineers, with each engineer sharing the
// workload equally. Both decisions incur a time cost.
// The time cost of splitting one engineer into two engineers is given as an integer split. Note that if two engineers
// split at the same time, they split in parallel so the cost would be split.
// Your goal is to calculate the minimum time needed to build all the engines, considering the time cost of splitting
// engineers.
// Input: engines= [1,2,3]
// Split cost (k)=1
// Output: 4
// Example:
// Imagine you need to build engine represented by an array [1,2,3] where ith element of an array i.e a[i] represents
// unit time to build ith engine and the split cost is 1. Initially, there is only one engineer available.
// The optimal strategy is as follows:
// 1. The engineer splits into two engineers, increasing the total count to two. (Split Time: 1) and assign first
// engineer to build third engine i.e. which will take 3 unit of time.
// 2. Again, split second engineer into two (split time :1) and assign them to build first and second engine
// respectively.
// Therefore, the minimum time needed to build all the engines using optimal decisions on splitting engineers and
// assigning them to engines. =1+ max (3, 1 + max (1, 2)) = 4.
// Note: The splitting process occurs in parallel, and the goal is to minimize the total time required to build all the
// engines using the available engineers while considering the time cost of splitting.


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
    /**
     * Main method to test the functionality of calculating the minimum time to repair engines.
     */
    public static void main(String[] args) {
        int[] engines = {1, 2, 3}; // Array representing time required to repair each engine
        int k = 1; // Maximum number of engineers available
        System.out.println(minimumTime(engines, k)); // Output the minimum time to repair all engines
    }

    /**
     * Method to calculate the minimum time required to repair all engines.
     * @param engines Array representing time required to repair each engine
     * @param k Maximum number of engineers available
     * @return Minimum time required to repair all engines
     */
    public static int minimumTime(int[] engines, int k) {
        int maxTime = 0; // Maximum time taken to repair any engine
        int engineers = 1; // Number of engineers currently available

        // Iterate through the engines starting from the last one
        for (int i = engines.length - 1; i >= 0; i--) {
            int time = engines[i]; // Time required to repair current engine

            // Continue until the required number of engineers is available
            while (engineers < time) {
                int splitTime = Math.min(time - engineers, k); // Time taken to repair with available engineers
                engineers += splitTime; // Allocate engineers for repair

                maxTime = Math.max(maxTime, time); // Update maximum time if needed
            }
            engineers--; // Reduce the number of engineers after repair
        }

        return maxTime + 1; // Add 1 to include the time for the last engine repair
    }
}

// OutPut: 4