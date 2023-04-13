class Analyser {
    private final TestResults testResults;

    Analyser(TestResults testResults) {
        this.testResults = testResults;
    }

    void analyse(String queryStrRegex, String missingRegex, String additionalRegex) {
        System.out.printf("analysing: queryStrRegex=%s missingRegex=%s additionalRegex=%s\n\n", queryStrRegex, missingRegex,
                additionalRegex);
    }
}
