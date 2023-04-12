class Analyser {
    private final TestResults testResults;

    Analyser(TestResults testResults) {
        this.testResults = testResults;
    }

    int getFailedCount() {
        int count = 0;
        for (Query query : testResults.getQueries()) {
            if (query.isFailed()) {
                count += 1;
            }
        }
        return count;
    }
}
