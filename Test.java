import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Read file from arg[0]
        if (args.length == 0) {
            System.out.println("Usage: java Test <file_path>");
            return;
        }
        // Read file
        File file = new File(args[0]);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String infix = scanner.nextLine();
                InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter(infix);
                try {
                    String postfix = infixToPostfixConverter.convert();
                    System.out.println("Infix: " + infix + " | Postfix: " + postfix);
                } catch (InvalidInfixExpressionException exception) {
                    System.out.println("Infix: " + infix + " | Postfix: Invalid");
                }

            }

            scanner.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Invalid File Path, Please try again.");
        }
    }
}
