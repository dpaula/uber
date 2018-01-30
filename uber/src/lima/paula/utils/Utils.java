package lima.paula.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	private static final String FORMATACAO_DIA_MES = "dd/MMM";
	
	/**
	 * 
	 * @param data
	 * @return 25/jan
	 */
	public static String dataFormatadaDiaMes(Date data) {
		return new SimpleDateFormat(FORMATACAO_DIA_MES).format(data);
	}
	
	public static void main(String[] args) {
		
		System.out.println(Utils.dataFormatadaDiaMes(new Date()));
		System.out.println(getDiaSemanaExtenso(new Date()));
		System.out.println(formatacaoDinheiroReal(59.23));
	}
	
	/**
	 * 
	 * @param data
	 * @return Quinta
	 */
	public static String getDiaSemanaExtenso(Date data) {
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		int dia = gc.get(Calendar.DAY_OF_WEEK);
		
		switch(dia){
		case Calendar.MONDAY :
			return EnDiaSemana.SEGUNDA.getNome();
		case Calendar.TUESDAY :
				return EnDiaSemana.TERCA.getNome();
		case Calendar.WEDNESDAY :
			return EnDiaSemana.QUARTA.getNome();
		case Calendar.THURSDAY :
			return EnDiaSemana.QUINTA.getNome();
		case Calendar.FRIDAY :
			return EnDiaSemana.SEXTA.getNome();
		case Calendar.SATURDAY :
			return EnDiaSemana.SABADO.getNome();
		case Calendar.SUNDAY :
			return EnDiaSemana.DOMINGO.getNome();
		}
		
		return null;
	}

	public static String formatacaoDinheiroReal(double ganhoBruto) {
		return String.format("\tR$%,7.2f", ganhoBruto);
	}
}
