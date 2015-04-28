package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.model.faxing.customer.CustomerType;
import me.manage.domain.model.faxing.customer.ICustomerRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("customerRepository")
public class CustomerRepository extends AbstractHibernateGenericRepository<Customer, String>
        implements ICustomerRepository<Customer, String> {

    @Override
    public List<Customer> findByType(CustomerType type) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("type", type));

        return criteria.list();
    }
}
