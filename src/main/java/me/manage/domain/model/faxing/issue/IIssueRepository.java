package me.manage.domain.model.faxing.issue;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by savion on 2015/4/29.
 */
public interface IIssueRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {

    T findById(String id);

}
