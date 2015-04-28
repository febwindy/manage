package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.model.faxing.customer.ICustomerRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("customerRepository")
public class CustomerRepository extends AbstractHibernateGenericRepository<Customer, String>
        implements ICustomerRepository<Customer, String> {
}
