[@override name="title"]合同列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>合同列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/contact/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">合同列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/contact/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="contactId">合同号:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="contactId" name="contactId" placeholder="合同号"
                               value="${contact.contactId}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="author">作者:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="author" name="author" placeholder="作者"
                               value="${contact.author}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/contact/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>合同号</th>
                    <th>图书页数</th>
                    <th>折扣率</th>
                    <th>作者</th>
                    <th>交稿日期</th>
                    <th>出版地址</th>
                    <th>合同类型</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as contact]
                            <tr>
                                <td>${contact_index + 1}</td>
                                <td>${contact.contactId}</td>
                                <td>${contact.page}</td>
                                <td>${contact.discount}</td>
                                <td>${contact.author}</td>
                                <td>${contact.manuscriptOutDate?date}</td>
                                <td>${contact.address}</td>
                                <td>${(contact.type.getName())!}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/contact/view/${contact.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/contact/edit/${contact.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/contact/delete/${contact.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/contact/list?part=${contact.contactId}&operator=${contact.author}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]