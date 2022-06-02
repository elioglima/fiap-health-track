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
<%		
	String messageError = (String) request.getSession().getAttribute("messageError");
%>
<body>
	<div class="accessTec"></div>
    <div class="accessBackground"></div>
    <div class="accessBase">
        <div class="titleDefaultTop mb1em wd60perc">Health Track</div>
        <div class="subTitleTop">Sabe que dia é hoje? O de começar a seguir com as metas.</div>
        <div class="accessForm">
        	<form action="login" method="POST">            
                <input type="text" name="mail" placeholder="Endereço de e-mail" value="elio.designer@hotmail.com">
                <input type="password" name="password" class="password" placeholder="Senha de Acesso" value="Ab@102030">
                <div>
                    <a href="#" class="forgotMyPasswordLabel">Esqueci minha senha</a>
                </div>
                
                <% if (messageError != null) { %>
                	<div class="messageError">
                    	<% out.print(messageError); %>
                	</div>
                <% } %>

				
                <button class='info'>Entrar</button>
            </form>

            <div>
                <a href="#" class="registerLabel" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/register")); %>'" >Não possuo uma conta</a>
            </div>
        </div>

    </div>
    <div class="accessTec"></div>
</body>
</html>