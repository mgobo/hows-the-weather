<%-- 
    Document   : index
    Created on : 10/11/2019, 17:30:19
    Author     : mateusgobo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hows the Weather</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <h1>How's the weather</h1>
            <div class="row">
                <div class="col-xl-12">C&oacute;digo:</div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <input type="number" style="width: 100%" id="code" name="code" /> 
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12" style="margin-top: 1%;">
                    <input type="button" value="Consultar" class="float-right" onclick="search();" />
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12" id="result" style="margin-top: 1%">
                    
                </div>
            </div>
        </div>
    </body>
    <script src="resources/js/jquery-3.4.1.js"></script>
    <script src="resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
        function search(){
            var code = $("#code").val();
            if(code === undefined || code === ''){
                alert('Preencha o campo com o código...');
                $("#code").focus();
            }else{
                $.ajax({
                    type: 'GET',
                    url: "http://localhost:8081/howstheweather/search/"+code,
                    crossDomain: true
                }).done(function(data){
                    var result   = JSON.parse(data.result);
                    var textJSON = JSON.stringify(result);
                    $("#result").empty();
                    $("#result").append(textJSON);
                }).fail(function(jqXHR, textStatus){
                    console.log(textStatus);
                });
            }
        }
    </script>
</html>
