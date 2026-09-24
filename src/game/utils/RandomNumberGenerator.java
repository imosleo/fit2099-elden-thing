package game.utils;

/**
 * RandomNumberGenerator provides utility methods for generating random
 * numbers within specified ranges. This class simplifies generating both
 * inclusive and exclusive random numbers for use in the game.
 * <p>
 * It currently offers methods to generate random numbers within a
 * given range and random indices for arrays or lists.
 *
 * @author Nicholas Hiew
 * Modified by: Dylan Matthew Quah Kwang Yung and Nicholas Hiew
 */
public class RandomNumberGenerator {

    /**
     * Generates a random number between the given minimum and maximum
     * values (both inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return a random integer between {@code min} and {@code max}
     */
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min); // min (inclusive) to max (inclusive)
    }

    /**
     * Generates a random index from 0 (inclusive) to the specified maximum value (exclusive).
     *
     * @param max the exclusive upper bound for the random index
     * @return a random integer between 0 (inclusive) and {@code max} (exclusive)
     */
    public static int randomIndex(int max) {
        return ((int) (Math.random() * (max) + 0)); // 0 (inclusive) to max (exclusive)
    }
}
