package me.manage.domain.service.bianwu.manuscript;

import me.manage.domain.model.bianwu.manuscript.Manuscript;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.manuscript.command.CreateManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.EditManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IManuscriptService {

    Manuscript findById(String id);

    Pagination<Manuscript> pagination(ListCommand command);

    void create(CreateManuscriptCommand command);

    void edit(EditManuscriptCommand command);

    void delete(String id);
}
