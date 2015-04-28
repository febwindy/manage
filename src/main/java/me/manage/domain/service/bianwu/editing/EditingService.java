package me.manage.domain.service.bianwu.editing;

import me.manage.application.security.SaltUser;
import me.manage.domain.model.bianwu.editing.Editing;
import me.manage.domain.model.bianwu.editing.EditingStatus;
import me.manage.domain.model.bianwu.editing.IEditingRepository;
import me.manage.domain.model.user.User;
import me.manage.domain.service.user.IUserService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.editing.command.CreateEditingCommand;
import me.manage.interfaces.bianwu.editing.command.EditEditingCommand;
import me.manage.interfaces.bianwu.editing.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by savion on 2015/4/28.
 */
@Service("editingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EditingService implements IEditingService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IEditingRepository<Editing, String> editingRepository;

    @Override
    public Editing findById(String id) {
        return editingRepository.findById(id);
    }

    @Override
    public Pagination<Editing> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getPart() && !StringUtils.isEmpty(command.getPart())) {
            criterionList.add(Restrictions.like("part", command.getPart(), MatchMode.ANYWHERE));
        }

        if (null != command.getOperator() && !StringUtils.isEmpty(command.getOperator())) {
            criterionList.add(Restrictions.like("operator", command.getOperator(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return editingRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateEditingCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (object instanceof SaltUser) {
            user = userService.findById(((SaltUser) object).getId());
        }

        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(command.getBeginDate());
            endDate = sdf.parse(command.getEndDate());
        } catch (ParseException e) {
            logger.warn("转换日期出错啦");
        }

        Editing editing = new Editing();
        editing.setPart(command.getPart());
        editing.setContent(command.getContent());
        editing.setThing(command.getThing());
        editing.setDepartment(command.getDepartment());
        editing.setOperator(command.getOperator());
        editing.setBeginDate(beginDate);
        editing.setEndDate(endDate);
        editing.setRemark(command.getRemark());
        editing.setCreatedDate(new Date());
        editing.setStatus(EditingStatus.PROCESSING);
        editing.setUser(user);

        editingRepository.save(editing);
    }

    @Override
    public void edit(EditEditingCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(command.getBeginDate());
            endDate = sdf.parse(command.getEndDate());
        } catch (ParseException e) {
            logger.warn("转换日期出错啦");
        }

        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (object instanceof SaltUser) {
            user = userService.findById(((SaltUser) object).getId());
        }

        Editing editing = this.findById(command.getId());
        editing.setPart(command.getPart());
        editing.setContent(command.getContent());
        editing.setThing(command.getThing());
        editing.setDepartment(command.getDepartment());
        editing.setOperator(command.getOperator());
        editing.setBeginDate(beginDate);
        editing.setEndDate(endDate);
        editing.setRemark(command.getRemark());
        editing.setCreatedDate(new Date());
        editing.setUser(user);

        editingRepository.save(editing);
    }

    @Override
    public void delete(String id) {
        Editing editing = this.findById(id);
        editingRepository.delete(editing);
    }

    @Override
    public void changeStatus(String id, String status) {
        Editing editing = this.findById(id);

        if (status.equals("finished")) {
            editing.setStatus(EditingStatus.FINISHED);
        } else {
            editing.setStatus(EditingStatus.UNFINISHED);
        }
        editingRepository.update(editing);
    }
}
