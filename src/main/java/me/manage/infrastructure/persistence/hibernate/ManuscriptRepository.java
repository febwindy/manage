package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.bianwu.manuscript.IManuscriptRepository;
import me.manage.domain.model.bianwu.manuscript.Manuscript;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("manuscriptRepository")
public class ManuscriptRepository extends AbstractHibernateGenericRepository<Manuscript, String>
        implements IManuscriptRepository<Manuscript, String> {
}
