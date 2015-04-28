package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.faxing.issue.IIssueRepository;
import me.manage.domain.model.faxing.issue.Issue;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("issueRepository")
public class IssueRepository extends AbstractHibernateGenericRepository<Issue, String>
        implements IIssueRepository<Issue, String> {

    @Override
    public Issue findById(String id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("user", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return null != obj ? (Issue) obj : null;
    }
}
