package me.manage.domain.service.permission;


import me.manage.domain.model.permission.Permission;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.permission.web.command.CreatePermissionCommand;
import me.manage.interfaces.permission.web.command.EditPermissionCommand;
import me.manage.interfaces.permission.web.command.ListCommand;

import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IPermissionService {

    Permission findById(String id);

    Permission findByName(String name);

    List<Permission> findByRoleId(String id);

    List<Permission> findAll();

    List<Permission> findAll(boolean isFetchMode);

    Pagination<Permission> pagination(ListCommand command);

    void create(CreatePermissionCommand command);

    void edit(EditPermissionCommand command);

    void delete(String id);
}
