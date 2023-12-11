package com.contactInfo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImp implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact con=new Contact();
		con.setId(rs.getInt(1));
		con.setFirst_name(rs.getString(2));
		con.setLast_name(rs.getString(3));
		con.setEmail(rs.getString(4));
		con.setRelation(rs.getString(5));
		return con;
	}

}
