[@override name="title"]印刷列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>印刷列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/printing/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">印刷列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/printing/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="name">印刷名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="name" name="name" placeholder="印刷名称"
                               value="${printing.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="type">印刷类型:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="type" name="type" placeholder="印刷类型"
                               value="${printing.type}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="isbn">ISBN:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="isbn" name="isbn" placeholder="ISBN"
                               value="${printing.isbn}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/printing/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>印刷名称</th>
                    <th>ISBN</th>
                    <th>印刷类型</th>
                    <th>纸张材料</th>
                    <th>纸张类型</th>
                    <th>油墨类型</th>
                    <th>包装材料</th>
                    <th>打印数量</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as printing]
                            <tr>
                                <td>${printing_index + 1}</td>
                                <td>${printing.name}</td>
                                <td>${printing.isbn}</td>
                                <td>${printing.type}</td>
                                <td>${printing.paper}</td>
                                <td>${printing.paperType}</td>
                                <td>${printing.ink}</td>
                                <td>${printing.wrapper}</td>
                                <td>${printing.printNumber}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/printing/view/${printing.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/printing/edit/${printing.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/printing/delete/${printing.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/printing/list?name=${printing.name}&principal=${printing.type}&ink=${printing.isbn}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]