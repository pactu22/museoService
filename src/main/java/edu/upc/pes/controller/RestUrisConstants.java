package edu.upc.pes.controller;

public class RestUrisConstants {

	public static final String GET_ALL_OBRAS = "/allobras";
	public static final String GET_OBRAS_MUSEO = "/museo/{museo}";
	public static final String CREATE_MUSEO = "/crear/{nombre}/{descripcion}";
	
	public static final String CREATE_OBRA = "/crear/{titulo}/{autor}/{estilo}/{coleccion}/{museo}";
	public static final String DELETE_OBRA = "/borrar/{id}";
	public static final String EDIT_OBRA = "/editar/{id}/{titulo}/{autor}/{estilo}/{coleccion}/{museo}";
	public static final String GET_OBRA = "/obras/{id}";
	
}
