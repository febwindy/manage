package me.manage.domain.service.wuliu.topic;

import me.manage.domain.model.wuliu.topic.LogisticsTopic;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.topic.command.CreateLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.EditLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.ListCommand;

/**
 * Created by savion on 2015/4/29.
 */
public interface ILogisticsTopicService {

    LogisticsTopic findById(String id);

    Pagination<LogisticsTopic> pagination(ListCommand command);

    void create(CreateLogisticsCommand command);

    void edit(EditLogisticsCommand command);

    void delete(String id);

    void changeStatus(String id, String status);
}
