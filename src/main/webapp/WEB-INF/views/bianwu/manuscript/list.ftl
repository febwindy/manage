[@override name="title"]发稿单列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>发稿单列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/manuscript/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">发稿单列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/manuscript/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="name">稿单名:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="name" name="name" placeholder="稿单名"
                               value="${manuscript.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="author">作者:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="author" name="author" placeholder="作者"
                               value="${manuscript.author}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="editor">责编:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="editor" name="editor" placeholder="责编"
                               value="${manuscript.editor}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="principal">经办人:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="principal" name="principal" placeholder="经办人"
                               value="${manuscript.principal}">
                    </div>
                </div>
                <div class="form-group" style="margin-top: 15px;">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/manuscript/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>稿单名</th>
                    <th>作者</th>
                    <th>字数</th>
                    <th>页数</th>
                    <th>通讯地址</th>
                    <th>审核意见</th>
                    <th>责编</th>
                    <th>经办人</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as manuscript]
                            <tr>
                                <td>${manuscript_index + 1}</td>
                                <td>${manuscript.name}</td>
                                <td>${manuscript.author}</td>
                                <td>${manuscript.count}</td>
                                <td>${manuscript.page}</td>
                                <td>${manuscript.address}</td>
                                <td>${manuscript.opinion}</td>
                                <td>${manuscript.editor}</td>
                                <td>${manuscript.principal}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/manuscript/view/${manuscript.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/manuscript/edit/${manuscript.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/manuscript/delete/${manuscript.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/manuscript/list?name=${manuscript.name}&author=${manuscript.author}&editor=${manuscript.editor}&principal=${manuscript.principa}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]