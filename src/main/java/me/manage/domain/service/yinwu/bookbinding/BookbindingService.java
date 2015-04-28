package me.manage.domain.service.yinwu.bookbinding;

import me.manage.domain.model.yinwu.bookbinding.Bookbinding;
import me.manage.domain.model.yinwu.bookbinding.IBookbindingRepository;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.bookbinding.command.CreateBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.EditBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.ListCommand;
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
@Service("bookbindingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BookbindingService implements IBookbindingService {

    @Autowired
    private IBookbindingRepository<Bookbinding, String> bookbindingRepository;

    @Override
    public Bookbinding findById(String id) {
        return bookbindingRepository.getById(id);
    }

    @Override
    public Pagination<Bookbinding> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getName() && !StringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.like("name", command.getName(), MatchMode.ANYWHERE));
        }

        if (null != command.getForm() && !StringUtils.isEmpty(command.getForm())) {
            criterionList.add(Restrictions.like("form", command.getForm(), MatchMode.ANYWHERE));
        }

        if (null != command.getStyle() && !StringUtils.isEmpty(command.getStyle())) {
            criterionList.add(Restrictions.like("style", command.getStyle(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return bookbindingRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateBookbindingCommand command) {

        Bookbinding bookbinding = new Bookbinding();
        bookbinding.setName(command.getName());
        bookbinding.setMaterial(command.getMaterial());
        bookbinding.setForm(command.getForm());
        bookbinding.setStyle(command.getStyle());
        bookbinding.setFlow(command.getFlow());
        bookbinding.setRemark(command.getRemark());
        bookbinding.setCreatedDate(new Date());

        bookbindingRepository.save(bookbinding);
    }

    @Override
    public void edit(EditBookbindingCommand command) {

        Bookbinding bookbinding = this.findById(command.getId());
        bookbinding.setName(command.getName());
        bookbinding.setMaterial(command.getMaterial());
        bookbinding.setForm(command.getForm());
        bookbinding.setStyle(command.getStyle());
        bookbinding.setFlow(command.getFlow());
        bookbinding.setRemark(command.getRemark());
        bookbinding.setCreatedDate(new Date());

        bookbindingRepository.save(bookbinding);
    }

    @Override
    public void delete(String id) {
        Bookbinding bookbinding = this.findById(id);
        bookbindingRepository.delete(bookbinding);
    }
}
