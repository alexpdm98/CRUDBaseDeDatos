package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import control.Alimento;

/**
 * Clase con funcionalidades usadas para interactuar con la base de datos
 * 
 * @author Alejandro Pineda
 * 
 */

public class UtilidadesAlimentos {
	// --------- Zona de declaración de variables --------

	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	Connection conexion = null;
	Statement sentenciaSQL = null;
	ResultSet rs;
	int resultado = 0;
	boolean resultadoExecute = false;
	boolean resultSearch = false;
	String sql = "";
	int index;
	String datoIntroducido;

	// --------- Fin de declaración de variables ----------

	/**
	 * --------- Constructor ------------------------------
	 * 
	 * @param inputStreamReader El parámetro inputStreamReader define un
	 *                          InputStreamRader, usado para obtener entradas de
	 *                          usuario
	 * 
	 * @param bufferedReader    El parámetro bufferedReader define un
	 *                          BufferedReader, usado para formatear las entradas de
	 *                          usuario
	 */
	public UtilidadesAlimentos(InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
		super();
		this.inputStreamReader = inputStreamReader;
		this.bufferedReader = bufferedReader;
	}
	// --------- Fin del constructor ----------------------

	/**
	 * Función utilizada para añadir datos a la base de datos
	 * 
	 * @return un boolean con el estado true o false en función de como haya acabado
	 *         la operación, correcta o incorrectamente, respectivamente
	 * 
	 * @throws IOException lanzada al captar un dato del usuario incorrecto
	 */
	public boolean addDataToPosition() throws IOException {
		Alimento alimento = new Alimento("", "", "");
		// Se pide una entrada
		System.out.println("Agregue una entrada a las proteinas de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setProteinas(datoIntroducido);
		// Se pide una entrada
		System.out.println("Agregue una entrada a las grasas de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setGrasas(datoIntroducido);
		// Se pide una entrada
		System.out.println("Agregue una entrada a los hidratos de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setHidratos(datoIntroducido);
		System.out.println("Se agrega el alimento a la lista");
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/alimento", "root", "");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();
			// lanzamos una sentencia de insercion
			String sql = TransformarSql.insertAlimentoAsql(alimento);
			resultado = sentenciaSQL.executeUpdate(sql);
			// Sacamos por pantalla el resultado de la operación
			if (resultado >= 1) {
				System.out.println("Se ha insertado correctamente.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Se cierra la conexion y las sentencias
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // Se devuelve un booleano con un true si la operación ha salido correctamente o
			// no
		return (resultado >= 1);
	}

	/**
	 * Función utilizada para modificar un dato de la base de datos
	 * 
	 * @return un boolean con el estado true o false en función de como haya acabado
	 *         la operación, correcta o incorrectamente, respectivamente
	 * 
	 * @throws IOException lanzada al captar un dato del usuario incorrecto
	 */
	public boolean modifyDataInPosition() throws IOException {
		// Se pide la posición que se desea modificar.
		Alimento alimento = new Alimento("", "", "");
		System.out.println("Indique la posicion que desea modificar");
		index = Integer.parseInt(bufferedReader.readLine());
		alimento.setIdAlimento(index);
		// Se pide una entrada
		System.out.println("Agregue una entrada a las proteinas de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setProteinas(datoIntroducido);
		// Se pide una entrada
		System.out.println("Agregue una entrada a las grasas de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setGrasas(datoIntroducido);
		// Se pide una entrada
		System.out.println("Agregue una entrada a los hidratos de este alimento");
		datoIntroducido = bufferedReader.readLine();
		// Añade el dato introducido por el usuario
		alimento.setHidratos(datoIntroducido);
		System.out.println("Se modifica alimento en base de datos");
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/alimento", "root", "");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();
			// lanzamos una sentencia de actualizacion
			String sql = TransformarSql.updateAlimentoAsql(alimento);
			resultado = sentenciaSQL.executeUpdate(sql);
			// Sacamos por pantalla el resultado de la operación
			if (resultado >= 1) {
				System.out.println("Se ha modificado correctamente.");
			} else {
				System.out.println("No se ha modificado correctamente.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Se cierra la conexion y las sentencias
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // Se devuelve un booleano con un true si la operación ha salido correctamente o
			// no
		return (resultado >= 1);
	}

	/**
	 * Función utilizada para borrar datos en la posición indicada de la base de
	 * datos
	 * 
	 * @return un boolean con el estado true o false en función de como haya acabado
	 *         la operación, correcta o incorrectamente, respectivamente
	 * 
	 * @throws IOException lanzada al captar un dato del usuario incorrecto
	 */
	public boolean deleteDataInPosition() throws IOException {
		// Se pide la posición que se desea borrar.
		System.out.println("Indique la posicion que desea borrar");
		String indexToDelete = bufferedReader.readLine();
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/alimento", "root", "");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();
			// lanzamos una sentencia de borrado
			String sql = TransformarSql.deleteAlimentoAsql(indexToDelete);
			resultado = sentenciaSQL.executeUpdate(sql);
			// Sacamos por pantalla el resultado de la operación
			if (resultado >= 1) {
				System.out.println("Se ha borrado correctamente.");
			} else {
				System.out.println("No se ha borrado correctamente.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Se cierra la conexion y las sentencias
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // Se devuelve un booleano con un true si la operación ha salido correctamente o
			// no
		return (resultado >= 1);
	}

	/**
	 * Función utilizada para buscar qué alimento contiene el daato buscado
	 * 
	 * @return un boolean con el estado true o false en función de como haya acabado
	 *         la operación, correcta o incorrectamente, respectivamente
	 * 
	 * @throws IOException lanzada al captar un dato del usuario incorrecto
	 */
	public boolean searchDataInDataBase() throws IOException {
		// Se pide el dato que se desea buscar.
		System.out.println("Indique el dato que desea buscar");
		String dataToSearch = bufferedReader.readLine();
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/alimento", "root", "");

			// creamos sentencias ejecutables sobre esa conexi�n
			sentenciaSQL = conexion.createStatement();
			// lanzamos una sentencia de busqueda
			String sql = TransformarSql.findAlimentoAsql(dataToSearch);
			sentenciaSQL.execute(sql);
			// obtenemos un booleano en función de si el ResultSet contiene o no elementos
			// devueltos por la base de datos
			resultSearch = sentenciaSQL.getResultSet().isBeforeFirst();
			if (resultSearch == true) {
				// En caso de tener elementos, lo imprime por pantalla
				try (ResultSet rs = sentenciaSQL.getResultSet()) {
					ResultSetMetaData md = rs.getMetaData();
					int cols = md.getColumnCount();
					System.out.println("");
					while (rs.next()) {
						for (int i = 0; i < cols; i++) {
							String value = rs.getString(i + 1);
							if (i == 0) {
								System.out.println("El dato buscado se ha encontrado en la fila con id " + value
										+ ", cuyo contenido es: ");
							}
							System.out.println(value + "\t");
						}
						System.out.println("");
					}
				} catch (SQLException e) {
					System.out.println("Error mostrando resultados: " + e.getMessage());
				}
			} else {// En caso de no tener elementos, lo imprime por pantalla
				System.out.println("El dato buscado no se encuentra en base de datos.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return resultSearch;

	}
}
