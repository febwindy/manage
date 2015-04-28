package me.manage.domain.service.yinwu.designing;

import me.manage.domain.model.yinwu.designing.Designing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.designing.command.CreateDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.EditDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IDesigningService {

    Designing findById(String id);

    Pagination<Designing> pagination(ListCommand command);

    void create(CreateDesigningCommand command);

    void edit(EditDesigningCommand command);

    void delete(String id);

    void changeStatus(String id, String status);
}
