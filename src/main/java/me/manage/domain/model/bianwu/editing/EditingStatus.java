package me.manage.domain.model.bianwu.editing;

/**
 * Created by savion on 2015/4/28.
 */
public enum EditingStatus {

    PROCESSING("处理中", 0),
    FINISHED("通过", 1),
    UNFINISHED("驳回", 2);

    EditingStatus(String name, int value) {
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
