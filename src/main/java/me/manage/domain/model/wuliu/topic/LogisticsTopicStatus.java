package me.manage.domain.model.wuliu.topic;

/**
 * Created by savion on 2015/4/29.
 */
public enum  LogisticsTopicStatus {

    PROCESSING("处理中", 0),
    FINISHED("通过", 1),
    UNFINISHED("驳回", 2);

    LogisticsTopicStatus(String name, int value) {
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
