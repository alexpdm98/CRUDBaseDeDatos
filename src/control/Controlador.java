package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.AlimentoService;
import utils.UtilidadesAlimentos;
import utils.UtilidadesGUI;

/**
 * Clase que se encarga de lanzar las funciones que contiene la lógica de la
 * aplicación
 * 
 * @author Alejandro Pineda
 */
public class Controlador {

	public static void main(String[] args) {
		// --------- Zona de declaración de variables ----------
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		UtilidadesAlimentos utilidadesAlimentos = new UtilidadesAlimentos(inputStreamReader, bufferedReader);
		UtilidadesGUI utilidadesGUI = new UtilidadesGUI();

		AlimentoService servicioAlimentos = new AlimentoService(utilidadesAlimentos, utilidadesGUI, inputStreamReader,
				bufferedReader);

		// --------- Fin de declaración de variables ----------

		// Se llama a la función que encapsula la lógica de negocio
		try {
			servicioAlimentos.cyclicMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
