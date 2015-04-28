[@override name="title"]采购销售创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            发行管理
            <small>采购销售创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/business/list"><i class="fa fa-tasks"></i> 发行管理</a></li>
            <li class="active">采购销售创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/business/create" method="post">

                <div class="form-group">
                    <label for="productId" class="col-sm-2 control-label">产品编号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productId" class="form-control" placeholder="产品编号" required="true"
                               value="${business.productId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productName" class="col-sm-2 control-label">产品名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productName" class="form-control" placeholder="产品名称" required="true"
                               value="${business.productName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="productStyle" class="col-sm-2 control-label">产品规格:</label>
                    <div class="col-sm-9">
                        <input type="text" name="productStyle" class="form-control" placeholder="产品规格" required="true"
                               value="${business.productStyle}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="unit" class="col-sm-2 control-label">单位:</label>
                    <div class="col-sm-9">
                        <input type="text" name="unit" class="form-control" placeholder="单位" required="true"
                               value="${business.unit}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="num" class="col-sm-2 control-label">数量:</label>
                    <div class="col-sm-9">
                        <input type="text" name="num" class="form-control" placeholder="数量" required="true"
                               value="${business.num}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">单价:</label>
                    <div class="col-sm-9">
                        <input type="text" name="price" class="form-control" placeholder="单价" required="true"
                               value="${business.price}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="discount" class="col-sm-2 control-label">折扣率:</label>
                    <div class="col-sm-9">
                        <input type="text" name="discount" class="form-control" placeholder="折扣率" required="true"
                               value="${business.discount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="taxRate" class="col-sm-2 control-label">税率:</label>
                    <div class="col-sm-9">
                        <input type="text" name="taxRate" class="form-control" placeholder="税率" required="true"
                               value="${business.taxRate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="amountOfTax" class="col-sm-2 control-label">税额:</label>
                    <div class="col-sm-9">
                        <input type="text" name="amountOfTax" class="form-control" placeholder="税额" required="true"
                               value="${business.amountOfTax}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="amount" class="col-sm-2 control-label">金额:</label>
                    <div class="col-sm-9">
                        <input type="text" name="amount" class="form-control" placeholder="金额" required="true"
                               value="${business.amount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">类型:</label>
                    <div class="col-sm-9">
                        <select name="type" id="type" class="form-control" required="true">
                            [#assign type="${business.type}" /]
                            <option value="">请选择</option>
                            <option value="MERCHANT" [@mc.selected type "MERCHANT"/]>商户</option>
                            <option value="CAPABILITY" [@mc.selected type "CAPABILITY"/]>能力</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="customerId" class="col-sm-2 control-label">商户能力:</label>
                    <div class="col-sm-9">
                        <select id="customerId" name="customerId" class="form-control" required="true">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${business.remark}"/>
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
                            <a href="/business/list" class="btn btn-block btn-danger">返回</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script>
    $("#type").bind("change", function(){
        $("#customerId").empty();
        var customer = $("#type").val();
        $.ajax({
            type: "get",
            url: "/customer/get_by_type",
            data: {type : customer},
            success: function(data){
                $("#customerId").append("<option value=''>请选择</option>")
                $.each(data, function(a, b){
                    $("#customerId").append("<option value='" + b.id + "'>"+ b.name + "</option>")
                });
            }
        });
    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]