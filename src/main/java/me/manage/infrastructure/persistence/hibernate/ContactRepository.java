package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.bianwu.contact.Contact;
import me.manage.domain.model.bianwu.contact.IContactRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("contactRepository")
public class ContactRepository extends AbstractHibernateGenericRepository<Contact, String>
        implements IContactRepository<Contact, String> {
}
