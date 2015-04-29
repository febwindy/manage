[@override name="title"]图书出库查看[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            物流管理
            <small>图书出库查看</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/delivery/list"><i class="fa fa-truck"></i> 物流管理</a></li>
            <li class="active">图书出库查看</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <div role="form" class="form-horizontal">

                <div class="form-group">
                    <label for="deliverygId" class="col-sm-2 control-label">出库编号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="deliverygId" class="form-control" placeholder="出库编号" readonly
                               value="${delivery.deliveryId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="supplier" class="col-sm-2 control-label">供应商:</label>
                    <div class="col-sm-9">
                        <input type="text" name="supplier" class="form-control" placeholder="供应商" readonly
                               value="${delivery.supplier}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="style" class="col-sm-2 control-label">出库方式:</label>
                    <div class="col-sm-9">
                        <input type="text" name="style" class="form-control" placeholder="出库方式" readonly
                               value="${delivery.style}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="deliveryDate" class="col-sm-2 control-label">出库日期:</label>
                    <div class="col-sm-9">
                        <input type="date" name="deliveryDate" class="form-control" placeholder="出库日期" readonly
                               value="${delivery.deliveryDate?date}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productId" class="col-sm-2 control-label">图书编号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productId" class="form-control" placeholder="图书编号" readonly
                               value="${delivery.productId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productName" class="col-sm-2 control-label">图书名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productName" class="form-control" placeholder="图书名称" readonly
                               value="${delivery.productName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productType" class="col-sm-2 control-label">图书类型:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productType" class="form-control" placeholder="图书类型" readonly
                               value="${delivery.productType}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="isbn" class="col-sm-2 control-label">ISBN:</label>
                    <div class="col-sm-9">
                        <input type="text" name="isbn" class="form-control" placeholder="ISBN" readonly
                               value="${delivery.isbn}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-9">
                        <input type="text" name="author" class="form-control" placeholder="作者" readonly
                               value="${delivery.author}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="press" class="col-sm-2 control-label">出版社:</label>
                    <div class="col-sm-9">
                        <input type="text" name="press" class="form-control" placeholder="出版社" readonly
                               value="${delivery.press}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="storeAddress" class="col-sm-2 control-label">出库地址:</label>
                    <div class="col-sm-9">
                        <input type="text" name="storeAddress" class="form-control" placeholder="出库地址" readonly
                               value="${delivery.storeAddress}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="num" class="col-sm-2 control-label">出库数量:</label>
                    <div class="col-sm-9">
                        <input type="text" name="num" class="form-control" placeholder="出库数量" readonly
                               value="${delivery.num}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">出库价格:</label>
                    <div class="col-sm-9">
                        <input type="text" name="price" class="form-control" placeholder="出库价格" readonly
                               value="${delivery.price}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="totalAmount" class="col-sm-2 control-label">出库总额:</label>
                    <div class="col-sm-9">
                        <input type="text" name="totalAmount" class="form-control" placeholder="出库总额" readonly
                               value="${delivery.totalAmount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="principal" class="col-sm-2 control-label">经办人:</label>
                    <div class="col-sm-9">
                        <input type="text" name="principal" class="form-control" placeholder="经办人" readonly
                               value="${delivery.principal}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" readonly
                               value="${delivery.remark}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="col-sm-offset-8 col-sm-4">
                            <a href="/delivery/create" class="btn btn-block bg-olive">创建</a>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-4">
                            <a href="/delivery/list" class="btn btn-block btn-danger">返回</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]