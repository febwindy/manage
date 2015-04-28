package me.manage.domain.service.faxing.business;

import me.manage.domain.model.faxing.business.IProcurementAndSalesRepository;
import me.manage.domain.model.faxing.business.ProcurementAndSales;
import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.service.faxing.customer.ICustomerService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.business.command.CreateProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.EditProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
@Service("procurementAndSalesService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ProcurementAndSalesService implements IProcurementAndSalesService {

    @Autowired
    private IProcurementAndSalesRepository<ProcurementAndSales, String> procurementAndSalesRepository;

    @Autowired
    private ICustomerService customerService;

    @Override
    public ProcurementAndSales findById(String id) {
        return procurementAndSalesRepository.findById(id);
    }

    @Override
    public Pagination<ProcurementAndSales> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getProductId() && !StringUtils.isEmpty(command.getProductId())) {
            criterionList.add(Restrictions.eq("productId", command.getProductId()));
        }

        if (null != command.getProductName() && !StringUtils.isEmpty(command.getProductName())) {
            criterionList.add(Restrictions.like("productName", command.getProductName(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return procurementAndSalesRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateProAndSaleCommand command) {

        Customer customer = customerService.findById(command.getCustomerId());

        ProcurementAndSales procurementAndSales = new ProcurementAndSales();
        procurementAndSales.setProductId(command.getProductId());
        procurementAndSales.setProductName(command.getProductName());
        procurementAndSales.setProductStyle(command.getProductStyle());
        procurementAndSales.setUnit(command.getUnit());
        procurementAndSales.setNum(command.getNum());
        procurementAndSales.setPrice(command.getPrice());
        procurementAndSales.setDiscount(command.getDiscount());
        procurementAndSales.setTaxRate(command.getTaxRate());
        procurementAndSales.setAmountOfTax(command.getAmountOfTax());
        procurementAndSales.setType(command.getType());
        procurementAndSales.setAmount(command.getAmount());
        procurementAndSales.setCustomer(customer);
        procurementAndSales.setRemark(command.getRemark());
        procurementAndSales.setCreatedDate(new Date());

        procurementAndSalesRepository.save(procurementAndSales);
    }

    @Override
    public void edit(EditProAndSaleCommand command) {

        Customer customer = customerService.findById(command.getCustomerId());

        ProcurementAndSales procurementAndSales = this.findById(command.getId());
        procurementAndSales.setProductId(command.getProductId());
        procurementAndSales.setProductName(command.getProductName());
        procurementAndSales.setProductStyle(command.getProductStyle());
        procurementAndSales.setUnit(command.getUnit());
        procurementAndSales.setNum(command.getNum());
        procurementAndSales.setPrice(command.getPrice());
        procurementAndSales.setDiscount(command.getDiscount());
        procurementAndSales.setTaxRate(command.getTaxRate());
        procurementAndSales.setAmountOfTax(command.getAmountOfTax());
        procurementAndSales.setType(command.getType());
        procurementAndSales.setAmount(command.getAmount());
        procurementAndSales.setCustomer(customer);
        procurementAndSales.setRemark(command.getRemark());
        procurementAndSales.setCreatedDate(new Date());

        procurementAndSalesRepository.save(procurementAndSales);
    }

    @Override
    public void delete(String id) {
        ProcurementAndSales procurementAndSales = this.findById(id);
        procurementAndSalesRepository.delete(procurementAndSales);
    }
}
