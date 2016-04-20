<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <title>首页</title>
    <script type="text/javascript" src="<%=path%>/jslib/jquery-1.9.1.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/jslib/jquery-1.9.1.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/jslib/Math.uuid.js" charset="utf-8"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#kaptchaImage").click(function(){
    			$(this).attr("src", "validate.code?" + Math.floor(Math.random()*100));
    		});
    	});
    </script>
  </head>
  
  <body>
  		<form action="/SpringMvc/hello/result.do" method="post">
  			<img id="kaptchaImage" src="validate.code" />
  			<input type="text" name="validateCode" value="" />
  			<input type="submit" value="提交表单">
  		</form>
  </body>
  
</html>
