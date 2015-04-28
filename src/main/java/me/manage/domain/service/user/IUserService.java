package me.manage.domain.service.user;

import me.manage.domain.model.user.User;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.user.web.command.AuthorizationRoleCommand;
import me.manage.interfaces.user.web.command.CreateUserCommand;
import me.manage.interfaces.user.web.command.EditUserCommand;
import me.manage.interfaces.user.web.command.ListCommand;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IUserService {

    User findByUsername(String username);

    User findById(String id);

    User findById(String id, Boolean isFetchMode);

    Pagination<User> pagination(ListCommand command);

    void create(CreateUserCommand command);

    void delete(String id);

    void edit(EditUserCommand command);

    void authorization(AuthorizationRoleCommand command);

}
