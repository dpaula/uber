/**
 * 
 */
package lima.paula.relacional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ferna
 *
 */
public class Driver {
	
	private int idDriver;
	private String nome;
	
	private List<Corrida> corridas = new ArrayList<Corrida>();
	
	
	/**
	 * 
	 */
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idDriver
	 * @param nome
	 */
	public Driver(int idDriver, String nome) {
		super();
		this.idDriver = idDriver;
		this.nome = nome;
	}
	/**
	 * @return the idDriver
	 */
	public int getIdDriver() {
		return idDriver;
	}
	/**
	 * @param idDriver the idDriver to set
	 */
	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Motorista Id: "+this.idDriver+", Nome: "+this.nome;
	}

}
