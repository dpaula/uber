/**
 * 
 */
package lima.paula.calculos;

/**
 * @author ferna
 *
 */
public class Depreciacao {
	
	//REVER OS VALORES PARA OUTROS VEÍCULOS
	private static final double GASTO_REVISOES_2017 =  1900;
	private static final double GASTO_PNEUS = 1550;
	private static final double GASTO_LIMPEZA = 150;
	
	private static final int KM_RODADO_ANO = 16000; 
	private static final int IPVA_ANO = 2040;
	private static final int SEGURO_OBRIGATORIO = 106;
	private static final int LICENCIAMENTO = 80;
	private static final int SEGURO_PARTICULAR = 3400;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		System.out.println(custoDepreciacaoPorKmRodadoFordFocus2015());

	}

	
	private static double custoIpvaSeguroLicenciamento() {
		return (IPVA_ANO+SEGURO_OBRIGATORIO+LICENCIAMENTO)/KM_RODADO_ANO;
	}
	
	private static double custoSeguroParticularAno() {
		return SEGURO_PARTICULAR/KM_RODADO_ANO;
	}
	
	private static double custoManutencao() {
		return (GASTO_PNEUS+GASTO_REVISOES_2017)/KM_RODADO_ANO;
	}
	
	private static double custoLimpezaAno() {
		return GASTO_LIMPEZA/KM_RODADO_ANO;
	}
	
	public static double custoDepreciacaoPorKmRodadoFordFocus2015() {
		return custoIpvaSeguroLicenciamento()+custoSeguroParticularAno()+custoManutencao()+custoLimpezaAno();
	}
}
