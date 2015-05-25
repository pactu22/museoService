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
<b>NEW_MUSEO</b>
<p>http://localhost:8080/pes-project/rest/museos
{ "nombre" : "MuseoXXXXX", "descripcion": "nada"}
{ "nombre" : "Museo1", "descripcion": "nada"}</p>
<b>NEW_AUTOR</b>
<p>http://localhost:8080/pes-project/rest/autores
{ "nombre" : "Felipe", "apellidos": "Porritas" , “fechaNacimiento”: “dd/MM/yyyy HH:mm:ss ” ,"nacionalidad": "Peruana"}
</p>
<b>NEW_COLECCION</b>
<p>http://localhost:8080/pes-project/rest/museos/MuseoXXXXX/colecciones
{“nombre”: “Coleccion1”}
</p>
<b>GET_COLECCIONES_MUSEO</b>
<p>http://localhost:8080/pes-project/rest/museos/MuseoXXXXX/colecciones
</p>
<b>GET_COLECCIONES</b>
<p>http://localhost:8080/pes-project/rest/colecciones
</p>
<b>GET_OBRAS</b>
<p>http://localhost:8080/pes-project/rest/obras
</p>
<b>NEW_OBRA_OF_MUSEO</b>
<p>http://localhost:8080/pes-project/rest/museos/MuseoXXXXX/obras
{
"titulo": "Obrita2",
"idBeacon": 1,
"estilo": "Romanico",
"idAutor": 5,
"nombreColeccion" : "Coleccion1",
"informacion": "esta es la obra blablabllbalblaa"
}

{"titulo": "Obrita3",
"idBeacon": 1,
"estilo": "Renacimiento",
"idAutor": 4,
"informacion": "esta es la obra blablabllbalblaa"}


</p>



<b> BORRAR_OBRA_OF_MUSEO </b>
<p>http://localhost:8080/pes-project/rest/museos/MuseoXXXXX/obras/1/borrar</p>

<b>EDITAR_OBRA_OF_MUSEO </b>
<p>http://localhost:8080/pes-project/rest/museos/MuseoXXXXX/obras/1

{"titulo": "Obrita3",
"idBeacon": 1,
"estilo": "Renacimiento",
"idAutor": 4,
"informacion": "esta es la obra blablabllbalblaa"}

</p>
<img src="data:image/jpeg;base64,${imagen}"  width="50" height="50">`

</body>
</html>