<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> New Document </title>
   <script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
   <script type="text/javascript">
		$(document).ready(function(){    
			$("#button").click(function(){      
				//将form1表单域的值转换为请求参数   
				var params = $("#form1").serialize();  
				params = decodeURIComponent(params,true);
				$("#show").html(params); 
				$.ajax({   
					type:"post",   
					url: '${pageContext.request.contextPath}/post_jquery_form',      
					async:true,   
					data:params,   
					success:function(form1){ 
					    $("#show2").html(form1.field1+','+form1.field2+','+form1.field3); 
					}   
				});   
			});    
		});         
   </script>      
 </head>
 <body>
  <form id="form1" name="form1" method="post">     
    <INPUT TYPE="text" name="field1" id="field1" value="${form1.field1}"/><br>     
    <INPUT TYPE="text" name="field2" id="field2" value="${form1.field2}"/><br>     
    <INPUT TYPE="text" name="field3" id="field3" value="${form1.field3}"/><br>     
    <INPUT TYPE="button" value="提交" id="button"/>     
    </form>     
    <div id="show"> 
    </div>     
    <div id="show2"> 
    </div>     
    <div id="show">
    ${IP}
    ${User}
    ${requestClass}
    ${requestCookies[0]}
    ${requestContextPath}
    </div>     
 </body>
</html>
