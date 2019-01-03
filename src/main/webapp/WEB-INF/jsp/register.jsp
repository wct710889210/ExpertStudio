<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <!-- Bootstrap -->
    <link href="/data/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/data/build/css/custom.min.css" rel="stylesheet">

</head>
<body style="background-color: #cbcbcb">
<div id="articleModalContent" style="width:30%;margin: 10% auto;">
    <div class="x_panel">
        <div class="x_title">
            <h2>注册工作室</h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <!-- ----------------------------------------------form -->
            <form method="post" action="/user/register" class="form-horizontal form-label-left input_mask"><br>

                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-2">用户名</label>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <!-------------------------------------------------username-->
                        <input  name="username" id="username" placeholder="用户名" type="text" class="form-control">
                    </div>
                </div><br>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-2">昵称</label>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <!-------------------------------------------------name-->
                        <input  name="name" id="name" placeholder="昵称" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-2">密码</label>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <!-------------------------------------------------password-->
                        <input name="password" id="password" type="password" class="form-control" placeholder="密码">
                    </div>
                </div><br>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-4">
                        <input type="submit" class="btn btn-success" value="注册">
                        <a class="btn btn-primary" href="login.login.jsp">登陆</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>