package me.manage.domain.service.editing;

import me.manage.domain.model.editing.Editing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.editing.command.CreateEditingCommand;
import me.manage.interfaces.editing.command.EditEditingCommand;
import me.manage.interfaces.editing.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IEditingService {

    Editing findById(String id);

    Pagination<Editing> pagination(ListCommand command);

    void create(CreateEditingCommand command);

    void edit(EditEditingCommand command);

    void delete(String id);

    void changeStatus(String id, String status);

}
