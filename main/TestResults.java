import java.util.ArrayList;
import java.util.List;

/**
 * Object representing the test results.
 */
class TestResults {
    public static final String TAG_BEGIN = "<test_results>";
    public static final String TAG_END = "</test_results>";

    private final String value;
    private List<Query> queries = new ArrayList<>();

    TestResults(String value) {
        this.value = value;
        queries = Query.parseAll(value);
    }

    static TestResults parse(String dirtyRawString) {
        int beginIndex = dirtyRawString.indexOf(TAG_BEGIN) + TAG_BEGIN.length();
        int endIndex = dirtyRawString.indexOf(TAG_END, beginIndex);
        String value = dirtyRawString.substring(beginIndex, endIndex);
        return new TestResults(value);
    }

    List<Query> getQueries() {
        return queries;
    }

    @Override
    public String toString() {
        return value;
    }
}
