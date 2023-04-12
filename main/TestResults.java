import java.util.ArrayList;
import java.util.List;

/**
 * Object representing the test results.
 */
class TestResults {
    public static final String TAG_BEGIN = "<test_results>";
    public static final String TAG_END = "</test_results>";
    private static final String tagQueriesBegin = "<queries>";
    private static final String tagQueriesEnd = "</queries>";

    private final String rawString;
    private final List<Query> queries = new ArrayList<>();

    TestResults(String rawRepresentation) {
        this.rawString = rawRepresentation;
        System.out.println(rawString);
        extractQueries();
    }

    private void extractQueries() {
        int beginIndex = rawString.indexOf(tagQueriesBegin);
        int endIndex = rawString.indexOf(tagQueriesEnd) + tagQueriesEnd.length();
        String queriesRaw = rawString.substring(beginIndex, endIndex);
        int fromIndex = 0;
        while (fromIndex < queriesRaw.length()) {
            int queryBeginIndex = queriesRaw.indexOf(Query.TAG_BEGIN, fromIndex);
            int queryEndIndex = queriesRaw.indexOf(Query.TAG_END, fromIndex) + Query.TAG_END.length();
            if (queryBeginIndex == -1 || queryEndIndex == -1) {
                break;
            }
            Query query = new Query(queriesRaw.substring(queryBeginIndex, queryEndIndex));
            queries.add(query);
            fromIndex = queryEndIndex;
        }
        System.out.println(queries.size());
    }

    @Override
    public String toString() {
        return this.rawString;
    }
}
