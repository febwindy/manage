package me.manage.domain.model.faxing.business;

/**
 * Created by savion on 2015/4/29.
 */
public enum CustomerType {

    ALL("全部", 0, Boolean.TRUE),
    MERCHANT("商户", 1, Boolean.FALSE),
    CAPABILITY("能力", 2, Boolean.FALSE);

    CustomerType(String name, int value, boolean onlyQuery) {
        this.name = name;
        this.value = value;
        this.onlyQuery = onlyQuery;
    }

    private final String name;
    private final int value;
    private final boolean onlyQuery;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isOnlyQuery() {
        return onlyQuery;
    }
}
