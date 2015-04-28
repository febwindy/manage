package me.manage.interfaces.faxing.customer.command;

import me.manage.domain.model.faxing.customer.CustomerType;

/**
 * Created by savion on 2015/4/29.
 */
public class ListCommand {
    private String name;
    private CustomerType type;
    private int page = 1;
    private int pageSize = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
