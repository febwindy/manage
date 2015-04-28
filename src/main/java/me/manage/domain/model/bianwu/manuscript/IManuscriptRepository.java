package me.manage.domain.model.bianwu.manuscript;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by savion on 2015/4/28.
 */
public interface IManuscriptRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
