import java.util.List;
import java.util.stream.Collectors;

/**
 * Object representing the test results.
 */
class TestResults {
    public static final String TAG_BEGIN = "<test_results>";
    public static final String TAG_END = "</test_results>";

    private final String value;
    private List<Query> queries;
    private List<Query> failedQueries;

    TestResults(String value) {
        this.value = value;
        queries = Query.parseAll(value);
        failedQueries = queries.stream().filter(q -> q.isFailed()).collect(Collectors.toList());
    }

    static TestResults parse(String dirtyRawString) {
        int beginIndex = dirtyRawString.indexOf(TAG_BEGIN) + TAG_BEGIN.length();
        int endIndex = dirtyRawString.indexOf(TAG_END, beginIndex);
        String value = dirtyRawString.substring(beginIndex, endIndex);
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
