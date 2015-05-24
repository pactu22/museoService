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
	
}
