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
	UserPhysicalActivityModel userPhysicalActivity = (UserPhysicalActivityModel) request.getSession().getAttribute("userPhysicalActivity");

	@SuppressWarnings("unchecked")
	ArrayList<TypePhyactivityModel> listTypePhyActivity = (ArrayList<TypePhyactivityModel>) request.getSession().getAttribute("listTypePhyActivity");
%>

<body>    
    <div class="background">
        <div class="homeTitle">
            <span id="logo">Health Track</span>            
        </div>        
        
        <form class="form" action="<%=request.getContextPath() %>/exercises/edit" method="POST">
        	<div class="homeText">
	        	<div class="homeTextTitle">
    	        	<div class="name">Registrando Atividade</div>    	        
        		</div>
        		
           		
           		<div class="row">
    	        	<div class="label-text">Tipo</div>    	        
    	        	<div class="label-value w50p">
	    	        	<select id="typePhyActivityId" name="typePhyActivityId" >
	        				<% for(TypePhyactivityModel value : listTypePhyActivity) { %>  
	  							<option value="<% out.print(value.getId()); %>"><% out.print(value.getDescription()); %></option>
							<%}%>
	    	        	</select>    	        		
    	        	</div>
        		</div>
        		
            	<div class="row">
    	        	<div class="label-text">Tempo (m)</div>    	        
    	        	<div class="label-value w50p">
    	        		<input type="text" class="w100perc" name="timeActivityMinute" placeholder="informe seu email" value="<% out.println(userPhysicalActivity.getTimeActivityMinute()); %>">
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