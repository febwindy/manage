[@override name="title"]图书出库[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            物流管理
            <small>图书出库</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/delivery/list"><i class="fa fa-truck"></i> 物流管理</a></li>
            <li class="active">图书出库</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/delivery/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="deliveryId">出库编号:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="deliveryId" name="deliveryId" placeholder="出库编号"
                               value="${delivery.deliveryId}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="isbn">ISBN:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="isbn" name="isbn" placeholder="ISBN"
                               value="${delivery.isbn}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="productName">图书名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="productName" name="productName" placeholder="图书名称"
                               value="${delivery.productName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/delivery/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>出库编号</th>
                    <th>供应商</th>
                    [#--<th>出库方式</th>--]
                    [#--<th>出库日期</th>--]
                    <th>图书编号</th>
                    <th>图书名称</th>
                    <th>图书类型</th>
                    <th>ISBN</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>出库地址</th>
                    [#--<th>出库数量</th>--]
                    [#--<th>出出库价格</th>--]
                    [#--<th>出库总额</th>--]
                    [#--<th>经办人</th>--]
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as delivery]
                            <tr>
                                <td>${delivery_index + 1}</td>
                                <td>${delivery.deliveryId}</td>
                                <td>${delivery.supplier}</td>
                                [#--<td>${delivery.style}</td>--]
                                [#--<td>${delivery.deliveryDate?date}</td>--]
                                <td>${delivery.productId}</td>
                                <td>${delivery.productName}</td>
                                <td>${delivery.productType}</td>
                                <td>${delivery.isbn}</td>
                                <td>${delivery.author}</td>
                                <td>${delivery.press}</td>
                                <td>${delivery.storeAddress}</td>
                                [#--<td>${delivery.num}</td>--]
                                [#--<td>${delivery.price}</td>--]
                                [#--<td>${delivery.totalAmount}</td>--]
                                [#--<td>${delivery.principal}</td>--]
                                <td>
                                    <a class="btn btn-success btn-sm" href="/delivery/view/${delivery.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/delivery/edit/${delivery.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/delivery/delete/${delivery.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/delivery/list?deliveryId=${delivery.deliveryId}&isbn=${delivery.isbn}&productName=${delivery.productName}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]