package me.manage.interfaces.faxing.customer.command;

import me.manage.domain.model.faxing.customer.CustomerType;

/**
 * Created by savion on 2015/4/29.
 */
public class CreateCustomerCommand {
    private String name;
    private String contact;
    private String tel;
    private String deliveryStyle;
    private String deliveryDate;
    private String deliveryAddress;
    private CustomerType type;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDeliveryStyle() {
        return deliveryStyle;
    }

    public void setDeliveryStyle(String deliveryStyle) {
        this.deliveryStyle = deliveryStyle;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
