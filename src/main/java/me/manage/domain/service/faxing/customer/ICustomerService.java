package me.manage.domain.service.faxing.customer;

import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.model.faxing.customer.CustomerType;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.customer.command.CreateCustomerCommand;
import me.manage.interfaces.faxing.customer.command.EditCustomerCommand;
import me.manage.interfaces.faxing.customer.command.ListCommand;

import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
public interface ICustomerService {

    Customer findById(String id);

    List<Customer> findByType(CustomerType type);

    Pagination<Customer> pagination(ListCommand command);

    void create(CreateCustomerCommand command);

    void edit(EditCustomerCommand command);

    void delete(String id);
}
