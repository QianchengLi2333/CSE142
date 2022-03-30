//<Qiancheng Li>
//<11/14/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #6>
//
//This program follows the feature of YazLang 
//programming language. It will interpret the 
//input file and make an output file with interpreted
//results.
import java.util.*;
import java.io.*;

public class YazInterpreter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        welcomMessage();
        String response = "";
        while (!response.equals("q")) {
            System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
            response = console.nextLine();
            response = response.toLowerCase();
            if (response.equals("i")) {
                interpret(console);
            } else if (response.equals("v")) {
                view(console);
            }
        }    
    }

    //Produce the welcom message.
    public static void welcomMessage() {
        System.out.println("Welcome to YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a file or view a previously");
        System.out.println("interpreted YazLang program.");
        System.out.println();
    }

    //Interpret the input file and output a file according to the commands.
    //Parameter:
    //    Scanner console: the scnanner to read user input
    public static void interpret(Scanner console) throws FileNotFoundException {    
        Scanner input = fileCheck(console);
        System.out.print("Output file name: ");
        String outputName = console.nextLine();
        File outputFile = new File(outputName);
        PrintStream output = new PrintStream(outputFile);       
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String command = lineScan.next();
            if (command.equals("CONVERT")) {
                convert(lineScan, output);
            } else if (command.equals("RANGE")) {
                range(lineScan, output);
            } else {
                repeat(lineScan, output);
            }
        }
        System.out.println("YazLang interpreted and output to a file!");
        System.out.println();
    }

    //Covert the Celcius degree to Fahrenheit degree, and vice versa
    //Parameters:
    //    Scanner lineScan: the scanner to read lines in the file
    //    PrintStream output: print the content to the output file
    public static void convert(Scanner lineScan, PrintStream output) {
        int value = lineScan.nextInt();
        String type = lineScan.next();
        if (type.equals("C")) {
            value = (int)(1.8 * value + 32);
            output.println(value + "F");
        } else {
            value = (int)((value - 32) / 1.8);
            output.println(value + "C");
        }
    }

    //Produce a sequence of arithmetic progression.
    //Parameters:
    //    Scanner lineScan: the scanner to read lines in the file
    //    PrintStream output: print the content to the output file
    public static void range(Scanner lineScan, PrintStream output) {
        int start = lineScan.nextInt();
        int end = lineScan.nextInt();
        int difference = lineScan.nextInt();
        while (start < end) {
            output.print(start + " ");
            start += difference;
        }
        output.println();
    }

    //Repeat the given content for certain times.
    //Parameters:
    //    Scanner lineScan: the scanner to read lines in the file
    //    PrintStream output: print the content to the output file
    public static void repeat(Scanner lineScan, PrintStream output) {
        while (lineScan.hasNext()) {
            String object = lineScan.next();
            object = object.substring(1, object.length() - 1);
            object = object.replace("_", " ");
            int times = lineScan.nextInt();
            for (int repeat = 0; repeat < times; repeat++) {
                output.print(object);
            }
        }
        output.println();
    }

    //View the input file.
    //Parameter:
    //    Scanner console: the scanner to read user input
    public static void view(Scanner console) throws FileNotFoundException {
        Scanner input = fileCheck(console);
        System.out.println();
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        System.out.println();
    }

    //Ask for the file name and check if the file exists.
    //Return the scanner to read the file.
    //Parameter: 
    //    Scanner console: the scanner to read user input
    public static Scanner fileCheck(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        String fileName = console.nextLine();
        File f = new File(fileName);
        while (!f.canRead()) {
            System.out.print("File not found. Try again: ");
            fileName = console.nextLine();
            f = new File(fileName);
        }
        Scanner input = new Scanner(f);
        return input;
    }
}
