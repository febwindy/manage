[@override name="title"]图书入库创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            物流管理
            <small>图书入库创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/warehousing/list"><i class="fa fa-truck"></i> 物流管理</a></li>
            <li class="active">图书入库创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/warehousing/create" method="post">

                <div class="form-group">
                    <label for="warehousingId" class="col-sm-2 control-label">入库编号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="warehousingId" class="form-control" placeholder="入库编号" required="true"
                               value="${warehousing.warehousingId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="supplier" class="col-sm-2 control-label">供应商:</label>
                    <div class="col-sm-9">
                        <input type="text" name="supplier" class="form-control" placeholder="供应商" required="true"
                               value="${warehousing.supplier}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="style" class="col-sm-2 control-label">入库方式:</label>
                    <div class="col-sm-9">
                        <input type="text" name="style" class="form-control" placeholder="入库方式" required="true"
                               value="${warehousing.style}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="warehousingDate" class="col-sm-2 control-label">入库日期:</label>
                    <div class="col-sm-9">
                        <input type="date" name="warehousingDate" class="form-control" placeholder="入库日期" required="true"
                               value="${warehousing.warehousingDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productId" class="col-sm-2 control-label">商品编号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productId" class="form-control" placeholder="商品编号" required="true"
                               value="${warehousing.productId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productName" class="col-sm-2 control-label">商品名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productName" class="form-control" placeholder="商品名称" required="true"
                               value="${warehousing.productName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productType" class="col-sm-2 control-label">商品类型:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productType" class="form-control" placeholder="商品类型" required="true"
                               value="${warehousing.productType}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="isbn" class="col-sm-2 control-label">ISBN:</label>
                    <div class="col-sm-9">
                        <input type="text" name="isbn" class="form-control" placeholder="ISBN" required="true"
                               value="${warehousing.isbn}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-9">
                        <input type="text" name="author" class="form-control" placeholder="作者" required="true"
                               value="${warehousing.author}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="press" class="col-sm-2 control-label">出版社:</label>
                    <div class="col-sm-9">
                        <input type="text" name="press" class="form-control" placeholder="出版社" required="true"
                               value="${warehousing.press}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="storeAddress" class="col-sm-2 control-label">存放地置:</label>
                    <div class="col-sm-9">
                        <input type="text" name="storeAddress" class="form-control" placeholder="存放地置" required="true"
                               value="${warehousing.storeAddress}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="num" class="col-sm-2 control-label">入库数量:</label>
                    <div class="col-sm-9">
                        <input type="text" name="num" class="form-control" placeholder="入库数量" required="true"
                               value="${warehousing.num}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">入库价格:</label>
                    <div class="col-sm-9">
                        <input type="text" name="price" class="form-control" placeholder="入库价格" required="true"
                               value="${warehousing.price}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="totalAmount" class="col-sm-2 control-label">入库总额:</label>
                    <div class="col-sm-9">
                        <input type="text" name="totalAmount" class="form-control" placeholder="入库总额" required="true"
                               value="${warehousing.totalAmount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="principal" class="col-sm-2 control-label">经办人:</label>
                    <div class="col-sm-9">
                        <input type="text" name="principal" class="form-control" placeholder="经办人" required="true"
                               value="${warehousing.principal}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${warehousing.remark}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-block bg-olive">创建</button>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-4">
                            <a href="/warehousing/list" class="btn btn-block btn-danger">返回</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]