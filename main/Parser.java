import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Parser of xml files.
 */
class Parser {
    static TestResults parse(String xmlPath) throws IOException {
        String content = Files.readString(Path.of(xmlPath));
        int startIndex = content.indexOf(TestResults.TAG_START);
        int endIndex = content.indexOf(TestResults.TAG_END) + TestResults.TAG_END.length();
        String rawTestResults = content.substring(startIndex, endIndex);
        return new TestResults(rawTestResults);
    }
}
