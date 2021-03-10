package org.reliableedu.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionPool implements ServletContextListener
{
	public static Connection[] connections;
	public static boolean[] available;
	private String DBName;

	
	public void contextInitialized(ServletContextEvent contextEvent)
	{
		int numberOfConnections = Integer.parseInt(contextEvent.getServletContext().getInitParameter("NOC"));
		 DBName = contextEvent.getServletContext().getInitParameter("dbName");

		connections = new Connection[numberOfConnections];
		available = new boolean[numberOfConnections];

		try
		{
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/" + DBName;
			String user = "postgres";
			String pass = "Mrw@6474";

			for (int i = 0; i < numberOfConnections; i++)
			{
				connections[i] = DriverManager.getConnection(url, user, pass);
				available[i] = true;
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		Connection connection = null;

		do
		{
			for (int i = 0; i < available.length; i++)
			{
				if (available[i])
				{
					available[i] = false;
					connection = connections[i];
					break;
				}
			}
		}
		while (connection == null);

		return connection;
	}

	public static void returnConnection(Connection connection)
	{
		for (int i = 0; i < connections.length; i++)
		{
			if (connections[i] == connection)
			{
				connections[i] = connection;
				available[i] = true;
			}
		}
	}
	
	
	public void contextDestroyed(ServletContextEvent arg0)
	{
		for (int i = 0; i < connections.length; i++)
		{
			if (available[i])
			{
				try
				{
					connections[i].close();
				}
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
			}
		}
		connections = null;
		available = null;
	}
	public String toString()
	{	
		return " this is connection of "+DBName;
	}
}
