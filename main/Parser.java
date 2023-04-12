import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Parser of xml files.
 */
class Parser {
    static TestResults parse(String xmlPath) throws IOException {
        String content = Files.readString(Path.of(xmlPath));
        TestResults testResults = TestResults.parse(content);
        return testResults;
    }
}
