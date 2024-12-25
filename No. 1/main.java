/***
 * This file contains the solution for the first challenge from Advent of Code 2024.
 * It reads in data from a file, splits the data into two separate arrays, sorts the arrays
 * and finds the difference between the two values of the arrays at a given index, then returns
 * the total difference between the two.
 * 
 * This isn't the cleanest-looking solution, but it's quick and dirty one that gets the job done.
 * @author Jared Eller
 * @
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    /***
     * This serves as the body of the program, performing all essential functions as demanded by the problem.
     * @param args unused
     */
    public static void main(String[] args) {
        /*
         * Steps: 
         * 1. Read/clean the data
         * 2. Separate the data into 2 locations
         * 3. Sort the data
         * 4. Find the distance between a given left-list number and a given right-list number
         * 5. Total up the distance
         */

        //initialize a few variables
        ArrayList<Integer> nums = new ArrayList<>();
        int distance = 0;
        
        //read in data, remove whitespace
        try (Scanner fileIn = new Scanner(new File("No. 1\\input.txt"))) {
            while (fileIn.hasNext()) {
                nums.add(Integer.parseInt(fileIn.next()));
            }

            //for every even #, remove from list and add to second list
            int[] leftNums = new int[nums.size() / 2];
            int[] rightNums = new int[nums.size() / 2];

            for (int i = 0; i < nums.size(); i++) {
                if (i % 2 != 0) {
                    //odd-numbered ones go in the right!
                    rightNums[i / 2] = nums.get(i);
                }
                else { //even-numbered ones go in the left!
                    leftNums[i / 2] = nums.get(i);
                }
            }

            //sort the two arrays
            Arrays.sort(leftNums);
            Arrays.sort(rightNums);

            //determine difference, count it up
            for (int i = 0; i < leftNums.length; i++) {
                //absolute value allows you to skip comparing the size of the two nums
                distance += Math.abs((leftNums[i] - rightNums[i]));
            }

            //and here's the total distance
            System.out.println("\nThe total distance for the list is: " + distance);
        }
        //don't want the program crashing in case someone deletes the file
        catch (FileNotFoundException ex) {
            System.out.println ("Error: File not found.");
        }
    }
}