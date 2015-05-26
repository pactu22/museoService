package edu.upc.pes.controller;

public class RestUrisConstants {
	
	public static final String NEW_MUSEO = "/museos";
	
	public static final String NEW_AUTOR = "/autores";
	
	public static final String NEW_COLECCION = "/museos/{museo}/colecciones";

	public static final String NEW_OBRA_OF_MUSEO = "/museos/{museo}/obras";
	
	public static final String GET_OBRAS = "/obras";
	
	public static final String GET_OBRAS_MUSEO = "/museos/{museo}/obras";
	 
	public static final String GET_COLECCIONES_MUSEO = "/museos/{museo}/colecciones";
	
	public static final String GET_COLECCIONES = "/colecciones";

	public static final String EDITAR_OBRA_OF_MUSEO = "/museos/{museo}/obras/{id}";

	public static final String BORRAR_OBRA_OF_MUSEO = "museos/{museo}/obras/{id}/borrar";
	
	public static final String USUARIOS = "/usuarios";
	
	public static final String MUSEOS = "/museos";
	
	public static final String AUTORES = "/autores";
	
	public static final String OBRA_OF_MUSEO = "/museos/{museo}/obras/{id}";
	
	
	
	
	public static final String GET_OBRAS_OF_MUSEO_BY_COLECCION = "/museos/{museo}/coleccion/{coleccion}/obras";
	public static final String GET_OBRAS_OF_MUSEO_BY_TITULO = "/museos/{museo}/obrasbytitulo/{titulo}";
	public static final String GET_OBRAS_OF_MUSEO_BY_ESTILO = "/museos/{museo}/obrasbyestilo/{estilo}";
	public static final String GET_OBRAS_OF_MUSEO_BY_AUTOR = "/museos/{museo}/obrasbyautor/{nombreAutor}";
	
}
