package beans;

public class DispositivoInteligenteAdapter extends DispositivoInteligente {

	private DispositivoEstandar dispositivoAConvertir;

	public DispositivoInteligenteAdapter(DispositivoEstandar dispositivo, Adaptador sAdaptador ) {
		this.setDispositivoAConvertir(dispositivo);
		this.setAdaptador(sAdaptador);
		this.modoAhorroEnergia = false;
		this.setRegistrado(true);
	}
	
	public DispositivoEstandar getDispositivoAConvertir() {
		return dispositivoAConvertir;
	}

	public void setDispositivoAConvertir(DispositivoEstandar dispositivoAConvertir) {
		this.dispositivoAConvertir = dispositivoAConvertir;
	}
		
	public void setConsumo(double consumo) {
		consumoPeriodo = dispositivoAConvertir.getConsumoPeriodo();	}
 
    public void setId(long id) {
    	id = dispositivoAConvertir.getId();
    }
    
}
