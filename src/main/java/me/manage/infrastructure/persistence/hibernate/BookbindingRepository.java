package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.yinwu.bookbinding.Bookbinding;
import me.manage.domain.model.yinwu.bookbinding.IBookbindingRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("bookbindingRepository")
public class BookbindingRepository extends AbstractHibernateGenericRepository<Bookbinding, String>
        implements IBookbindingRepository<Bookbinding, String> {
}
