[@override name="title"]选题列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>选题列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/designing/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">选题列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/designing/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="part">工作环节:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="part" name="part" placeholder="工作环节"
                               value="${designing.part}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="principal">责任人:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="principal" name="principal" placeholder="责任人"
                               value="${designing.principal}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/designing/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>工作环节</th>
                    <th>工作内容</th>
                    <th>工作情况</th>
                    <th>责任部门</th>
                    <th>责任人</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>进度</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as designing]
                            <tr>
                                <td>${designing_index + 1}</td>
                                <td>${designing.part}</td>
                                <td>${designing.content}</td>
                                <td>${designing.thing}</td>
                                <td>${designing.department}</td>
                                <td>${designing.principal}</td>
                                <td>${designing.beginDate?date}</td>
                                <td>${designing.endDate?date}</td>
                                <td>${(designing.status.getName())!}</td>
                                <td>
                                    [#if designing.status??]
                                        [#assign status=designing.status/]
                                        [#if status.getValue() == 0]
                                            <a class="btn btn-warning btn-sm" href="/designing/verified/${designing.id}?status=finished">通过</a>
                                            <a class="btn btn-warning btn-sm" href="/designing/verified/${designing.id}?status=unfinished">驳回</a>
                                        [/#if]
                                    [/#if]
                                    <a class="btn btn-success btn-sm" href="/designing/view/${designing.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/designing/edit/${designing.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/designing/delete/${designing.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/designing/list?part=${designing.part}&principal=${designing.principal}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]