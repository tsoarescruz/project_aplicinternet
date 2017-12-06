package view;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class UtilsTela {
	public static String ConverterDataToTela(GregorianCalendar data){
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		String dtNascFormatada = dt.format(data.getTime());
		return dtNascFormatada;
	}
	

}
