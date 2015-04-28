package me.manage.domain.service.faxing.issue;

import me.manage.domain.model.faxing.issue.Issue;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.issue.command.CreateIssueCommand;
import me.manage.interfaces.faxing.issue.command.EditIssueCommand;
import me.manage.interfaces.faxing.issue.command.ListCommand;

/**
 * Created by savion on 2015/4/29.
 */
public interface IIssueService {

    Issue findById(String id);

    Pagination<Issue> pagination(ListCommand command);

    void create(CreateIssueCommand command);

    void edit(EditIssueCommand command);

    void delete(String id);

    void changeStatus(String id, String status);

}
