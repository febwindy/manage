package me.manage.interfaces.verified.web.user.command;

/**
 * Created by ivan_ on 2015/4/10.
 */
public class ListCommand {
    private int page = 1;
    private int pageSize = 20;

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
