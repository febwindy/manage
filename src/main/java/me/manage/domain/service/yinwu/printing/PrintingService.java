package me.manage.domain.service.yinwu.printing;

import me.manage.domain.model.yinwu.printing.IPrintingRepository;
import me.manage.domain.model.yinwu.printing.Printing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.printing.command.CreatePrintingCommand;
import me.manage.interfaces.yinwu.printing.command.EditPrintingCommand;
import me.manage.interfaces.yinwu.printing.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by savion on 2015/4/28.
 */
@Service("printingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PrintingService implements IPrintingService {

    @Autowired
    private IPrintingRepository<Printing, String> printingRepository;

    @Override
    public Printing findById(String id) {
        return printingRepository.getById(id);
    }

    @Override
    public Pagination<Printing> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getName() && !StringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.like("name", command.getName(), MatchMode.ANYWHERE));
        }

        if (null != command.getType() && !StringUtils.isEmpty(command.getType())) {
            criterionList.add(Restrictions.like("type", command.getType(), MatchMode.ANYWHERE));
        }

        if (null != command.getIsbn() && !StringUtils.isEmpty(command.getIsbn())) {
            criterionList.add(Restrictions.like("isbn", command.getIsbn(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return printingRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreatePrintingCommand command) {

        Printing printing = new Printing();
        printing.setName(command.getName());
        printing.setIsbn(command.getIsbn());
        printing.setType(command.getType());
        printing.setPaper(command.getPaper());
        printing.setPaperType(command.getPaperType());
        printing.setInk(command.getInk());
        printing.setWrapper(command.getWrapper());
        printing.setPrintNumber(command.getPrintNumber());
        printing.setRemark(command.getRemark());
        printing.setCreatedDate(new Date());

        printingRepository.save(printing);
    }

    @Override
    public void edit(EditPrintingCommand command) {

        Printing printing = this.findById(command.getId());
        printing.setName(command.getName());
        printing.setIsbn(command.getIsbn());
        printing.setType(command.getType());
        printing.setPaper(command.getPaper());
        printing.setPaperType(command.getPaperType());
        printing.setInk(command.getInk());
        printing.setWrapper(command.getWrapper());
        printing.setPrintNumber(command.getPrintNumber());
        printing.setRemark(command.getRemark());
        printing.setCreatedDate(new Date());

        printingRepository.save(printing);
    }

    @Override
    public void delete(String id) {
        Printing printing = this.findById(id);
        printingRepository.delete(printing);
    }
}
