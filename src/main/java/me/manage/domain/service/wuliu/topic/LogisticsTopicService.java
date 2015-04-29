package me.manage.domain.service.wuliu.topic;

import me.manage.application.security.SaltUser;
import me.manage.domain.model.user.User;
import me.manage.domain.model.wuliu.topic.ILogisticsTopicRepository;
import me.manage.domain.model.wuliu.topic.LogisticsTopic;
import me.manage.domain.model.wuliu.topic.LogisticsTopicStatus;
import me.manage.domain.service.user.IUserService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.topic.command.CreateLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.EditLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.ListCommand;
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
 * Created by savion on 2015/4/29.
 */
@Service("logisticsTopicService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LogisticsTopicService implements ILogisticsTopicService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ILogisticsTopicRepository<LogisticsTopic, String> logisticsTopicRepository;

    @Autowired
    private IUserService userService;

    @Override
    public LogisticsTopic findById(String id) {
        return logisticsTopicRepository.findById(id);
    }

    @Override
    public Pagination<LogisticsTopic> pagination(ListCommand command) {

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
        return logisticsTopicRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateLogisticsCommand command) {

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

        LogisticsTopic logisticsTopic = new LogisticsTopic();
        logisticsTopic.setPart(command.getPart());
        logisticsTopic.setContent(command.getContent());
        logisticsTopic.setThing(command.getThing());
        logisticsTopic.setDepartment(command.getDepartment());
        logisticsTopic.setPrincipal(command.getPrincipal());
        logisticsTopic.setBeginDate(beginDate);
        logisticsTopic.setEndDate(endDate);
        logisticsTopic.setRemark(command.getRemark());
        logisticsTopic.setCreatedDate(new Date());
        logisticsTopic.setStatus(LogisticsTopicStatus.PROCESSING);
        logisticsTopic.setUser(user);

        logisticsTopicRepository.save(logisticsTopic);
    }

    @Override
    public void edit(EditLogisticsCommand command) {

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

        LogisticsTopic logisticsTopic = this.findById(command.getId());
        logisticsTopic.setPart(command.getPart());
        logisticsTopic.setContent(command.getContent());
        logisticsTopic.setThing(command.getThing());
        logisticsTopic.setDepartment(command.getDepartment());
        logisticsTopic.setPrincipal(command.getPrincipal());
        logisticsTopic.setBeginDate(beginDate);
        logisticsTopic.setEndDate(endDate);
        logisticsTopic.setRemark(command.getRemark());
        logisticsTopic.setCreatedDate(new Date());
        logisticsTopic.setStatus(LogisticsTopicStatus.PROCESSING);
        logisticsTopic.setUser(user);

        logisticsTopicRepository.save(logisticsTopic);
    }

    @Override
    public void delete(String id) {
        LogisticsTopic logisticsTopic = this.findById(id);
        logisticsTopicRepository.delete(logisticsTopic);
    }

    @Override
    public void changeStatus(String id, String status) {
        LogisticsTopic logisticsTopic = this.findById(id);

        if (status.equals("finished")) {
            logisticsTopic.setStatus(LogisticsTopicStatus.FINISHED);
        } else {
            logisticsTopic.setStatus(LogisticsTopicStatus.UNFINISHED);
        }
        logisticsTopicRepository.update(logisticsTopic);
    }

}
