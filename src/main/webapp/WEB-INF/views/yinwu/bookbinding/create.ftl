[@override name="title"]装订创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>装订创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/bookbinding/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">装订创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/bookbinding/create" method="post">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">装订名称:</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" class="form-control" placeholder="装订名称" required="true"
                               value="${bookbinding.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="material" class="col-sm-2 control-label">装订材料:</label>
                    <div class="col-sm-9">
                        <input type="text" name="material" class="form-control" placeholder="装订材料" required="true"
                               value="${bookbinding.material}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="form" class="col-sm-2 control-label">装订形式:</label>
                    <div class="col-sm-9">
                        <input type="text" name="form" class="form-control" placeholder="装订形式" required="true"
                               value="${bookbinding.form}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="style" class="col-sm-2 control-label">装订方式:</label>
                    <div class="col-sm-9">
                        <input type="text" name="style" class="form-control" placeholder="装订方式" required="true"
                               value="${bookbinding.style}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="flow" class="col-sm-2 control-label">装订流程:</label>
                    <div class="col-sm-9">
                        <input type="text" name="flow" class="form-control" placeholder="装订流程" required="true"
                               value="${bookbinding.flow}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${bookbinding.remark}"/>
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
                            <a href="/bookbinding/list" class="btn btn-block btn-danger">返回</a>
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