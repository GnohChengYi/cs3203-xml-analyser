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
        Analyser analyser = new Analyser(testResult);
        System.out.println(testResult.getQueries());
        System.out.println(analyser.getFailedCount());
    }
}
