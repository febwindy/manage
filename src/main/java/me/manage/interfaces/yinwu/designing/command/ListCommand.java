package me.manage.interfaces.yinwu.designing.command;

/**
 * Created by savion on 2015/4/28.
 */
public class ListCommand {
    private String part;
    private String principal;
    private int page = 1;
    private int pageSize = 20;

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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
