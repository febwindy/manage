[@override name="title"]商户与能力列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            发行管理
            <small>商户与能力列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/customer/list"><i class="fa fa-tasks"></i> 发行管理</a></li>
            <li class="active">商户与能力列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/customer/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="name">商户与能力名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="name" name="name" placeholder="商户与能力名称"
                               value="${customer.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <label for="type">类型:</label>
                    </div>
                    <div class="col-sm-6">
                        <select name="type" class="form-control">
                            [#assign type="${customer.type}" /]
                            <option value="ALL" [@mc.selected type "ALL"/]>全部</option>
                            <option value="MERCHANT" [@mc.selected type "MERCHANT"/]>商户</option>
                            <option value="CAPABILITY" [@mc.selected type "CAPABILITY"/]>能力</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/customer/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>联系人</th>
                    <th>联第电话</th>
                    <th>交货方式</th>
                    <th>交货日期</th>
                    <th>交货地址</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as customer]
                            <tr>
                                <td>${customer_index + 1}</td>
                                <td>${customer.name}</td>
                                <td>${customer.contact}</td>
                                <td>${customer.tel}</td>
                                <td>${customer.deliveryStyle}</td>
                                <td>${customer.deliveryDate?date}</td>
                                <td>${customer.deliveryAddress}</td>
                                <td>${(customer.type.getName())!}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/customer/view/${customer.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/customer/edit/${customer.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/customer/delete/${customer.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/customer/list?name=${customer.name}&type=${customer.type}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]