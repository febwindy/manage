package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.wuliu.topic.ILogisticsTopicRepository;
import me.manage.domain.model.wuliu.topic.LogisticsTopic;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("logisticsTopicRepository")
public class LogisticsTopicRepository extends AbstractHibernateGenericRepository<LogisticsTopic, String>
        implements ILogisticsTopicRepository<LogisticsTopic, String> {

    @Override
    public LogisticsTopic findById(String id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("user", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return null != obj ? (LogisticsTopic) obj : null;
    }
}
