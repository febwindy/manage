package me.manage.domain.service.faxing.customer;

import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.model.faxing.customer.ICustomerRepository;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.customer.command.CreateCustomerCommand;
import me.manage.interfaces.faxing.customer.command.EditCustomerCommand;
import me.manage.interfaces.faxing.customer.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
@Service("customerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class CustomerService implements ICustomerService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICustomerRepository<Customer, String> customerRepository;

    @Override
    public Customer findById(String id) {
        return customerRepository.getById(id);
    }

    @Override
    public Pagination<Customer> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getName() && !StringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.like("name", command.getName(), MatchMode.ANYWHERE));
        }

        if (null != command.getType() && !command.getType().isOnlyQuery()) {
            criterionList.add(Restrictions.eq("type", command.getType()));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return customerRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateCustomerCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date deliveryDate = null;
        try {
            deliveryDate = sdf.parse(command.getDeliveryDate());
        } catch (ParseException e) {
            logger.warn("转换日期出错啦");
        }

        Customer customer = new Customer();
        customer.setName(command.getName());
        customer.setContact(command.getContact());
        customer.setTel(command.getTel());
        customer.setDeliveryStyle(command.getDeliveryStyle());
        customer.setDeliveryDate(deliveryDate);
        customer.setDeliveryAddress(command.getDeliveryAddress());
        customer.setType(command.getType());
        customer.setRemark(command.getRemark());
        customer.setCreatedDate(new Date());

        customerRepository.save(customer);
    }

    @Override
    public void edit(EditCustomerCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date deliveryDate = null;
        try {
            deliveryDate = sdf.parse(command.getDeliveryDate());
        } catch (ParseException e) {
            logger.warn("转换日期出错啦");
        }

        Customer customer = this.findById(command.getId());
        customer.setName(command.getName());
        customer.setContact(command.getContact());
        customer.setTel(command.getTel());
        customer.setDeliveryStyle(command.getDeliveryStyle());
        customer.setDeliveryDate(deliveryDate);
        customer.setDeliveryAddress(command.getDeliveryAddress());
        customer.setType(command.getType());
        customer.setRemark(command.getRemark());
        customer.setCreatedDate(new Date());

        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        Customer customer = this.findById(id);
        customerRepository.delete(customer);
    }
}
