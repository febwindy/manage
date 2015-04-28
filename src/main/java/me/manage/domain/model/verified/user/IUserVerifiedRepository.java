package me.manage.domain.model.verified.user;

import me.manage.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/4/10.
 */
public interface IUserVerifiedRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
