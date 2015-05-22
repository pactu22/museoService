package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.MultimediaItem;
import edu.upc.pes.model.Obra;

public interface MultimediaRepository extends JpaRepository<MultimediaItem,String> {
	public MultimediaItem findByType(String type);
	
	public MultimediaItem findByObra(Obra obra);
	public MultimediaItem findByTypeAndObra(String type, Obra obra);
}
