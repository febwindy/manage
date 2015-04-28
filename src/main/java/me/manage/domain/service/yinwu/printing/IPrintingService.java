package me.manage.domain.service.yinwu.printing;

import me.manage.domain.model.yinwu.printing.Printing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.printing.command.CreatePrintingCommand;
import me.manage.interfaces.yinwu.printing.command.EditPrintingCommand;
import me.manage.interfaces.yinwu.printing.command.ListCommand;

/**
 * Created by savion on 2015/4/28.
 */
public interface IPrintingService {

    Printing findById(String id);

    Pagination<Printing> pagination(ListCommand command);

    void create(CreatePrintingCommand command);

    void edit(EditPrintingCommand command);

    void delete(String id);
}
