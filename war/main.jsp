<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style>
                title{font-size: 30pt; font-synthesis:weight; color: magenta;}
                h1{font-size: 20pt; font-synthesis: weight; color:magenta;}
                body{background: ivory}
            </style>
        <title>履修登録</title>
    </head>
    <body>
        <h1>メニュー</h1>
        <ul>     
            <form method="post" action="/users">
            	<td>
                	<input type="submit" value="ログアウト" style="width:100px; height:80px; font-size: 15pt;">
            	</td>
        	</form>
            <li><a href ="search">検索</a></li>
            <li><a href ="timetable.jsp">時間割表示</a></li>
        </ul>
    </body>
</html>
