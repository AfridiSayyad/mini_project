package com.contactInfo.DAO;

public class Contact {
	
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	public String relation;
	
	public Contact(int id, String first_name, String last_name, String email, String relation) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.relation = relation;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", relation=" + relation + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	

}
