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
	String messageError = (String) request.getSession().getAttribute("messageError");
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        <form class="form" action="edit" method="POST">
        	<div class="homeText">
	        	<div class="homeTextTitle">
    	        	<div class="name">Editar Perfil</div>    	        
        		</div>
           		
           		<div class="row">
    	        	<div class="label-text">Nome</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" class="w100perc" name="name" placeholder="informe seu nome completo" value="<% out.println(user.getName()); %>">
    	        	</div>
        		</div>
        		
            	<div class="row">
    	        	<div class="label-text">e-mail</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" class="w100perc" name="mail" placeholder="informe seu email" value="<% out.println(user.getMail()); %>">
    	        	</div>
        		</div>
        		
        		<div class="row">
    	        	<div class="label-text">Telefone</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" class="w100perc" name="phoneMobile" placeholder="informe seu telefone" value="<% out.println(user.getPhoneMobile()); %>">
    	        	</div>
        		</div>
           		    
			           
        </div>
           		<% if (messageError != null) { %>
                	<div class="messageError2">
                    	<% out.print(messageError); %>
                	</div>
                <% } %>
        
        	<div class='homeButton'>        
            	<button class="cancel" type="button" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Cancelar</button>
            	<button class='save' type="submit" >Salvar</button>            
        	</div>
        </form>
    </div>
</body>

</html>