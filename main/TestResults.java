import java.util.List;
import java.util.stream.Collectors;

/**
 * Object representing the test results.
 */
class TestResults {
    public static final String TAG = "test_results";

    private final String value;
    private List<Query> queries;
    private List<Query> failedQueries;

    TestResults(String value) {
        this.value = value;
        queries = Query.parseAll(value);
        failedQueries = queries.stream().filter(q -> q.isFailed()).collect(Collectors.toList());
    }

    static TestResults parse(String dirtyRawString) {
        String value = Utils.getValue(dirtyRawString, TAG);
        if (value == null) {
            return null;
        }
        return new TestResults(value);
    }

    List<Query> getFailedQueries() {
        return failedQueries;
    }

    @Override
    public String toString() {
        return value;
    }
}
