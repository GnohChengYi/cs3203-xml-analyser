import java.io.IOException;
import java.util.Scanner;

/**
 * Main driver class.
 */
class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter xml filepath: ");
        String xmlPath = scanner.nextLine();
        scanner.close();
        TestResults testResult = Parser.parse(xmlPath);
        System.out.println(testResult);
    }
}
