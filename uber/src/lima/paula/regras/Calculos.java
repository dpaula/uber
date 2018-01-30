package lima.paula.regras;

import java.util.ArrayList;

import lima.paula.calculos.Depreciacao;
import lima.paula.relacional.Corrida;

public class Calculos {
	
	
	
	public static final double PRECO_GASOLINA = 3.7;
	
	
	public static double gastoGasolina(double km, double autonomia) {
		if(autonomia == 0) {
			return 0;
		}
		
		return (km/autonomia)*PRECO_GASOLINA;
	}
	
	public static double ganhoLiquidoDia(double bruto, double km, double autonomia) {
		return bruto - gastosTotais(km, autonomia);
		
	}

	public static double gastosTotais(double km, double autonomia) {
		return (Depreciacao.custoDepreciacaoPorKmRodadoFordFocus2015()*km + gastoGasolina(km, autonomia));
	}
	
	public static double ganhoPorHoraLiquido(double bruto, double km, double autonomia, float horasTrabalhadas) {
		return ganhoLiquidoDia(bruto, km, autonomia)/horasTrabalhadas;
	}

	public static double totalDiasTrabalhados(ArrayList<Corrida> corridas) {
		return totalHorasTrabalhadas(corridas)/corridas.size();
	}
	
	private static double totalHorasTrabalhadas(ArrayList<Corrida> corridas) {

		double totalHoras = 0;
		
		for (Corrida corrida : corridas) {
			totalHoras += corrida.getHorasTrabalhadas();
		}
		return totalHoras;
	}

	
	public static double ganhoTotalBruto(ArrayList<Corrida> corridas) {
		double ganhoTotal = 0;
		for (Corrida corrida : corridas) {
			ganhoTotal += corrida.getGanhoBruto();
		}
		return ganhoTotal; 
	}
	
	public static double ganhoTotalLiquid(ArrayList<Corrida> corridas) {
		double ganhoTotal = 0;
		for (Corrida corrida : corridas) {
			ganhoTotal += ganhoLiquidoDia(corrida.getGanhoBruto(), corrida.getDistPercorrida(), corrida.getAutonomia());
		}
		return ganhoTotal;
	}
	
	public static double ganhoMedioDiasBruto(ArrayList<Corrida> corridas) {
		return ganhoTotalBruto(corridas)/corridas.size();
	}
	
	public static double ganhoMedioDiasLiquido(ArrayList<Corrida> corridas) {
		return ganhoTotalLiquid(corridas)/corridas.size();
	}
	
	public static double projecaoGanhoMesBruto(ArrayList<Corrida> corridas) {
		return ganhoMedioDiasBruto(corridas)*22;
	}
	
	public static double projecaoGanhoMesLiquido(ArrayList<Corrida> corridas) {
		return ganhoMedioDiasLiquido(corridas)*22;
	}
	
	public static double projecaoGanhoAnoLiquido(ArrayList<Corrida> corridas) {
		return projecaoGanhoMesLiquido(corridas)*12;
	}
	
	public static double totalGastoGasolina(ArrayList<Corrida> corridas) {
		double gastoTotal = 0;
		for (Corrida corrida : corridas) {
			gastoTotal += gastoGasolina(corrida.getDistPercorrida(), corrida.getAutonomia());
		}
		return gastoTotal;
	}
	
	public static double ganhoMedioPorHoraTotalLiquido(ArrayList<Corrida> corridas) {
		return ganhoTotalLiquid(corridas)/totalHorasTrabalhadas(corridas);
	}
	
	public static double projecaoGanhoSemanaBruto(ArrayList<Corrida> corridas) {
		return ganhoMedioDiasBruto(corridas)*5;
	}
	
	public static double projecaoGanhoSemanaLiquido(ArrayList<Corrida> corridas) {
		return ganhoMedioDiasLiquido(corridas)*5;
	}
}
