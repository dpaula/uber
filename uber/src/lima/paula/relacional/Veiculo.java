/**
 * 
 */
package lima.paula.relacional;

import java.util.Date;

/**
 * @author ferna
 *
 */
public class Veiculo {
	
	private int id;
	private String marca;
	private String modelo;
	private double valorDepreciacao;
	private String ano;
	
	
	
	
	/**
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param valorDepreciacao
	 * @param ano
	 */
	public Veiculo(int id, String marca, String modelo, double valorDepreciacao, String ano) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.valorDepreciacao = valorDepreciacao;
		this.ano = ano;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the valorDepreciacao
	 */
	public double getValorDepreciacao() {
		return valorDepreciacao;
	}
	/**
	 * @param valorDepreciacao the valorDepreciacao to set
	 */
	public void setValorDepreciacao(double valorDepreciacao) {
		this.valorDepreciacao = valorDepreciacao;
	}
	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	@Override
	public String toString() {
		return "Veiculo id: "+this.id+", Marca: "+this.marca+", Modelo: "+this.modelo+", Ano: "+this.ano+", Valor depreciação: "+this.valorDepreciacao;
	}
	
	

}
