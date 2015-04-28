package me.manage.domain.service.faxing.issue;

import me.manage.application.security.SaltUser;
import me.manage.domain.model.faxing.issue.IIssueRepository;
import me.manage.domain.model.faxing.issue.Issue;
import me.manage.domain.model.faxing.issue.IssueStatus;
import me.manage.domain.model.user.User;
import me.manage.domain.service.user.IUserService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.issue.command.CreateIssueCommand;
import me.manage.interfaces.faxing.issue.command.EditIssueCommand;
import me.manage.interfaces.faxing.issue.command.ListCommand;
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
@Service("issueService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class IssueService implements IIssueService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IIssueRepository<Issue, String> issueRepository;

    @Override
    public Issue findById(String id) {
        return issueRepository.findById(id);
    }

    @Override
    public Pagination<Issue> pagination(ListCommand command) {

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
        return issueRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateIssueCommand command) {

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

        Issue issue = new Issue();
        issue.setPart(command.getPart());
        issue.setContent(command.getContent());
        issue.setThing(command.getThing());
        issue.setDepartment(command.getDepartment());
        issue.setPrincipal(command.getPrincipal());
        issue.setBeginDate(beginDate);
        issue.setEndDate(endDate);
        issue.setRemark(command.getRemark());
        issue.setCreatedDate(new Date());
        issue.setStatus(IssueStatus.PROCESSING);
        issue.setUser(user);

        issueRepository.save(issue);
    }

    @Override
    public void edit(EditIssueCommand command) {

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

        Issue issue = this.findById(command.getId());
        issue.setPart(command.getPart());
        issue.setContent(command.getContent());
        issue.setThing(command.getThing());
        issue.setDepartment(command.getDepartment());
        issue.setPrincipal(command.getPrincipal());
        issue.setBeginDate(beginDate);
        issue.setEndDate(endDate);
        issue.setRemark(command.getRemark());
        issue.setCreatedDate(new Date());
        issue.setStatus(IssueStatus.PROCESSING);
        issue.setUser(user);

        issueRepository.update(issue);
    }

    @Override
    public void delete(String id) {
        Issue issue = this.findById(id);
        issueRepository.delete(issue);
    }

    @Override
    public void changeStatus(String id, String status) {
        Issue issue = this.findById(id);

        if (status.equals("finished")) {
            issue.setStatus(IssueStatus.FINISHED);
        } else {
            issue.setStatus(IssueStatus.UNFINISHED);
        }
        issueRepository.update(issue);
    }
}
