#!/bin/bash
# My first script

curl -H "Content-Type: application/json" -X POST -d '{"nombre":"Museo Principal","descripcion":"Este museo es el mas pequeño de Barcelona","direccion":"Avenida Les Corts 233"}' http://museo-project.herokuapp.com/rest/museos
curl -H "Content-Type: application/json" -X POST -d '{ "nombre" : "Vincent", "apellidos": " Van Gogh" , "fechaNacimiento": "30/03/1853" ,"nacionalidad": "Holandesa"}' http://museo-project.herokuapp.com/rest/autores
curl -H "Content-Type: application/json" -X POST -d '{ "nombre" : "Leonardo", "apellidos": " Da Vinci" , "fechaNacimiento": "30/03/1700" ,"nacionalidad": "Italiana"}' http://museo-project.herokuapp.com/rest/autores
curl -H "Content-Type: application/json" -X POST -d '{"nombre": "Coleccion1"}' http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/colecciones
curl -H "Content-Type: application/json" -X POST -d '{"nombre": "Coleccion2"}' http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/colecciones
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "Bautismo De Cristo", "idBeacon": 2, "estilo": "Renacimiento", "idAutor": 1, "informacion": "Pintado por Andrea del Verrocchio, pero el ángel del lado izquierdo está hecho por Leonardo"}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "Anunciacion", "idBeacon": 2, "estilo": "Renacimiento", "idAutor": 1, "informacion": "En general, se cree que es la primera obra completa existente de Leonardo."}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "Adoración de los Magos", "idBeacon": 2, "estilo": "Renacimiento", "idAutor": 1, "informacion": "Inacabada"}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "La noche estrellada","idBeacon": 2,"estilo": "Ni idea","idAutor": 2,"informacion": "La noche estrellada es una de las imágenes más conocidas en la cultura moderna además de ser uno de los grabados más reproducidos y deseados"}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "Los girasoles","idBeacon": 2,"estilo": "Ni idea","idAutor": 2,"informacion": "La colección más famosa de bodegones de Vincent van Gogh "}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras
curl -H "Content-Type: application/json" -X POST -d '{"titulo": "El viñedo rojo","idBeacon": 2,"estilo": "Ni idea","idAutor": 2,"informacion": "Esta pintura fue vendido en Bruselas por 400 francos, unos pocos meses antes de su muerte."}'  http://museo-project.herokuapp.com/rest/museos/Museo%20Principal/obras

