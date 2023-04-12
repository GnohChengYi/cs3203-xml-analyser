/**
 * Object representing a query.
 */
class Query {
    public static final String TAG_BEGIN = "<query>";
    public static final String TAG_END = "</query>";
    private final String rawString;

    Query(String rawString) {
        this.rawString = rawString;
    }
}
