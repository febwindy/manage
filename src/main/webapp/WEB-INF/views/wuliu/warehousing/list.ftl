[@override name="title"]图书入库[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            物流管理
            <small>图书入库</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/warehousing/list"><i class="fa fa-truck"></i> 物流管理</a></li>
            <li class="active">图书入库</li>
        </ol>
    </section>

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/warehousing/list" method="post">
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="warehousingId">入库编号:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="warehousingId" name="warehousingId" placeholder="入库编号"
                               value="${warehousing.warehousingId}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="isbn">ISBN:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="isbn" name="isbn" placeholder="ISBN"
                               value="${warehousing.isbn}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="productName">商品名称:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" class="form-control pull-left" id="productName" name="productName" placeholder="商品名称"
                               value="${warehousing.productName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                    <div class="col-sm-6 pull-right">
                        <a href="/warehousing/create" class="btn btn-success">创建</a>
                    </div>
                </div>
            </form>
            <br/>
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>入库编号</th>
                    <th>供应商</th>
                    [#--<th>入库方式</th>--]
                    [#--<th>入库日期</th>--]
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品类型</th>
                    <th>ISBN</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>存放地置</th>
                    [#--<th>入库数量</th>--]
                    [#--<th>入库价格</th>--]
                    [#--<th>入库总额</th>--]
                    [#--<th>经办人</th>--]
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as warehousing]
                            <tr>
                                <td>${warehousing_index + 1}</td>
                                <td>${warehousing.warehousingId}</td>
                                <td>${warehousing.supplier}</td>
                                [#--<td>${warehousing.style}</td>--]
                                [#--<td>${warehousing.warehousingDate?date}</td>--]
                                <td>${warehousing.productId}</td>
                                <td>${warehousing.productName}</td>
                                <td>${warehousing.productType}</td>
                                <td>${warehousing.isbn}</td>
                                <td>${warehousing.author}</td>
                                <td>${warehousing.press}</td>
                                <td>${warehousing.storeAddress}</td>
                                [#--<td>${warehousing.num}</td>--]
                                [#--<td>${warehousing.price}</td>--]
                                [#--<td>${warehousing.totalAmount}</td>--]
                                [#--<td>${warehousing.principal}</td>--]
                                <td>
                                    <a class="btn btn-success btn-sm" href="/warehousing/view/${warehousing.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/warehousing/edit/${warehousing.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/warehousing/delete/${warehousing.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/warehousing/list?warehousingId=${warehousing.warehousingId}&isbn=${warehousing.isbn}&productName=${warehousing.productName}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]