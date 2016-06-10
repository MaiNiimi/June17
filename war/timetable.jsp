<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>時間割表示</title>
<script type="text/javascript" src="lib.js"></script>
<script type="text/javascript">
        function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].className +'</td></tr>';
                res += '<tr><td>' + json[0].teacher +'</td></tr>';
                res += '<tr><td>' + json[0].explanation +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                	res += '<tr><td><a href="javascript:return false;" onclick="getData2(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td>' + json[i].className + '</td>' +
                    '<td>' + json[i].teacher+' </td>' +
                    '<td>' + json[i].explanation +'</td>'</tr>'
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        </script>
</head>
	<body onload="getData2(null);">
		<h1>あなたの時間割</h1>

	<br>
	<a href="main.jsp">メニューへ</a>
	<br>
	<br>
	<table id="datatable" border="1">
		<tr>
			<td>wait...</td>
		</tr>
	</table>
	<br>
	<div>
	</div>
</body>
</html>