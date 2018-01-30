/**
 * 
 */
package lima.paula.relacional;

import java.util.Date;

/**
 * @author ferna
 *
 */
public class Corrida {
	
	private int id;
	private int distPercorrida;
	private double autonomia;
	private Date dia;
	private double ganhoBruto;
	private float horasTrabalhadas;
	
	private Veiculo veiculo;
	private Driver motorista;
	
	
	
	
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
	 * @return the distPercorrida
	 */
	public int getDistPercorrida() {
		return distPercorrida;
	}
	/**
	 * @param distPercorrida the distPercorrida to set
	 */
	public void setDistPercorrida(int distPercorrida) {
		this.distPercorrida = distPercorrida;
	}
	/**
	 * @return the autonomia
	 */
	public double getAutonomia() {
		return autonomia;
	}
	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	/**
	 * @return the dia
	 */
	public Date getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(Date dia) {
		this.dia = dia;
	}
	/**
	 * @return the ganhoBruto
	 */
	public double getGanhoBruto() {
		return ganhoBruto;
	}
	/**
	 * @param ganhoBruto the ganhoBruto to set
	 */
	public void setGanhoBruto(double ganhoBruto) {
		this.ganhoBruto = ganhoBruto;
	}
	/**
	 * @return the horasTrabalhadas
	 */
	public float getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	/**
	 * @param horasTrabalhadas the horasTrabalhadas to set
	 */
	public void setHorasTrabalhadas(float horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	/**
	 * @return the veiculo
	 */
	public Veiculo getVeiculo() {
		return veiculo;
	}
	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	/**
	 * @return the motorista
	 */
	public Driver getMotorista() {
		return motorista;
	}
	/**
	 * @param motorista the motorista to set
	 */
	public void setMotorista(Driver motorista) {
		this.motorista = motorista;
	}
	
	/**
	 * private int id;
	private int distPercorrida;
	private double autonomia;
	private Date dia;
	private double ganhoBruto;
	private float horasTrabalhadas;
	
	private Veiculo veiculo;
	private Driver motorista;
	
	 */
	@Override
	public String toString() {
		return "Corrida id: "+this.id+", Distancia percorrida: "+this.distPercorrida+", Autonomia: "
	+this.autonomia+", Data: "+this.dia+", Ganho Bruto: "+this.ganhoBruto+", Horas Trabalhadas: "+this.horasTrabalhadas+
	"\n\t\tMotorista: "+this.motorista.getNome()+", Veiculo: "+this.veiculo.getModelo();
	}

}
