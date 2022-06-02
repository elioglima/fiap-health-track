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
        <div class="titleDefaultTop">
            <span class="colorBlack">Health Track</span>            
        </div>         
        
        <div class="homeText noBorder ">
	        <div class="homeTextTitle">
    	        <div class="name">Alimentos Consumidos</div>    	        
        	</div>
        	
        	<div class="grid">
	          	<div class="grid-title bgr1">
	   	        	<div class="grid-col-title w25p textLeft">Data</div>    	        
	   	        	<div class="grid-col-title w25p textLeft">Tipo</div>
	   	        	<div class="grid-col-title w25p textRight">Qtde</div>
	   	        	<div class="grid-col-title w25p textRight">Calorias</div>
	       		</div>
	       		<div class="grid-box-collumn">
	       			<% for(TypeFoodConsumedModel value : listTypeFoodConsumed) { %>
		       			<div class="grid-row">
		       				<div class="w100perc">
		       					<div class="grid-col-title2 textLeft">Data</div>
			   	        		<div class="grid-col w25p textLeft"><% out.print(value.getAtUpdate()); %></div>
			   	        	</div>    	        
			   	        	<div class="w100perc">
			   	        		<div class="grid-col-title2 textRight">Tipo</div>
			   	        		<div class="grid-col w25p textRight"><% out.print(value.getDescription()); %></div>
			   	        	</div>    	        
			   	        	<div class="w100perc">
			   	        		<div class="grid-col-title2 textRight">Minutos</div>
			   	        		<div class="grid-col w25p textRight"><% out.print(value.getQtde()); %></div>
			   	        	</div>    	        
			   	        	<div class="w100perc">
			   	        		<div class="grid-col-title2 textRight">Calorias</div>
			   	        		<div class="grid-col w25p textRight"><% out.print(value.getValueCalorie()); %></div>
			   	        	</div>
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