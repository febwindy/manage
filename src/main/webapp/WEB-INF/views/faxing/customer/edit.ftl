[@override name="title"]商户与能力修改[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>商户与能力修改</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/customer/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">商户与能力修改</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/customer/edit/${customer.id}" method="post">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" class="form-control" placeholder="名称" required="true"
                               value="${customer.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="contact" class="col-sm-2 control-label">联系人:</label>
                    <div class="col-sm-9">
                        <input type="text" name="contact" class="form-control" placeholder="联系人" required="true"
                               value="${customer.contact}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="tel" class="col-sm-2 control-label">联第电话:</label>
                    <div class="col-sm-9">
                        <input type="text" name="tel" class="form-control" placeholder="联第电话" required="true"
                               value="${customer.tel}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="deliveryStyle" class="col-sm-2 control-label">交货方式:</label>
                    <div class="col-sm-9">
                        <input type="text" name="deliveryStyle" class="form-control" placeholder="交货方式" required="true"
                               value="${customer.deliveryStyle}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="deliveryDate" class="col-sm-2 control-label">交货日期:</label>
                    <div class="col-sm-9">
                        <input type="date" name="deliveryDate" class="form-control" placeholder="交货日期" required="true"
                               value="${customer.deliveryDate?date}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="deliveryAddress" class="col-sm-2 control-label">交货地址:</label>
                    <div class="col-sm-9">
                        <input type="text" name="deliveryAddress" class="form-control" placeholder="交货地址" required="true"
                               value="${customer.deliveryAddress}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">类型:</label>
                    <div class="col-sm-9">
                        <select name="type" class="form-control" required="true">
                            [#assign type="${customer.type}" /]
                            <option value="MERCHANT" [@mc.selected type "MERCHANT"/]>商户</option>
                            <option value="CAPABILITY" [@mc.selected type "CAPABILITY"/]>能力</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${customer.remark}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-block bg-olive">编辑</button>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-4">
                            <a href="/customer/list" class="btn btn-block btn-danger">返回</a>
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