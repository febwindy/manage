package me.manage.domain.service.faxing.business;

import me.manage.domain.model.faxing.business.ProcurementAndSales;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.business.command.CreateProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.EditProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.ListCommand;

/**
 * Created by savion on 2015/4/29.
 */
public interface IProcurementAndSalesService {

    ProcurementAndSales findById(String id);

    Pagination<ProcurementAndSales> pagination(ListCommand command);

    void create(CreateProAndSaleCommand command);

    void edit(EditProAndSaleCommand command);

    void delete(String id);
}
