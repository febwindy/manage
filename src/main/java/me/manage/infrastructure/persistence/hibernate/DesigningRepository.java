package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.yinwu.designing.Designing;
import me.manage.domain.model.yinwu.designing.IDesigningRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("designingRepository")
public class DesigningRepository extends AbstractHibernateGenericRepository<Designing, String>
        implements IDesigningRepository<Designing, String> {

    @Override
    public Designing findById(String id) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("user", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return null != obj ? (Designing) obj : null;
    }
}
