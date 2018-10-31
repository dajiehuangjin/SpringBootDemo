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
    <script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
    <title>用户列表</title>

</head>

<body>
    <table>
        <colgroup>
            <col width="100">
            <col width="300">
            <col width="200">
            <col width="200">
            <col width="300">
        </colgroup>
        <thead>
        <tr>
            <th>昵称</th>
            <th>用户id</th>
            <th>用户电话</th>
            <th>注册时间</th>
            <th>角色</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="userInfo">
                <tr>
                    <td><a href="<%=basePath%>user/id/${userInfo.id}">${userInfo.nick_name}</a></td>
                    <td><a href="<%=basePath%>user/id/${userInfo.id}">${userInfo.id}</a></td>
                    <td>${userInfo.telephone}</td>
                    <td><fmt:formatDate value="${userInfo.register_time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    <td>
                        <c:forEach items="${userInfo.acctUserRoles}" var="userRole">
                            ${userRole.acctRole.name} 权限：
                            <c:forEach items="${userRole.acctRole.acctRoleAuthorities}" var="roleAuthority">
                                【${roleAuthority.acctAuthority.name}】
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
