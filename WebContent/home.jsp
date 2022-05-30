<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="br.fiap.healthtrack.model.*" %>
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
	UserModel user = (UserModel) request.getSession().getAttribute("user");	
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>
        <div class='homePhoto'>
            <img src="assets/homePhoto.png" >
        </div>
        <div class="homeText">
	        <div class="homeTextTitle">
    	        <div class="name"><% out.println(user.getName()); %></div>    	        
    	        <a class="button" href="profile/edit" >Editar Cadastro</a>
        	</div>
            <div class="homeTextName">
            	<div class="label">E-mail:</div>
            	<div class="value"><% out.println(user.getMail()); %></div>
			</div>
			<div class="homeTextName">
            	<div class="label">Telefone:</div>
            	<div class="value"><% out.println(user.getPhoneMobile()); %></div>
			</div>    
			<div class="homeTextName">
            	<a class="button" href="logout" >Sair</a>            	
			</div>           
        </div>
        
        <div class='homeButton'>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/exercises")); %>'">Exercícios</button>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/food/edit")); %>'">Alimentação</button>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/measurements/edit")); %>'">Medições</button>
        </div>
        
        <div class="featureSummary">
        	<div class="title">
    	        <div class="primary">Resumo</div>
        	</div>
	        <div class="title">
    	        <div class="name">Exercícios</div>
        	</div>
            <div class="title">
            	<div class="name">Atividades</div>            	
			</div>
			<div class="title">
            	<div class="name">Medições</div>            	
			</div>     
        </div>

        

    </div>
    <script src="tools/site.js"></script>
</body>

</html>