class Failed {
    public static final String TAG = "failed";

    private final String value;

    Failed(String value) {
        this.value = value;
    }

    static Failed parse(String dirtyRawString) {
        String value = Utils.getValue(dirtyRawString, TAG);
        if (value == null) {
            return null;
        }
        return new Failed(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
