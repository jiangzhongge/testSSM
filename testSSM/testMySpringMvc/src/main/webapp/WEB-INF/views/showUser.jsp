<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- jstl标签 --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!-- import jar -->
<%-- <%@ page language="java" import="com.jiang.seven.entity.*"  pageEncoding="UTF-8"%> --%>
<!-- import class -->
<%@ page language="java" import="com.jiang.seven.entity.*" %>
<%@ page language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>  <!-- el 表达式开关 true：关闭 false：打开 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
<% UserInfoVo userInfoVo = (UserInfoVo)request.getAttribute("user");out.print("------"+userInfoVo.getName()); %>
${user.name}
<br>
<%	out.println(request.getSession().getId()); %> <br>
<%	out.println(request.getSession().getAttributeNames().toString());
%><br>
<%	out.println(request.getCookies().length); 
	Cookie[] cookie = request.getCookies();
	for(int i=0;i<request.getCookies().length ; i++){
		out.println(cookie[i].getName()+"---"+cookie[i].getValue()+"==="+cookie[i].getDomain()+"==="+cookie[i].getComment()+"==="+cookie[i].getMaxAge());
%><br>	
<%} %>	
 <br>
<%	out.println(request.getHeaderNames()); %> <br>
<%	out.println(request.getUserPrincipal().getName()); %> <br>
</body>
</html>