package edu.upc.pes.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
@Component
public class CustomDateSerializer extends JsonSerializer<Date> {

	
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		String formattedDate = formato.format(date);
		
		
		gen.writeString(formattedDate);
	}

}
