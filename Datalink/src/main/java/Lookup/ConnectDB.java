package Lookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDB {

	

	public static void main(String[] args) {
		LookupService dq = new LookupService();
		dq.FindByGenre("so");
	}

	
	
}
