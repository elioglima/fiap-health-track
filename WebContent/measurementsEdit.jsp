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
	UserBloodPressureModel userBloodPressure = (UserBloodPressureModel) request.getSession().getAttribute("userBloodPressure");	
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        <form class="form" action="edit" method="POST">
        	<div class="homeText ">
	        	<div class="homeTextTitle">
    	        	<div class="name">Registro de Medições</div>    	        
        		</div>
           		
            	<div class="row">
    	        	<div class="label-text">Mínimo</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" name="valueMin" value="<% out.println(userBloodPressure.getValueMin()); %>">
    	        	</div>
        		</div>
        		
        		<div class="row">
    	        	<div class="label-text">Máximo</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" name="valueMax" value="<% out.println(userBloodPressure.getValueMax()); %>">
    	        	</div>
        		</div>
        		
        		<div class="row mb50">
    	        	<div class="label-text">Batimentos</div>    	        
    	        	<div class="label-value">
    	        		<input type="text" name="valueBeats" value="<% out.println(userBloodPressure.getValueBeats()); %>">
    	        	</div>
        		</div>
			           
        </div>
        
        	<div class='homeButton mt50'>        
            	<button class="cancel" type="button" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Cancelar</button>
            	<button class='save' type="submit" >Salvar</button>            
        	</div>
        </form>
    </div>
</body>

</html>