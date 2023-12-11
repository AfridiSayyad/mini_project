package com.contactInfo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactInfo.DAO.Contact;
import com.contactInfo.DAO.ContactRepository;

//@Service annotation is used to mark the class as a service component.
//This annotation is specialization of the @Component annotation its a typically applied to class that handle business logic. 
@Service
public class ContactService {
	
	//@Autowired is an annotation used for automatic dependency injection.
	//When you annotate a field,constructor with @Autowired,Spring will Automatically resolve and inject the corresponding dependency at runtime
	@Autowired
	public ContactRepository contactRepo;
	
	//This method retrieve all the data present in table.
	public List<Map<String, Object>> getAllContacts() {
		return this.contactRepo.getAllContacts();
	}
	
	public List<Contact> findAll(){
		return this.contactRepo.findAll();
	}
	
	//This method retrieve all the data related to given id
	public List<Map<String, Object>> getContactById(int id) {
		return this.contactRepo.getContactById(id);
	}
	
	//This method is created to insert data into the table with the user provided data
	public int insertContact(Contact con) {
		
		//This will return in integer format how many rows are effected.
		return this.contactRepo.insertContact(con);
	}
	
	//This is created to update data in the table using Data and id , the id is used to where we need to update the data.
	public int updateContact(Contact con, int id) {
		
		//This will return in integer format how many rows are effected.
		return this.contactRepo.updateContact(con,id);
	}
	
	//This method is created to delete the particular data in the table with the help id and it will return in integer format
	public int deleteContact(int id) {
		
		//getting a data from contactRepo and return in integer 
		return this.contactRepo.deleteContact(id);
	}
	
}
