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
	ArrayList<TypePhyactivityModel> listTypePhyActivity = (ArrayList<TypePhyactivityModel>) request.getSession().getAttribute("listTypePhyActivity");
	
	@SuppressWarnings("unchecked")
	ArrayList<TypeFoodConsumedModel> listTypeFoodConsumed = (ArrayList<TypeFoodConsumedModel>) request.getSession().getAttribute("listTypeFoodConsumed");
	
	@SuppressWarnings("unchecked")
	ArrayList<UserBloodPressureModel> listUserBloodPressure = (ArrayList<UserBloodPressureModel>) request.getSession().getAttribute("listUserBloodPressure");
%>
<body>
	<div class="accessTec"></div> 	   
    <div class="background">
        <div class="titleDefaultTop">
            <span class="colorBlack">Health Track</span>            
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
            	<div class="value"><% if (user.getPhoneMobile() != null) { out.println(user.getPhoneMobile()); } %></div>
			</div>    
			<div class="homeTextName">
            	<a class="button" href="logout" >Sair</a>            	
			</div>           
        </div>
        
        <div class='homeButton'>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/exercises")); %>'">Exercícios</button>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/food")); %>'">Alimentação</button>
            <button class='info' onclick="javascript:window.location.href='<% out.print(request.getContextPath().concat("/measurements")); %>'">Medições</button>
        </div>
        
        <div class="featureSummary">
        	<div class="title">
    	        <div class="primary">Resumo Semanal</div>
        	</div>
        	<div class="title">
            	<div class="secondary border-bootom">Medições</div>
            	<div class="grid">
		          	<div class="grid-title bgr1">
		   	        	<div class="grid-col-title w25p textLeft">Data</div>    	        
		   	        	<div class="grid-col-title w25p textRight">Mínima</div>
		   	        	<div class="grid-col-title w25p textRight">Máxima</div>
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
			
			<div class="title">
            	<div class="secondary border-bootom">Alimentação</div>
            	<div class="grid">
		          	<div class="grid-title bgr1">
		   	        	<div class="grid-col-title w25p textLeft">Data</div>    	        
		   	        	<div class="grid-col-title w25p textRight">Tipo</div>
		   	        	<div class="grid-col-title w25p textRight">Minutos</div>
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
			
	        <div class="title">
    	        <div class="secondary border-bootom">Exercícios</div>
    	        <div class="grid">
		          	<div class="grid-title bgr1">
		   	        	<div class="grid-col-title w25p textLeft">Data</div>    	        
		   	        	<div class="grid-col-title w25p textLeft">Tipo</div>
		   	        	<div class="grid-col-title w25p textRight">Minutos</div>
		   	        	<div class="grid-col-title w25p textRight">Calorias</div>
		       		</div>
		       		<div class="grid-box-collumn">
		       			<% for(TypePhyactivityModel value : listTypePhyActivity) { %>
			       			<div class="grid-row">
			       				<div class="w100perc">
			       					<div class="grid-col-title2 w25p textLeft">Data</div>
					   	        	<div class="grid-col w25p textLeft"><% out.print(value.getAtUpdate()); %></div>    	        
			       				</div>    	        
				   	        	<div class="w100perc">
				   	        		<div class="grid-col-title2 textLeft">Tipo</div>
				   	        		<div class="grid-col w25p textLeft"><% out.print(value.getDescription()); %></div>
				   	        	</div>    	        
				   	        	<div class="w100perc">
				   	        		<div class="grid-col-title2 textRight">Minutos</div>
				   	        		<div class="grid-col w25p textRight"><% out.print(value.getTimeActivityMinute()); %></div>
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
            		 
			
        </div>

        
	
    </div>
    <div class="accessTec">
		<div class="accessTecDesktop">desktop</div>
		<div class="accessTecTablet">tablet</div>
		<div class="accessTecMobile">mobile</div>		
	</div> 
    <script src="tools/site.js"></script>
</body>
</html>