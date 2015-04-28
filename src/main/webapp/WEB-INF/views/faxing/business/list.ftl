[@override name="title"]采购销售列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            发行管理
            <small>采购销售列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/business/list"><i class="fa fa-tasks"></i> 发行管理</a></li>
            <li class="active">采购销售列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/business/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="productId">产品编号:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="productId" name="productId" placeholder="产品编号"
                               value="${business.productId}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="productName">产品名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="productName" name="productName" placeholder="产品名称"
                               value="${business.productName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/business/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>产品编号</th>
                    <th>产品名称</th>
                    <th>产品规格</th>
                    <th>单位</th>
                    <th>数量</th>
                    <th>单价</th>
                    <th>折扣率</th>
                    <th>税率</th>
                    <th>税额</th>
                    <th>类型</th>
                    <th>金额</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as data]
                            <tr>
                                <td>${data_index + 1}</td>
                                <td>${data.productId}</td>
                                <td>${data.productName}</td>
                                <td>${data.productStyle}</td>
                                <td>${data.unit}</td>
                                <td>${data.num}</td>
                                <td>${data.price}</td>
                                <td>${data.discount}</td>
                                <td>${data.taxRate}</td>
                                <td>${data.amountOfTax}</td>
                                <td>${(data.type.getName())!}</td>
                                <td>${data.amount}</td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/business/view/${data.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/business/edit/${data.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/business/delete/${data.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/business/list?productId=${business.productId}&productName=${business.productName}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]