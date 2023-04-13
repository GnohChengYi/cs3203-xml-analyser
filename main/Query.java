import java.util.ArrayList;
import java.util.List;

/**
 * Object representing a query.
 */
class Query {
    public static final String TAG_BEGIN = "<query>";
    public static final String TAG_END = "</query>";
    public static final String TAG_BEGIN_MULT = "<queries>";
    public static final String TAG_END_MULT = "</queries>";
    public static final String TAG_ID = "id";
    public static final String TAG_QUERY_STR = "querystr";

    private final String value;
    private Failed failed = null;
    private String id = "";
    private String queryStr = "";

    Query(String value) {
        this.value = value;
        init();
    }

    static List<Query> parseAll(String dirtyRawString) {
        List<Query> queries = new ArrayList<>();
        int fromIndex = 0;
        while (fromIndex < dirtyRawString.length() && fromIndex >= 0) {
            Query query = Query.parse(dirtyRawString, fromIndex);
            if (query == null) {
                break;
            }
            queries.add(query);
            fromIndex = dirtyRawString.indexOf(TAG_BEGIN, fromIndex + 1);
        }
        return queries;
    }

    static Query parse(String dirtyRawString, int fromIndex) {
        int beginIndex = dirtyRawString.indexOf(Query.TAG_BEGIN, fromIndex) + Query.TAG_BEGIN.length();
        int endIndex = dirtyRawString.indexOf(Query.TAG_END, fromIndex);
        if (beginIndex == -1 || endIndex == -1) {
            return null;
        }
        String value = dirtyRawString.substring(beginIndex, endIndex);
        return new Query(value);
    }

    String getValue() {
        return value;
    }

    Failed getFailed() {
        return failed;
    }

    boolean isFailed() {
        return failed != null;
    }

    String getId() {
        return id;
    }

    String getQueryStr() {
        return queryStr;
    }

    private void init() {
        failed = Failed.parse(value);
        id = Utils.getValueFlexible(value, TAG_ID);
        queryStr = Utils.getValue(value, TAG_QUERY_STR);
    }

    @Override
    public String toString() {
        return value;
    }
}
