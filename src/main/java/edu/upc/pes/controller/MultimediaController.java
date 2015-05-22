package edu.upc.pes.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.upc.pes.dao.MultimediaRepository;
import edu.upc.pes.model.MultimediaItem;

@Controller
public class MultimediaController {
	
	@Autowired
	private MultimediaRepository repo;
	
	@RequestMapping(value = "/imageDisplay")
	public void showImage(String itemId, HttpServletResponse response,HttpServletRequest request)
			throws ServletException, IOException {
		
		MultimediaItem item = repo.findOne(itemId);
		
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(item.getContent());

	
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/imagen/{id}")
	public String showImageHome(@PathVariable("id") String itemId,  Model model){
		
		MultimediaItem item = repo.findOne(itemId);

		byte[] encoded=Base64.encodeBase64(item.getContent());
		String encodedString = new String(encoded);
		model.addAttribute("imagen", encodedString);
	
		return "home";
	}

}
