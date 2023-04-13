import java.util.ArrayList;
import java.util.List;

class Analyser {
    private final TestResults testResults;

    Analyser(TestResults testResults) {
        this.testResults = testResults;
    }

    List<String> getMatchingQueries(String queryStrRegex, String missingRegex, String additionalRegex) {
        System.out.printf("analysing: queryStrRegex=%s missingRegex=%s additionalRegex=%s\n\n", queryStrRegex,
                missingRegex,
                additionalRegex);
        List<Query> failedQueries = testResults.getFailedQueries();
        List<String> ids = new ArrayList<>();
        for (Query query : failedQueries) {
            System.out.println("id: " + query.getId());
            System.out.println("querystr: " + query.getQueryStr());
            System.out.println("missing: " + query.getFailed().getMissing());
            System.out.println("additional: " + query.getFailed().getAdditional());
            if (query.getQueryStr().matches(queryStrRegex) && query.getFailed().getMissing().matches(missingRegex)
                    && query.getFailed().getAdditional().matches(additionalRegex)) {
                ids.add(query.getId());
            }
            System.out.println();
        }
        return ids;
    }
}
