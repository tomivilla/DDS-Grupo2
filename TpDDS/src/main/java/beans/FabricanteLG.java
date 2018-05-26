package beans;

import java.util.ArrayList;
import java.util.List;

public class FabricanteLG extends Fabricante {

	
	public FabricanteLG(List<DispositivoInteligente> dispositivos) {
		super(dispositivos);
		// TODO Auto-generated constructor stub
	}

	public void EjecutarAccion(double idFabricante, Actuador accion) {
		// TODO Auto-generated method stub
		if(accion.getNombreAccion().equals("Apagar Dispositivo")){
			
			
		}
	}	
 	

}
