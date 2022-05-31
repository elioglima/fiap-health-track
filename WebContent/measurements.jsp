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
	ArrayList<UserBloodPressureModel> listUserBloodPressure = (ArrayList<UserBloodPressureModel>) request.getSession().getAttribute("listUserBloodPressure");
%>
<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        
        <div class="homeText noBorder ">
	        <div class="homeTextTitle">
    	        <div class="name">Medições</div>    	        
        	</div>
        	
        	<div class="grid">
	          	<div class="grid-title">
	   	        	<div class="grid-col w25p">Data</div>    	        
	   	        	<div class="grid-col w25p">Min</div>
	   	        	<div class="grid-col w25p">Max</div>
	   	        	<div class="grid-col w25p">Batimentos</div>
	       		</div>
	       		<div class="grid-box-collumn">
	       			<% for(UserBloodPressureModel value : listUserBloodPressure) { %>
		       			<div class="grid-row">
			   	        	<div class="grid-col w25p"><% out.print(value.getAtUpdate()); %></div>    	        
			   	        	<div class="grid-col w25p"><% out.print(value.getValueBeats()); %></div>
			   	        	<div class="grid-col w25p"><% out.print(value.getValueMin()); %></div>
			   	        	<div class="grid-col w25p"><% out.print(value.getValueMax()); %></div>
			       		</div>
					<%}%>
		       	</div>
	       	</div>  
        </div>
		
		
        <div class='homeButton mt50'>        
            <button class="cancel" onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/home")); %>'">Voltar</button>
            <button class='save' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/measurememts/edit")); %>'" >Adicionar</button>            
        </div>
        
    </div>
</body>

</html>