package enums;

public enum GoldAccountType {
    WITHOUT_INTEREST(1, "Gold Account (XAU) without Interest"),
    WITH_INTEREST(2, "Gold Account (XAU) with Interest");

    private final int value;
    private final String name;

    GoldAccountType(int value, String name) {
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
        for (GoldAccountType type : GoldAccountType.values()) {
            if (type.getValue() == value) {
                return type.getName();
            }
        }
        throw new IllegalArgumentException("Invalid GoldAccountType value: " + value);
    }
}
