package pruebas;

import java.util.List;

import beans.Dispositivo;
import beans.Usuario;
import utils.CargarDispositivos;
import utils.CargarUsuarios;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rutaArchivos = "C:\\Users\\tomas.villa\\eclipse-workspace\\TpDDS\\src\\main\\resources\\archivos\\";
		String contenido = null;
		List<Dispositivo> dispositivos = null;
		List<Usuario> usuarios= null;
		
//		contenido = CargarDispositivos.leerArchivo("C:\\Users\\tomas.villa\\eclipse-workspace\\TpDDS\\src\\main\\resources\\archivos\\JsonDispositivos");
		dispositivos = CargarDispositivos.cargarDispositivos(rutaArchivos + "JsonDispositivos");

		System.out.println(dispositivos.size());
		
		for (Dispositivo dispositivo : dispositivos) {
			System.out.println(dispositivo.getNombreGenerico());
		}
		
		usuarios = CargarUsuarios.cargarUsuarios(rutaArchivos+"JsonUsuarios");
		
		System.out.println(usuarios.size());
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}
		
	}

}
