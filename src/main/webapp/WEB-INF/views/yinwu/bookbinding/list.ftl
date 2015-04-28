[@override name="title"]装订列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>装订列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/bookbinding/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">装订列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/bookbinding/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="name">装订名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="name" name="name" placeholder="装订名称"
                               value="${bookbinding.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="form">装订形式:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="form" name="form" placeholder="装订形式"
                               value="${bookbinding.form}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="style">装订方式:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="style" name="style" placeholder="装订方式"
                               value="${bookbinding.style}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/bookbinding/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>装订名称</th>
                    <th>装订材料</th>
                    <th>装订形式</th>
                    <th>装订方式</th>
                    <th>装订流程</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as bookbinding]
                            <tr>
                                <td>${bookbinding_index + 1}</td>
                                <td>${bookbinding.name}</td>
                                <td>${bookbinding.material}</td>
                                <td>${bookbinding.form}</td>
                                <td>${bookbinding.style}</td>
                                <td>${bookbinding.flow}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/bookbinding/view/${bookbinding.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/bookbinding/edit/${bookbinding.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/bookbinding/delete/${bookbinding.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/bookbinding/list?name=${bookbinding.name}&principal=${bookbinding.form}&ink=${bookbinding.style}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]