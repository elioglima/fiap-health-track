<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Início</title>    
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/theme.css">
</head>
<body>

    <div class="accessBackground"></div>
    <div class="accessBase">
        <div class="accessTitle">Health Track</div>
        <div class="accessAddress">Sabe que dia é hoje? O de começar a seguir com as metas.</div>
        <div class="accessForm">
        	<form action="login" method="POST">            
                <input type="text" name="mail" class="mail" placeholder="Endereço de e-mail" value="elio.designer@hotmail.com">
                <input type="password" name="password" class="password" placeholder="Senha de Acesso" value="Ab@102030">
                <div>
                    <a href="#">Esqueci minha senha</a>
                </div>

                <button class='info'>Entrar</button>
            </form>

            <div>
                <a href="#">Não possuo uma conta</a>
            </div>
        </div>

    </div>
</body>

</html>