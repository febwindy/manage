[@override name="title"]印刷修改[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>印刷修改</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/printing/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">印刷修改</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/printing/edit/${printing.id}" method="post">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">印刷名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" class="form-control" placeholder="印刷名称" required="true"
                               value="${printing.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="isbn" class="col-sm-2 control-label">ISBN:</label>
                    <div class="col-sm-9">
                        <input type="text" name="isbn" class="form-control" placeholder="ISBN" required="true"
                               value="${printing.isbn}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">印刷类型:</label>
                    <div class="col-sm-9">
                        <input type="text" name="type" class="form-control" placeholder="印刷类型" required="true"
                               value="${printing.type}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="paper" class="col-sm-2 control-label">纸张材料:</label>
                    <div class="col-sm-9">
                        <input type="text" name="paper" class="form-control" placeholder="纸张材料" required="true"
                               value="${printing.paper}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="paperType" class="col-sm-2 control-label">纸张类型:</label>
                    <div class="col-sm-9">
                        <input type="text" name="paperType" class="form-control" placeholder="纸张类型" required="true"
                               value="${printing.paperType}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="ink" class="col-sm-2 control-label">油墨类型:</label>
                    <div class="col-sm-9">
                        <input type="text" name="ink" class="form-control" placeholder="油墨类型" required="true"
                               value="${printing.ink}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="wrapper" class="col-sm-2 control-label">包装材料:</label>
                    <div class="col-sm-9">
                        <input type="text" name="wrapper" class="form-control" placeholder="包装材料" required="true"
                               value="${printing.wrapper}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="printNumber" class="col-sm-2 control-label">打印数量:</label>
                    <div class="col-sm-9">
                        <input type="text" name="printNumber" class="form-control" placeholder="打印数量" required="true"
                               value="${printing.printNumber}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${printing.remark}"/>
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
                            <a href="/printing/list" class="btn btn-block btn-danger">返回</a>
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