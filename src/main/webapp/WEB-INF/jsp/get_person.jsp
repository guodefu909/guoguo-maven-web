<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Json</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#profile").click(function() {
            profile();
        });
        $("#login").click(function() {
            login();
        });
    });
    function profile() {
        var url = "${pageContext.request.contextPath}/person/profile/";
        var query = $('#id').val() + '/' + $('#name').val() + '/'
                + $('#status').val();
        url += query;
        alert(url);
        $.get(url, function(data) {
            alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
                    + data.status);
        });
    }
    function login() {
        var mydata = '{"name":"' + $('#name').val() + '","id":"'
                + $('#id').val() + '","status":"' + $('#status').val() + '"}';
        alert("mydata："+mydata);
        $.ajax({
            type : 'POST',
            contentType : 'application/json',
            url : "${pageContext.request.contextPath}/person/login",
            processData : false,
            dataType : 'json',
            data : mydata,
            success : function(data) {
                alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
                        + data.status);
            },
            error : function() {
                alert('出错了！');
            }
        });

        //      $.post('http://localhost:8080/spring-json/json/person/login', {
        //          name : $('#name').val(),
        //          stats : $('#stats').val(),
        //          id : $('#id').val()
        //      }, function(data) {
        //          alert(data);
        //      });
    };

    //  $.fn.serializeObject = function() {
    //      var o = {};
    //      var a = this.serializeArray();
    //      $.each(a, function() {
    //          if (o[this.name]) {
    //              if (!o[this.name].push) {
    //                  o[this.name] = [ o[this.name] ];
    //              }
    //              o[this.name].push(this.value || '');
    //          } else {
    //              o[this.name] = this.value || '';
    //          }
    //      });
    //      return o;
    //  };
</script>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td><input id="id" value="100" /></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input id="name" value="snowolf" /></td>
        </tr>
        <tr>
            <td>status</td>
            <td><input id="status" value="true" /></td>
        </tr>
        <tr>
            <td><input type="button" id="profile" value="Profile——GET" /></td>
            <td><input type="button" id="login" value="Login——POST" /></td>
        </tr>
    </table>
</body>
</html>