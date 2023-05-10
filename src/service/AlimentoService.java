package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import utils.UtilidadesAlimentos;
import utils.UtilidadesGUI;

/**
 * Clase con la lógica de negocio esperada de la aplicación.
 * 
 * @author Alejandro Pineda
 */

public class AlimentoService {
	// --------- Zona de declaración de variables --------
	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

	UtilidadesAlimentos utilidadesAlimentos = new UtilidadesAlimentos(inputStreamReader, bufferedReader);
	UtilidadesGUI utilidadesGUI;
	boolean salida = false;
	Integer datoIntroducido;
	String respuesta;
	// --------- Fin de declaración de variables ----------

	/**
	 * --------- Constructor ------------------------------
	 * 
	 * @param utilidadesAlimentos El parámetro utilidadesAlimentos se utiliza para
	 *                            instanciar el servicio de utilidades con la logica
	 *                            de servicio
	 * 
	 * @param utilidadesGUI       El parámetro utilidadesAlimentos se utiliza para
	 *                            instanciar el servicio de utilidades con interfaz
	 *                            grafica
	 * 
	 * @param inputStreamReader   El parámetro inputStreamReader define un
	 *                            InputStreamRader, usado para obtener entradas de
	 *                            usuario
	 * 
	 * @param bufferedReader      El parámetro bufferedReader define un
	 *                            BufferedReader, usado para formatear las entradas
	 *                            de usuario
	 */
	public AlimentoService(UtilidadesAlimentos utilidadesAlimentos, UtilidadesGUI utilidadesGUI,
			InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
		super();
		this.utilidadesAlimentos = utilidadesAlimentos;
		this.utilidadesGUI = utilidadesGUI;
		this.inputStreamReader = inputStreamReader;
		this.bufferedReader = bufferedReader;
	}
	// --------- Fin del constructor ----------------------

	/**
	 * Función utilizada para mostrar un menú cíclico que permite interactuar con la
	 * base de datos hasta que el usuario decida.
	 * 
	 * @throws IOException lanzada al captar un dato del usuario incorrecto
	 * 
	 */
	public void cyclicMenu() throws IOException {
		// Se inicializan las variables necesarias en la función y se muestra el menú de
		// inicio
		this.utilidadesGUI.startMenu();
		do {
			// Se muestra el menú con las opciones a realizar en esta posición en concreto
			// de los arrays
			this.utilidadesGUI.lifecycleMenu();
			// Se lee la respuesta de usuario

			try {
				datoIntroducido = Integer.valueOf(bufferedReader.readLine());
			} catch (NumberFormatException e) {
				datoIntroducido = 6;
			}
			// Se evalúa la respuesta del usuario
			switch (datoIntroducido) {
			case 1: {
				// Se añade un dato
				this.utilidadesAlimentos.addDataToPosition();
				break;
			}
			case 2: {
				// Se modifica un dato
				this.utilidadesAlimentos.modifyDataInPosition();
				break;
			}
			case 3: {
				// Se borra un dato
				this.utilidadesAlimentos.deleteDataInPosition();
				break;
			}
			case 4: {
				// Se busca un dato y se muestra por pantalla si se encuentra o no en base de
				// datos
				this.utilidadesAlimentos.searchDataInDataBase();
				break;
			}
			case 5: {
				// Se sale del menú
				salida = true;
				break;
			}
			default: {
				// En caso de introducir un valor no esperado
				System.out.println("ERROR: DATO NO VALIDO.");
			}
			}
		} while (!salida);

		this.utilidadesGUI.exitMenu();
		respuesta = bufferedReader.readLine();
		// Se procesa la respuesta del usuario
		if ("Y".equals(respuesta) || "y".equals(respuesta)) {
			// Bye Bye Usuario :'(
			this.utilidadesGUI.byeByeMenu();
		}
	}

}