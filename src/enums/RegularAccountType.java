package enums;

public enum RegularAccountType {
    WITHOUT_INTEREST(1, "Regular Account (TRY) without Interest"),
    WITH_INTEREST(2, "Regular Account (TRY) with Interest");

    private final int value;
    private final String name;

    RegularAccountType(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public boolean isValue(int num) {
        for (GoldAccountType type : GoldAccountType.values()) {
            if (type.getValue() == num) {
                return true;
            }
        }
        return false;
    }
    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getNameByValue(int value) {
        for (RegularAccountType type : RegularAccountType.values()) {
            if (type.getValue() == value) {
                return type.getName();
            }
        }
        throw new IllegalArgumentException("Invalid RegularAccountType value: " + value);
    }
}
