package model.persistence;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilsBanco {

	public static GregorianCalendar converterData(String data){
		String novaData[] = data.split("/");
		String dia = novaData[0];
		String mes = novaData[1];
		String ano = novaData[2];
		GregorianCalendar dt = new GregorianCalendar(new Integer(ano), 
				new Integer(mes) - 1, new Integer(dia));
		return dt; /*
					* cal.getTime() == DATE;
					*/
	}	
	
	public static String converterDataToBanco(GregorianCalendar data){
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String dtNascFormatada = dt.format(data.getTime());
		return dtNascFormatada;
	}
	
	public static GregorianCalendar converterDataBancoToGC(String data){
		String novaData[] = data.split("-");
		String ano = novaData[0];
		String mes = novaData[1];
		String dia = novaData[2];
		GregorianCalendar dt = new GregorianCalendar(new Integer(ano), 
				new Integer(mes) - 1, new Integer(dia));
		return dt;
	}	
	
	public static GregorianCalendar converterTSBancoToGC(Timestamp data){
		Date d = new Date(data.getTime());
		GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
		return gc;
	}
	
	public static String getDataHoraCorrente() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	/*
	 * Funcao de Replace para fazer parser do Double que vem do Banco
	 */
	public static String prepararDouble(String valor) { 
		valor = valor.replace( "." , ""); 
		valor = valor.replace( "R$ " , ""); 
		valor = valor.replace( "%" , "");  
		valor = valor.replace( "," , "."); 
		
		return valor;
	}

}
