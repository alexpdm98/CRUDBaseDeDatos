package control;

import java.util.Objects;

/**
 * Objeto utilizado como dto para interactuar con la base de datos
 * 
 * @author Alejandro Pineda
 */

public class Alimento {
	// --------- Zona de declaración de variables --------
	int idAlimento;
	String proteinas;
	String grasas;
	String hidratos;
	// --------- Fin de declaración de variables ----------

	/**
	 * --------- Constructor ------------------------------
	 * 
	 * @param proteinas El parámetro proteinas define un String que almacena el
	 *                  valor de las proteinas
	 * 
	 * @param grasas    El parámetro grasas define un String que almacena el valor
	 *                  de las grasas
	 * 
	 * @param hidratos  El parámetro hidratos define un String que almacena el valor
	 *                  de los hidratos
	 */
	public Alimento(String proteinas, String grasas, String hidratos) {
		super();

		this.proteinas = proteinas;
		this.grasas = grasas;
		this.hidratos = hidratos;

	}

	/**
	 * --------- Constructor ------------------------------
	 * 
	 * @param idAlimento El parámetro idAlimento define un int que almacena el valor
	 *                   del id en base de datos.
	 * 
	 * @param proteinas  El parámetro proteinas define un String que almacena el
	 *                   valor de las proteinas
	 * 
	 * @param grasas     El parámetro grasas define un String que almacena el valor
	 *                   de las grasas
	 * 
	 * @param hidratos   El parámetro hidratos define un String que almacena el
	 *                   valor de los hidratos
	 */

	public Alimento(int idAlimento, String proteinas, String grasas, String hidratos) {
		super();
		this.idAlimento = idAlimento;
		this.proteinas = proteinas;
		this.grasas = grasas;
		this.hidratos = hidratos;
	}

	public Alimento() {
		super();
	}
	// --------- Fin del constructor ----------------------

	// ---------- Getters ------------

	public int getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getProteinas() {
		return proteinas;
	}

	public String getGrasas() {
		return grasas;
	}

	public String getHidratos() {
		return hidratos;
	}

	public void setProteinas(String proteinas) {
		this.proteinas = proteinas;
	}

	public void setGrasas(String grasas) {
		this.grasas = grasas;
	}

	public void setHidratos(String hidratos) {
		this.hidratos = hidratos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(grasas, other.grasas) && Objects.equals(hidratos, other.hidratos)
				&& Objects.equals(idAlimento, other.idAlimento) && Objects.equals(proteinas, other.proteinas);
	}

}
