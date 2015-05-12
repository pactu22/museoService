### Aplicacion desplegada en: ###

** https://museo-project.herokuapp.com/**


* Creamos un museo desde el terminal:
curl -X POST https://museo-project.herokuapp.com/crear/Museo2/descripcion 

* Creamos las obras ligadas al Museo2(previamente creado)
curl -X POST https://museo-project.herokuapp.com/crear/tituloObra/Picasso/estilooooo/coleccion10/Museo2

* Listamos obras:
 https://museo-project.herokuapp.com/allobras