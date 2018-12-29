<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">

</head>
<body style="background-color: #cbcbcb">
<div id="articleModalContent" style="width:30%;margin: 10% auto;">
    <div class="x_panel">
        <div class="x_title">
            <h2>登陆工作室</h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <!--                                form!                            -->
            <form method="post" action="/user/login" class="form-horizontal form-label-left input_mask"><br>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-2">用户名</label>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <input  type="text" class="form-control" name="username"
                               placeholder="用户名">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-md-4 col-sm-4 col-xs-2">密码</label>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <input type="password" class="form-control" name="password"
                               placeholder="密码">
                    </div>
                </div><br>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-4">
                        <input type="submit" class="btn btn-success" value="登陆">
                        <a class="btn btn-primary" href="register.register.js[">注册</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>