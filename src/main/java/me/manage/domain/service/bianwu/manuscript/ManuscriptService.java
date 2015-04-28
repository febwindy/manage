package me.manage.domain.service.bianwu.manuscript;

import me.manage.domain.model.bianwu.manuscript.IManuscriptRepository;
import me.manage.domain.model.bianwu.manuscript.Manuscript;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.manuscript.command.CreateManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.EditManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
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
@Service("manuscriptService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ManuscriptService implements IManuscriptService {

    @Autowired
    private IManuscriptRepository<Manuscript, String> manuscriptRepository;

    @Override
    public Manuscript findById(String id) {
        return manuscriptRepository.getById(id);
    }

    @Override
    public Pagination<Manuscript> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getName() && !StringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.eq("name", command.getName()));
        }

        if (null != command.getAuthor() && !StringUtils.isEmpty(command.getAuthor())) {
            criterionList.add(Restrictions.eq("author", command.getAuthor()));
        }

        if (null != command.getEditor() && !StringUtils.isEmpty(command.getEditor())) {
            criterionList.add(Restrictions.eq("editor", command.getEditor()));
        }

        if (null != command.getPrincipal() && !StringUtils.isEmpty(command.getPrincipal())) {
            criterionList.add(Restrictions.eq("principal", command.getPrincipal()));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return manuscriptRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateManuscriptCommand command) {

        Manuscript manuscript = new Manuscript();
        manuscript.setName(command.getName());
        manuscript.setAuthor(command.getAuthor());
        manuscript.setCount(command.getCount());
        manuscript.setPage(command.getPage());
        manuscript.setAddress(command.getAddress());
        manuscript.setOpinion(command.getOpinion());
        manuscript.setEditor(command.getEditor());
        manuscript.setPrincipal(command.getPrincipal());
        manuscript.setRemark(command.getRemark());
        manuscript.setCreatedDate(new Date());

        manuscriptRepository.save(manuscript);
    }

    @Override
    public void edit(EditManuscriptCommand command) {

        Manuscript manuscript = this.findById(command.getId());
        manuscript.setName(command.getName());
        manuscript.setAuthor(command.getAuthor());
        manuscript.setCount(command.getCount());
        manuscript.setPage(command.getPage());
        manuscript.setAddress(command.getAddress());
        manuscript.setOpinion(command.getOpinion());
        manuscript.setEditor(command.getEditor());
        manuscript.setPrincipal(command.getPrincipal());
        manuscript.setRemark(command.getRemark());
        manuscript.setCreatedDate(new Date());

        manuscriptRepository.save(manuscript);
    }

    @Override
    public void delete(String id) {
        Manuscript manuscript = this.findById(id);
        manuscriptRepository.delete(manuscript);
    }
}
