class Failed {
    public static final String TAG_BEGIN = "<failed>";
    public static final String TAG_END = "</failed>";

    private final String value;

    Failed(String value) {
        this.value = value;
    }

    static Failed parse(String dirtyRawString) {
        int beginIndex = dirtyRawString.indexOf(TAG_BEGIN) + TAG_BEGIN.length();
        int endIndex = dirtyRawString.indexOf(TAG_END, beginIndex);
        if (beginIndex == -1 || endIndex == -1) {
            return null;
        }
        String value = dirtyRawString.substring(beginIndex, endIndex);
        return new Failed(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
