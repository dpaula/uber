/**
 * 
 */
package lima.paula.regras;

import java.util.ArrayList;

import lima.paula.conexao.PopulaDados;
import lima.paula.relacional.Corrida;
import lima.paula.utils.Utils;

/**
 * @author ferna
 *
 */
public class RelatorioUber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PopulaDados p = PopulaDados.getInstance();
		
//		for (Corrida c : p.corridas) {
//			System.out.println(c.toString());
//		}
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nTotal de dias Trabalhados: "+p.corridas.size()+"\n\n");
		diasTrabalhados(sb, p.corridas);
		
		sb.append("Ganho médio por dia BRUTO: "+Utils.formatacaoDinheiroReal(Calculos.ganhoMedioDiasBruto(p.corridas)));
		sb.append("\n");
		sb.append("Ganho médio por dia LÍQUIDO: "+Utils.formatacaoDinheiroReal(Calculos.ganhoMedioDiasLiquido(p.corridas)));
		sb.append("\n");
		sb.append("Ganho médiao por hora LIQUIDO: "+Utils.formatacaoDinheiroReal(Calculos.ganhoMedioPorHoraTotalLiquido(p.corridas)));
		sb.append("\n");
		sb.append("Ganho médio por semana \t --> BRUTO:"+Utils.formatacaoDinheiroReal(Calculos.projecaoGanhoSemanaBruto(p.corridas))+"  ; LÍQUIDO: "+Utils.formatacaoDinheiroReal(Calculos.projecaoGanhoSemanaLiquido(p.corridas)));
		sb.append("\n");
		sb.append("Ganho médio por mês\t --> BRUTO:"+Utils.formatacaoDinheiroReal(Calculos.projecaoGanhoMesBruto(p.corridas))+" ; LÍQUIDO: "+Utils.formatacaoDinheiroReal(Calculos.projecaoGanhoMesLiquido(p.corridas)));
		sb.append("\n\n");
		sb.append("TOTAL GANHO LÍQUIDO POR ANO:"+Utils.formatacaoDinheiroReal(Calculos.projecaoGanhoAnoLiquido(p.corridas)));
		
		
		System.out.println(sb.toString());
	}

	private static void diasTrabalhados(StringBuffer sb, ArrayList<Corrida> corridas) {
		
		for (Corrida corrida : corridas) {
			sb.append("Dia: "+Utils.dataFormatadaDiaMes(corrida.getDia())+" - "+Utils.getDiaSemanaExtenso(corrida.getDia())+"; \t");
			sb.append(corrida.getHorasTrabalhadas()+" horas trabalhadas; \t");
			sb.append(corrida.getDistPercorrida()+" km percorridos; \t");
			sb.append("GANHO BRUTO: "+Utils.formatacaoDinheiroReal(corrida.getGanhoBruto())+" ; \t");
			sb.append("GANHO LIQUIDO: "+Utils.formatacaoDinheiroReal(Calculos.ganhoLiquidoDia(corrida.getGanhoBruto(), corrida.getDistPercorrida(), corrida.getAutonomia()))+" ; ");
			sb.append(Utils.formatacaoDinheiroReal(Calculos.ganhoPorHoraLiquido(corrida.getGanhoBruto(), corrida.getDistPercorrida(), corrida.getAutonomia(), corrida.getHorasTrabalhadas()))+" reais por hora neste dia.");
			sb.append("\n");
		}
		sb.append("\n\n");
		
	}
	

}
