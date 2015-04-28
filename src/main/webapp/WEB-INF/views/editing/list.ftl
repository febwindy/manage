[@override name="title"]选题列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>选题列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/editing/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">选题列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/editing/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="part">工作环节:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="part" name="part" placeholder="工作环节"
                               value="${editing.part}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="operator">责任人:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="operator" name="operator" placeholder="责任人"
                               value="${editing.operator}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
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
                        [#list pagination.data as editing]
                            <tr>
                                <td>${editing_index + 1}</td>
                                <td>${editing.part}</td>
                                <td>${editing.content}</td>
                                <td>${editing.thing}</td>
                                <td>${editing.department}</td>
                                <td>${editing.operator}</td>
                                <td>${editing.beginDate?date}</td>
                                <td>${editing.endDate?date}</td>
                                <td>${(editing.status.getName())!}</td>
                                <td>
                                    [#if editing.status??]
                                        [#assign status=editing.status/]
                                        [#if status.getValue() == 0]
                                            <a class="btn btn-warning btn-sm" href="/editing/verified/${editing.id}?status=finished">通过</a>
                                            <a class="btn btn-warning btn-sm" href="/editing/verified/${editing.id}?status=unfinished">驳回</a>
                                        [/#if]
                                    [/#if]
                                    <a class="btn btn-success btn-sm" href="/editing/view/${editing.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/editing/edit/${editing.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/editing/delete/${editing.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/editing/list?part=${editing.part}&operator=${editing.operator}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]