[@override name="title"]选题列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            发行管理
            <small>选题列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/issue/list"><i class="fa fa-edit"></i> 发行管理</a></li>
            <li class="active">选题列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/issue/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="part">工作环节:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="part" name="part" placeholder="工作环节"
                               value="${issue.part}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="principal">责任人:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="principal" name="principal" placeholder="责任人"
                               value="${issue.principal}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/issue/create" class="btn btn-success">创建</a>
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
                        [#list pagination.data as issue]
                            <tr>
                                <td>${issue_index + 1}</td>
                                <td>${issue.part}</td>
                                <td>${issue.content}</td>
                                <td>${issue.thing}</td>
                                <td>${issue.department}</td>
                                <td>${issue.principal}</td>
                                <td>${issue.beginDate?date}</td>
                                <td>${issue.endDate?date}</td>
                                <td>${(issue.status.getName())!}</td>
                                <td>
                                    [#if issue.status??]
                                        [#assign status=issue.status/]
                                        [#if status.getValue() == 0]
                                            <a class="btn btn-warning btn-sm" href="/issue/verified/${issue.id}?status=finished">通过</a>
                                            <a class="btn btn-warning btn-sm" href="/issue/verified/${issue.id}?status=unfinished">驳回</a>
                                        [/#if]
                                    [/#if]
                                    <a class="btn btn-success btn-sm" href="/issue/view/${issue.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/issue/edit/${issue.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/issue/delete/${issue.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/issue/list?part=${issue.part}&principal=${issue.principal}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]