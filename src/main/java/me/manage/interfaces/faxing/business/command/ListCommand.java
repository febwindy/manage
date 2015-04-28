package me.manage.interfaces.faxing.business.command;

/**
 * Created by savion on 2015/4/29.
 */
public class ListCommand {
    private String productId;
    private String productName;
    private int page = 1;
    private int pageSize = 20;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
