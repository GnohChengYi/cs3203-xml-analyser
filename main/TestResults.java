/**
 * Object representing the test results.
 */
class TestResults {
    public static final String TAG_START = "<test_results>";
    public static final String TAG_END = "</test_results>";

    String rawRepresentation;

    TestResults(String rawRepresentation) {
        this.rawRepresentation = rawRepresentation;
    }

    @Override
    public String toString() {
        return this.rawRepresentation;
    }
}
