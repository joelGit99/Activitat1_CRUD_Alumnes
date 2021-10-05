import java.sql.Connection;

import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 
 * @author Joel
 *
 */
public class Activitat1 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Driver driver = null;
		Scanner teclado = new Scanner(System.in);

		String url = "jdbc:mysql://localhost:3306/alumnes";
		String usuari = "root";
		String password = "";

		// Connexió amb el driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		conn = abrirConnexion(conn, url, usuari, password);
		System.out.println("Introdueix el nom");
		String nom = teclado.nextLine();
		System.out.println("Introdueix el DNI");
		String DNI = teclado.nextLine();
		System.out.println("Introdueix la data de naixement");
		String naixement = teclado.nextLine();
		System.out.println("Introdueix la direcció");
		String direccio = teclado.nextLine();
		System.out.println("Introdueix el sexe");
		String sexe = teclado.nextLine();
		System.out.println("Introdueix el codi postal");
		String codiPostal = teclado.nextLine();
		System.out.println("Introdueix la població");
		String poblacio = teclado.nextLine();
		insertarAlumnes(conn, nom, DNI, naixement, direccio, sexe, codiPostal, poblacio);
		mostrarAlumnes(conn);
		System.out.println("Introdueix la taula a actualitzar");
		String taula = teclado.nextLine();
		System.out.println("Introdueix la columna a actualitzar");
		String columna = teclado.nextLine();
		System.out.println("Introdueix el valor amb el que vols actualitzar la columna");
		String valorActualitzat = teclado.nextLine();
		System.out.println("Introdueix l'id de la fila a actualitzar");
		int idAct = teclado.nextInt();
		actualitzarAlumne(conn, taula, idAct, columna, valorActualitzat);
		System.out.println("Introdueix l'id de l'alumne que vols mostrar");
		int idMost = teclado.nextInt();
		mostrarAlumnesXID(conn, idMost);
		System.out.println("Introdueix l'id de l'alumne a esborrar");
		int idEsb = teclado.nextInt();
		esborrarAlumne(conn, idEsb);
		conn.close();

	}
	/**
	 * Mètode per obrir la connexió amb la base de dades
	 * @param conn
	 * @param url
	 * @param usuari
	 * @param password
	 * @return
	 */
	public static Connection abrirConnexion(Connection conn,String url,String usuari,String password) {
		try {
			conn = DriverManager.getConnection(url, usuari, password);
			System.out.println("Connexió realitzada amb la base de dades");
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Métode per insertar alumnes
	 * @param conn
	 * @param nom
	 * @param DNI
	 * @param naixement
	 * @param adreça
	 * @param sexe
	 * @param codiPostal
	 * @param poblacio
	 */
	public static void insertarAlumnes(Connection conn,String nom,String DNI,String naixement,String adreça,String sexe,String codiPostal,String poblacio) {
		String insert = "INSERT INTO alumne (nom,DNI,data_naixement,adreça,sexe,codi_postal,poblacio) "
				+ "VALUES" + "('" + nom + "','" + DNI + "','" + naixement + "','" + adreça + "','" + sexe + "','" + codiPostal + "','" + poblacio + "');";
		try {
			Statement st = conn.createStatement();
			st.execute(insert);
			System.out.println("Se ha insertado un nuevo registro.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Métode per mostrar tots els alumnes
	 * @param conn
	 */
	public static void mostrarAlumnes(Connection conn) {
		String select = "SELECT * FROM alumne;";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println("ID: " + rs.getString("ID") + "\n" +
						"Nom: " + rs.getString("nom") + "\n" +
						"DNI: " + rs.getString("DNI") + "\n" +
						"Data de naixement: " + rs.getString("data_naixement") + "\n" +
						"Adreça: " + rs.getString("adreça") + "\n" +
						"Sexe: " + rs.getString("sexe") + "\n" +
						"Codi postal: " + rs.getString("codi_postal") + "\n" +
						"Població: " + rs.getString("poblacio"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Métode per actualitzar un alumne
	 * @param conn
	 * @param taula
	 * @param id
	 * @param columna
	 * @param valorActualitzat
	 */
	public static void actualitzarAlumne(Connection conn, String taula, int id, String columna, String valorActualitzat) {
		String update = "UPDATE " + taula + " SET " + columna + " = '" + valorActualitzat + "' WHERE id = " + id + ";";
		try {
			Statement st = conn.createStatement();
			st.execute(update);
			System.out.println("S'ha actualitzat la taula " + taula);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Mètode per mostrar alumnes per id
	 * @param conn
	 * @param id
	 */
	public static void mostrarAlumnesXID(Connection conn, int id) {
		String select = "SELECT * FROM alumne WHERE id = " + id + ";";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println("ID: " + rs.getString("ID") + "\n" +
						"Nom: " + rs.getString("nom") + "\n" +
						"DNI: " + rs.getString("DNI") + "\n" +
						"Data de naixement: " + rs.getString("data_naixement") + "\n" +
						"Adreça: " + rs.getString("adreça") + "\n" +
						"Sexe: " + rs.getString("sexe") + "\n" +
						"Codi postal: " + rs.getString("codi_postal") + "\n" +
						"Població: " + rs.getString("poblacio"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Métode per esborrar alumnes
	 * @param conn
	 * @param id
	 */
	public static void esborrarAlumne(Connection conn, int id) {
		String delete = "DELETE FROM alumne WHERE id = " + id + ";";
		try {
			Statement st = conn.createStatement();
			st.execute(delete);
			System.out.println("S'ha esborrat un alumne");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
