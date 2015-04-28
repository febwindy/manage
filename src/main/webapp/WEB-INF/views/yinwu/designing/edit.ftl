[@override name="title"]选题修改[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            印务管理
            <small>选题修改</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/designing/list"><i class="fa fa-edit"></i> 印务管理</a></li>
            <li class="active">选题修改</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/designing/edit/${designing.id}" method="post">

                <div class="form-group">
                    <label for="part" class="col-sm-2 control-label">工作环节:</label>
                    <div class="col-sm-9">
                        <input type="text" name="part" class="form-control" placeholder="工作环节" required="true"
                               value="${designing.part}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="content" class="col-sm-2 control-label">工作内容:</label>
                    <div class="col-sm-9">
                        <input type="text" name="content" class="form-control" placeholder="工作内容" required="true"
                               value="${designing.content}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="thing" class="col-sm-2 control-label">工作情况:</label>
                    <div class="col-sm-9">
                        <input type="text" name="thing" class="form-control" placeholder="工作情况" required="true"
                               value="${designing.thing}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="department" class="col-sm-2 control-label">责任部门:</label>
                    <div class="col-sm-9">
                        <input type="text" name="department" class="form-control" placeholder="责任部门" required="true"
                               value="${designing.department}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="principal" class="col-sm-2 control-label">责任人:</label>
                    <div class="col-sm-9">
                        <input type="text" name="principal" class="form-control" placeholder="责任人" required="true"
                               value="${designing.principal}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="beginDate" class="col-sm-2 control-label">开始时间:</label>
                    <div class="col-sm-9">
                        <input type="date" name="beginDate" class="form-control" placeholder="开始时间" required="true"
                               value="${designing.beginDate?date}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="endDate" class="col-sm-2 control-label">结束时间:</label>
                    <div class="col-sm-9">
                        <input type="date" name="endDate" class="form-control" placeholder="结束时间" required="true"
                               value="${designing.endDate?date}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${designing.remark}"/>
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
                            <a href="/designing/list" class="btn btn-block btn-danger">返回</a>
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