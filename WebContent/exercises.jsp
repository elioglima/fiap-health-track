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
        
        <div class="homeText noBorder ">
	        <div class="homeTextTitle">
    	        <div class="name">Atividade Fisica</div>    	        
        	</div>
        	
        	<div class="grid">
	          	<div class="grid-title">
	   	        	<div class="grid-col w25p">Data</div>    	        
	   	        	<div class="grid-col w25p">Tipo</div>
	   	        	<div class="grid-col w25p">Minutos</div>
	   	        	<div class="grid-col w25p">Calorias</div>
	       		</div>
	       		<div class="grid-box-collumn">
		       		<div class="grid-row">
		   	        	<div class="grid-col w25p">01/05/2022 10:20</div>    	        
		   	        	<div class="grid-col w25p">Corrida</div>
		   	        	<div class="grid-col w25p">120</div>
		   	        	<div class="grid-col w25p">1200</div>
		       		</div>
		       		<div class="grid-row">
		   	        	<div class="grid-col w25p">02/05/2022 10:20</div>    	        
		   	        	<div class="grid-col w25p">Natação</div>
		   	        	<div class="grid-col w25p">40</div>
		   	        	<div class="grid-col w25p">700</div>
		       		</div>
		       		<div class="grid-row">
		   	        	<div class="grid-col w25p">03/05/2022 12:00</div>    	        
		   	        	<div class="grid-col w25p">Natação</div>
		   	        	<div class="grid-col w25p">40</div>
		   	        	<div class="grid-col w25p">500</div>
		       		</div>
		       	</div>
	       	</div>  
        </div>
		
		
        <div class='homeButton'>        
            <button class="cancel" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Voltar</button>
            <button class='save' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/exercises/edit")); %>'" >Adicionar</button>            
        </div>
        
    </div>
</body>

</html>