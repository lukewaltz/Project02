import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            String op1;
            String op;
            String op2;
            String result;
            LinkedList list = new LinkedList();
            while (scan.hasNextLine()) {
                // TODO: Process each line of the input file here.
                op1 = scan.next();
                op = scan.next();
                op2 = scan.next();

                //System.out.println(op1);
                //System.out.println(op2);
                //System.out.println(op);

                switch (op) {
                    case "+" -> {
                        result = list.add(op1, op2);
                        if (scan.hasNextLine()){
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
                        } else{
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result);
                        }
                    }
                    case "*" -> {
                        result = list.multiply(String.valueOf(op1), String.valueOf(op2));
                        if (scan.hasNextLine()){
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
                        } else{
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result);
                        }
                    }
                    case "^" -> {
                        result = list.exponent(String.valueOf(op1), String.valueOf(op2));
                        if (scan.hasNextLine()){
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
                        } else{
                            System.out.print(op1 + ' ' + op + ' ' + op2 + " = " + result);
                        }
                    }
                }

                //String line = scan.nextLine();
                //System.out.println(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}