package Q2;


/*
Question 2 (b)

You are given an integer n representing the total number of individuals. Each individual is identified by a unique
ID from 0 to n-1. The individuals have a unique secret that they can share with others.
The secret-sharing process begins with person 0, who initially possesses the secret. Person 0 can share the secret
with any number of individuals simultaneously during specific time intervals. Each time interval is represented by
a tuple (start, end) where start and end are non-negative integers indicating the start and end times of the interval.
You need to determine the set of individuals who will eventually know the secret after all the possible secretsharing intervals have occurred.
Example:
Input: n = 5, intervals = [(0, 2), (1, 3), (2, 4)], firstPerson = 0
Output: [0, 1, 2, 3, 4]
Explanation:
In this scenario, we have 5 individuals labeled from 0 to 4.
The secret-sharing process starts with person 0, who has the secret at time 0. At time 0, person 0 can share the
secret with any other person. Similarly, at time 1, person 0 can also share the secret. At time 2, person 0 shares the
secret again, and so on.
Given the intervals [(0, 2), (1, 3), (2, 4)], we can observe that during these intervals, person 0 shares the secret with
every other individual at least once.
Hence, after all the secret-sharing intervals, individuals 0, 1, 2, 3, and 4 will eventually know the secret.

*/

import java.util.Arrays;
public class SecretSharing {
    int individuals[]; // Array to store individuals
    int intervals[][]; // 2D array to store intervals

    // Constructor to initialize individuals and intervals
    SecretSharing(int noOfindividuals, int[][] intervalMatrix) {
        individuals = new int[noOfindividuals];
        // Assign unique IDs to individuals
        for (int i = 0; i < noOfindividuals; i++) {
            individuals[i] = i;
        }
        intervals = intervalMatrix; // Initialize intervals
    }

    // Method to determine which individuals know the secret
    int[] startSharing() {
        int secretKnowingIndividuals = 0; // Counter for individuals who know the secret
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                // Condition to check if interval overlaps with previous interval
                if (i > 0 && intervals[i - 1][intervals[0].length - 1] > intervals[i][j]) {
                    continue; // Skip if overlap occurs
                }
                // Increment the count of individuals who know the secret
                secretKnowingIndividuals++;
            }
            // Check if all individuals know the secret
            if (secretKnowingIndividuals >= individuals.length) {
                break; // Exit loop if all individuals know the secret
            }
        }

        // Return an array of secret knowing individuals
        return Arrays.copyOf(individuals, secretKnowingIndividuals);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of SecretSharing with 5 individuals and intervals
        SecretSharing share = new SecretSharing(5, new int[][]{{0, 1}, {1, 3}, {2, 4}});
        // Get the array of individuals who know the secret
        int[] secretKnowingIndividuals = share.startSharing();
        // Print the IDs of individuals who know the secret
        for (int i : secretKnowingIndividuals) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}

//OutPut: 0       1       2       3       4
