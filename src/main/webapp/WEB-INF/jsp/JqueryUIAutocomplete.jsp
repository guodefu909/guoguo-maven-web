<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>jQuery UI Autocomplete - Default functionality</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/jquery.ui.all.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.core.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.widget.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.position.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.menu.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.autocomplete.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demos.css">
    <script>
    	var availableTags = [
             "ActionScript",
             "AppleScript",
             "Asp",
             "BASIC",
             "C",
             "C++",
             "Clojure",
             "COBOL",
             "ColdFusion",
             "Erlang",
             "Fortran",
             "Groovy",
             "Haskell",
             "Java",
             "JavaScript",
             "Lisp",
             "Perl",
             "PHP",
             "Python",
             "Ruby",
             "Scala",
             "Scheme"
         ];
    	function get_value( ) {
    	    $("#text1").val($("#tags").val());
        }
    	function a( request, response ) {
            $.ajax({
                url: "${pageContext.request.contextPath}/getperson/user",
                type : 'POST',
                dataType: "json",
                success : function (data) {
                        response(
                        		 $.map(data, function(item) {
                                     return {
                                         label: item.name + " - " + item.staffName,
                                         value: item.name
                                     };
                                 })
                        );
                }
            });
        }
	    $(function() {
	         $( "#tags" ).autocomplete({
	            source: a
	        }); 
	         $( "#tags2" ).autocomplete({
	             source: availableTags
	         }); 
	    });
    </script>
</head>
<body>

<div class="ui-widget">
    <label for="tags">Tags: </label>
    <input id="tags">
</div>
<div class="ui-widget">
    <label for="tags2">Tags: </label>
    <input id="tags2">
</div>
<input type="button" id="get_value" value="get_value" onclick="get_value();">
<input type="text" id="text1" name="" value="">
</body>
</html>
