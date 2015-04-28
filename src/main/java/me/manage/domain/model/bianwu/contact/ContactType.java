package me.manage.domain.model.bianwu.contact;

/**
 * Created by savion on 2015/4/28.
 */
public enum ContactType {

    PUB("出版合同", 0),
    COMMISSION("约稿合同", 1),
    COPYRIGHT("版权贸易合同", 2);

    ContactType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
