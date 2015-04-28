[@override name="title"]合同创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>合同创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/contact/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">合同创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/contact/create" method="post">

                <div class="form-group">
                    <label for="contactId" class="col-sm-2 control-label">合同号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="contactId" class="form-control" placeholder="合同号" required="true"
                               value="${contact.contactId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="page" class="col-sm-2 control-label">图书页数:</label>
                    <div class="col-sm-9">
                        <input type="text" name="page" class="form-control" placeholder="图书页数" required="true"
                               value="${contact.page}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="discount" class="col-sm-2 control-label">折扣率:</label>
                    <div class="col-sm-9">
                        <input type="text" name="discount" class="form-control" placeholder="折扣率" required="true"
                               value="${contact.discount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-9">
                        <input type="text" name="author" class="form-control" placeholder="作者" required="true"
                               value="${contact.author}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="manuscriptOutDate" class="col-sm-2 control-label">交稿日期:</label>
                    <div class="col-sm-9">
                        <input type="date" name="manuscriptOutDate" class="form-control" placeholder="交稿日期" required="true"
                               value="${contact.manuscriptOutDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">出版地址:</label>
                    <div class="col-sm-9">
                        <input type="text" name="address" class="form-control" placeholder="出版地址" required="true"
                               value="${contact.address}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">合同类型:</label>
                    <div class="col-sm-9">
                        <select name="type" class="form-control">
                            [#assign type="${contact.type}" /]
                            <option value="PUB" [@mc.selected type "PUB"/]>出版合同</option>
                            <option value="COMMISSION" [@mc.selected type "COMMISSION"/]>约稿合同</option>
                            <option value="COPYRIGHT" [@mc.selected type "COPYRIGHT"/]>版权贸易合同</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${contact.remark}"/>
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
                            <a href="/contact/list" class="btn btn-block btn-danger">返回</a>
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