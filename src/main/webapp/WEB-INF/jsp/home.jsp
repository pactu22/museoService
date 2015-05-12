<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operaciones disponibles</title>
</head>
<body>
<p> Las operaciones disponibles en el servicio son las siguientes: </p>

	<b>Crear obra: </b> /crear/{titulo}/{autor}/{estilo}/{coleccion}/{museo}
	</br>
	<b>Borrar obra:</b> /borrar/{id}
	</br>
	<b>Editar obra: </b> /editar/{id}/{titulo}/{autor}/{estilo}/{coleccion}/{museo}
	</br>
	<b>Obtener obra: </b> /obras/{id}
	
</body>
</html>