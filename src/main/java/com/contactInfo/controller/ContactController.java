package com.contactInfo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactInfo.DAO.Contact;
import com.contactInfo.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	public ContactService contactService;
	
	@GetMapping("/allData")
	public List<Map<String,Object>> getAllContacts(){
		return this.contactService.getAllContacts();
		//return this.contactService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public List<Map<String,Object>> getContactById(@PathVariable("id") int id){
		return this.contactService.getContactById(id);
	}
	
	@PostMapping("/adding")
	public String insertContact(@RequestBody Contact con) {
		int res=this.contactService.insertContact(con);
		if(res==0) {
			return "Data Is Not Inserted";
		}else {
			return "Data Inserted";
		}
	}
	
	@PutMapping("/update/{id}")
	public String updateContact(@RequestBody Contact con,@PathVariable("id") int id) {
		int res=this.contactService.updateContact(con,id);
		if(res==0) {
			return "Data Is Not Updated Check Id";
		}else {
			return "Data Updated";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable("id") int id) {
		int res=this.contactService.deleteContact(id);
		if(res==0) {
			return "Data Is Not Fund";
		}else {
			return "Data Deleted";
		}
	}

}
