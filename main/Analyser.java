import java.util.ArrayList;
import java.util.List;

class Analyser {
    private final TestResults testResults;

    Analyser(TestResults testResults) {
        this.testResults = testResults;
    }

    List<String> getMatchingQueries(String queryStrHas, String missingHas, String additionalHas) {
        List<Query> failedQueries = testResults.getFailedQueries();
        List<String> ids = new ArrayList<>();
        for (Query query : failedQueries) {
            if (query.getQueryStr().contains(queryStrHas) && query.getFailed().getMissing().contains(missingHas)
                    && query.getFailed().getAdditional().contains(additionalHas)) {
                ids.add(query.getId());
            }
        }
        return ids;
    }
}
