package fecha_helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha_Helper {
		
	public static String obtenerFechaActual() {
		Calendar c = new GregorianCalendar();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String sFecha =annio+"-"+mes+"-"+dia;
		return sFecha;
	}
	
	public static int diferenciaEnMeses(Date unaFecha) throws ParseException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	 
	java.util.Date fechaFinal = dateFormat.parse(Fecha_Helper.obtenerFechaActual());

	int dias=(int) ((fechaFinal.getTime()-unaFecha.getTime())/86400000);
	
	return (dias/31);
	
	}
}
