import java.io.IOException;
import java.util.List;
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
            System.out.print("Query string must have: ");
            String queryStrHas = scanner.nextLine();
            System.out.print("Missing instances must have: ");
            String missingHas = scanner.nextLine();
            System.out.print("Additional answers must have: ");
            String additionalHas = scanner.nextLine();
            List<String> ids = analyser.getMatchingQueries(queryStrHas, missingHas, additionalHas);
            System.out.println(ids);
            System.out.printf("input \"%s\" to stop, anything else to continue: ", STOP_STRING);
            String option = scanner.nextLine();
            if (option.equals(STOP_STRING)) {
                break;
            }
        }
        scanner.close();
    }
}
