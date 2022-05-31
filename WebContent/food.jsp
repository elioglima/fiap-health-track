<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="br.fiap.healthtrack.model.*" %>
<%@page import="java.util.ArrayList" %>
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
	@SuppressWarnings("unchecked")
	ArrayList<TypeFoodConsumedModel> listTypeFoodConsumed = (ArrayList<TypeFoodConsumedModel>) request.getSession().getAttribute("listTypeFoodConsumed");
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        
        <div class="homeText noBorder ">
	        <div class="homeTextTitle">
    	        <div class="name">Alimentos Consumidos</div>    	        
        	</div>
        	
        	<div class="grid">
	          	<div class="grid-title">
	   	        	<div class="grid-col w25p">Data</div>    	        
	   	        	<div class="grid-col w25p">Tipo</div>
	   	        	<div class="grid-col w25p">Qtde</div>
	   	        	<div class="grid-col w25p">Calorias</div>
	       		</div>
	       		<div class="grid-box-collumn">
	       			<% for(TypeFoodConsumedModel value : listTypeFoodConsumed) { %>
		       			<div class="grid-row">
			   	        	<div class="grid-col w25p"><% out.print(value.getAtUpdate()); %></div>    	        
			   	        	<div class="grid-col w25p"><% out.print(value.getDescription()); %></div>
			   	        	<div class="grid-col w25p"><% out.print(value.getQtde()); %></div>
			   	        	<div class="grid-col w25p"><% out.print(value.getValueCalorie()); %></div>
			       		</div>
					<%}%>
		       	</div>
	       	</div>  
        </div>
        <div class='homeButton mt50'>        
            <button class="cancel" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Voltar</button>
            <button class='save' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/food/edit")); %>'" >Adicionar</button>            
        </div>
    </div>
</body>
</html>