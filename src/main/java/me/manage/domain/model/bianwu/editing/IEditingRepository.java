package me.manage.domain.model.bianwu.editing;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by savion on 2015/4/28.
 */
public interface IEditingRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {

    T findById(String id);

}
