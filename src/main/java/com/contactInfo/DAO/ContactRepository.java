package com.contactInfo.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//The @Repository annotation is s specialization of the @Component annotation.
//The class annotated with @Repository is typically used to perform CRUD or JDBC.
@Repository
public class ContactRepository {
	
	//@Autowired is an annotation used for automatic dependency injection.
	//When you annotate a field,constructor with @Autowired,Spring will Automatically resolve and inject the corresponding dependency at runtime
	@Autowired
	//JdbcTemplate is a part of spring JDBC framework and provides a convenient way to interact with relation database using SQL queries
	public JdbcTemplate jdbcTemplate;
	
	public ContactRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
		//this.jdbcTemplate.execute("create database if not exists test;");
		this.jdbcTemplate.execute("use test;");
		//This Executes when we create a object of this call it will perform the create table query if not exists table in the given database
		this.jdbcTemplate.execute("create table if not exists Contact(\r\n"
				+ "id int primary key auto_increment,\r\n"
				+ "first_name varchar(20),\r\n"
				+ "last_name varchar(20),\r\n"
				+ "email varchar(50),\r\n"
				+ "relation varchar(20) \r\n"
				+ ");");
	}
	
	//This method is created to get all the data present in table.
	public List<Map<String, Object>> getAllContacts() {
		
		//This query is commonly used to retrieve all the data present in Contact table.
		String query="select * from Contact";
		
		//The queryForList method is commonly used to execute a SQL query and retrieve the result as a List of Maps.
		List<Map<String,Object>> res=this.jdbcTemplate.queryForList(query);
		return res;
	}
	public List<Contact> findAll(){
		String query="select * from Contact";
		List<Contact> res=this.jdbcTemplate.query(query, new RowMapperImp());
		return res;
	}
	
	//This method is created to get all the data of the given id.
	public List<Map<String, Object>> getContactById(int id) {
		
		//This query fetch all data which is related to given id.
		String query="select * from Contact where id=?";
		
		//The queryForList method is commonly used to execute a SQL query and retrieve the result as a List of Maps.
		List<Map<String , Object>> res=this.jdbcTemplate.queryForList(query,id);
		return res;
	}
	
	//This method is created to insert data into the table or create a new record in table with the provided Data(Object)
	public int insertContact(Contact con) {
		
		//This query insert data into the Contact Table with Object(Data) passed by the user.
		String query="insert into Contact values(?,?,?,?,?)";
		
		//The method prints the number of rows affected by the update operation.
		int res=this.jdbcTemplate.update(query,con.getId(),con.getFirst_name(),con.getLast_name(),con.getEmail(),con.getRelation());
		return res;
	}
	
	//This method is created to update data in the table with the help of Object(What we need to update) and id
	public int updateContact(Contact con, int id) {
		
		//This query update data in Contact table with the provided id if the id is present then it going to replace data
		String query="update Contact set first_name=?,last_name=?,email=?,relation=? where id=? ";
		
		//The method prints the number of rows affected by the update operation.
		int res=this.jdbcTemplate.update(query,con.getFirst_name(),con.getLast_name(),con.getEmail(),con.getRelation(),id);
		
		return res;
	}
	
	//This method is created to delete a single record in the table with the help of id.
	public int deleteContact(int id) {
		
		//"delete from Contact where id=?" with the help of this query we can delete a record form the Contact table.
		String query="delete from Contact where id=?";
		
		//The method prints the number of rows affected by the update operation.
		int res=this.jdbcTemplate.update(query,id);
		
		return res;
	}
	
	

}
