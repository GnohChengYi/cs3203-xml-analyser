import java.util.ArrayList;
import java.util.List;

class Analyser {
    private final TestResults testResults;

    Analyser(TestResults testResults) {
        this.testResults = testResults;
    }

    List<String> getMatchingQueries(String queryStrHas, String missingHas, String additionalHas) {
        System.out.printf("analysing: queryStrRegex=%s missingRegex=%s additionalRegex=%s\n\n", queryStrHas,
                missingHas, additionalHas);
        List<Query> failedQueries = testResults.getFailedQueries();
        List<String> ids = new ArrayList<>();
        for (Query query : failedQueries) {
            System.out.println("id: " + query.getId());
            System.out.println("querystr: " + query.getQueryStr());
            System.out.println("missing: " + query.getFailed().getMissing());
            System.out.println("additional: " + query.getFailed().getAdditional());
            if (query.getQueryStr().contains(queryStrHas) && query.getFailed().getMissing().contains(missingHas)
                    && query.getFailed().getAdditional().contains(additionalHas)) {
                ids.add(query.getId());
            }
            System.out.println();
        }
        return ids;
    }
}
