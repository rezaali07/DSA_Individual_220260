package Q2;

import java.util.Arrays;

/*
 * You are given an integer n representing the total number of individuals. Each individual is identified by a unique 
 * ID from 0 to n-1. The individuals have a unique secret that they can share with others.
 * 
 * The secret-sharing process begins with person 0, who initially possesses the secret. Person 0 can share the secret 
 * with any number of individuals simultaneously during specific time intervals. Each time interval is represented by 
 * a tuple (start, end) where start and end are non-negative integers indicating the start and end times of the interval.
 * 
 * You need to determine the set of individuals who will eventually know the secret after all the possible secret-sharing
 * intervals have occurred
*/

//Note : I am assuming that in each interval=(start,end) individuals can share with start-end+1 no of individuals
// and that in every overlapping interval the mutually exclusive time will only be accounted for sharing process
public class SecretSharing {
    int individuals[];
    int intervals[][];

    SecretSharing(int noOfindividuals, int[][] intervalMatrix) {
        individuals = new int[noOfindividuals];
        for (int i = 0; i < noOfindividuals; i++) {
            individuals[i] = i;
        }
        intervals = intervalMatrix;
    }

    int[] startSharing() {
        int secretKnowingIndividuals = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                // Above note condition: if interval overlaps
                if (i > 0 &&
                        intervals[i - 1][intervals[0].length - 1] > intervals[i][j]) {
                    continue;
                }
                // In each interval only end-start+1 individuals will know secret
                secretKnowingIndividuals++;
            }
            // All individuals know the secret
            if (secretKnowingIndividuals >= individuals.length) {
                break;
            }
        }

        // Return an array of secret knowing individuals
        return Arrays.copyOf(individuals, secretKnowingIndividuals);
    }

    public static void main(String[] args) {
        SecretSharing share = new SecretSharing(5, new int[][] { { 0, 1 }, { 1, 3 }, { 2, 4 } });
        int[] secretKnowingIndividuals = share.startSharing();
        for (int i : secretKnowingIndividuals) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}
