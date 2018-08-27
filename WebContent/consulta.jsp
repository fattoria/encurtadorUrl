<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.*, persistence.*" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de Consulta</title>

<!-- Chamando o BootStrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<h2 style="text-align: center; color: blue;"><b>Tabela de URL's</b></h2>
	
	<table align="center" class="table table-bordered" style="text-align: center; background-color: #728DCF; color: #FFFFFF; font-family: Georgia; font-size: 13pt; width: 800px;">
		<!-- Cabeçalho -->
		<thead>
			<tr>
			<td><b>URL Longa</b></td>
			<td><b>URL Curta</b></td>
			<td><b>Ações</b></td>
			</tr>
		</thead>
	
	</table>
	<div class="container">
		<a href="sistema.jsp"><button type="button" class="btn btn-info" style="font-size: 13pt; padding: 6px 6px;"><span class="glyphicon glyphicon-backward">&nbsp;Voltar</span></button></a>	
	</div>	

</body>
</html>