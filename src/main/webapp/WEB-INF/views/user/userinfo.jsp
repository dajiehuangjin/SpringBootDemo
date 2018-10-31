<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>userInfo</title>

</head>

<body>
<h1>用户信息</h1>
<a href="<%=basePath%>user/users">返回</a>
<table>
    <tr>
        <td>昵称： </td>
        <td>${userInfo.nick_name }</td>
    </tr>
    <tr>
        <td>用户id： </td>
        <td>${userInfo.id }</td>
    </tr>
    <tr>
        <td>用户电话： </td>
        <td>${userInfo.telephone }</td>
    </tr>
    <tr>
        <td>注册时间： </td>
        <td><fmt:formatDate value="${userInfo.register_time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
    <tr>
        <td>角色：</td>
        <td>
            <c:forEach items="${userInfo.acctUserRoles }" var="userRole">
                ${userRole.acctRole.name }&nbsp;&nbsp;权限[
                <c:set var="auth" value=""/>
                <c:forEach items="${userRole.acctRole.acctRoleAuthorities }" var="roleAuthority">
                    <c:if test="${not empty auth }">
                        <c:set var="auth" value="${auth }|"/>
                    </c:if>
                    <c:set var="auth" value="${auth }${roleAuthority.acctAuthority.name }"/>
                </c:forEach>
                <c:out value="${auth }"/>
                <c:remove var="auth"/>
                ]
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>

