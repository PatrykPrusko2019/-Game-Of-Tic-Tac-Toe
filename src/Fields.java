public enum Fields {
    X("SHARP"),
    O("CIRCLE"),
    EMPTY("EMPTY");

    private String value;

     Fields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
