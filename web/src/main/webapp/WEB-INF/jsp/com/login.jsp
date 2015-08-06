<%--
  Created by IntelliJ IDEA.
  User: dqf
  Date: 2015/7/22
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="zh-CN"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="zh-CN"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="zh-CN"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
  <base href="http://localhost/">
  <title>Login</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <link href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css" rel="stylesheet">
  <link href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
  <link href="http://localhost/static/css/jx.main.css" rel="stylesheet">
  <!-- jQuery scrollUp 2.0-->
  <link id="scrollUpTheme" rel="stylesheet" href="http://markgoodyear.com/labs/scrollup/css/themes/image.css">
  <script src="http://cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
  <style>
    *{margin:0;padding: 0;}
    body{
      background: #444 url(http://sandbox.runjs.cn/uploads/rs/418/nkls38xx/carbon_fibre_big.png);
      font-family:"宋体";
    }
    .loginBox{
      width:420px;
      height:280px;
      padding:0 20px;
      border:1px solid #fff;
      color:#000;
      margin-top:40px;
      border-radius:8px;
      background: white;
      box-shadow:0 0 15px #222;
      background: -moz-linear-gradient(top, #fff, #efefef 8%);
      background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));
      font:11px/1.5em 'Microsoft YaHei' ;
      position: absolute;
      left:50%;
      top:50%;
      margin-left:-210px;
      margin-top:-165px;
    }
    .loginBox h2{
      height:45px;
      font-size:20px;
      font-weight:normal;
    }
    .loginBox .left{
      border-right:1px solid #ccc;
      height:100%;
      padding-right: 20px;
    }
    .regBtn{
      margin-top:21px;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="loginBox row">
    <h2 class="text-center">Login</h2>
    <form id="login_form" name="login_form" action="<%=basePath%>com/login.action" method="post" class="form-horizontal">
      <div class="form-group has-success">
        <label for="userName" class="col-sm-2 col-md-2 control-label">UserName</label>
        <div class="col-sm-10 col-md-10">
          <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" value="">
        </div>
      </div>
      <div class="form-group has-success">
        <label for="psw" class="col-sm-2 col-md-2 control-label">Password</label>
        <div class="col-sm-10 col-md-10">
          <input type="password" class="form-control" id="psw" name="psw" placeholder="Password">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-4 col-sm-10" style="color: #990033;"></div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-4 col-sm-10 col-md-10">
          <button class="btn btn-info" data-loading-text="Logging..." type="submit">Login</button>
              <button class="btn btn-info" type="reset">Clear</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--.content-->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

</body>
</html>
