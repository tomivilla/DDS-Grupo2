package dispositivo;

public class RegistroConsumo {
	private long horaInicio;
	private long horaFin;
	
	public RegistroConsumo(long horaInicio,long horaFin){
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
	}
	public long getHoraInicio() {
		
		return horaInicio;
	}
	public void setHoraInicio(long horaInicio) {
		this.horaInicio = horaInicio;
	}
	public long getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(long horaFin) {
		this.horaFin = horaFin;
	}
	public int horasTranscurridas(){
		return (int) ((int) (this.getHoraFin()-this.getHoraInicio())/3600);
	}
	public boolean estasEnPeriodo(RegistroConsumo unPeriodo){
		return this.horaInicio>=unPeriodo.horaInicio && this.horaFin<=unPeriodo.horaFin;
	}
}
