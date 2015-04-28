package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.faxing.business.CustomerType;
import me.manage.domain.model.faxing.business.IProcurementAndSalesRepository;
import me.manage.domain.model.faxing.business.ProcurementAndSales;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("procurementAndSalesRepository")
public class ProcurementAndSalesRepository extends AbstractHibernateGenericRepository<ProcurementAndSales, String>
        implements IProcurementAndSalesRepository<ProcurementAndSales, String> {

    @Override
    public ProcurementAndSales findById(String id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("customer", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return null != obj ? (ProcurementAndSales) obj : null;
    }

    @Override
    public List<ProcurementAndSales> findByType(CustomerType type) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("type", type));

        return criteria.list();
    }
}
