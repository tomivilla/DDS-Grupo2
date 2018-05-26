package beans;

public class ActuadorAdapter {
   protected static DispositivoInteligente dispositivo;
   
	public static void EjecutarAccionEnFabricante(double idFabricante, Actuador accion) {
		dispositivo.getFabricante().EjecutarAccion(idFabricante,accion);
	}
}
