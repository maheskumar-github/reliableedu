package org.reliableedu.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class contactus extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	private String name,email,phone,msg;
		
public String execute()
{	
	try 
	{
		Class.forName("org.postgresql.Driver");

		String url = "jdbc:postgresql://localhost:5432/reliableedu";
		String user = "postgres";
		String pass = "Mrw@6474";

		Connection connection = DriverManager.getConnection(url, user, pass);
		
		Statement statement = connection.createStatement();
		String svalues = "'"+getName()+"', '"+getEmail()+"','"+getPhone()+"','"+getMsg()+"'";
		String query = "INSERT INTO contactus (name, email, phone,msg) VALUES (" + svalues + ")";
		statement.executeUpdate(query);
		statement.close();
		connection.close();
		return "success";
	}catch(Exception e) 
	{
		return "error";
	}
	  		
}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}