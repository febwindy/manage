package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.wuliu.warehousing.IWarehousingRepository;
import me.manage.domain.model.wuliu.warehousing.Warehousing;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("warehousingRepository")
public class WarehousingRepository extends AbstractHibernateGenericRepository<Warehousing, String>
        implements IWarehousingRepository<Warehousing, String> {
}
