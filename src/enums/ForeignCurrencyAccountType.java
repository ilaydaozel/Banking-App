package enums;

public enum ForeignCurrencyAccountType {
    EUR_WITHOUT_INTEREST(1, "Foreign Currency Account (EUR) without Interest"),
    EUR_WITH_INTEREST(2, "Foreign Currency Account (EUR) with Interest"),
    USD_WITHOUT_INTEREST(3, "Foreign Currency Account (USD) without Interest"),
    USD_WITH_INTEREST(4, "Foreign Currency Account (USD) with Interest");

    private final int value;
    private final String name;

    ForeignCurrencyAccountType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    public static boolean isValue(int num) {
        for (ForeignCurrencyAccountType type : ForeignCurrencyAccountType.values()) {
            if (type.getValue() == num) {
                return true;
            }
        }
        return false;
    }

    public static String getNameByValue(int value) {
        for (ForeignCurrencyAccountType type : ForeignCurrencyAccountType.values()) {
            if (type.getValue() == value) {
                return type.getName();
            }
        }
        throw new IllegalArgumentException("Invalid ForeignCurrencyAccountType value: " + value);
    }
}
