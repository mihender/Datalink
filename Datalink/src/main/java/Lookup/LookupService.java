package Lookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("LookUpService")
public class LookupService {

	static Connection con = null;

	// static Statement stmt;

	public static void ConnectDB() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dataweb", "root", "snakes");
			System.out.println("Connection OK");

		} catch (ClassNotFoundException ex) {
			System.out.println("JDBC Driver not found");
		} catch (SQLException ex) {
			System.out.println("SQL problem");
			ex.printStackTrace();
		}

	}

	public static void DisconnectFromDB() {
		try {
			if (con != null) {
				con.close();
				System.out.println("Verbinding gesloten");
			}
		} catch (SQLException ex) {
			System.out.println("SQL problem");
			ex.printStackTrace();
		}

	}

	public List<DocuData> FindByGenre(String genre) {
		Statement stmt;

		List<DocuData> GenreList = new ArrayList();
		List<String> UrlList = new ArrayList();
		ConnectDB();
		try {
			stmt = con.createStatement();
			String cmd = "SELECT * FROM DocDatabase WHERE Genre LIKE '" + genre
					+ "%'";
			ResultSet rs = stmt.executeQuery(cmd);

			while (rs.next()) {
				DocuData docu = new DocuData();
				docu.setUrl(rs.getString("URL"));
				docu.setGenre(rs.getString("Genre"));
				docu.setNaam(rs.getString("Naam"));
				docu.setType(rs.getString("Type"));
				GenreList.add(docu);

			}

			if (GenreList.isEmpty()) {
				System.out.println("Geen records gevonden");
			}

			else
				rs.close();
			stmt.close();
			DisconnectFromDB();

		} catch (SQLException e) {
			System.out.println("SQL problem");
			e.printStackTrace();
		}
		return GenreList;

	}

	public List<DocuData> FindByType(String type) {
		Statement stmt;
		List<DocuData> TypeList = new ArrayList();
		ConnectDB();
		try {
			stmt = con.createStatement();
			String cmd = "SELECT * FROM DocDatabase WHERE Type= '" + type + "'";
			ResultSet rs = stmt.executeQuery(cmd);

			while (rs.next()) {
				DocuData docu = new DocuData();
				docu.setUrl(rs.getString("URL"));
				docu.setGenre(rs.getString("Genre"));
				docu.setNaam(rs.getString("Naam"));
				docu.setType(rs.getString("Type"));
				TypeList.add(docu);
			}

			if (TypeList.isEmpty()) {
				System.out.println("Geen records gevonden");
			}

			else
				rs.close();
			stmt.close();
			DisconnectFromDB();

		} catch (SQLException e) {
			System.out.println("SQL problem");
			e.printStackTrace();
		}

		return TypeList;

	}

	public List<DocuData> FindByNaam(String naam) {
		Statement stmt;
		List<DocuData> NaamList = new ArrayList();
		ConnectDB();
		try {
			stmt = con.createStatement();
			String cmd = "SELECT * FROM DocDatabase WHERE Naam LIKE '%" + naam
					+ "%'";
			ResultSet rs = stmt.executeQuery(cmd);

			while (rs.next()) {
				DocuData docu = new DocuData();
				docu.setUrl(rs.getString("URL"));
				docu.setGenre(rs.getString("Genre"));
				docu.setNaam(rs.getString("Naam"));
				docu.setType(rs.getString("Type"));
				NaamList.add(docu);
			}

			if (NaamList.isEmpty()) {
				System.out.println("Geen records gevonden");
			}

			else
				rs.close();
			stmt.close();
			DisconnectFromDB();

		} catch (SQLException e) {
			System.out.println("SQL problem");
			e.printStackTrace();
		}
		return NaamList;

	}

	public List<DocuData> FindBySubGenre(String subGenre) {
		Statement stmt;
		List<DocuData> subGenreList = new ArrayList();
		ConnectDB();
		try {
			stmt = con.createStatement();
			String cmd = "SELECT * FROM DocDatabase WHERE SubGenre LIKE '%"
					+ subGenre + "%'";
			ResultSet rs = stmt.executeQuery(cmd);

			while (rs.next()) {
				DocuData docu = new DocuData();
				docu.setUrl(rs.getString("URL"));
				docu.setGenre(rs.getString("Genre"));
				docu.setNaam(rs.getString("Naam"));
				docu.setType(rs.getString("Type"));
				subGenreList.add(docu);
			}

			if (subGenreList.isEmpty()) {
				System.out.println("Geen records gevonden");
			}

			else
				rs.close();
			stmt.close();
			DisconnectFromDB();

		} catch (SQLException e) {
			System.out.println("SQL problem");
			e.printStackTrace();
		}
		return subGenreList;


	}

}
