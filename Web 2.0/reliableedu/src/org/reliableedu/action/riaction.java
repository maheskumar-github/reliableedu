package org.reliableedu.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class riaction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	private String name,email,phone,courses,msg;
		
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
		String svalues = "'"+getName()+"', '"+getEmail()+"','"+getPhone()+"','"+getCourses()+"','"+getMsg()+"'";
		String query = "INSERT INTO member (name, email, phone,courses,msg) VALUES (" + svalues + ")";
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
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
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
