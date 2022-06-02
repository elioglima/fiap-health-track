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
	          	<div class="grid-title bgr1">
	   	        	<div class="grid-col-title w25p textLeft">Data</div>    	        
	   	        	<div class="grid-col-title w25p textRight">Min</div>
	   	        	<div class="grid-col-title w25p textRight">Max</div>
	   	        	<div class="grid-col-title w25p textRight">Batimentos</div>
	       		</div>
	       		<div class="grid-box-collumn">
	       			<% for(UserBloodPressureModel value : listUserBloodPressure) { %>
		       			<div class="grid-row">
		       				<div class="w100perc">
		       					<div class="grid-col-title2 textLeft">Data</div>
				   	        	<div class="grid-col w25p textLeft"><% out.print(value.getAtUpdate()); %></div>    	        
		       				</div>
		       				<div class="w100perc">
		       					<div class="grid-col-title2 textRight">Mínima</div>				   	        	    	        
			   	        		<div class="grid-col w25p textRight"><% out.print(value.getValueMin()); %></div>
			   	        	</div>
			   	        	<div class="w100perc">
			   	        		<div class="grid-col-title2 textRight">Máxima</div>
			   	        		<div class="grid-col w25p textRight"><% out.print(value.getValueMax()); %></div>
			   	        	</div>
			   	        	<div class="w100perc">
			   	        		<div class="grid-col-title2 textRight">Batimentos</div>
				   	        	<div class="grid-col w25p textRight"><% out.print(value.getValueBeats()); %></div>
			   	        	</div>
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