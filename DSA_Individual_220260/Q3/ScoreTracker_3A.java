package Q3;

// a)

// You are developing a student score tracking system that keeps track of scores from different assignments. The
// ScoreTracker class will be used to calculate the median score from the stream of assignment scores. The class
// should have the following methods:
//          ScoreTracker() initializes a new ScoreTracker object.
//          void addScore(double score) adds a new assignment score to the data stream.
//          double getMedianScore() returns the median of all the assignment scores in the data stream. If the number
//         of scores is even, the median should be the average of the two middle scores.

//     Input:
//     ScoreTracker scoreTracker = new ScoreTracker();
//     scoreTracker.addScore(85.5); // Stream: [85.5]
//     scoreTracker.addScore(92.3); // Stream: [85.5, 92.3]
//     scoreTracker.addScore(77.8); // Stream: [85.5, 92.3, 77.8]
//     scoreTracker.addScore(90.1); // Stream: [85.5, 92.3, 77.8, 90.1]
//     double median1 = scoreTracker.getMedianScore(); // Output: 88.9 (average of 90.1 and 85.5)
//     scoreTracker.addScore(81.2); // Stream: [85.5, 92.3, 77.8, 90.1, 81.2]
//     scoreTracker.addScore(88.7); // Stream: [85.5, 92.3, 77.8, 90.1, 81.2, 88.7]
//     double median2 = scoreTracker.getMedianScore(); // Output: 86.95 (average of 88.7 and 85.5)



import java.util.ArrayList;
import java.util.List;

public class ScoreTracker_3A {

    // List to store scores
    List<Double> scores = new ArrayList<>();

    // Method to add a score to the list
    void addScore(Double score) {
        scores.add(score);
    }

    // Method to calculate the median score
    double getMedianScore() {
        // Sort the scores in ascending order
        scores.sort(null);
        switch (scores.size() % 2) {
            // If the number of scores is even
            case 0:
                // Calculate the average of the two middle scores
                return (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2;
            // If the number of scores is odd
            default:
                // Return the middle score
                return scores.get(scores.size() / 2);
        }
    }

    public static void main(String[] args) {
        // Create an instance of ScoreTracker
        ScoreTracker_3A sc = new ScoreTracker_3A();
        // Add some scores
        sc.addScore(85.5);
        sc.addScore(92.3);
        sc.addScore(77.8);
        sc.addScore(90.1);
        // Calculate and print the median score
        double median1 = sc.getMedianScore();
        System.out.println(median1);
        
        // Add more scores
        sc.addScore(81.2);
        sc.addScore(88.7);
        // Calculate and print the median score again
        double median2 = sc.getMedianScore();
        System.out.println(median2);
    }
}
