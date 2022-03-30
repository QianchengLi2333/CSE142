//<Qiancheng Li>
//<11/20/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #7>
//
//This program reads the response of a personality test
//and report the result in an output file.
import java.util.*;
import java.io.*;

public class Personality {
    //Set the size of arrays in this program.
    public static final int DIMENSION = 4;
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        introduction();
        System.out.print("input file name? ");
        String inputFile = console.nextLine();
        System.out.print("output file name? ");
        String outputFile = console.nextLine();
        PrintStream output = new PrintStream(new File(outputFile));
        Scanner input = new Scanner(new File(inputFile));
        while (input.hasNextLine()) {
            processAnswer(input, output);
        }
    }

    //Produce the introduction message.
    public static void introduction() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    //Read the name and response of each user and 
    //produce the report of the personality test in the output file.
    //Parameter:
    //    Scanner input: the scanner to read the input file
    //    PrintStream output: the generated output file 
    public static void processAnswer(Scanner input, PrintStream output) {
        String name = input.nextLine();
        String response = input.nextLine();    
        int[] percentageB = computeAB(response);
        String personality = personalityType(percentageB);
        output.println(name + ": " + Arrays.toString(percentageB) + " = " + personality);
    }

    //Compute the count of A or B and store the result in the array.
    //Return the array that stores the percentage of B.
    //Parameters:
    //    String response: the response, which contains results of A or B, to be read
    public static int[] computeAB(String response) {
        int[] respA = new int[DIMENSION];
        int[] respB = new int[DIMENSION];
        int[] percentageB = new int[DIMENSION];
        response = response.toLowerCase();
        for (int i = 0; i < response.length(); i++) {
            if (response.charAt(i) == 'a') {
                respA[(i % 7 + 1) / 2]++;
            } else if (response.charAt(i) == 'b') {
                respB[(i % 7 + 1) / 2]++;
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            percentageB[i] = calculatePercentage(respA[i], respB[i]);
        }
        return percentageB;
    }

    //Determine the specific personality type.
    //Return the personality type as a string.
    //Parameter:
    //    int[] percentageB: the array that contains the data of A and B
    public static String personalityType (int[] percentageB) {
        String result = "";
        String[] personalityArray = {"E", "I", "S", "N", "T", "F", "J", "P"};
        
        for (int i = 0; i < DIMENSION; i++) {
            if (percentageB[i] > 50) {
                result += personalityArray[i * 2 + 1];
            } else if (percentageB[i] < 50) {
                result += personalityArray[i * 2];
            } else { //percentage[i] = 50
                result += "X";
            }
        }
        return result;
    }

    //Calculate the percentage of a number in a sum.
    //Return the rounded number of the percentage.
    //Parameters:
    //    int num1: the number to be added as a sum
    //    int num2: the number we want to see its percentage in the sum
    public static int calculatePercentage(int num1, int num2) {
        double percentage = num2 * 100.0 / (num1 + num2);
        return (int)Math.round(percentage);
    }
}
