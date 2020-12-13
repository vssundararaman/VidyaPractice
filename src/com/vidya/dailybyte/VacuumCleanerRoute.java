package com.vidya.dailybyte;

/**
 * This question is asked by Amazon.
 * Given a string representing the sequence of moves a robot vacuum makes, return whether or not it will return to its original position.
 * The string will only contain L, R, U, and D characters, representing left, right, up, and down respectively.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * "LR", return true
 * "URURD", return false
 * "RUULLDRD", return true
 *
 *
 * Time Complexity: O(N)O(N), where NN is the length of moves. We iterate through the string.
 *
 * Space Complexity: O(1)O(1). In Java, our character array is O(N)O(N).
 */
public class VacuumCleanerRoute {

    public static void main(String[] args) {

        String str = "LR";
        System.out.println(isReturnToOriginal(str));

        str = "URURD";
        System.out.println(isReturnToOriginal(str));

        str = "RUULLDRD";
        System.out.println(isReturnToOriginal(str));

    }

    static boolean isReturnToOriginal(String moves) {

        int UD = 0;
        int LR = 0;

        for (int i = 0; i < moves.length(); i++) {

            char currentChar = moves.charAt(i);

            if (currentChar == 'U') {
                UD++;
            } else if (currentChar == 'D') {
                UD--;
            } else if (currentChar == 'L') {
                LR++;
            } else if (currentChar == 'R') {
                LR--;
            }
        }

        return UD == 0 && LR == 0;
    }
}
