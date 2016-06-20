<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>
        title{font-size: 30pt; font-synthesis:weight; color: magenta;}
        h1{font-size: 20pt; font-synthesis: weight; color:magenta;}
        body{background: ivory}
    </style>
<title>履修登録</title>
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
					if(json[i].student===""){
                	res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td>' + json[i].className + '</td>' +
                    '<td>' + json[i].teacher+' </td>' +
                    '<td>' + json[i].term+' </td>' +
                    '<td>' + json[i].week+ json[i].period+' </td>' +
                    '<td>' + json[i].credit+' </td>' +
                    '<td>' + json[i].explanation +'</td>'+
                    '<td><a href ="add.html?id='+json[i].id + '">登録</a></td></tr>'
                    }
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        </script>
</head>
<body onload="getData(null);">
	<h1>授業を選択する</h1>
	<p><img src = 'http://4.bp.blogspot.com/-b7y2k5-3YPY/UPzH8PJ65gI/AAAAAAAAKz8/-c9-RIs0iPg/s1600/books.png' width = '130' height = '130' align = 'middle' border = '0'></p>
	<a href="main.jsp">メニューへ</a>
	<br>
	<a href="timetable.jsp">自分の登録した科目を見る</a>
	<br>
	<a href="search.jsp">授業を選択する</a>
	<br><br>
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