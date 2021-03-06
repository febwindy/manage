<!-- Left side column. contains the logo and sidebar -->
<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left info">
                <p>您好, <@security.authentication property='name'/></p>

                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->

        <ul class="sidebar-menu">
            <li class="active">
                <a href="/index">
                    <i class="fa fa-dashboard"></i> <span>公告</span>
                </a>
            </li>
            <@security.authorize access="hasAnyRole('administrator')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i>
                        <span>用户管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/user/list"><i class="fa fa-angle-double-right"></i> 用户列表</a></li>
                        <li><a href="/user/create"><i class="fa fa-angle-double-right"></i> 用户创建</a></li>
                        <li><a href="/user/verified/list"><i class="fa fa-angle-double-right"></i> 用户审核</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-users"></i>
                        <span>角色管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/role/list"><i class="fa fa-angle-double-right"></i> 角色列表</a></li>
                        <li><a href="/role/create"><i class="fa fa-angle-double-right"></i> 角色创建</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-lock"></i>
                        <span>资源管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/permission/list"><i class="fa fa-angle-double-right"></i> 资源列表</a></li>
                        <li><a href="/permission/create"><i class="fa fa-angle-double-right"></i> 资源创建</a></li>
                    </ul>
                </li>
            </@security.authorize>
            <@security.authorize access="hasAnyRole('administrator,bianwuadmin')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i>
                        <span>编务管理系统</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/editing/list"><i class="fa fa-angle-double-right"></i> 选题管理</a></li>
                        <li><a href="/manuscript/list"><i class="fa fa-angle-double-right"></i> 发稿管理</a></li>
                        <li><a href="/contact/list"><i class="fa fa-angle-double-right"></i> 合同管理</a></li>
                    </ul>
                </li>
            </@security.authorize>
            <@security.authorize access="hasAnyRole('administrator,yinwuadmin')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-print"></i>
                        <span>印务管理系统</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/designing/list"><i class="fa fa-angle-double-right"></i> 选题管理</a></li>
                        <li><a href="/printing/list"><i class="fa fa-angle-double-right"></i> 印刷管理</a></li>
                        <li><a href="/bookbinding/list"><i class="fa fa-angle-double-right"></i> 装订管理</a></li>
                    </ul>
                </li>
            </@security.authorize>
            <@security.authorize access="hasAnyRole('administrator,faxingadmin')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-tasks"></i>
                        <span>发行管理系统</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/issue/list"><i class="fa fa-angle-double-right"></i> 选题管理</a></li>
                        <li><a href="/business/list"><i class="fa fa-angle-double-right"></i> 采购销售管理</a></li>
                        <li><a href="/customer/list"><i class="fa fa-angle-double-right"></i> 商户与能力管理</a></li>
                    </ul>
                </li>
            </@security.authorize>
            <@security.authorize access="hasAnyRole('administrator,caiwuadmin')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-truck"></i>
                        <span>物流管理系统</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/logistics/list"><i class="fa fa-angle-double-right"></i> 选题管理</a></li>
                        <li><a href="/warehousing/list"><i class="fa fa-angle-double-right"></i> 图书入库</a></li>
                        <li><a href="/delivery/list"><i class="fa fa-angle-double-right"></i> 图书出库</a></li>
                    </ul>
                </li>
            </@security.authorize>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>