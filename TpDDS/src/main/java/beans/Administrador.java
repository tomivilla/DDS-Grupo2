package beans;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario{

	private int idUsuario;
	
	private Date fechaAlta;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void SetConsumoPromedio(double consumoPromedio, DispositivoEstandar dispositivo) {
	  dispositivo.setConsumo(consumoPromedio);		
		
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getMesesDeAntiguedad() {
		DateTime hoy = new DateTime();
		DateTime fechaAlta = new DateTime(getFechaAlta());
		
		Months meses = Months.monthsBetween(fechaAlta, hoy);
		
		return meses.getMonths();
		
	}
	
}
