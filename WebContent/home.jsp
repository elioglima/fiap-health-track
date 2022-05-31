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
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
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
            	<div class="value"><% out.println(user.getPhoneMobile()); %></div>
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
		   	        	<div class="grid-col w25p">Data</div>    	        
		   	        	<div class="grid-col w25p">Mínima</div>
		   	        	<div class="grid-col w25p">Máxima</div>
		   	        	<div class="grid-col w25p">Batimentos</div>
		       		</div>
		       		<div class="grid-box-collumn">
		       			<% for(UserBloodPressureModel value : listUserBloodPressure) { %>
			       			<div class="grid-row">
				   	        	<div class="grid-col w25p"><% out.print(value.getAtUpdate()); %></div>    	        
				   	        	<div class="grid-col w25p"><% out.print(value.getValueMin()); %></div>
				   	        	<div class="grid-col w25p"><% out.print(value.getValueMax()); %></div>
				   	        	<div class="grid-col w25p"><% out.print(value.getValueBeats()); %></div>
				       		</div>
						<%}%>
			       	</div>
	       		</div>            	            	
			</div>		
			
			<div class="title">
            	<div class="secondary border-bootom">Alimentação</div>
            	<div class="grid">
		          	<div class="grid-title bgr1">
		   	        	<div class="grid-col w25p">Data</div>    	        
		   	        	<div class="grid-col w25p">Tipo</div>
		   	        	<div class="grid-col w25p">Minutos</div>
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
			
	        <div class="title">
    	        <div class="secondary border-bootom">Exercícios</div>
    	        <div class="grid">
		          	<div class="grid-title bgr1">
		   	        	<div class="grid-col w25p">Data</div>    	        
		   	        	<div class="grid-col w25p">Tipo</div>
		   	        	<div class="grid-col w25p">Minutos</div>
		   	        	<div class="grid-col w25p">Calorias</div>
		       		</div>
		       		<div class="grid-box-collumn">
		       			<% for(TypePhyactivityModel value : listTypePhyActivity) { %>
			       			<div class="grid-row">
				   	        	<div class="grid-col w25p"><% out.print(value.getAtUpdate()); %></div>    	        
				   	        	<div class="grid-col w25p"><% out.print(value.getDescription()); %></div>
				   	        	<div class="grid-col w25p"><% out.print(value.getTimeActivityMinute()); %></div>
				   	        	<div class="grid-col w25p"><% out.print(value.getValueCalorie()); %></div>
				       		</div>
						<%}%>
			       	</div>
	       		</div>  
        	</div>
            		 
			
        </div>

        

    </div>
    <script src="tools/site.js"></script>
</body>

</html>