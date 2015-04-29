<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");%>
</head>
<body>
    <div>
        <form action="login"> <!-- method="post" -->
            <input type="text" name="username">
            <input type="text" name="password">
            <input type="submit" value="提交">
        </form>
    </div>
    <div>
        <form action="JqueryUIAutocomplete">
            <input type="submit" value="JqueryUIAutocomplete">
        </form>
    </div>
    <div>
        <form action="get_person">
            <input type="submit" value="get_person">
        </form>
    </div>
    <div>
        <form action="jquery_form">
            <input type="submit" value="jquery_form">
        </form>
    </div>
    <div>
        <form action="ichartjs">
            <input type="submit" value="ichartjs">
        </form>
    </div>
    <div>
        <form action="echarts">
            <input type="submit" value="echarts">
        </form>
    </div>
    
</body>
</html>