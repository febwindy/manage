[@override name="title"]发稿单创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            编务管理
            <small>发稿单创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/manuscript/list"><i class="fa fa-edit"></i> 编务管理</a></li>
            <li class="active">发稿单创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/manuscript/create" method="post">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">稿单号:</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" class="form-control" placeholder="稿单号" required="true"
                               value="${manuscript.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-9">
                        <input type="text" name="author" class="form-control" placeholder="作者" required="true"
                               value="${manuscript.author}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="count" class="col-sm-2 control-label">字数:</label>
                    <div class="col-sm-9">
                        <input type="text" name="count" class="form-control" placeholder="字数" required="true"
                               value="${manuscript.count}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="page" class="col-sm-2 control-label">页数:</label>
                    <div class="col-sm-9">
                        <input type="text" name="page" class="form-control" placeholder="页数" required="true"
                               value="${manuscript.page}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">通讯地址:</label>
                    <div class="col-sm-9">
                        <input type="date" name="address" class="form-control" placeholder="通讯地址" required="true"
                               value="${manuscript.address}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="opinion" class="col-sm-2 control-label">审核意见:</label>
                    <div class="col-sm-9">
                        <input type="text" name="opinion" class="form-control" placeholder="审核意见" required="true"
                               value="${manuscript.opinion}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="editor" class="col-sm-2 control-label">责编:</label>
                    <div class="col-sm-9">
                        <input type="text" name="editor" class="form-control" placeholder="责编" required="true"
                               value="${manuscript.editor}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="principal" class="col-sm-2 control-label">经办人:</label>
                    <div class="col-sm-9">
                        <input type="text" name="principal" class="form-control" placeholder="经办人" required="true"
                               value="${manuscript.principal}"/>
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
                            <a href="/manuscript/list" class="btn btn-block btn-danger">返回</a>
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