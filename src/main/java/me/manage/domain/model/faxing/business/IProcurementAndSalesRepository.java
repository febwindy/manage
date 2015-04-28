package me.manage.domain.model.faxing.business;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
public interface IProcurementAndSalesRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {

    ProcurementAndSales findById(String id);

    List<ProcurementAndSales> findByType(CustomerType type);

}
