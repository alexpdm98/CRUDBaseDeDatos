package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;
import service.AlimentoService;
import utils.UtilidadesAlimentos;
import utils.UtilidadesGUI;

public class TestsBaseDatos {

	// --------- Zona de declaración de variables --------
	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	UtilidadesAlimentos utilidadesAlimentos = new UtilidadesAlimentos(inputStreamReader, bufferedReader);

	UtilidadesGUI utilidadesGUI = new UtilidadesGUI();

	AlimentoService servicioAlimentos = new AlimentoService(utilidadesAlimentos, utilidadesGUI, inputStreamReader,
			bufferedReader);
	// --------- Fin de declaración de variables --------

	@Test
	void testAdd() throws IOException {
		System.out.println("Se comprueba el correcto funcionamiento de añadir");
		assertTrue(utilidadesAlimentos.addDataToPosition());
	}

	@Test
	void testModify() throws IOException {
		System.out.println("Se comprueba el correcto funcionamiento de modificar");
		assertTrue(utilidadesAlimentos.modifyDataInPosition());
	}

	@Test
	void testDelete() throws IOException {
		System.out.println("Se comprueba el correcto funcionamiento de borrar");
		assertTrue(utilidadesAlimentos.deleteDataInPosition());
	}

	@Test
	void testSearch() throws IOException {
		System.out.println("Se comprueba el correcto funcionamiento de buscar");
		assertTrue(utilidadesAlimentos.searchDataInDataBase());
	}

	@Test
	void testModifyFailed() throws IOException {
		System.out.println(
				"Se comprueba el correcto funcionamiento de modificar fallido, se insta a modificar un dato que no esté en la base");
		assertFalse(utilidadesAlimentos.modifyDataInPosition());
	}

	@Test
	void testDeleteFailed() throws IOException {
		System.out.println(
				"Se comprueba el correcto funcionamiento de borrar fallido, se insta a borrar un dato que no esté en la base");
		assertFalse(utilidadesAlimentos.deleteDataInPosition());
	}

	@Test
	void testSearchFailed() throws IOException {
		System.out.println(
				"Se comprueba el correcto funcionamiento de buscar fallido, se insta a buscar un dato que no esté en la base");
		assertFalse(utilidadesAlimentos.searchDataInDataBase());
	}

	@Test
	void testUtilidadesGUI() throws IOException {
		utilidadesGUI.byeByeMenu();
		utilidadesGUI.exitMenu();
		utilidadesGUI.lifecycleMenu();
		utilidadesGUI.startMenu();
	}

	@Test
	void testServicioAlimentos() throws IOException {
		servicioAlimentos.cyclicMenu();
	}
}
