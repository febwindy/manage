package me.manage.domain.service.wuliu.warehousing;

import me.manage.domain.model.wuliu.warehousing.Warehousing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.warehousing.command.CreateWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.EditWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.ListCommand;

/**
 * Created by savion on 2015/4/29.
 */
public interface IWarehousingService {

    Warehousing findById(String id);

    Pagination<Warehousing> pagination(ListCommand command);

    void create(CreateWarehousingCommand command);

    void edit(EditWarehousingCommand command);

    void delete(String id);

}
