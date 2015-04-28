package me.manage.domain.model.yinwu.bookbinding;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by savion on 2015/4/28.
 */
public interface IBookbindingRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
