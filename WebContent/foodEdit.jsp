<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="br.fiap.healthtrack.model.*" %>
<%@page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	UserFoodConsumedModel userFoodConsumed = (UserFoodConsumedModel) request.getSession().getAttribute("userFoodConsumed");
	@SuppressWarnings("unchecked")
	ArrayList<TypeFoodConsumedModel> listTypeFoodConsumed = (ArrayList<TypeFoodConsumedModel>) request.getSession().getAttribute("listTypeFoodConsumed");
%>

<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        
        <form class="form" action="<%=request.getContextPath() %>/food/edit" method="POST">
        	<div class="homeText">
	        	<div class="homeTextTitle">
    	        	<div class="name">Registrando Consumo de Alimento</div>    	        
        		</div>           		
           		<div class="row">
    	        	<div class="label-text">Tipo</div>    	        
    	        	<div class="label-value w50p">
	    	        	<select id="typeConsumedId" name="typeConsumedId" >
	        				<% for(TypeFoodConsumedModel value : listTypeFoodConsumed) { %>  
	  							<option value="<% out.print(value.getId()); %>"><% out.print(value.getDescription()); %></option>
							<%}%>
	    	        	</select>    	        		
    	        	</div>
        		</div>        		
            	<div class="row">
    	        	<div class="label-text">Qtde</div>    	        
    	        	<div class="label-value w50p">
    	        		<input type="number" class="w100perc" name="qtde" value="<% out.println(userFoodConsumed.getQtde()); %>">
    	        	</div>
        		</div>			           
        	</div>        
        	<div class='homeButton'>        
            	<button class="cancel" type="button" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/exercises")); %>'">Cancelar</button>
            	<button class='save' type="submit" >Salvar</button>            
        	</div>
        </form>
    </div>
</body>
</html>