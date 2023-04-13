import java.io.IOException;
import java.util.Scanner;

/**
 * Main driver class.
 */
class Main {
    private static final String STOP_STRING = "STOP";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter xml filepath: ");
        String xmlPath = scanner.nextLine();
        TestResults testResult = Parser.parse(xmlPath);
        Analyser analyser = new Analyser(testResult);
        while (true) {
            System.out.print("Regex for query string: ");
            String queryStrRegex = scanner.nextLine();
            System.out.print("Regex for missing instances: ");
            String missingRegex = scanner.nextLine();
            System.out.print("Regex for additional answers: ");
            String additionalRegex = scanner.nextLine();
            analyser.analyse(queryStrRegex, missingRegex, additionalRegex);
            System.out.printf("input \"%s\" to stop, anything else to continue: ", STOP_STRING);
            String option = scanner.nextLine();
            if (option.equals(STOP_STRING)) {
                break;
            }
        }
        scanner.close();
    }
}
