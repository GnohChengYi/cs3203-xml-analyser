class Utils {
    static String getValue(String rawString, String tag) {
        String beginTag = String.format("<%s>", tag);
        String endTag = String.format("</%s>", tag);
        int beginIndex = rawString.indexOf(beginTag) + beginTag.length();
        int endIndex = rawString.indexOf(endTag, beginIndex);
        if (beginIndex == -1 || endIndex == -1) {
            return null;
        }
        return rawString.substring(beginIndex, endIndex);
    }
}