package enums;

public enum MainAccountType {
    REGULAR(1, "Regular"),
    FOREIGNCURRENCY(2, "Foreign Currency"),
    GOLD(3, "Gold"),
    INVESTMENT(4, "Investment");


    private final int value;
    private final String name;

    MainAccountType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    
    public static String getNameByValue(int value) {
        for (MainAccountType type : MainAccountType.values()) {
            if (type.getValue() == value) {
                return type.getName();
            }
        }
        throw new IllegalArgumentException("Invalid MainAccountType value: " + value);
    }
}