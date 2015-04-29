package me.manage.domain.service.wuliu.delivery;

import me.manage.domain.model.wuliu.delivery.Delivery;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.delivery.command.CreateDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.EditDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.ListCommand;

/**
 * Created by savion on 2015/4/29.
 */
public interface IDeliveryService {

    Delivery findById(String id);

    Pagination<Delivery> pagination(ListCommand command);

    void create(CreateDeliveryCommand command);

    void edit(EditDeliveryCommand command);

    void delete(String id);

}
