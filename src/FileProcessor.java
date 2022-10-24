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
            int op1;
            String op;
            int op2;
            String result;
            LinkedList list = new LinkedList();
            while (scan.hasNextLine()) {
                // TODO: Process each line of the input file here.
                op1 = scan.nextInt();
                op = scan.next();
                op2 = scan.nextInt();

                System.out.println(op1);
                System.out.println(op2);
                System.out.println(op);

                switch (op) {
                    case "+" -> {
                        result = list.add(String.valueOf(op1), String.valueOf(op2));
                        System.out.println(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
                    }
                    case "*" -> {
                        result = list.multiply(String.valueOf(op1), String.valueOf(op2));
                        System.out.println(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
                    }
                    case "^" -> {
                        result = list.exponent(String.valueOf(op1), String.valueOf(op2));
                        System.out.println(op1 + ' ' + op + ' ' + op2 + " = " + result + "\n");
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
