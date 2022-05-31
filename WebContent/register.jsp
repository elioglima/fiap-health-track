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
	// UserModel user = (UserModel) request.getSession().getAttribute("user");
	String name = (String) request.getParameter("name");
	String mail = (String) request.getParameter("mail");
	String password = (String) request.getParameter("password");
	String passwordConfirm = (String) request.getParameter("passwordConfirm");
	
	String messageError = (String) request.getSession().getAttribute("messageError");
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        		<form class="form" action="register" method="POST">
        	<div class="homeText mb50">
	        	<div class="homeTextTitle">
    	        	<div class="name">Crie seu cadastro</div>    	        
        		</div>
        		
           		<div class="row">
    	        	<div class="label-text">Nome</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" name="name" placeholder="informe o nome" value="<% out.print(name); %>" autocomplete="new-password">
    	        	</div>
        		</div>
        		
            	<div class="row">
    	        	<div class="label-text">e-mail</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" name="mail" placeholder="informe o email" value="<% out.print(mail); %>" autocomplete="new-password">
    	        	</div>
        		</div>
        		
        		<div class="row">
    	        	<div class="label-text">Senha</div>    	        
    	        	<div class="label-value">
    	        		<input type="password" name="password" placeholder="informe a senha" value="<% out.print(password); %>" autocomplete="new-password">
    	        	</div>
        		</div>
        		
        		<div class="row mb50">
    	        	<div class="label-text">Confirmação</div>    	        
    	        	<div class="label-value" >
    	        		<input type="password" name="passwordConfirm" placeholder="confirme a senha" value="<% out.print(passwordConfirm); %>"  autocomplete="new-password">
    	        	</div>
        		</div>
           		    
			           
        </div>
        	<div class="messageError color1 ">
                    <% out.print(messageError); %>
                </div>
        
        	<div class='homeButton'>        
            	<button class="cancel" type="button" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Voltar</button>
            	<button class='save' type="submit" >Cadastrar</button>            
        	</div>
        </form>
    </div>
</body>

</html>