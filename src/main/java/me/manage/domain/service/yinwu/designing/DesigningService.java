package me.manage.domain.service.yinwu.designing;

import me.manage.application.security.SaltUser;
import me.manage.domain.model.user.User;
import me.manage.domain.model.yinwu.designing.Designing;
import me.manage.domain.model.yinwu.designing.DesigningStatus;
import me.manage.domain.model.yinwu.designing.IDesigningRepository;
import me.manage.domain.service.user.IUserService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.yinwu.designing.command.CreateDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.EditDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.ListCommand;
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
@Service("designingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DesigningService implements IDesigningService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDesigningRepository<Designing, String> designingRepository;

    @Autowired
    private IUserService userService;

    @Override
    public Designing findById(String id) {
        return designingRepository.findById(id);
    }

    @Override
    public Pagination<Designing> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getPart() && !StringUtils.isEmpty(command.getPart())) {
            criterionList.add(Restrictions.like("part", command.getPart(), MatchMode.ANYWHERE));
        }

        if (null != command.getPrincipal() && !StringUtils.isEmpty(command.getPrincipal())) {
            criterionList.add(Restrictions.like("principal", command.getPrincipal(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return designingRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateDesigningCommand command) {

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

        Designing designing = new Designing();
        designing.setPart(command.getPart());
        designing.setContent(command.getContent());
        designing.setThing(command.getThing());
        designing.setDepartment(command.getDepartment());
        designing.setPrincipal(command.getPrincipal());
        designing.setBeginDate(beginDate);
        designing.setEndDate(endDate);
        designing.setRemark(command.getRemark());
        designing.setCreatedDate(new Date());
        designing.setStatus(DesigningStatus.PROCESSING);
        designing.setUser(user);

        designingRepository.save(designing);
    }

    @Override
    public void edit(EditDesigningCommand command) {

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

        Designing designing = this.findById(command.getId());
        designing.setPart(command.getPart());
        designing.setContent(command.getContent());
        designing.setThing(command.getThing());
        designing.setDepartment(command.getDepartment());
        designing.setPrincipal(command.getPrincipal());
        designing.setBeginDate(beginDate);
        designing.setEndDate(endDate);
        designing.setRemark(command.getRemark());
        designing.setCreatedDate(new Date());
        designing.setStatus(DesigningStatus.PROCESSING);
        designing.setUser(user);

        designingRepository.save(designing);
    }

    @Override
    public void delete(String id) {
        Designing designing = this.findById(id);
        designingRepository.delete(designing);
    }

    @Override
    public void changeStatus(String id, String status) {
        Designing designing = this.findById(id);

        if (status.equals("finished")) {
            designing.setStatus(DesigningStatus.FINISHED);
        } else {
            designing.setStatus(DesigningStatus.UNFINISHED);
        }
        designingRepository.update(designing);
    }
}
