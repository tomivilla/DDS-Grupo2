package beans;

public class DispositivoInteligenteAdapter extends DispositivoInteligente {

	private DispositivoEstandard dispositivoAConvertir;

	public DispositivoInteligenteAdapter(DispositivoEstandard dispositivo, Adaptador sAdaptador ) {
		this.setDispositivoAConvertir(dispositivo);
		setAdaptador(sAdaptador);
		setModoAhorroEnergia(false);
		setRegistrado(true);
	}
	
	public DispositivoEstandard getDispositivoAConvertir() {
		return dispositivoAConvertir;
	}

	public void setDispositivoAConvertir(DispositivoEstandard dispositivoAConvertir) {
		this.dispositivoAConvertir = dispositivoAConvertir;
	}
		
	public void setConsumo(double consumo) {
		consumoPeriodo = dispositivoAConvertir.getConsumoPeriodo();	}
 
    public void setId(long id) {
    	id = dispositivoAConvertir.getId();
    }
    
}
