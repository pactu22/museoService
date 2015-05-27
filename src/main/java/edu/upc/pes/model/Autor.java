package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import edu.upc.pes.config.JsonDateDeSerializer;
import edu.upc.pes.config.JsonDateSerializer;
@Entity
public class Autor{


	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	
	
	private Date fechaNacimiento;
	
	private String nacionalidad;
	
	@JsonIgnore
	@OneToMany(mappedBy = "autor",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;

	public Autor(){
		obras = new ArrayList<Obra>();
	}
	public Autor(String nombre, String apellidos, String nacionalidad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		obras = new ArrayList<Obra>();
		this.nacionalidad = nacionalidad;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	@JsonDeserialize(using= JsonDateDeSerializer.class)
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public boolean tieneObra(Obra o){
		return obras.contains(o);
	}
	
	@Override
	public boolean equals(Object u){
		Autor autor = (Autor) u;
		return (autor.getNombre().equals(this.getNombre())&& 
				autor.getApellidos().equals(this.getApellidos())&&
				autor.getFechaNacimiento().equals(this.getFechaNacimiento()) && 
				autor.getNacionalidad().equals(this.getNacionalidad())
				);
	}
	
	@Override
	public int hashCode(){
		return nombre.hashCode() + apellidos.hashCode() + fechaNacimiento.hashCode() + nacionalidad.hashCode();
	}

	public List<Obra> obrasDelMuseo(String museo){
		List<Obra>result = new ArrayList<Obra>();
		for(Obra o  : obras) {
			if (o.getMuseo().getNombre().equals(museo)) result.add(o);
		}
		return result;
	}
}
