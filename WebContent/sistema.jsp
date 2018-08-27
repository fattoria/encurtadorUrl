<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<br/>
	<div class="container">
		<div align="center">
			<img src="img/encurtador.png" width="300px" height="150px">
		</div>
		<br/>
	<fieldset class="col-md-12" style="border: 2px solid; border-radius: 4px; background-color: #728DCF; color: #FFFFFF; font-family: Georgia; border-color: blue">
		<form id="form1" method="post" action="Controle?cmd=gravar" role="form">
			<br/>
			<div class="form-group">
				<input type="text" name="url_longa" id="url_longa" class="form-control" placeholder="Digite a URL a ser encurtada">
			</div>
	
			<button type="submit" class="btn btn-primary" class="form-control" style="style="font-size: 13pt; padding: 6px 6px;"><span class="glyphicon glyphicon-resize-small">&nbsp;Encurtar URL</span></button>
			<br/><br/>
			${msg}
		</form>
	</fieldset>
	
	</div>
	<br/>
	
	<div class="container">
		<form id="form2" method="get" action="Controle">
			<input type="hidden" name="cmd" value="listar">
			
			<h4>Realizar Consulta</h4> 
			<button type="submit" class="btn btn-success" style="font-size: 13pt; padding: 6px 6px;"><span class="glyphicon glyphicon-search">&nbsp;Consultar URL's</span></button>
		
		</form>
	
	</div>
	
</body>
</html>