<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operaciones disponibles</title>
</head>
<body>
	<p>Las operaciones disponibles en el servicio son las siguientes:</p>

	<b>Crear museo: </b> /crear/{nombre}/{descripcion}
	</br>

	<b>Todas las obras de todos los museos: </b> /allobras
</br>
	<b>Crear obra: </b>
	/crear/{titulo}/{autor}/{estilo}/{coleccion}/{museo}
	</br>
	<b>Borrar obra:</b> /borrar/{id}
	</br>
	<b>Editar obra: </b>
	/editar/{id}/{titulo}/{autor}/{estilo}/{coleccion}/{museo}
	</br>
	<b>Obtener obra: </b> /obras/{id}

</br>
curl -X POST https://museo-project.herokuapp.com/crear/Museo2/descripcion
</br>
curl -X POST https://museo-project.herokuapp.com/crear/tituloObra/Picasso/estilooooo/coleccion10/Museo2

<img src="data:image/jpeg;base64,${imagen}"  width="50" height="50">`

</body>
</html>