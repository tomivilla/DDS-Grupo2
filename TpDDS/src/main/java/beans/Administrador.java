package beans;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario{

	private int idUsuario;
	
	private Calendar fechaAlta;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public int getMesesDeAntiguedad() {
		DateTime hoy = new DateTime();
		DateTime fechaAlta = new DateTime(getFechaAlta().getTimeInMillis());
		
		Months meses = Months.monthsBetween(fechaAlta, hoy);
		
		return meses.getMonths();
		
	}
	
}
