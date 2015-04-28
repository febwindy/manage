package me.manage.interfaces.bianwu.contact.command;

import me.manage.domain.model.bianwu.contact.ContactType;

import java.util.Date;

/**
 * Created by savion on 2015/4/28.
 */
public class EditContactCommand {

    private String id;
    private String contactId;
    private String page;
    private String author;
    private String manuscriptOutDate;
    private String address;
    private String discount;
    private ContactType type;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getManuscriptOutDate() {
        return manuscriptOutDate;
    }

    public void setManuscriptOutDate(String manuscriptOutDate) {
        this.manuscriptOutDate = manuscriptOutDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
