<%-- 
    Document   : search
    Created on : 2015/12/16, 16:38:13
    Author     : g14911ih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>履修登録</title>
    <script type="text/javascript" src="lib.js"></script>
        <script type="text/javascript">
        <!--
        function initial(){
            var datas = getQuery();
            getData(datas.id);
        }
         
        function callback(request){
            var arr = eval(request.responseText);
            var data = arr[0];
            var msg = '<table border="1"><tr><td>' + data.className + '</td></tr>';
            msg += '<tr><td>' + data.teacher + '</td></tr>';
            msg += '<tr><td>' + data.explanation + '</td></tr></table>';
            document.getElementById("data").innerHTML = msg;
            document.getElementById("name").value = data.className;
        }
        //-->
        </script>
    </head>
    <body onload="initial();">
        <h1>授業を登録</h1>
        <div>以下のデータを登録しますか？</div>
        <div id="data"></div>
        <form method="post" action="add">
            <input type="hidden" id="name" name="name">
            <input type="submit" value="登録">
        </form>
        </body>
</html>
