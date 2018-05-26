package beans;

import java.util.ArrayList;
import java.util.List;

public class FabricanteLG extends Fabricante {

	// cada fabricante conoce los dispositivos que fabrico.
	@Override
	public void EjecutarAccion(double idFabricante, Actuador accion) {
		// TODO Auto-generated method stub
		if(accion.getNombreAccion().equals("Apagar Dispositivo")){
			
			
		}
	}

	

}
