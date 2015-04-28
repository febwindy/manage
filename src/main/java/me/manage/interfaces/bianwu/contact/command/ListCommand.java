package me.manage.interfaces.bianwu.contact.command;

/**
 * Created by savion on 2015/4/28.
 */
public class ListCommand {
    private String contactId;
    private String author;
    private int page = 1;
    private int pageSize = 20;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
