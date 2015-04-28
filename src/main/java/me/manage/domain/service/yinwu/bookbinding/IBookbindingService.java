package me.manage.domain.service.yinwu.bookbinding;

import me.manage.domain.model.yinwu.bookbinding.Bookbinding;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.bookbinding.command.CreateBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.EditBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IBookbindingService {

    Bookbinding findById(String id);

    Pagination<Bookbinding> pagination(ListCommand command);

    void create(CreateBookbindingCommand command);

    void edit(EditBookbindingCommand command);

    void delete(String id);
}
