package me.manage.domain.service.bianwu.contact;

import me.manage.domain.model.bianwu.contact.Contact;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.contact.command.CreateContactCommand;
import me.manage.interfaces.bianwu.contact.command.EditContactCommand;
import me.manage.interfaces.bianwu.contact.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IContactService {

    Contact findById(String id);

    Pagination<Contact> pagination(ListCommand command);

    void create(CreateContactCommand command);

    void edit(EditContactCommand command);

    void delete(String id);

}
