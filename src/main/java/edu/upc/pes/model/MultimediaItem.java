package edu.upc.pes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MultimediaItem {
	
	@Id
	private String id;
	private String type; // para indicar img, sound, video
	private byte[] content;  // Este tipo de dato Java (array of byte) creara en Postgres una columna BYTEA que sirve para almacenar imagenes

	
	@JsonIgnore
	@ManyToOne
	private Obra obra;
	
	public MultimediaItem(){
		
	}
	public MultimediaItem(String type, byte[] content, Obra o){
		this.type = type;
		this.content = content;
		obra = o;
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}
	

}
