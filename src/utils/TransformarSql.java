package utils;

import java.io.IOException;

import control.Alimento;

/**
 * Clase con funcionalidades usadas para generar sentencias de sql en base a los
 * parámetros de un alimento
 * 
 * @author Alejandro Pineda
 * 
 */
public class TransformarSql {

	/**
	 * Función utilizada para generar una sentencia de inserción
	 * 
	 * @param alimento El parámetro alimento contiene el objeto empleado como dto en
	 *                 esta práctica, con los parámetros a insertar
	 * 
	 * @return un String con la sentencia de sql
	 */
	public static String insertAlimentoAsql(Alimento alimento) {

		return "INSERT INTO favoritos (proteinas, grasas, hidratos) VALUES ('" + alimento.getProteinas() + "', '"
				+ alimento.getGrasas() + "', '" + alimento.getHidratos() + "');";

	}

	/**
	 * Función utilizada para generar una sentencia de inserción
	 * 
	 * @param alimento El parámetro alimento contiene el objeto empleado como dto en
	 *                 esta práctica, con los parámetros a modificar
	 * 
	 * @return un String con la sentencia de sql
	 */
	public static String updateAlimentoAsql(Alimento alimento) {

		return "UPDATE favoritos SET proteinas ='" + alimento.getProteinas() + "', grasas ='" + alimento.getGrasas()
				+ "', hidratos ='" + alimento.getHidratos() + "' WHERE idAlimento ='" + alimento.getIdAlimento() + "';";

	}

	/**
	 * Función utilizada para generar una sentencia de inserción
	 * 
	 * @param datos El parámetro datos es un string que contiene la posición a
	 *              borrar
	 * 
	 * @return un String con la sentencia de sql
	 */
	public static String deleteAlimentoAsql(String datos) {

		return "DELETE FROM favoritos WHERE idAlimento ='" + datos + "';";

	}

	/**
	 * Función utilizada para generar una sentencia de inserción
	 * 
	 * @param datos El parámetro datos es un string que contiene el contenido a
	 *              buscar en base de datos
	 * 
	 * @return un String con la sentencia de sql
	 */
	public static String findAlimentoAsql(String datos) {

		return "SELECT * FROM favoritos WHERE idAlimento ='" + datos + "' OR grasas ='" + datos + "' OR proteinas ='"
				+ datos + "' OR hidratos ='" + datos + "';";

	}

}
