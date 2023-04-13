class Failed {
    public static final String TAG = "failed";
    public static final String TAG_MISSING = "missing";
    public static final String TAG_ADDITIONAL = "additional";

    private final String value;
    private String missing = "";
    private String additional = "";

    Failed(String value) {
        this.value = value;
        missing = Utils.getValue(value, TAG_MISSING);
        additional = Utils.getValue(value, TAG_ADDITIONAL);
    }

    static Failed parse(String dirtyRawString) {
        String value = Utils.getValue(dirtyRawString, TAG);
        if (value == null) {
            return null;
        }
        return new Failed(value);
    }

    String getMissing() {
        return missing;
    }

    String getAdditional() {
        return additional;
    }

    @Override
    public String toString() {
        return value;
    }
}
