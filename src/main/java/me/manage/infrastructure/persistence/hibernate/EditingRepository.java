package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.bianwu.editing.Editing;
import me.manage.domain.model.bianwu.editing.IEditingRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("editingRepository")
public class EditingRepository extends AbstractHibernateGenericRepository<Editing, String>
        implements IEditingRepository<Editing, String> {

    @Override
    public Editing findById(String id) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("user", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return null != obj ? (Editing) obj : null;
    }
}
