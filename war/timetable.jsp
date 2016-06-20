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
		<!--
		function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].className +'</td></tr>';
                res += '<tr><td>' + json[0].teacher +'</td></tr>';
                res += '<tr><td>' + json[0].explanation +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                	if(json[i].student===json[i].loginId){
                		res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                	    res += '<td>' + json[i].className + '</td>' +
           			    '<td>' + json[i].teacher+' </td>' +
                    	'<td>' + json[i].term+' </td>' +
                    	'<td>' + json[i].week+ json[i].period+' </td>' +
             	        '<td>' + json[i].credit+' </td>' +
                	    '<td>' + json[i].explanation +'</td></tr>'
                	    }   
                }               
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
       	 }
        </script>
</head>
	<body onload="getData(null);">
		<h1>あなたの登録した科目</h1>
	<br>
	<a href="main.jsp">メニューへ</a>
	<br>
	<a href="/search">授業を選択する</a>
	<br><br>
	<table id="datatable" border="1">
		<tr>
			<td>wait...</td>
		</tr>
	</table>
	<br>
	  <p><img src = 'http://2.bp.blogspot.com/-xe_c9i7r7x4/VyNc2AkGMMI/AAAAAAAA6JA/IjziMtBmazka4StP2TctJ5PQ0YAv2lq5ACLcB/s800/religion_keiji_man.png' width = '200' height = '200' alt = '時間割' align = 'left' border = '0'></p>
	<div>
	</div>
</body>
</html>