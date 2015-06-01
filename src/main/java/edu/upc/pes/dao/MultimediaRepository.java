package edu.upc.pes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.MultimediaItem;
import edu.upc.pes.model.Obra;

public interface MultimediaRepository extends JpaRepository<MultimediaItem,String> {
	public List<MultimediaItem> findByType(String type);
	
	public List<MultimediaItem> findByObra(Obra obra);
	
	public List<MultimediaItem> findByTypeAndObra(String type, Obra obra);
}
